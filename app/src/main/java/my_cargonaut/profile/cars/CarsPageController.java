package my_cargonaut.profile.cars;

import io.javalin.http.Handler;
import my_cargonaut.landing.NotFoundPage;
import my_cargonaut.profile.deals.DealsPage;
import my_cargonaut.utility.FormManUtils;
import my_cargonaut.utility.SessionManUtils;
import my_cargonaut.utility.data_classes.Vehicle;
import my_cargonaut.utility.data_classes.user.CarManufacturer;
import my_cargonaut.utility.data_classes.user.User;
import my_cargonaut.utility.data_classes.user.UserRegister;

import java.util.Map;
import java.util.Optional;

public class CarsPageController {

    public static Handler serveCarsPage = ctx -> {
        CarsPage page = new CarsPage(ctx);
        // is fine as we should only be able to access this page while logged in (as in: there's a User in the Optional)
        User user = SessionManUtils.getUserInSession(ctx).get();
        page.setVehicle(user.getVehicle());
        page.render();
    };

    public static Handler handleCarsPagePost = ctx -> {
        CarsPage page = new CarsPage(ctx);
        Map<String, String> map = FormManUtils.createFormParamMap(ctx);
        User currentUser = page.getCurrentUser().orElseThrow(IllegalStateException::new);
        Vehicle inputVehicle = new Vehicle();

        inputVehicle.setCarInformation(
                CarManufacturer.permissiveValueOf(map.get(CarsPage.ProfileCBrand)),
                map.get(CarsPage.ProfileCModel),
                Double.parseDouble(map.get(CarsPage.ProfileCFreeHeight)),
                Double.parseDouble(map.get(CarsPage.ProfileCFreeWidth)),
                Double.parseDouble(map.get(CarsPage.ProfileCFreeDepth)),
                Double.parseDouble(map.get(CarsPage.ProfileCFreeWeight)),
                Double.parseDouble(map.get(CarsPage.ProfileCMaxHeight)),
                Double.parseDouble(map.get(CarsPage.ProfileCMaxWidth)),
                Double.parseDouble(map.get(CarsPage.ProfileCMaxDepth)),
                Double.parseDouble(map.get(CarsPage.ProfileCMaxWeight))
        );

        currentUser.setVehicle(inputVehicle);
        page.setVehicle(inputVehicle).render();
    };

    public static Handler serveNotFoundPage = ctx -> {
        NotFoundPage page = new NotFoundPage(ctx);
        page.render();
    };
}
