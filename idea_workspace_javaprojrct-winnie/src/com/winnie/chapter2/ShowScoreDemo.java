package com.winnie.chapter2;

public class ShowScoreDemo {
    public static void main(String[] args) {
        //1 声明变量并赋值
        int stbScore=89;
        int javaScre=90;
        int sqlScore=60;
        //2 对数据进行处理
        int difference;
        double avgScore;
        difference=javaScre-sqlScore;
        avgScore=(stbScore+javaScre+sqlScore)/3;
        //3 输出处理的结果
        System.out.println("————————————");
        System.out.println("STB\t\tJava\tSQL");
        System.out.println(stbScore+"\t\t"+javaScre+"\t\t"+sqlScore);
        System.out.println("————————————");
        System.out.println("Java课和SQL课的分数之差:"+difference);
        System.out.println("3门课的平均分是:"+avgScore);
    }
}
