package my_cargonaut.utility.dataClasses;

public class Location {

    private final double lon, lat;
    private final String locationName;
    private final String country;

    public Location(double lon, double lat, String location, String country) {
        // Todo: Check if this is right order!
        this.lon = lon;
        this.lat = lat;
        this.locationName = location;
        this.country = country;
    }

    public double getLongtitude() {
        return lon;
    }

    public double getLatitude() {
        return lat;
    }

    public String getLocatioNname() {
        return locationName;
    }

    public String getCountry() {
        return country;
    }
}
