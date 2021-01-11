package my_cargonaut.offer;

import io.javalin.http.Context;
import my_cargonaut.Page;

public class OffersPage extends Page {

    public static final String PATH = "/offers";

    public OffersPage(Context ctx) {
        super(ctx);
    }

    @Override
    public String getTemplate() {
        return "offer/offers.jte";
    }
}
