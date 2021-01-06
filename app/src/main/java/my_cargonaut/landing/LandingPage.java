package my_cargonaut.landing;

import io.javalin.http.Context;
import my_cargonaut.Page;

public class LandingPage extends Page {

    public static final String PATH = "/";

    public LandingPage(Context ctx) {
        super(ctx);
    }

    @Override
    public String getTemplate() {
        return "landing/landing.jte";
    }
}
