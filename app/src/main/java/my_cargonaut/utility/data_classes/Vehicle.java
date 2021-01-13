package my_cargonaut.utility.data_classes;

import my_cargonaut.utility.data_classes.user.CarManufacturer;

import java.util.Objects;

public class Vehicle implements java.io.Serializable {
    private CarManufacturer brand;
    private String model;
    private Measurements currentCargoHold;
    private Measurements maxCargoHold;

    public Vehicle() {
        this.brand = CarManufacturer.Lancia;
        this.model = "Delta HF Integrale \"Evoluzione\"";
        this.currentCargoHold = new Measurements(1,1,1,1);
        this.maxCargoHold = new Measurements(1,1,1,1);
    }

    public String getModel() {
        return model;
    }
    public CarManufacturer getBrand() {
        return brand;
    }

    public Measurements getCurrentCargoHold() {
        return currentCargoHold;
    }

    public Measurements getMaxCargoHold() {
        return maxCargoHold;
    }
    public void setCarInformation(CarManufacturer brand, String model, double curHeight, double curWidth,
                             double curDepth, double curWeight, double maxHeight, double maxWidth,
                             double maxDepth, double maxWeight){
        this.brand=brand;
        this.model=model;
        this.currentCargoHold=new Measurements(curHeight,curWidth,curDepth,curWeight);
        this.maxCargoHold=new Measurements(maxHeight,maxWidth,maxDepth,maxWeight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return getBrand() == vehicle.getBrand() && Objects.equals(getModel(), vehicle.getModel()) && Objects.equals(getCurrentCargoHold(), vehicle.getCurrentCargoHold()) && Objects.equals(getMaxCargoHold(), vehicle.getMaxCargoHold());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), getCurrentCargoHold(), getMaxCargoHold());
    }
}
