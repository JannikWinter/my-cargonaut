package my_cargonaut.profile.edit;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;
import my_cargonaut.utility.data_classes.user.User;

import java.util.Optional;

public class EditPage extends ProfileEditPage {
    public static final String PATH = BASEPATH + "/editProfile";
    private final String templateFilePath;

    public static final String ProfileEForm = "editProfile";
    public static final String ProfileEPronoun = "editProfileDropdown";
    public static final String ProfileEName = "editProfileName";
    public static final String ProfileESurname = "editProfileSurname";
    public static final String ProfileEDOB = "editProfileDOB";
    public static final String ProfileEPLZ = "editProfilePLZ";
    public static final String ProfileECity = "editProfileCity";
    public static final String ProfileECellPhone = "editProfileCellphone";

    private User user;

    public EditPage(Context ctx){
        super(ctx);
        templateFilePath="/profile/edit/editProfile.jte";
    }

    public EditPage setUser(User user){
        this.user = user;
        return this;
    }
    public Optional<User> getUser(){
        return Optional.ofNullable(user);
    }

    public static String getDynamicPath(String username) {
        return PATH.replace(":username", username);
    }


    @Override
    public String getTemplate(){
        return templateFilePath;
    }
}
