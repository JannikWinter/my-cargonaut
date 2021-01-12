package my_cargonaut.profile.cars;

import io.javalin.http.Handler;
import my_cargonaut.landing.NotFoundPage;
import my_cargonaut.login.LoginController;
import my_cargonaut.profile.deals.DealsPage;

public class CarsPageController {
    public static Handler serveDealsPage = ctx -> {
        DealsPage page = new DealsPage(ctx);
        page.render();
    };
    public static Handler handleDealsPagePost = ctx -> {
        DealsPage page = new DealsPage(ctx);
        page = (DealsPage) LoginController.checkLoginPost(page, ctx);
        page.render();
    };
    public static Handler serveNotFoundPage = ctx -> {
        NotFoundPage page = new NotFoundPage(ctx);
        page.render();
    };
}
