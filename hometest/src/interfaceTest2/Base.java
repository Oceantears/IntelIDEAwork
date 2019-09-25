/**
 * <一句话功能简述>
 * <Java8新特性01 在接口中允许有默认方法和静态方法>
 *
 * @author sunmeng
 * @create 2019/9/23   17:44
 */
package interfaceTest2;

public interface Base {
    public default void f1(){                     //只能是public,abstract，default
        System.out.println("Hello World!!====================>f1()");
    }
    default void f2(){
        System.out.println("Hello World!====================>f2()");
    }
    public void f3();
    public static void f4(){
        System.out.println("Hello World!====================>f4()");
    }
    default String f5(){
        return "Hello World!=========================>f5()";
    }

    default int f6(int x){
        System.out.println("传入的值是："+x);
        return x;
    }
}
