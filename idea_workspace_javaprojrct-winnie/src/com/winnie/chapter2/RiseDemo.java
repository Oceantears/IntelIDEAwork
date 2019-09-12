package com.winnie.chapter2;

public class RiseDemo {
    public static void main(String[] args) {
        int before=20;
        double rise=9.8;
        int now=(int)(before+rise);//数据要兼容，大数据类型变为小数据类型，这叫强制类型转换
        System.out.println(now);
    }
}
