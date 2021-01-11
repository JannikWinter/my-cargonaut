package my_cargonaut.utility;

import io.javalin.http.Context;
import my_cargonaut.Page;

public abstract class SearchPage extends Page {

    public final String offerSearchForm = "offerSearchForm";
    public final String offerSearchFormOrig = "offerSearchFormOrigin";
    public final String offerSearchFormDest = "offerSearchFormDestination";
    public final String offerSearchFormStartT = "offerSearchFormStartTime";
    public final String offerSearchFormEndT = "offerSearchFormEndTime";

    public SearchPage(Context ctx) {
        super(ctx);
    }
}
