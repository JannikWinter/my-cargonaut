package my_cargonaut.offer.search;

import io.javalin.http.Handler;
import my_cargonaut.login.LoginController;
import my_cargonaut.utility.FormManUtils;
import my_cargonaut.utility.data_classes.offers.Offer;

import java.text.ParseException;
import java.util.*;

public class OffersSearchController {

    private static final OffersSearchService offersSearchService = OffersSearchService.getInstance();

    public static Handler serveOffersSearchPage = ctx -> {
        List<Offer> resultList;

        Optional<Date> maybeDate1, maybeDate2;
        String tmp;
        OffersSearchService.OfferFilterConfigurator offerConfig = offersSearchService.getOfferFilterConfigurator();

        OffersSearchPage page = new OffersSearchPage(ctx);
        Map<String, String> map = FormManUtils.createQueryParamMap(ctx);

        // Todo: implement filtering and saving of offers for the given query!
        try{
            maybeDate1 = offersSearchService.getMaybeDateFromString(map.get(page.offerSearchFormStartT));
            maybeDate1.ifPresent(offerConfig::setStartDate);
            maybeDate2 = offersSearchService.getMaybeDateFromString(map.get(page.offerSearchFormEndT));
            maybeDate2.ifPresent(offerConfig::setEndDate);
        } catch(ParseException e) {
            e.printStackTrace();
        }
        tmp = map.get(page.offerSearchFormOrig);
        if(!tmp.equals("")) {
            offerConfig.setStartLocationName(tmp);
        }
        tmp = map.get(page.offerSearchFormDest);
        if(!tmp.equals("")) {
            offerConfig.setDestinationName(tmp);
        }
        if(map.containsKey(page.offerSearchFormCargoMaxWeight)) {
            /*
                    Might be null if the get-request came from the landing page!
             */
            if(!map.get(page.offerSearchFormCargoHeight).equals("")) {
                offerConfig.setHeight(Double.parseDouble(map.get(page.offerSearchFormCargoHeight)));
            }
            if(!map.get(page.offerSearchFormCargoWidth).equals("")) {
                offerConfig.setWidth(Double.parseDouble(map.get(page.offerSearchFormCargoWidth)));
            }
            if(!map.get(page.offerSearchFormCargoDepth).equals("")) {
                offerConfig.setDepth(Double.parseDouble(map.get(page.offerSearchFormCargoDepth)));
            }
            if(!map.get(page.offerSearchFormCargoMaxWeight).equals("")) {
                offerConfig.setWeight(Double.parseDouble(map.get(page.offerSearchFormCargoMaxWeight)));
            }
        }

        resultList = offerConfig.queryOffersWithFilter();

        page.markAsQueried(map, resultList);
        page.render();
    };

    public static Handler handleOffersSearchPost = ctx -> {
        // only POST-Request for now is via the Login-Form
        // Todo: Watch out for further possible post requests!
        OffersSearchPage page = new OffersSearchPage(ctx);
        page = (OffersSearchPage)LoginController.checkLoginPost(page, ctx);
        page.render();
    };
}
