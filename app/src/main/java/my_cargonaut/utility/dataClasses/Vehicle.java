package my_cargonaut.utility.dataClasses;

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
}
