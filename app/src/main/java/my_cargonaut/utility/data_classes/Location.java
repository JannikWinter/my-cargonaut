package my_cargonaut.utility.data_classes;

public class Location implements java.io.Serializable {

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

    public String getLocationName() {
        return locationName;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (Double.compare(location.lon, lon) != 0) return false;
        if (Double.compare(location.lat, lat) != 0) return false;
        if (!locationName.equals(location.locationName)) return false;
        return country.equals(location.country);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(lon);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + locationName.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }
}
