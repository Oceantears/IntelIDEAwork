package my_demo;

import java.util.ArrayList;

public class Recursion {
//    //通过递归方法写出歌曲 99 Bottles of Beer全部歌词的程序。第一段歌词为：
//    //99 bottles of beer on the wall,
//    //99 bottles of beer,
//    //ya' take one down,ya' pass it around,
//    //98 bottles of beer on the wall.
//    //最后一段歌词如下：
//    //No bottles of beer on the wall,
//    //No bottles of beer,
//    //ya' can't take one down,ya' can't pass it around,
//    //'cause there are no more bottles of beer on the wall!
//    public void recieveNum(String num){
//        if(num==0){
//            System.out.println("No bottles of beer on the wall,");
//            System.out.println("No bottles of beer,");
//        }
//        System.out.println(num+" bottles of beer on the wall,");
//        System.out.println(num+" bottles of beer,");
//        ya(num);
//        beer(num);
//
//        recieveNum(num-1);
//
//    }
//    public void ya(String n){
//        System.out.println("ya'"+n+"take one down,ya'"+n+"pass it around,");
//    }
//    public void beer(String m){
//
//    }

    /**
     * 一个关于递归的测试。
     */
    public int prod(int m,int n){
        if(m==n){
            return n;
        }
        else {
            int recurse=prod(m,n-1);
            int result=n*recurse;
            return result;
        }

    }
}
