package my_cargonaut.landing;

import io.javalin.http.Context;

public class LogoutPage extends LandingPage {

    public static final String PATH = "/logout";

    public LogoutPage(Context ctx) {
        super(ctx);
    }
}
