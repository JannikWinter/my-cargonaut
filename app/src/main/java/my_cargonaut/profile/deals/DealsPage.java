package my_cargonaut.profile.deals;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;

public class DealsPage extends ProfileEditPage {
    public static final String PATH = "/dealsProfile";
    private final String templateFilePath;


    public DealsPage(Context ctx){
        super(ctx);
        templateFilePath="/profile/deals/dealsProfile.jte";
    }

    @Override
    public String getTemplate(){
        return templateFilePath;
    }
}
