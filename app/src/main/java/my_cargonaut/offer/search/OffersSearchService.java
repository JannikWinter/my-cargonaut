package my_cargonaut.offer.search;

import my_cargonaut.utility.FormManUtils;
import my_cargonaut.utility.data_classes.Measurements;
import my_cargonaut.utility.data_classes.Vehicle;
import my_cargonaut.utility.data_classes.offers.Offer;
import my_cargonaut.utility.data_classes.offers.OfferPool;
import my_cargonaut.utility.data_classes.user.User;
import my_cargonaut.utility.data_classes.user.UserRegister;

import java.text.ParseException;
import java.util.*;

public class OffersSearchService {

    private static OffersSearchService instance;

    private final OfferPool offerPool;
    private final UserRegister userRegister;

    private OffersSearchService() {
        this.offerPool = OfferPool.getInstance();
        this.userRegister = UserRegister.getInstance();
    }

    public static OffersSearchService getInstance() {
        if(OffersSearchService.instance == null) {
            OffersSearchService.instance = new OffersSearchService();
        }
        return OffersSearchService.instance;
    }

    public OfferFilterConfigurator getOfferFilterConfigurator() {
        return new OfferFilterConfigurator(offerPool.getOfferFilter());
    }

    private List<Offer> queryOffers(OfferPool.OfferFilter filter) {
        return offerPool.filterOffers(filter);
    }

    public Optional<Date> getMaybeDateFromString(String dateString) throws ParseException {
        if(dateString.equals("")) return Optional.empty();
        return Optional.ofNullable(FormManUtils.parseDateFromFromParam(dateString));
    }



    /*
            provides a Builder object to map the query params to an Object
     */
    public class OfferFilterConfigurator {

        private final OfferPool.OfferFilter offerFilter;

        /*private User user;
        //private Location startLoc, destination;
        private String startLocName, destinationName;
        private Date startDate, endDate;
        private Vehicle vehicle;*/

        private final Map<String, Double> cargoMeasurements;

        private OfferFilterConfigurator(OfferPool.OfferFilter offerFilter) {
            this.offerFilter = offerFilter;
            this.cargoMeasurements = new HashMap<>();
            offerFilter.setMeasurementsMap(cargoMeasurements);
        }

        public List<Offer> queryOffersWithFilter() {
            if(this.cargoMeasurements.size() == 4) {
                this.offerFilter.freeSpace = new Measurements(cargoMeasurements.get("height"),
                        cargoMeasurements.get("width"), cargoMeasurements.get("depth"), cargoMeasurements.get("weight"));
            }
            return queryOffers(this.offerFilter);
        }

        public OfferFilterConfigurator setStartLocationName(String startLocName) {
            this.offerFilter.startLocName = startLocName;
            return this;
        }

        public OfferFilterConfigurator setDestinationName(String destName) {
            // If we were to use an Geocoding-API: Build a location-object from this String!
            this.offerFilter.destLocName = destName;
            return this;
        }

        public OfferFilterConfigurator setStartDate(Date startDate) {
            this.offerFilter.startD = startDate;
            return this;
        }

        public OfferFilterConfigurator setEndDate(Date endDate) {
            this.offerFilter.endD = endDate;
            return this;
        }

        public OfferFilterConfigurator setHeight(double d) {
            this.cargoMeasurements.put("height", d);
            return this;
        }

        public OfferFilterConfigurator setWidth(double d) {
            this.cargoMeasurements.put("width", d);
            return this;
        }

        public OfferFilterConfigurator setDepth(double d) {
            this.cargoMeasurements.put("depth", d);
            return this;
        }

        public OfferFilterConfigurator setWeight(double d) {
            this.cargoMeasurements.put("weight", d);
            return this;
        }

        public OfferFilterConfigurator setUser(String username) throws IllegalStateException {
            this.offerFilter.user = userRegister.getUser(username).orElseThrow(IllegalAccessError::new);
            return this;
        }

        public OfferFilterConfigurator setUser(User user){
            this.offerFilter.user = user;
            return this;
        }

        public OfferFilterConfigurator setVehicle(Vehicle vic) {
            this.offerFilter.vehicle = vic;
            return this;
        }

        public OfferFilterConfigurator setOfferId(long id) {
            this.offerFilter.offerID = id;
            return this;
        }
    }
}
