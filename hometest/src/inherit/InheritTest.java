/**
 * <一句话功能简述>
 * <关于继承的练习>
 *
 * @author sunmeng
 * @create 2019/9/20   16:54
 */
package inherit;

public class InheritTest {
    public static void main(String[] args) {
        A a=new A();
        B b=new B();
        C c=new C();
        D d=new D();
        System.out.println(a.get(a));
        System.out.println(a.get(d));
        System.out.println(a.get(b));
        System.out.println(b.get(a));
        System.out.println(b.get(c));
        System.out.println(b.get(d));
    }
}
class A{
    String get(D d){
        return "AD";
    }
    String get(A a){
        return "AA";
    }
}
class B extends A{
    String get(A a){
        return "BA";
    }
    String get(B b){
        return "BB";
    }
}
class C extends B{}
class D extends B{}