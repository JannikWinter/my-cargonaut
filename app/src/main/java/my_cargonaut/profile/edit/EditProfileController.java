package my_cargonaut.profile.edit;

import io.javalin.http.Handler;
import my_cargonaut.landing.NotFoundPage;
import my_cargonaut.login.LoginController;

public class EditProfileController {
    public static Handler serveEditprofilePage = ctx -> {
        EditPage page = new EditPage(ctx);
        page.render();
    };
    public static Handler handleEditprofilePagePost = ctx -> {
        EditPage page = new EditPage(ctx);
        page = (EditPage) LoginController.checkLoginPost(page, ctx);
        page.render();
    };
    public static Handler serveNotFoundPage = ctx -> {
        NotFoundPage page = new NotFoundPage(ctx);
        page.render();
    };
}
