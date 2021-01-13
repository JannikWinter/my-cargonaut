package my_cargonaut.utility.data_classes.offers;

import my_cargonaut.utility.data_classes.Location;
import my_cargonaut.utility.data_classes.Measurements;
import my_cargonaut.utility.data_classes.Vehicle;
import my_cargonaut.utility.data_classes.user.User;

import java.util.*;
import java.util.stream.Collectors;

public class OfferPool implements java.io.Serializable {

    private static OfferPool instance;

    private final List<Offer> offerList;

    private OfferPool() {
        this. offerList = new LinkedList<>();
    }

    public static OfferPool getInstance() {
        if(OfferPool.instance == null) {
            OfferPool.instance = new OfferPool();
        }
        return OfferPool.instance;
    }

    public boolean addOffer(Offer offer) {
        return this.offerList.add(offer);
    }

    public List<Offer> filterOffers(OfferFilter filter) {
        return offerList.stream()
                .filter(offer -> {
                    if(filter.user != null) {
                        if(!filter.user.equals(offer.getUser())) return false;
                    }
                    if(filter.startLoc != null) {
                        if(!filter.startLoc.equals(offer.getRoute().getStartLoc())) return false;
                    } else {
                        if(filter.startLocName != null && !filter.startLocName.equals(offer.getRoute().getStartLoc().getLocationName())) {
                            return false;
                        }
                    }
                    if(filter.destLoc != null) {
                        if(!filter.destLoc.equals(offer.getRoute().getEndLoc())) return false;
                    } else {
                        if(filter.destLocName != null && !filter.destLocName.equals(offer.getRoute().getEndLoc().getLocationName())) {
                            return false;
                        }
                    }
                    if(filter.startD != null) {
                        Date offerStartDate = offer.getRoute().getStartTime();
                        if(!filter.startD.equals(offer.getRoute().getStartTime())) return false;

                        if(filter.startD.after(offerStartDate)) return false;
                        if(filter.endD.before(offerStartDate)) return false;
                    }
                    if(filter.freeSpace != null) {
                        if(offer.getFreeSpace().isPresent()) {
                            Measurements cargoMeas = filter.freeSpace;
                            Measurements cargoHold = offer.getFreeSpace().get();

                            return (!(cargoHold.getHeight() < cargoMeas.getHeight()))
                                    && (!(cargoHold.getWidth() < cargoMeas.getWidth()))
                                    && (!(cargoHold.getDepth() < cargoMeas.getDepth()))
                                    && (!(cargoHold.getWeight() < cargoMeas.getDepth()));
                        }
                    } else {
                        if(offer.getFreeSpace().isPresent()) {
                            Measurements cargoHold = offer.getFreeSpace().get();
                            if(filter.getHeight().isPresent() && cargoHold.getHeight() < cargoHold.getHeight()) return false;
                            if(filter.getWidth().isPresent() && cargoHold.getWidth() < cargoHold.getWidth()) return false;
                            if(filter.getDepth().isPresent() && cargoHold.getDepth() < cargoHold.getDepth()) return false;
                            return filter.getWeight().isEmpty() || !(cargoHold.getWeight() < cargoHold.getWeight());
                        }
                    }
                    return true;
                }).collect(Collectors.toCollection(LinkedList::new));
    }

    public OfferFilter getOfferFilter() {
        return new OfferFilter();
    }


    public class OfferFilter {

        public User user;
        public String startLocName, destLocName;
        public Location startLoc, destLoc;
        public Date startD, endD;
        public Measurements freeSpace;
        private Map<String, Double> measurements;
        public Vehicle vehicle;
        public long offerID;

        private OfferFilter() {
            measurements = new HashMap<>();
            offerID = -1L;
        }

        public void setMeasurementsMap(Map<String, Double> measMap) {
            this.measurements = measMap;
        }

        public Optional<Double> getHeight() {
            return Optional.ofNullable(measurements.get("height"));
        }

        public Optional<Double> getWidth() {
            return Optional.ofNullable(measurements.get("width"));
        }

        public Optional<Double> getDepth() {
            return Optional.ofNullable(measurements.get("depth"));
        }

        public Optional<Double> getWeight() {
            return Optional.ofNullable(measurements.get("weight"));
        }

        public List<Offer> applyFilter() {
            return filterOffers(this);
        }
    }
}
