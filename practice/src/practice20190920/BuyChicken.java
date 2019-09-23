/**
 * <一句话功能简述>
 * <3.（for 循环）*“百钱买百鸡”是我国古代的著名数学题。
 * 题目这样描述：3 文钱可以买 1只公鸡，2 文钱可以买一只母鸡，1 文钱可以买 3 只小鸡。用 100 文钱买 100 只鸡，那么各
 * 有公鸡、母鸡、小鸡多少只？>
 *
 * @author sunmeng
 * @create 2019/9/20   11:41
 */
package practice20190920;

public class BuyChicken {
    public static void main(String[] args) {
        int money;      //定总价为300，则一文钱一只小鸡，6文钱一只母鸡，9文钱一只公鸡
        int sum;
        int num1=300;     //小鸡个数
        int num2=300/6;
        int num3=300/9;

        for(int i=num1;i>=0;i--){       //小鸡个数
            for (int j=num2;j>=0;j--){      //母鸡个数
                for (int k=num3;k>=0;k--){
                    money=i+j*6+k*9;
                    sum=i+j+k;
                    if(money==300&&sum==100){
                        System.out.println("小鸡"+i+"只，母鸡"+j+"只，公鸡"+k+"只");
                    }
                }
            }
        }
    }
}
