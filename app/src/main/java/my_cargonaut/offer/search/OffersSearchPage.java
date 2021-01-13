package my_cargonaut.offer.search;

import io.javalin.http.Context;
import my_cargonaut.utility.SearchPage;
import my_cargonaut.utility.data_classes.offers.Offer;

import java.util.*;

public class OffersSearchPage extends SearchPage {

    public static final String PATH = "/searchOffers";
    private final String templateFilePath;
    private boolean displaysQueryResult;
    private Map<String, String> enteredValues;
    private List<Offer> offerList;


    public final String offerSearchFormCargoHeight = "offerSearchFormCargoHeight";
    public final String offerSearchFormCargoWidth = "offerSearchFormCargoWidth";
    public final String offerSearchFormCargoDepth = "offerSearchFormCargoDepth";
    public final String offerSearchFormCargoMaxWeight = "offerSearchFormCargoMaxWeight";

    public OffersSearchPage(Context ctx) {
        super(ctx);
        templateFilePath = "offer/search/searchOffers.jte";
        displaysQueryResult = false;
    }

    public void enteredFormValues(Map<String, String> searchParams) {
        this.enteredValues = new HashMap<>(searchParams);
    }

    public OffersSearchPage markAsQueried(Map<String, String> searchParams, List<Offer> results) {
        this.displaysQueryResult = true;
        this.enteredValues = searchParams;
        this.offerList = results;
        return this;
    }

    public boolean displaysQueryResult() {
        return displaysQueryResult;
    }

    public List<Offer> getOfferList() {
        return this.offerList;
    }

    @Override
    public String getTemplate() {
        return templateFilePath;
    }

    public String getEnteredValue(String name) {
        return Optional.ofNullable(enteredValues.get(name)).orElse("");
    }
}
