package my_cargonaut.profile.cars;

import io.javalin.http.Handler;
import my_cargonaut.landing.NotFoundPage;
import my_cargonaut.profile.deals.DealsPage;
import my_cargonaut.utility.SessionManUtils;
import my_cargonaut.utility.data_classes.user.User;

public class CarsPageController {

    public static Handler serveCarsPage = ctx -> {
        CarsPage page = new CarsPage(ctx);
        // is fine as we should only be able to access this page while logged in (as in: there's a User in the Optional)
        User user = SessionManUtils.getUserInSession(ctx).get();
        page.setVehicle(user.getVehicle());
        page.render();
    };

    public static Handler handleDealsPagePost = ctx -> {
        DealsPage page;
        try {

        }catch (Exception e){

        }

    };
    public static Handler serveNotFoundPage = ctx -> {
        NotFoundPage page = new NotFoundPage(ctx);
        page.render();
    };
}
