package my_cargonaut.utility;

import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SessionManUtils {

    public static final String sessionAttributeLoggedInUsername = "loggedInUser";
    public static final String sessionAttributeRegisteredUserName = "newlyRegisteredUser";
    public static final String sessionAttributeRedirect = "registrationRedirect";

    public static Optional<String> getUserInSession(Context ctx) {
        return Optional.ofNullable(ctx.sessionAttribute(SessionManUtils.sessionAttributeLoggedInUsername));
    }
}
