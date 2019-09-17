/**
 * <一句话功能简述>
 * <关于String类函数的一些用法>
 *
 * @author sunmeng
 * @create 2019/9/1619:33
 */
package homework20190916;

import java.util.Scanner;

public class StringMethod {
    public static void main(String[] args) {
        // String s="  I love Java.       ";
        // boolean isEmpty=s.isEmpty();
        // char five=s.charAt(5);
        // String s1=s.toLowerCase();
        // String s2=s.toUpperCase();
        // String s3=s.replace('a','e');
        // String s4=s.replace("Java","C#");
        // String[] s5=s.split(" ");
        // String s6=s.trim();               //除去两端空格
        // System.out.println(isEmpty);
        // System.out.println(five);
        // System.out.println(s1);
        // System.out.println(s2);
        // System.out.println(s3);
        // System.out.println(s4);
        // System.out.println(s6);
        // System.out.println("=====================================");
        // for(String n:s5){
        //     System.out.println(n);
        // }

        // String n1="name";
        // System.out.println(getPropertyGetMethodName(n1));

        getIndexString();
    }

    //2.分析以下需求，并用代码实现：
    // 	(1)定义如下方法public static String getPropertyGetMethodName(String property);
    // 	(2)该方法的参数为String类型，表示用户给定的成员变量的名字，返回值类型为String类型，返回值为成员变量对应的get方法的名字
    // 	(3)如：用户调用此方法时给定的参数为"name",该方法的返回值为"getName"
    public static String getPropertyGetMethodName(String property){
        return "get"+property.substring(0,1).toUpperCase()+property.substring(1);
    }

    //3.分析以下需求，并用代码实现：
    // 	(1)定义数字字符串数组{"010","3223","666","7890987","123123"}
    // 	(2)判断该数字字符串数组中的数字字符串是否是对称(第一个数字和最后一个数字相等，第二个数字和倒数第二个数字是相等的，依次类推)的，并逐个输出
    // 	(3)如：010 是对称的，3223 是对称的，123123 不是对称的
    // 	(4)最终打印该数组中对称字符串的个数
    //
    // 	提示：循环获取字符串的每一个字符，依次比较第一个和最后一个，第二个和倒数第二个。。。
    public static void getIndexString(){
        String[] numString={"010","3223","666","7890987","123123"};
        int count=0;
        for(String s:numString){
            boolean isThat=true;
            for(int i=0;i<(s.length()/2);i++){
                if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                    isThat=false;
                    break;
                }
            }
            if(isThat==true){
                count++;
            }
        }
        System.out.println("数组中的对称字符串个数为："+count);
    }


    //4.分析以下需求，并用代码实现：
    // 	(1)从键盘循环录入录入一个字符串,输入"end"表示结束
    // 	(2)将字符串中大写字母变成小写字母，小写字母变成大写字母，其它字符用"*"代替,并统计字母的个数
    // 		举例:
    // 			键盘录入：Hello12345World
    // 			输出结果：hELLO*****wORLD
    // 					  总共10个字母
    public static void stringTest(){
        Scanner scan=new Scanner(System.in);
        while (true){
            System.out.println("请输入字符串：");
            String s=scan.nextLine();
            if(s.equalsIgnoreCase("end")){
                break;
            }


        }
    }

}
