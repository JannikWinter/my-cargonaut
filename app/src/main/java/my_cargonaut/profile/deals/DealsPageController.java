package my_cargonaut.profile.deals;
import io.javalin.http.Handler;
import my_cargonaut.landing.NotFoundPage;
import my_cargonaut.login.LoginController;
import my_cargonaut.offer.search.OffersSearchService;
import my_cargonaut.utility.data_classes.offers.Offer;

import java.util.List;

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
        page = (DealsPage) LoginController.checkLoginPost(page, ctx);
        page.render();
    };
}
