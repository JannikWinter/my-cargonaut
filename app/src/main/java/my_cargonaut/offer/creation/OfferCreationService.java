package my_cargonaut.offer.creation;

import my_cargonaut.utility.data_classes.offers.Offer;
import my_cargonaut.utility.data_classes.offers.OfferPool;
import my_cargonaut.utility.data_classes.user.UserRegister;
import my_cargonaut.utility.data_classes.*;
import my_cargonaut.utility.data_classes.user.User;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OfferCreationService {

    private static OfferCreationService instance;

    private final OfferPool offerPool;
    private final UserRegister userRegister;

    private OfferCreationService() {
        this.offerPool = OfferPool.getInstance();
        userRegister = UserRegister.getInstance();
    }

    public OfferBuilder getOfferBuilder(String uid) throws Exception {
        Optional<User> user = userRegister.getUser(uid);
        if(user.isEmpty()){
            throw new IllegalAccessException("The user %s does not exist in the database!".formatted(uid));
        }
        return new OfferBuilder(user.get());
    }

    private void addNewOffer(Offer offer) {
        offerPool.addOffer(offer);
    }

    public static OfferCreationService getInstance() {
        if(OfferCreationService.instance == null) {
            OfferCreationService.instance = new OfferCreationService();
        }
        return OfferCreationService.instance;
    }


    /*
            Inner class in order to build an offer
     */
    public class OfferBuilder {

        private final User user;

        // Tour
        private Location startLoc;
        private Location endLoc;
        private Date startTime;
        private Date estEndTime;

        // Measurements
        private Measurements measurements;

        // Vehicle
        private Vehicle vehicle;

        private OfferBuilder(User user) {
            this. user = user;
        }

        public void createOffer() throws IllegalStateException {
            Offer offer;
            Tour tour;
            if(startLoc == null || endLoc == null || startTime == null) {
                throw new IllegalStateException("Before building you need to set at least a starting location, a destination and a start data!");
            }
            if(estEndTime == null) {
                tour = new Tour(startLoc, endLoc, startTime);
            } else {
                tour = new Tour(startLoc, endLoc, startTime, estEndTime);
            }
            setVehicle(vehicle == null ? user.getVehicle() : vehicle);

            offer = new Offer(user, tour, measurements, vehicle);
            addNewOffer(offer);
        }

        // Todo: Is that cool?
        public OfferBuilder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public OfferBuilder setTourCapabilities(double height, double length, double depth, double weight) {
            this.measurements = new Measurements(height, length, depth, weight);
            return this;
        }

        public OfferBuilder setStarLocation(String name, String country, double lon, double lat) {
            this.startLoc = new Location(lon, lat, name, country);
            return this;
        }

        public OfferBuilder setDestinationLocation(String name, String country, double lon, double lat) {
            this.endLoc = new Location(lon, lat, name, country);
            return this;
        }

        public OfferBuilder setStartTime(Date start) {
            this.startTime = start;
            return this;
        }

        public OfferBuilder setEstimatedArrival(Date end) {
            this.estEndTime = end;
            return this;
        }
    }
}
