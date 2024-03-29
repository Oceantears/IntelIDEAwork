package demo_20210523_Exception.NO1_Logger;

/**
 * @Author: sun
 * @Date: 2021/5/23 23:13
 * @Description: 自定义异常，加入额外的构造器和成员
 */
class MyException2 extends Exception{
    private int x;

    public MyException2() {
    }

    public MyException2(String message) {
        super(message);
    }

    public MyException2(String message, int x) {
        super(message);
        this.x = x;
    }
    public int val(){
        return x;
    }
    public String message(){
        return "Detail Message: "+ x + " " + super.getMessage();
    }
}

public class ExtraFeatures {
    public static void f() throws MyException2{
        System.out.println("Throwing MyException2 from f()");
        throw new MyException2();
    }
    public static void g() throws MyException2{
        System.out.println("Throwing MyException2 from g()");
        throw new MyException2("Originated in g()");
    }
    public static void h() throws MyException2{
        System.out.println("Throwing MyException2 from h()");
        throw new MyException2("Originated in h()",47);
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
        }
        try {
            h();
        } catch (MyException2 e) {
            e.printStackTrace(System.out);
            System.out.println("e.val() = " + e.val());
        }
    }
}
