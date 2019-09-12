package practice;

import java.util.Scanner;

public class Practice {
    //1.求200到400间，能被３整除但不能被７整除的数的个数
    public void findNum(){
        int count=0;        //统计个数
        for(int i=200;i<=400;i++){
            if(i%3==0&&i%7!=0){
                count++;
            }
        }
        System.out.println("200到400间，能被３整除但不能被７整除的数的个数: "+count);
    }

    //求二维int类型数组3行4列，求其最大值，最小值，求和，行平均值
    public void useMath(){
        int[][] num=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int max=0;
        int min=0;
        int sum=0;

        for(int i=0;i<num.length;i++){
            int sumEveryLine=0;
            double avgEveryLine=0;
            for(int j=0;j<num[i].length;j++){
                sumEveryLine+=num[i][j];
                if(max<num[i][j]){
                    max=num[i][j];
                }
                if(min>num[i][j]){
                    min=num[i][j];
                }
            }
            avgEveryLine=(double) sumEveryLine/4;
            sum+=sumEveryLine;
            System.out.println("每一行的平均值是："+avgEveryLine);
        }
        System.out.println("数组的最大值是："+max);
        System.out.println("数组的最小值是："+min);
        System.out.println("数组的总和是："+sum);
    }

    //3 开发一个Person类，要求如下：
    //1.	该类包含实例属性：姓名、性别、年龄、地址，要求所有的属性定义私有的，
    // 并为每一个属性分别编写设置值和读取值的方法；
    //开发一个测试类（即包含主方法的类）（测试上述类生成该类的一个对象即可)。
    public void getMessage(){
        Person per=new Person();
        String add= per.getAddress();
        System.out.println("地址是："+add);
    }

    //4利用for循环嵌套，打印图形。
    //        ****
    //        ***
    //        **
    //        *
    public void drawStar(){
        int num=4;
        for(int i=0;i<4;i++){
            for(int j=0;j<num;j++){
                System.out.print("*\t");
            }
            System.out.println();
            num--;
        }
    }

    //5 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，
    // 几个数相加有键盘控制。   程序分析：关键是计算出每一项的值。
    public void sum(){
        System.out.println("请输入有几个数相加：");
        Scanner scan=new Scanner(System.in);
        int count=scan.nextInt();
        int s=0;
        int sum=0;
        int a=2;
        System.out.println("a为："+a);
        for(int i=0;i<count;i++){
            s+=a*Math.pow(10,i);
            sum+=s;
        }
        System.out.println("sum=a+aa+aaa+aaaa+aa..的值为："+sum);
    }

    //6 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
    //1.	程序分析：可填在百位、十位、个位的数字都是1、2、3、4。组成所有的排列后再去掉不满足条件的排列。
    public void setNum(){
        int[] a=new int[]{1,2,3,4};
        int num;
        int count=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                for(int k=0;k<a.length;k++){
                    if(a[i]!=a[j]&&a[j]!=a[k]&&a[k]!=a[i]){
                        num=a[i]*100+a[j]*10+a[k];
                        System.out.println("这些三位数分别是："+num);
                        count++;
                    }
                }
            }
        }
        System.out.println("组成三位数的总数是："+count);
    }
}
