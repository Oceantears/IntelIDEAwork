package practice20190909;

import static java.lang.Math.*;

abstract class Shape{
    public abstract double shapeArea();
    public abstract double shapeGirth();
}
class Circle extends Shape{
    private double radius;         //半径
    public Circle(double radius){
        this.radius=radius;
    }
    @Override
    public double shapeArea(){
        return PI*radius*radius;
    }
    @Override
    public double shapeGirth(){
        return 2*PI*radius;
    }

}
class Rect extends Shape{
    private double length;
    private double width;

    public Rect(double length,double width){
        this.length=length;
        this.width=width;
    }
    @Override
    public double shapeArea(){
        return width*length;
    }
    @Override
    public double shapeGirth(){
        return 2*(width+length);
    }
}
class Square extends Rect{
    public Square(double length){
        super(length,length);
    }
}
public class AreaAndGirth {
    public static void main(String[] args) {
//        Rect rect=new Rect(10,20);
//        System.out.println(rect.shapeArea());
//
//        Square square=new Square(10);
//        System.out.println(square.shapeArea());

        Shape[] shapes=new Shape[3];
        for(int i=0;i<3;i++){
            switch (i){
                case 0:
                    shapes[i]=new Circle(3);
                    break;
                case 1:
                    shapes[i]=new Rect(5,2);
                    break;
                case 2:
                    shapes[i]=new Square(4);
                    break;
            }
        }
        for(Shape shape:shapes){
            System.out.println(shape.shapeArea()+"\t"+shape.shapeGirth());
        }

    }
    public static Shape getShape(int i){
        Shape[] shapes=new Shape[3];
        switch (i){
            case 0:
                return new Circle(1);
            case 1:
                return new Rect(3,2);
            case 2:
                return new Square(2);
        }
        return shapes[i];
    }
    public static void getAreaAndGirth(Shape shape){
        System.out.println(shape.shapeArea());
        System.out.println(shape.shapeGirth());
    }
}
