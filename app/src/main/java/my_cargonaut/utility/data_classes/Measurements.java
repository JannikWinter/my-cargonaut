package my_cargonaut.utility.data_classes;

import java.util.Objects;

public class Measurements extends Size implements java.io.Serializable {

    private double weight;

    public Measurements(double height, double width, double depth, double weight) {
        super(height, width, depth);
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public double getWeight() { return weight; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Measurements that = (Measurements) o;
        return Double.compare(that.getWeight(), getWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWeight());
    }
}
