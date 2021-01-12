package my_cargonaut.profile.cars;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;

public class CarsPage extends ProfileEditPage {
    public static final String PATH = "/carsProfile";
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

    public CarsPage(Context ctx){
        super(ctx);
        //TODO add Filepath
        templateFilePath="";
    }

    @Override
    public String getTemplate(){
        return templateFilePath;
    }
}
