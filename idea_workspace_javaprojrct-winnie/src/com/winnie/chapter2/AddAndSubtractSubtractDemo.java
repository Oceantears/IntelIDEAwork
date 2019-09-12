package com.winnie.chapter2;

public class AddAndSubtractSubtractDemo {
    public static void main(String[] args) {
        int num1=1;
        int num2=2;
        num1++; //等价于num1=num1+1
        num2--; //等价于num2=num2-1
        /*
        * ++ --与sout一块执行的时候
        * ++ --在前时先计算后输出
        * ++ --在后时先输出再计算
         */
        System.out.println(num1++);
        System.out.println(--num2);
    }
}
