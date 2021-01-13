package my_cargonaut.utility.data_classes.offers;

import my_cargonaut.utility.data_classes.Measurements;
import my_cargonaut.utility.data_classes.Tour;
import my_cargonaut.utility.data_classes.user.User;
import my_cargonaut.utility.data_classes.Vehicle;

import java.util.Optional;

public class Offer implements java.io.Serializable {

    private static long numberOfOffers = 0L;

    // use userid here instead?
    private User user;
    private Tour tour;
    private long offerID;
    private Measurements freeSpace;
    private Vehicle vic;

    public User offerAcceptor;

    public Offer(User user, Tour tour, Measurements freeSpace, Vehicle vehicle) {
        this.user = user;
        this.tour = tour;
        this.offerID = numberOfOffers++;
        this.freeSpace = freeSpace;
        this.vic = vehicle;
        this.offerAcceptor = null;
    }

    public User getUser() {
        return user;
    }

    public Tour getRoute() {
        return tour;
    }

    public Optional<Vehicle> getVehicle() {
        return Optional.ofNullable(vic);
    }

    public Optional<Measurements> getFreeSpace() {
        return Optional.ofNullable(freeSpace);
    }

    public Optional<User> getOfferAcceptor() {
        return Optional.ofNullable(offerAcceptor);
    }

    public long getOfferID() {
        return this.offerID;
    }

    public boolean hasOfferAcceptor() {
        return getOfferAcceptor().isPresent();
    }

    public Offer setOfferAcceptor(User user) {
        this.offerAcceptor = user;
        return this;
    }
}
