package my_cargonaut.utility.dataClasses;

public class Size {

    protected double height, length, depth;

    public Size(double height, double length, double depth) {
        this.height = height;
        this.length = length;
        this.depth = depth;
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
}
