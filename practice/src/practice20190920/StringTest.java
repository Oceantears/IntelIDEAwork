/**
 * <一句话功能简述>
 * <考试>
 *1.声明一个String类的变量并初始化值“HelloWorld”。
 * 1)用字符串类的一个方法将上面变量的值拆分成” Hello”和“World”两个字符串并打印输出。
 * 2）将” Hello”这个变量转换成大写、“World”转换成 小写并打印输出。
 * 声明一个String类的变量并初始化值“20100110”。
 * 1）	将上面变量的值转换成2010年1月10日的形式打印输出。
 * @author sunmeng
 * @create 2019/9/20   11:11
 */
package practice20190920;

import java.util.Date;

public class StringTest {
    public static void main(String[] args) {
        String s="HelloWorld";
        String s1=s.substring(0,5);
        String s2=s.substring(5);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("==================================");
        System.out.println(s1.toUpperCase());
        System.out.println(s2.toLowerCase());
        System.out.println("==================================");
        String s3="20100110";
        Date date=new Date();
        date.setYear(2012);
        date.setMonth(10);
        date.setDate(10);
        System.out.println(date.toString());

    }
}
