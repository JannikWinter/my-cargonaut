package my_cargonaut.profile.deals;
import io.javalin.http.Handler;
import my_cargonaut.landing.NotFoundPage;
import my_cargonaut.login.LoginController;
import my_cargonaut.offer.search.OffersSearchService;
import my_cargonaut.utility.FormManUtils;
import my_cargonaut.utility.SessionManUtils;
import my_cargonaut.utility.data_classes.offers.Offer;
import my_cargonaut.utility.data_classes.user.User;
import my_cargonaut.utility.data_classes.user.UserRegister;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DealsPageController {

    public static Handler serveDealsPage = ctx -> {
        DealsPage page;
        OffersSearchService oss = OffersSearchService.getInstance();

        page = new DealsPage(ctx);

        List<Offer> offersOfUser = oss.getOfferFilterConfigurator()
                .setUser(page.getCurrentUser().orElseThrow(IllegalStateException::new))
                .queryOffersWithFilter();

        page.addOffersList(offersOfUser);
        page.render();
    };

    public static Handler handleDealsPagePost = ctx -> {
        DealsPage page = new DealsPage(ctx);

        Map<String, String> map = FormManUtils.createFormParamMap(ctx);
        //Offer changedOffer = OffersSearchService.getInstance().getOfferFilterConfigurator();
        if(!map.get(page.dealsPageFormAcceptionUser).equals("")) {
            Optional<User> maybeAcceptingUser = UserRegister.getInstance().getUser(map.get(page.dealsPageFormAcceptionUser));

        }

        page.render();
    };
}
