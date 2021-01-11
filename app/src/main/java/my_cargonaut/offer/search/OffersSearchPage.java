package my_cargonaut.offer.search;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my_cargonaut.Page;
import my_cargonaut.utility.SearchPage;

public class OffersSearchPage extends SearchPage {

    public static final String PATH = "/searchOffers";
    private final String templateFilePath;


    public final String offerSearchFormCargoHeight = "offerSearchFormCargoHeight";
    public final String offerSearchFormCargoWidth = "offerSearchFormCargoWidth";
    public final String offerSearchFormCargoDepth = "offerSearchFormCargoLength";

    public OffersSearchPage(Context ctx) {
        super(ctx);
        templateFilePath = "offer/search/searchOffers.jte";
    }

    @Override
    public String getTemplate() {
        return templateFilePath;
    }
}
