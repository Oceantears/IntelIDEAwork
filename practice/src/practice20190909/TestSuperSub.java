package practice20190909;


class Super{
//    {
//        System.out.println("父类代码块。");
//    }
    public Super(){
        System.out.println("Super()");
    }
    public Super(String str){
        System.out.println("Super(String)");
    }
}
class Sub extends Super{
//    {
//        System.out.println("子类代码块。");
//    }
    public Sub(){
        System.out.println("Sub()");
    }
    public Sub(int i){
        this();
        System.out.println("Sub(int)");
    }
    public Sub(String str){
        super(str);
        System.out.println("Sub(String)");
    }
}
public class TestSuperSub {
    public static void main(String args[]){
        Sub s1 = new Sub();
        Sub s2 = new Sub(10);
        Sub s3 = new Sub("hello");
    }
}
