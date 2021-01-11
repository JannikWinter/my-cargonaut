package my_cargonaut.offer.search;

import io.javalin.http.Handler;
import my_cargonaut.landing.LandingPage;
import my_cargonaut.login.LoginController;
import my_cargonaut.utility.FormManUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OffersSearchController {

    public static Handler serveOffersSearchPage = ctx -> {
        OffersSearchPage page = new OffersSearchPage(ctx);
        Map<String, String> map = ctx.pathParamMap();
        Map<String, String> map2 = FormManUtils.createFormParamMap(ctx);
        Map<String, List<String>> map3 = ctx.queryParamMap();
        if(Optional.ofNullable(map).isPresent()) {
            System.out.println("test");
        }
        page.render();
    };

    public static Handler handleOffersSearchPost = ctx -> {
        // only POST-Request for now is via the Login-Form
        OffersSearchPage page = new OffersSearchPage(ctx);
        page = (OffersSearchPage)LoginController.checkLoginPost(page, ctx);
        page.render();
    };
}
