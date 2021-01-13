package my_cargonaut.profile.deals;
import io.javalin.http.Handler;
import my_cargonaut.landing.NotFoundPage;
import my_cargonaut.login.LoginController;

public class DealsPageController {

    public static Handler serveDealsPage = ctx -> {
        DealsPage page = new DealsPage(ctx);
        page.render();
    };

    public static Handler handleDealsPagePost = ctx -> {
        DealsPage page = new DealsPage(ctx);
        page = (DealsPage) LoginController.checkLoginPost(page, ctx);
        page.render();
    };
}
