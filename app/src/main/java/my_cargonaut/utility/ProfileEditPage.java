package my_cargonaut.utility;

import io.javalin.http.Context;
import my_cargonaut.Page;

public abstract class ProfileEditPage extends Page {

    protected static final String BASEPATH = "/user/:username/editProfile";

    public ProfileEditPage(Context ctx){
        super(ctx);
        pageIsNotAccessRestricted = false;
    }
}
