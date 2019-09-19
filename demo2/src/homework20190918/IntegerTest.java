/**
 * <一句话功能简述>
 * <关于Integer包装类的一些测试>
 *
 * @author sunmeng
 * @create 2019/9/19   14:17
 */
package homework20190918;

public class IntegerTest {
    public static void main(String[] args) {
        //  1
        Integer a=new Integer(125);
        Integer b=new Integer(125);
        System.out.println(a==b);

        // 2
        Integer a1=new Integer(125);
        Integer b1=125;
        System.out.println(a1==b1);

        //  3
        Integer a2=125;
        Integer b2=125;
        System.out.println(a2==b2);

        //  4
        /*
        注：Integer在常量池中的值范围是-128到127，超出这个范围时，创建Integer对象就要重新new一个Integer，这时候指向地址会不同。
         */
        Integer a3=128;
        Integer b3=128;
        System.out.println(a3==b3);

        //  5
        Integer a4=new Integer(128);
        Integer b4=new Integer(128);
        System.out.println(a4==b4);

        //  6
        Integer a5=new Integer(128);
        Integer b5=128;
        System.out.println(a5==b5);

        //  7
        /*
        Integer与int比较的时候，会自动拆箱进行比较，是数值比较
         */
        int i=128;
        Integer k=128;
        System.out.println(i==k);
    }
}
