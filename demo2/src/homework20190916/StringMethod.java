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

        // getIndexString();

        // stringTest();

        Scanner scan=new Scanner(System.in);
        System.out.println("输入两个字符串：");
        String str1=scan.nextLine();
        String str2=scan.nextLine();
        System.out.println("筛选完的字符串为："+deleteSubString(str1,str2)[0]);
        System.out.println("包含str2的个数为："+deleteSubString(str1,str2)[1]);
        System.out.println("================================第二种方法==================================");
        System.out.println("筛选完的字符串为："+deleteSubString2(str1,str2)[0]);
        System.out.println("包含str2的个数为："+deleteSubString2(str1,str2)[1]);
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
            //System.out.println(s);
            int upper=0;
            int lower=0;
            char[] chars=new char[s.length()];        //建一个char数组容纳String中改变以后的字符
            for(int i=0;i<s.length();i++){
                if(Character.isDigit(s.charAt(i))){
                    chars[i]='*';
                }
                if(Character.isUpperCase(s.charAt(i))){
                    chars[i]=s.substring(i,i+1).toLowerCase().charAt(0);
                    upper++;
                }
                if(Character.isLowerCase(s.charAt(i))){
                    chars[i]=s.substring(i,i+1).toUpperCase().charAt(0);
                    lower++;
                }
            }
            String s1=String.copyValueOf(chars);           //将chars中的字符数组连在一起组成字符串
            System.out.println(s1);
        }
    }

    //5.分析以下需求，并用代码实现：
    // 	(1)从键盘循环录入录入一个字符串,输入"end"表示结束
    // 	(2)定义一个方法
    // 		public Object[] deleteSubString(String str1,String str2) {
    //
    // 		}
    // 	(3)方法功能描述:从str1中删除所有的str2,并返回删除后的结果,返回结果为Object[]数组
    // 		* 该数组的第一个元素为删除所有的str2后的最终的字符串
    // 		* 该数组的第二个元素为删除的str2的个数

    //第一种方法：
    public static Object[] deleteSubString(String str1,String str2){
        Object[] objects=new Object[2];

        int count=0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)==str2.charAt(0)&&str1.substring(i,i+str2.length()).equals(str2)){
                str1=str1.substring(0,i)+str1.substring(i+str2.length(),str1.length());
                count++;
            }
        }
        objects[0]=str1;
        objects[1]=count;
        return objects;
    }
    //第二种方法：
    public static Object[] deleteSubString2(String str1,String str2){
        Object[] objects=new Object[2];
        String[] str=str1.split(str2);
        String str3="";
        for(int i=0;i<str.length;i++){
            str3+=str[i];
        }
        int count=(str1.length()-str3.length())/str2.length();
        objects[0]=str3;
        objects[1]=count;
        return objects;
    }
}

//6.关于String类的练习题，分析运行结果？
class Test01 {
    public static void main(String[] args) {
        //demo1();
        //demo2();
        //demo3();
        //demo4();
        demo5();
    }
    private static void demo5() {
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        System.out.println(s3 == s2);
        System.out.println(s3.equals(s2)); 		//true
    }
    private static void demo4() {
        //byte b = 3 + 4;						//在编译时就变成7,把7赋值给b,常量优化机制
        String s1 = "a" + "b" + "c";//java中有常量优化机制,在编译时期就能确定s2的值为"abc",所以编译时期,在常量池中创建"abc"
        String s2 = "abc";//执行到这里时常量池中已经有了"abc",所以就不再创建,所以s1和s2指向的是常量池中同一个字符串常量"abc"
        System.out.println(s1 == s2); 			//true,java中有常量优化机制
        System.out.println(s1.equals(s2)); 		//true
    }
    private static void demo3() {//==比较的是地址值
        String s1 = new String("abc");			//录的是堆内存对象的地址值
        String s2 = "abc";						//记录的是常量池中的地址值
        System.out.println(s1 == s2); 			//false
        System.out.println(s1.equals(s2)); 		//true
    }
    private static void demo2() {
        //创建几个对象
        //创建两个对象,一个在常量池中,一个在堆内存中
        String s1 = new String("abc");
        System.out.println(s1);
    }
    private static void demo1() {				//常量池中没有这个字符串对象,就创建一个,如果有直接用即可
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); 			//==号比较的是地址值,true
        System.out.println(s1.equals(s2)); 		//比较的是字符串的内容:true
    }
}