package homeWork;

import java.util.Scanner;

public class Hw8_23 {
    Scanner scan=new Scanner(System.in);

    //【程序1】   题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
    // 小兔子长到第四个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
    //1.程序分析：   兔子的规律为数列1,1,2,3,5,8,13,21....
    public void numOfRabbit(){
        System.out.println("请输入月数： ");
        int month=scan.nextInt();
        int[] num=new int[month];
        num[0]=1;
        num[1]=1;
        for (int i=2;i<month;i++){
            num[i]=num[i-1]+num[i-2];
        }
        System.out.println("第"+month+"个月的兔子总数为： "+num[month-1]+"对。");
    }

    /**
     * 【程序2】   题目：判断301-600之间有多少个素数，并输出所有素数。
     */
    public void suShu(){
        int count=0;              //素数个数

        for(int i=301;i<=600;i++){
            boolean isSushu=true;     //是否是素数

            int sq=(int)Math.sqrt(i)+1;
            for(int j=2;j<=sq;j++){            //循环对其开根号范围内的数求余
                if(i%j==0){
                    isSushu=false;
                    break;
                }
            }
            if(isSushu==true){
                System.out.println(i+"\t");
                count++;
            }
        }
        System.out.println("301到600之间有"+count+"个素数。");
    }

    /**
     * 【程序3】   题目：利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，60-89分之间的用B表示，
     * 60分以下的用C表示。
     * 1.程序分析：(a> b)?a:b这是条件运算符的基本例子。
     */
    public void level(){
        int num=scan.nextInt();

        char level=(num>=90)?'A':(num>=60?'B':'C');
        System.out.println(level);
    }

    /**
     * 【程序4】   题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，
     * 几个数相加有键盘控制。
     * 1.程序分析：关键是计算出每一项的值。
     */
    public void sum(){
        System.out.println("请输入相加数的个数： ");
        int n=scan.nextInt();

    }

    /**
     * 【程序11】   题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
     * 1.程序分析：请抓住分子与分母的变化规律。
     */
    public void sumFenshu(){
        int[] n1=new int[20];
        int[] n2=new int[20];
        n1[0]=2;
        n1[1]=3;
        n2[0]=1;
        n2[1]=2;
        double sum=0;
        for(int i=2;i<20;i++){
            n1[i]=n1[i-1]+n1[i-2];
            n2[i]=n2[i-1]+n2[i-2];
            sum=sum+n1[i]/n2[i];
        }
        double sum20=(double)(n1[0]/n2[0])+(double)(n1[1]/n2[1])+sum;
        System.out.println("这个数列的前20项和为： "+sum20);
    }

    /**
     * 【程序12】   题目：求1+2!+3!+...+20!的和
     * 1.程序分析：此程序只是把累加变成了累乘。
     */
    public void sumOfLeiCheng(){
        int num=20;         //规定元素个数
        int sum=0;          //和初始化
        int numOfLeicheng=1;
        for(int i=1;i<=num;i++){
            numOfLeicheng=numOfLeicheng*i;
            sum=sum+numOfLeicheng;
        }
        System.out.println("1+2!+3!+...+20!的和为： "+sum);
    }

    /**
     * 【程序13】   题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
     */
    public void printNum(){
        System.out.println("请输入一个数： ");
        int num=scan.nextInt();
    }
}
