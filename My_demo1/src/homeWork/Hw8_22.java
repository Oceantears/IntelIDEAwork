package homeWork;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hw8_22 {
    Scanner sn=new Scanner(System.in);
    //4. 比较两个数的大小，并输出最大的
    public void compareNum(){
        System.out.println("请输入一个数字：");
        int a=sn.nextInt();
        System.out.println("请输入另一个数：");
        int b=sn.nextInt();
        System.out.println("这两个数比较大的是："+(a>b?a:b));
    }

    //5. 输出一个6位数的个十百千万十万位
    public void everyNum(){
        System.out.println("请输入一个六位数：");
        int receive=sn.nextInt();
        int n=(int)Math.log10(receive);
        switch (0){
            case 0:
                System.out.println("这个数的个位数是："+(receive%10));
            case 1:
                System.out.println("这个数的十位数是："+((receive/10)%10));
            case 2:
                System.out.println("这个数的百位数是："+((receive/100)%10));
            case 3:
                System.out.println("这个数的千位数是："+((receive/1000)%10));
            case 4:
                System.out.println("这个数的万位数是："+((receive/10000)%10));
            case 5:
                System.out.println("这个数的十万位数是："+((receive/100000)%10));
        }
    }

    //6.比较三个数的大小，并输出最大的和最小的（还可用三目运算）
    public void compare3(){
        System.out.println("请输入第一个数：");
        int a=sn.nextInt();
        System.out.println("请输入第二个数：");
        int b=sn.nextInt();
        System.out.println("请输入第三个数：");
        int c=sn.nextInt();
        System.out.println("最大数为："+((a>=b?a:b)>=c?(a>=b?a:b):c));
    }
    //7.输入10个数(使用数组)里面的最大的和最小的
    public void maxNum(){
        int[] a=new int[]{23,25,43645,234,1,432,4,60,35,645};
        System.out.println("数组为：");
        for(int i=0;i<a.length-1;i++){
            System.out.print(a[i]+"   ");
        }
        System.out.println();     //对上面数组进行换行
        int max=a[0];
        for(int j=1;j<a.length;j++){
            if(max>=a[j]){
                max=max;
            }
            else{
                max=a[j];
            }
        }
        System.out.println("数组里的最大数为："+max);
    }

    //8.判断指定的一个数字是否是素数.规则：1,2 是，只能被1或者本身整除的数,求100以内的素数和以及个数
    public void suShu(){
        System.out.println("请输入一个数：");
        int a=sn.nextInt();

        //看这个数是不是素数
        int b=((int)Math.sqrt(a))+1;   //对 数a开根号+1，以最短的循环判断a是否有1和自身以外的除数。

        if(a==1){
            System.out.println("1既不是素数也不是合数。");
        }
        else if(a==2){
            System.out.println("输入的是素数。");
        }
        else if(a>2){
            boolean isSuShu=true;     //初始判断是素数
            for(int i=2;i<=b;i++){
                if(a%i==0){
                    System.out.println("你输入的"+a+"不是素数。");
                    isSuShu=false;
                    break;
                }
            }
            if(isSuShu==true){
                System.out.println("你输入的"+a+"是素数。");
            }
        }
        else
            System.out.println("你输入的数不对，请重新输入。");
    }

    //9.判断一个数是否是2的N次方，规则：1 ,2 ,4,8,16..是
    public void isTwo(){
        //一个简单方法
        System.out.println("请输入一个数：");
        int a=sn.nextInt();
        double b=Math.log(a)/Math.log(2);    //Log2N=LogN/Log2,对数转换公式(Log2N表示以2为底，N的对数)
        int c=(int)b;
        if(b==(double)c){
            System.out.println("这个数"+a+"是2的"+c+"次方。");
        }
        else{
            System.out.println("此数不是2的幂数。");
        }

        //正常判断方法

    }

    //12.   1,1,2,3,5,8,...(斐波纳契数列)找出规律出入前20
    public void boNaqie(){
        System.out.println("请输入你选择的数列的第几个数：");
        int n=sn.nextInt();
        int[] num=new int[n];       //n表示数组里元素的个数
        num[0]=1;         //数组的第一个数
        num[1]=1;         //数组的第二个数
        for(int i=2;i<n;i++){             //数组元素位数从0开始，因此是n-1，包括下面的输出，没有num[n]
            num[i]=num[i-1]+num[i-2];
        }
        System.out.println("你选择的斐波纳契数列的第"+n+"个数为："+num[n-1]);
    }

    //13.   找出一个数组第二大的数。规则：有序
    public void secondLarge(){
        double[] num={576,98,56.879,98676,0,7696.566,343,98676,7654.8678,98676,7696.566};
        Arrays.sort(num);
        for(int i=num.length-1;i>0;i--){
            if(num[i-1]!=num[i]){
                System.out.println("这个数组第二大的数为："+num[i-1]);
                break;
            }
        }
    }

    //14.   找出1000以内的水仙花数 ,规则：各位立方和 等于 其本身   153  370 ,abc = a立方+b立方+c立方
    public void flowerNum(){
        System.out.print("1000以内的水仙花数为：");

        for(int i=1;i<1001;i++){
            int a=i%10;   //个位
            int b=(i/10)%10;    //十位
            int c=(i/100)%10;   //百位
            if(i==(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3))){
                System.out.print(i+"  ");
            }
        }
    }

    //15.   1-100之间所有的数的和
    public void sum(){
        int sum=0;
        int a1=1;      //第一个数
        int d=1;       //公差
        System.out.println("请输入你想求总和的数：");
        int num=sn.nextInt();
        if(num>0){
            sum=num*a1+num*(num-1)*d/2;
            System.out.println("前"+num+"个数的总和为："+sum);
        }
        else {
            System.out.println("输入的数不对，请重新输入。");
        }
    }

    //16.   1-100之间所有的不能被3整除的数的和
    public void sum3(){
        int sum=0;
        for(int i=1;i<=100;i++){
            if(i%3==0){
                continue;
            }
            sum=sum+i;
        }
        System.out.println(sum);
    }


    //17.   找出两个整数的最大公约数
    public void maxGongYue(){
        int i=2;        //从2开始循环找能共同除的数
        int a1,a2;
        System.out.println("请输入两个数：");
        int p1=sn.nextInt();
        int p2=sn.nextInt();

        a1=p1;       //保留初始值，并赋值计算；
        a2=p2;
        int a=a1<a2?a1:a2;
        do{
            if(a1%i==0&&a2%i==0){
                a1=a1/i;
                a2=a2/i;
                a=a1<a2?a1:a2;          //找除完i以后的值的最小值
            }
            else {
                i++;
            }
        }while (i<=a);
        if(a1!=p1||a2!=p2){
            System.out.println("数"+p1+"和"+p2+"的最大公约数是："+(p1/a1));
        }
        else{
            System.out.println("这两个数没有最大公约数。");
        }
    }

    //欧几里得算法求最大公约数
    public void ouJilide(){
        System.out.println("请输入两个数：");
        int p1=sn.nextInt();
        int p2=sn.nextInt();
        int min=p1<p2?p1:p2;
        int max=p1>p2?p1:p2;
        diGui(max,min);
    }
    private void diGui(int a,int b){
        int p=a%b;
        if(p==0){
            System.out.println("两个数的最大公约数为： "+b);
            return;
        }
        diGui(b,p);
    }


    //18.   找出两个整数的最小公倍数
    public void minGongBei(){
        System.out.println("请输入两个数：");
        int p1=sn.nextInt();
        int p2=sn.nextInt();
        //先求最大公约数
        int a=p1<=p2?p1:p2;
        int maxGongYue=0;
        for(int i=2;i<=a;i++){
            if(p1%i==0&&p2%i==0){
                maxGongYue=i;
            }
        }
        int minGongbei=(p1/maxGongYue)*(p2/maxGongYue)*maxGongYue;
        System.out.println("数"+p1+"和"+p2+"的最小公倍数是："+minGongbei);
    }


    //19.  杨辉三角:二维数组
    public void yangHui(){
        System.out.println("请输入你想打印的杨辉三角的行数：");
        int row=sn.nextInt();

        int[][] a=new int[row][row];
        for(int i=0;i<row;i++){
            for(int j=0;j<=i;j++){
                if(j==i||j==0){
                    a[i][j]=1;
                }
                else {
                    a[i][j]=a[i-1][j-1]+a[i-1][j];
                }
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();                  //换行
        }
    }

    //20.   冒泡排序
    public void maoPao(){
        int[] a={432,52542,34,5636,34,2353,0,32,245,234,3};
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                int temp;
                if(a[j]>a[j+1]){
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
        for(int n:a){
            System.out.print(n+"  ");
        }
    }

    //21.   选择排序
    public void xuanZe(){
        int[] a={432,52542,34,5636,34,2353,0,32,245,234,3};

    }

    //22.   插入排序
    public void insertPai(){
        int[] a={432,52542,34,5636,34,2353,0,32,245,234,3};

    }

    //23.快速排序
    public void kuaiSu(){
        int[] a={432,52542,34,5636,34,2353,0,32,245,234,3};

    }

    /**
     * 24.   二分法查找
     */
    public void erFen(){

    }
}
