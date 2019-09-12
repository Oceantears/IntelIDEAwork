import homeWork.Hw8_22;
import homeWork.Hw8_23;
import my_demo.*;

import javax.sound.midi.SysexMessage;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(args));

//        Scanner scan=new Scanner(System.in);
//        if(scan.hasNext()){
//            String s1=scan.next();
//            System.out.println(s1);
//        }
//        String s=scan.nextLine();
//        System.out.println(s+"!!!");
//        int sum=0;
//        int cheng=1;
//        for(int i=1;i<=3;i++){
//            cheng=cheng*i;
//            sum=sum+cheng;
//        }
//        System.out.println(sum);
//        Scanner sca=new Scanner(System.in);
//        long s=sca.nextLong();
//        for(long i=2;i<s;i++){
//            if(s%i!=0){
//                System.out.println("此数为素数："+s);
//            }
//            else {
//                System.out.println("此数不是素数！！");
//            }
//        }
//        Scanner s=new Scanner(System.in);
//        int a=s.nextInt();
//        int sum=0;
//        for(int i=200;i<=6000;i++) {
//            if(i%2==0) {
//                sum=sum+i;
//            }
//        }
//        System.out.println(sum);
//        math_demo1 ma=new math_demo1();
//        ma.paixu();
//        increasing inc=new increasing();
//        inc.Increase();

//        int i=0;
//        int j=i++;
//        int n=++i;
//        System.out.println(j);
//        System.out.println(n);
//        System.out.println(j++);

//        final double CM_PER_INCH=2.54;
//        int inch=100;
//        double cm=inch*CM_PER_INCH;
//        System.out.printf("%d in=%f cm\n",inch,cm);    //printf()规范一种输出格式
//
//        int num=10;
//        int num1=num+++num+++num++;
//        System.out.println(num1);
//
//        double a=1/3;
//        int b=(int)0.999999;
//        System.out.println(b);

//        aboutScan as=new aboutScan();
//        as.inputMessage();

//        double a=100.0;
//        double sum=0.0;
//        for(int b=1;b<=6;b++){
//            sum=(sum+a)*(1+0.00417);
//            System.out.println(sum);
//        }

//        AboutBreak ab=new AboutBreak();
//        ab.breakUse();


//        int a=10;
//        double b=12.3456;
//        System.out.printf("My age is %d,He's age is %f",a,b);

//        GuessNumber gm=new GuessNumber();
//        gm.GuessStart();


        //double a=0.1*3;
//        boolean a=(3*0.1f==(float)0.3);
//        System.out.println(a);

//        int x=4;
//        int y=(--x)+(x--)+(x*10);
//        System.out.println("x="+x+",y="+y);

        Hw8_22 hw8_22=new Hw8_22();
        //hw8_22.compareNum();
        //hw8_22.everyNum();
        //hw8_22.compare3();
        //hw8_22.maxNum();
        //hw8_22.suShu();
        //hw8_22.isTwo();
        //hw8_22.boNaqie();
        //hw8_22.secondLarge();
        //hw8_22.flowerNum();
        //hw8_22.sum();
        //hw8_22.maxGongYue();
        //hw8_22.minGongBei();
        //hw8_22.yangHui();
       // hw8_22.maoPao();
        //hw8_22.sum3();
        //hw8_22.ouJilide();


        Hw8_23 hw8_23=new Hw8_23();
        //hw8_23.numOfRabbit();
        //hw8_23.suShu();
        //hw8_23.level();
        //hw8_23.sumFenshu();
        //hw8_23.sumOfLeiCheng();

        Menu_demo md=new Menu_demo();
        //md.mainMenu();

//        Person per=new Person("李明",20);
//        String s=per.getName();
//        int ag=per.getAge();
//        System.out.println(s);
//        System.out.println(ag);

        //scanDouble();
//        Recursion re=new Recursion();
//        System.out.println(re.prod(1,4));

//        Scanner sn=new Scanner(System.in);
//        System.out.println("请输入一个数");
//        int a=sn.nextInt();
//        coutUp(a);

        /**
         * 验证费曼理论
         */
//        System.out.println("请随便输入四个数： ");
//        Scanner sn=new Scanner(System.in);
//        int a=sn.nextInt();
//        int b=sn.nextInt();
//        int c=sn.nextInt();
//        int n=sn.nextInt();
//        FeiMaTheorem fei=new FeiMaTheorem();
//        fei.checkFermat(a,b,c,n);

        //多维数组的定义：x[]和y[][]
//        int[]x,y[]=new int[5][3];
//        //System.out.println(x[0]);
//        for(int[] i:y){
//            for(int j:i){
//                System.out.print(j+"\t");
//            }
//            System.out.println();
//        }

    }

    /**
     * System.err.println()系统抛异常检测
     */
    public static void scanDouble(){
        Scanner in =new Scanner(System.in);
        System.out.print("Enter a number: ");
        if(!in.hasNextDouble()){
            String word=in.next();
            System.err.println(word+" is not a number");
            return;
        }
        double x=in.nextDouble();
        printLogarithm(x);
    }
    public static void printLogarithm(double x){
        if(x<=0.0){
            System.err.println("Error:x must be positive.");
            return;
        }
        double result=Math.log(x);
        System.out.println("The log of "+x+" is "+result);
    }

    //递归结果的正反输出
    public static void coutUp(int n){
        if(n==0){
            System.out.println("到0了！");
        }else {
            coutUp(n-1);              //如果把coutUp()和System.out.println()换位置，输出是倒序(执行步骤不同，输出不同)
            System.out.println(n);
        }

    }


}