package my_demo;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public void GuessStart(){
        Random random=new Random();
        int b;

        Scanner num=new Scanner(System.in);
        int a;
        int c;
        do {
            b = random.nextInt(100)+1;
            System.out.println("I'm thinking of a number between 1 and 100\n(including both).Can you guess what it is?");
            System.out.println("Type a number:");
            a=num.nextInt();
            System.out.println("Your guess is:"+a);
            System.out.println("The number I was thinking of is:"+b);

            c=Math.abs(a-b);
            if(a==b){
                System.out.println("You thought same with me.");
            }
            else {
                System.out.println("We thought diffrent.");
            }
            System.out.println("You were off by :"+c);

            System.out.println("=================================================================================>");
        }while (a!=b);

    }
}
