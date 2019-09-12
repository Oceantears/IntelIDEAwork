package demo;

public class math_demo2 {
    //冒泡排序
    int[] a={52,64,2,48,895645,564,846,0,468413,4874};
    public void maoPao(){
        for(int i=0;i<a.length-1;i++)
        {
            for(int j=0;j<a.length-1-i;j++)
            {
                int temp;
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for(int m=0;m<a.length;m++){
            System.out.print(a[m]+"   ");
        }
    }
}
