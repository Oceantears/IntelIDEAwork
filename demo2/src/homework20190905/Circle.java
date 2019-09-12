package homework20190905;

/**
 * 圆形
 */
public class Circle extends Patterning {
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double radius;
    @Override
    public double area() {
        return Math.PI*getRadius()*getRadius();
    }
}
