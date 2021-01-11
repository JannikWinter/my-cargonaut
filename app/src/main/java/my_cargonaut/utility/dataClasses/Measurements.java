package my_cargonaut.utility.dataClasses;

public class Measurements extends Size {

    private double weight;

    public Measurements(double height, double length, double depth, double weight) {
        super(height, length, depth);
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getDepth() {
        return depth;
    }

    public double getWeight() { return weight; }
}
