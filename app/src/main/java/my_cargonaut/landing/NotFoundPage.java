package my_cargonaut.landing;

import io.javalin.http.Context;
import my_cargonaut.Page;

public class NotFoundPage extends Page {

    private final String templateFilePath;

    public NotFoundPage(Context ctx) {
        super(ctx);
        this.hideNavBarNavigation = true;
        this.templateFilePath = "landing/notFound.jte";
    }

    @Override
    public String getTemplate() {
        return templateFilePath;
    }
}
