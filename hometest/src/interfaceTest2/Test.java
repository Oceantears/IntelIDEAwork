/**
 * <一句话功能简述>
 * <对以上接口继承测试>
 *
 * @author sunmeng
 * @create 2019/9/23   17:56
 */
package interfaceTest2;

public class Test {
    public static void main(String[] args) {
        Sub sub=new Sub();
        sub.f1();
        sub.f2();
        sub.f3();
        Base.f4();
        sub.f5();
        sub.f6(10);
    }
}
