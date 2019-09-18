/**
 * <一句话功能简述>
 * <String类的应用>
 *
 * @author sunmeng
 * @create 2019/9/1721:30
 */
package homework20190916;

public class StringPractice {
    public static void main(String[] args) {
        //findString();

        // getIO();

        stringAPItest();
    }

    //1、从字符串“abcdefzhig”中取下标为偶数的字符放入另一字符串中，并输出。（用两种方法完成：①、用字符数组来完成。②、用字符串来完成。）
    public static void findString(){
        String s="abcdefzhig";
        //用字符数组来完成
        char[] ch=s.toCharArray();
        String s1="";
        for(int i=0;i<ch.length;i++){
            if(i%2==0){
                s1+=ch[i];
            }
        }
        System.out.println("用字符数组来完成的结果为："+s1);

        //用字符串来完成
        String s2="";
        for (int i=0;i<s.length();i++){
            if(i%2==0){
                s2+=s.charAt(i);
            }
        }
        System.out.println("用字符串来完成的结果为："+s2);
    }

    //2、将上题取到的字符串与“oi”连接保存于字符串str中，输出原串与新串。
    public static void getIO(){
        String s="abcdefzhig";
        String str=s.concat("oi");
        System.out.println(s);
        System.out.println(str);
    }

    //*3、编写一个java程序，完成以下功能：
    //   1） 声名为s的string对象，并使它的内容是“ Call Me Ishmael ”；
    //   2）打印整个字符串；
    //   3）使用length()方法打印字符串的长度；
    //   4）使用charAt()方法打印字符串的第一个字符；
    //   5) 使用charAt()方法和length()方法打印字符串的最后一个字符；
    //   6) 使用indexOf()方法和substring()方法打印字符串的第一个单词。
    //   7) 使用replace(char,char)将'C'替换为'B';
    //   8) 使用substring(int,int)截取Me;
    //   9) 使用indexOf(char)与substring(int，int)结合打印s中的各个单词。
    // 10) 使用lastIndexOf(char)与substring(int,int)结合将单词倒序排列。结果：Ishmael Me Call.
    // 11) 使用compareTo( ).例如，s1是字符串，s是字符串，s1.compareTo(s) 的值是负 s1<s ,值是0 s1=s.值为正 s1>s;
    // 请将上面的字符串中的每个单词取出来，并按升序排列各个单词，在屏幕上显示出来。
    // 12)将以上字符串分别转为大写和小写和输出.
    // 13)判断该字符串中是否包含me这个单词(不区分大小写)
    // 14)判断该字符串是否以Tsh开头,是否以txt结尾.
    // 15)去掉该字符串两边的空格.
    public static void stringAPItest(){
        String s=" Call Me Ishmael ";
        System.out.println("1===========>"+s);
        System.out.println("2===========>"+s.length());
        System.out.println("3===========>"+s.charAt(0));
        System.out.println("4===========>"+s.charAt(s.length()-1));
        System.out.println("5===========>"+s.substring(1,s.substring(1).indexOf(" ")+1));
        System.out.println("6===========>"+s.replace('C','B'));
        System.out.println("7===========>"+s.substring(6,8));

    }
}
