package my_demo;

public class math_demo1 {
    //冒泡排序
    int[] a= {12,45,23,65,21941,1,214};
    public void paixu(){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                int temp;
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for(int m=0;m<a.length;m++){
            System.out.println(a[m]);
        }
    }
}
