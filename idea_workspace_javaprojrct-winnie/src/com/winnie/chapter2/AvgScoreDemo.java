package com.winnie.chapter2;

public class AvgScoreDemo {
    public static void main(String[] args) {
        //1 变量的声明并赋值
        double avgScore1=81.29;
        double avgScore2;
        int rise=2;
        //2 处理数据
        avgScore2=avgScore1+rise; //double和int累加返回的是double类型，叫数据类型提升
        //3 输出结果
        System.out.println("第二次平均分是:"+avgScore2);
    }
}
