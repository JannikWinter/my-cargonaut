package my_cargonaut.utility.dataClasses;


import java.util.Date;
import java.util.Optional;

public class Tour {

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
}
