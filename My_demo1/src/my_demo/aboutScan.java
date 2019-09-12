package my_demo;

import java.util.Scanner;

public class aboutScan {
    //Scanner类里的BUG
    public void inputMessage(){
        Scanner in =new Scanner(System.in);
        String name;
        int age;
        System.out.print("What's your age? ");
        age=in.nextInt();
        //in.nextLine();//读取换行符()
        System.out.print("What's your name? ");
        name=in.nextLine();

        System.out.printf("Hello %s,age %d\n",name,age);
    }
}
