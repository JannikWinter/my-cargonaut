package my_cargonaut.profile.cars;
import my_cargonaut.offer.search.OffersSearchService;
import my_cargonaut.utility.FormManUtils;
import my_cargonaut.utility.data_classes.Measurements;
import my_cargonaut.utility.data_classes.Vehicle;
import my_cargonaut.utility.data_classes.offers.Offer;
import my_cargonaut.utility.data_classes.offers.OfferPool;
import my_cargonaut.utility.data_classes.user.User;
import my_cargonaut.utility.data_classes.user.UserRegister;
import java.text.ParseException;
import java.util.*;
public class CarsPageService {
    private static CarsPageService instance;

    private CarsPageService(){

    }

    public static CarsPageService getInstance(){
        if(CarsPageService.instance == null){
            CarsPageService.instance = new CarsPageService();
        }
        return CarsPageService.instance;
    }

}
