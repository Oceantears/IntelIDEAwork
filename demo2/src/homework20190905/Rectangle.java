package homework20190905;

/**
 * 矩形
 */
public class Rectangle extends Patterning {

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    private double length;
    private double heigth;

    @Override
    public double area() {
        return getHeigth()*getLength();
    }
}
