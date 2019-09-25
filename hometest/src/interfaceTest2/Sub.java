/**
 * <一句话功能简述>
 * <实现Base接口>
 *
 * @author sunmeng
 * @create 2019/9/23   17:52
 */
package interfaceTest2;

public class Sub implements Base {
    @Override
    public void f3(){
        System.out.println("Hello World!====================>f3()");
    }

    public void f2(){                 //只能用public修饰，因为父类是public，子类不能缩小父类的访问权限
        System.out.println("我是重写的f2()");
    }
}
