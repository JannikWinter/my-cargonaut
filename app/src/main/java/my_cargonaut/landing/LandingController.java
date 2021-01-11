package my_cargonaut.landing;

import io.javalin.http.Handler;
import my_cargonaut.login.LoginController;
import my_cargonaut.utility.FormManUtils;

import java.util.Map;

public class LandingController {

    public static Handler serveLandingPage = ctx -> {
        LandingPage page = new LandingPage(ctx);
        page.render();
    };

    public static Handler handleLandingPagePost = ctx -> {
        LandingPage page = new LandingPage(ctx);
        page = (LandingPage)LoginController.checkLoginPost(page, ctx);
        page.render();
    };

    public static Handler serveNotFoundPage = ctx -> {
        NotFoundPage page = new NotFoundPage(ctx);
        page.render();
    };
}
