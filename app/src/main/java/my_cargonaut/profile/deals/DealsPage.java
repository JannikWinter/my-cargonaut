package my_cargonaut.profile.deals;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;

import java.util.Optional;

public class DealsPage extends ProfileEditPage {

    private static final String PATH_ENDING = "/deals";
    public static final String PATH_STATIC = BASEPATH + PATH_ENDING;

    private final String templateFilePath;

    public DealsPage(Context ctx){
        super(ctx);
        templateFilePath="profile/deals/dealsProfile.jte";
    }

    public static String getDynamicPath(String username) {
        return Optional.ofNullable(username).map(name -> PATH_STATIC.replace(":username", name)).orElse("404error");
    }

    @Override
    public String getTemplate(){
        return templateFilePath;
    }
}
