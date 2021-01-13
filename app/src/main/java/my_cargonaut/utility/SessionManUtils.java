package my_cargonaut.utility;

import io.javalin.http.Context;
import my_cargonaut.utility.data_classes.user.User;
import my_cargonaut.utility.data_classes.user.UserRegister;

import java.util.Optional;

public class SessionManUtils {

    public static final String sessionAttributeLoggedInUsername = "loggedInUser";
    public static final String sessionAttributeRegisteredUserName = "newlyRegisteredUser";
    public static final String sessionAttributeRedirect = "registrationRedirect";

    public static Context addSessionAttribute(Context ctx, String attributeName, String value) {
        ctx.sessionAttribute(attributeName, value);
        return ctx;
    }

    public static Context removeSessionAttribute(Context ctx, String attributeName) {
        ctx.sessionAttribute(attributeName, null);
        //ctx.sessionAttributeMap().remove(attributeName);
        return ctx;
    }

    public static Optional<User> getUserInSession(Context ctx) {
        //this actually queries with "" if no user is in this context
        return UserRegister.getInstance().getUser(ctx.sessionAttribute(SessionManUtils.sessionAttributeLoggedInUsername));
    }
}
