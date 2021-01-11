package my_cargonaut.offer.creation;

import io.javalin.http.Handler;
import my_cargonaut.utility.FormManUtils;
import my_cargonaut.utility.SessionManUtils;

import java.text.ParseException;
import java.util.*;

public class OfferCreationController {

    private static final OfferCreationService offerCreationService = OfferCreationService.getInstance();

    public static Handler serveOfferCreationPage = ctx -> {
        OfferCreationPage page = new OfferCreationPage(ctx);
        page.render();
    };

    public static Handler handleOfferCreationPost = ctx -> {
        OfferCreationPage page;
        OfferCreationService.OfferBuilder offerBuilder;

        Optional<String> currentlyLoggedInUser = SessionManUtils.getUserInSession(ctx);
        try {
            if(currentlyLoggedInUser.isEmpty()) {
                // should not happen: Creation of offer while not logged in
                page = new OfferCreationPage(ctx);
                page.markOfferCreationFailure("Ein nicht angemeldeter Nutzer kann keine Angebote erstellen").render();
                return;
            }
            Map<String, String> map = FormManUtils.createFormParamMap(ctx);
            Date date = FormManUtils.parseDateFromFromParam(map.get(OfferCreationPage.offerCFormStartTime));

            offerBuilder = offerCreationService.getOfferBuilder(currentlyLoggedInUser.get())
                    .setStarLocation(map.get(OfferCreationPage.offerCFormStart), "Test", 0.0, 0.0)
                    .setDestinationLocation(map.get(OfferCreationPage.offerCFormDest), "Test", 0.0, 0.0)
                    .setStartTime(date)
                    .setTourCapabilities(
                            Double.parseDouble(map.get(OfferCreationPage.offerCFormHeight)),
                            Double.parseDouble(map.get(OfferCreationPage.offerCFormLength)),
                            Double.parseDouble(map.get(OfferCreationPage.offerCFormDepth)),
                            Double.parseDouble(map.get(OfferCreationPage.offerCFormWeight))
                    );
            offerBuilder.createOffer();

            page = new OfferCreationPage(ctx);
            page.markOfferCreationSuccess().render();
        } catch (ParseException | IllegalStateException e) {
            /*
             *      !!! SHOULD NOT HAPPEN !!!
             *      IllegalStateException MAY be thrown by offerBuilder.createOffer();
             *      ParseException may be thrown if the Date-Format is wrong
             */
            page = new OfferCreationPage(ctx);
            page.markOfferCreationFailure(e.getMessage()).render();
        }
    };
}
