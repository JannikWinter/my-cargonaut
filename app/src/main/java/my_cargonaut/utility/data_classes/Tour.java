package my_cargonaut.utility.data_classes;


import java.util.Date;
import java.util.Optional;

public class Tour implements java.io.Serializable {

    private Location startLoc;
    private Location endLoc;
    private Date startTime;
    private Date estEndTime;

    public Tour(Location startLocation, Location endLocation, Date startTime, Date endTime) {
        this.startLoc = startLocation;
        this.endLoc = endLocation;
        this.startTime = startTime;
        this.estEndTime = endTime;
    }

    public Tour(Location startLocation, Location endLocation, Date startTime) {
        this(startLocation, endLocation, startTime, null);
    }

    // TODO: create second constructor that calculates endtime?


    public Location getStartLoc() {
        return startLoc;
    }

    public Location getEndLoc() {
        return endLoc;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Optional<Date> getEstEndTime() {
        return Optional.ofNullable(estEndTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (!startLoc.equals(tour.startLoc)) return false;
        if (!endLoc.equals(tour.endLoc)) return false;
        if (!startTime.equals(tour.startTime)) return false;
        return estEndTime != null ? estEndTime.equals(tour.estEndTime) : tour.estEndTime == null;
    }

    @Override
    public int hashCode() {
        int result = startLoc.hashCode();
        result = 31 * result + endLoc.hashCode();
        result = 31 * result + startTime.hashCode();
        result = 31 * result + (estEndTime != null ? estEndTime.hashCode() : 0);
        return result;
    }
}
