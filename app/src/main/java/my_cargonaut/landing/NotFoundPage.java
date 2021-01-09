package my_cargonaut.landing;

import io.javalin.http.Context;
import my_cargonaut.Page;

public class NotFoundPage extends Page {

    public NotFoundPage(Context ctx) {
        super(ctx);
        this.hideNavBarNavigation = true;
    }

    @Override
    public String getTemplate() {
        return "landing/notFound.jte";
    }
}
