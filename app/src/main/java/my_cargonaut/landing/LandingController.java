package my_cargonaut.landing;

import io.javalin.http.Handler;

public class LandingController {

    public static Handler serveLandingPage = ctx -> {
        LandingPage page = new LandingPage(ctx);
        page.render();
    };

    public static Handler serveNotFoundPage = ctx -> {
        NotFoundPage page = new NotFoundPage(ctx);
        page.render();
    };
}
