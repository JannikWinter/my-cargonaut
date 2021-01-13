package my_cargonaut.profile.edit;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;
import my_cargonaut.utility.data_classes.user.User;

import java.util.Optional;

public class EditPage extends ProfileEditPage {
    private static final String PATH_ENDING = "/profile";
    public static final String PATH_STATIC = BASEPATH + PATH_ENDING;

    private final String templateFilePath;

    public static final String ProfileEForm = "editProfile";
    public static final String ProfileEPronoun = "editProfileDropdown";
    public static final String ProfileEName = "editProfileName";
    public static final String ProfileESurname = "editProfileSurname";
    public static final String ProfileEDOB = "editProfileDOB";
    public static final String ProfileEPLZ = "editProfilePLZ";
    public static final String ProfileECity = "editProfileCity";
    public static final String ProfileECellPhone = "editProfileCellphone";

    public EditPage(Context ctx){
        super(ctx);
        templateFilePath="profile/edit/editProfile.jte";
    }

    public static String getDynamicPath(String username) {
        return Optional.ofNullable(username).map(name -> PATH_STATIC.replace(":username", name)).orElse("404error");
    }


    @Override
    public String getTemplate(){
        return templateFilePath;
    }
}
