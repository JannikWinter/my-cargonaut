package my_cargonaut.profile.edit;

import io.javalin.http.Handler;
import my_cargonaut.landing.NotFoundPage;
import my_cargonaut.login.LoginController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseDateFromFromParam(String param) throws ParseException {
        return dateFormat.parse(param);
    }
}
