package my_cargonaut.landing;

import io.javalin.http.Handler;
import my_cargonaut.login.LoginController;

public class LandingController {

    public static Handler serveLandingPage = ctx -> {
        LandingPage page = new LandingPage(ctx);
        if(ctx.method().equals("POST")) {
            page = (LandingPage)LoginController.checkLoginPostFromEverywhere(page, ctx);
        }
        page.render();
    };

    public static Handler serveNotFoundPage = ctx -> {
        NotFoundPage page = new NotFoundPage(ctx);
        page.render();
    };
}
