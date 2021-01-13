package my_cargonaut.profile.deals;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;
import my_cargonaut.utility.data_classes.offers.Offer;

import java.util.List;
import java.util.Optional;

public class DealsPage extends ProfileEditPage {

    private static final String PATH_ENDING = "/deals";
    public static final String PATH_STATIC = BASEPATH + PATH_ENDING;

    public final String dealsPageForm = "dealsPageForm";
    public final String dealsPageFormAcceptionUser = "dealsPageFormAcceptor";
    public final String dealsPageFormOfferID = "dealsPageFormOfferID";

    private final String templateFilePath;

    private List<Offer> offerList;

    public DealsPage(Context ctx){
        super(ctx);
        templateFilePath="profile/deals/dealsProfile.jte";
    }

    public static String getDynamicPath(String username) {
        return Optional.ofNullable(username).map(name -> PATH_STATIC.replace(":username", name)).orElse("404error");
    }

    public List<Offer> getOfferList() {
        return this.offerList;
    }

    public DealsPage addOffersList(List<Offer> list) {
        this.offerList = list;
        return this;
    }

    @Override
    public String getTemplate(){
        return templateFilePath;
    }
}
