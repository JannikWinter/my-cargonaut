package my_cargonaut.profile.edit;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;

public class EditPage extends ProfileEditPage {
    public static final String PATH = "/editProfile";
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
        templateFilePath="/profile/edit/editProfile.jte";
    }

    @Override
    public String getTemplate(){
        return templateFilePath;
    }
}
