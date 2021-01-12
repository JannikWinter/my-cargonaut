package my_cargonaut.utility.data_classes;

public class Vehicle {

    private String nickname;
    private String type;
    private double maxCarryWeight;
    private Measurements cargoHold;

    public Vehicle(String nickname, String type, double maxCarryWeight, Measurements cargoHold) {
        this.nickname = nickname;
        this.type = type;
        this.maxCarryWeight = maxCarryWeight;
        this.cargoHold = cargoHold;
    }

    public String getNickname() {
        return nickname;
    }

    public String getType() {
        return type;
    }

    public double getMaxCarryWeight() {
        return maxCarryWeight;
    }

    public Measurements getCargoHold() {
        return cargoHold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (Double.compare(vehicle.maxCarryWeight, maxCarryWeight) != 0) return false;
        if (nickname != null ? !nickname.equals(vehicle.nickname) : vehicle.nickname != null) return false;
        if (type != null ? !type.equals(vehicle.type) : vehicle.type != null) return false;
        return cargoHold != null ? cargoHold.equals(vehicle.cargoHold) : vehicle.cargoHold == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nickname != null ? nickname.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(maxCarryWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (cargoHold != null ? cargoHold.hashCode() : 0);
        return result;
    }
}
