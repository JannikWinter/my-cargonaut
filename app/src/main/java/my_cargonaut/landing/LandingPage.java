package my_cargonaut.landing;

import io.javalin.http.Context;
import my_cargonaut.utility.SearchPage;

public class LandingPage extends SearchPage {

    public static final String PATH = "/";
    private final String templateFilePath;

    public LandingPage(Context ctx) {
        super(ctx);
        templateFilePath = "landing/landing.jte";
    }

    @Override
    public String getTemplate() {
        return templateFilePath;
    }
}
