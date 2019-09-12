package homework20190904;

class Complex{
    private double real;
    private double im;

    public double getReal() {
        return real;
    }
    public void setReal(double real) {
        this.real = real;
    }
    public double getIm() {
        return im;
    }
    public void setIm(double im) {
        this.im = im;
    }
    //复数与复数相加
    public Complex add(Complex c){
        Complex complex=new Complex();
        complex.setReal(this.getReal()+c.getReal());
        complex.setIm(this.getIm()+c.getIm());

        return complex;
    }
    //复数与实数相加
    public Complex add(double real){
        Complex complex=new Complex();
        complex.setReal(this.getReal()+real);

        return complex;
    }

    //复数与复数相减
    public Complex sub(Complex c){
        Complex complex=new Complex();
        complex.setReal(this.getReal()-c.getReal());
        complex.setIm(this.getIm()-c.getIm());

        return complex;
    }
    //复数与实数相减
    public Complex sub(double real){
        Complex complex=new Complex();
        complex.setReal(this.getReal()-real);

        return complex;
    }

    //复数与复数相乘
    public Complex mul(Complex c){
        Complex complex=new Complex();

        return complex;
    }
    //复数与实数相乘
    public Complex mul(double real){
        Complex complex=new Complex();

        return complex;
    }
}
public class MathOfComplex {
    public static void main(String[] args) {
        Complex cop=new Complex();
    }
}
