/**
 * <一句话功能简述>
 * <对i++的测试>
 *
 * @author sunmeng
 * @create 2019/9/24   10:07
 */
package java_base;

public class Int_test {
    public static void main(String[] args) {
        Integer a=0;
        int b=0;
        for (int i = 0; i <99 ; i++) {
            a=a++;
            b=a++;
        }
        System.out.println(a);
        System.out.println(b);
    }
}
