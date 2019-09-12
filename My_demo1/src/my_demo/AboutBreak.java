package my_demo;

public class AboutBreak {
    public void breakUse(){
        for(int i=0;i<10;i++) {
            for(int j=0;j<9;j++) {
                if(j==6) {
                    break;
                }
                System.out.println("======={0}========"+j);
            }
            System.out.println("=======aa{0}========"+i);
        }
    }
}
