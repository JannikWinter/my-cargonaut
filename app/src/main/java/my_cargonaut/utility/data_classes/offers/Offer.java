package my_cargonaut.utility.data_classes.offers;

import my_cargonaut.utility.data_classes.Measurements;
import my_cargonaut.utility.data_classes.Tour;
import my_cargonaut.utility.data_classes.user.User;
import my_cargonaut.utility.data_classes.Vehicle;

import java.util.Optional;

public class Offer {

    // use userid here instead?
    private User user;
    private Tour tour;
    private Measurements freeSpace;
    private Vehicle vic;

    public Offer(User user, Tour tour, Measurements freeSpace, Vehicle vehicle) {
        this.user = user;
        this.tour = tour;
        this.freeSpace = freeSpace;
        this.vic = vehicle;
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
}
