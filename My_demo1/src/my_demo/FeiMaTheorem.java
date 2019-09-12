package my_demo;

import java.util.Scanner;

public class FeiMaTheorem {
    //费马大定理指出，如果整数n大于2，则方程a^n+b^n=c^n没有整数解。
    public void checkFermat(int a,int b,int c,int n){

        for(int m=1;m<=n;m++){
            double left=Math.pow(a,m)+Math.pow(b,m);
            double right=Math.pow(c,m);
            if(m>2&&left==right){
                System.err.println("欧，不！费马错了！！！");
            }
            else if(left!=right){
                System.out.println("还在检测中.....");
            }
            else if(left==right)
                System.out.println(a+"的"+m+"次方加"+b+"的"+m+"次方等于"+c+"的"+m+"次方");
        }
    }

}
