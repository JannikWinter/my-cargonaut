package my_cargonaut.profile.deals;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;

public class CarsPage extends ProfileEditPage {
    public static final String PATH = "/";
    private final String templateFilePath;


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
