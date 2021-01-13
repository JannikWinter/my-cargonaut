package my_cargonaut.profile.cars;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;
import my_cargonaut.utility.data_classes.Vehicle;

import java.util.Optional;

public class CarsPage extends ProfileEditPage {
    private static final String PATH_ENDING = "/cars";
    public static final String PATH_STATIC = BASEPATH + PATH_ENDING;

    private final String templateFilePath;

    public static final String ProfileCForm = "carsProfile";
    public static final String ProfileCBrand = "carsBrandDropdown";
    public static final String ProfileCModel = "carsModel";
    public static final String ProfileCFreeHeight = "carsFreeHeight";
    public static final String ProfileCFreeWidth = "carsFreeWidth";
    public static final String ProfileCFreeDepth = "carsFreeDepth";
    public static final String ProfileCFreeWeight = "carsFreeWeight";
    public static final String ProfileCMaxHeight = "carsMaxHeight";
    public static final String ProfileCMaxWidth = "carsMaxWidth";
    public static final String ProfileCMaxDepth = "carsMaxDepth";
    public static final String ProfileCMaxWeight = "carsMaxWeight";

    private Vehicle vehicle;

    public CarsPage(Context ctx){
        super(ctx);
        templateFilePath="profile/cars/carsProfile.jte";
    }

    public CarsPage setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public Optional<Vehicle> getVehicle() {
        return Optional.ofNullable(vehicle);
    }

    @Override
    public String getTemplate(){
        return templateFilePath;
    }

    public static String getDynamicPath(String username) {
        return Optional.ofNullable(username).map(name -> PATH_STATIC.replace(":username", name)).orElse("404error");
    }
}
