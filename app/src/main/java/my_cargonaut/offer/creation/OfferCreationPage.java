package my_cargonaut.offer.creation;

import io.javalin.http.Context;
import my_cargonaut.Page;

import java.util.Optional;

public class OfferCreationPage extends Page {

    public static final String PATH = "/createOffer";
    private final String templateFilePath;

    private boolean wasOfferCreationAttempted;
    private boolean hasOfferCreationSucceeded;
    private String creationErrorMsg;

    // Offer Creation Form
    public static final String offerCForm = "offerCreate";
    public static final String offerCFormStart = "offerCreateStartLoc";
    public static final String offerCFormDest = "offerCreateDestinationLoc";
    public static final String offerCFormStartTime = "offerCreateStartTime";
    public static final String offerCFormWeight = "offerCreateWeight";
    public static final String offerCFormHeight = "offerCreateHeight";
    public static final String offerCFormLength = "offerCreateLength";
    public static final String offerCFormDepth = "offerCreateDepth";
    public static final String offerCFormDesc = "offerCreateDescription";

    public OfferCreationPage(Context ctx) {
        super(ctx);
        pageIsNotAccessRestricted = false;
        wasOfferCreationAttempted = false;
        hasOfferCreationSucceeded = false;
        templateFilePath = "offer/creation/createOffer.jte";
    }

    public OfferCreationPage markOfferCreationSuccess() {
        this.wasOfferCreationAttempted = true;
        this.hasOfferCreationSucceeded = true;
        return this;
    }

    public OfferCreationPage markOfferCreationFailure(String errorMsg) {
        this.wasOfferCreationAttempted = true;
        this.hasOfferCreationSucceeded = false;
        this.creationErrorMsg = errorMsg;
        return this;
    }

    public boolean wasOfferCreationAttempted() {
        return this.wasOfferCreationAttempted;
    }

    public boolean hasOfferCreationSucceeded() {
        return this.wasOfferCreationAttempted && this.hasOfferCreationSucceeded;
    }

    public String getCreationErrorMsg() {
        return Optional.ofNullable(creationErrorMsg).orElse("Unbekannter Angebotserstellungsfehler");
    }

    @Override
    public String getTemplate() {
        return templateFilePath;
    }
}
