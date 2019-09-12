package demo;

public class math_demo1 {
    int s=1,sum=0;
    public void Sum(){
        for(int i=1;i<=6;i++){
            s=s*i;
            sum=sum+s;
        }
        System.out.println("6的阶乘为："+s);
        System.out.println("1到6的阶乘的和为："+sum);
    }

}
