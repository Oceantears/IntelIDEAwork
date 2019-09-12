package my_demo;

import java.util.Scanner;

public class Menu_demo {
    Scanner menuNum=new Scanner(System.in);

    public void mainMenu(){
        System.out.println("***************************************************");
        System.out.println("欢迎来到本餐厅就餐！o(*￣︶￣*)o");
        System.out.println("***************************************************");
        System.out.println("您现在是否进行点餐？");
        System.out.println("----------------------------------------------");
        System.out.println("|    点餐请按1   |");
        System.out.println("----------------------------------------------");
        System.out.println("|    退出系统请按2   |");
        System.out.println("----------------------------------------------");

        int num=menuNum.nextInt();
        switch (num){
            case 1:
                selectNumber();
                break;
            case 2:
                System.out.println("欢迎您下次光临本餐厅！o(*￣︶￣*)o");
                System.out.println("您本次没有点餐，欢迎下次光临！");
                break;
                default:
                    System.out.println("木有此菜单，请重新输入");
                    mainMenu();
        }
    }
    private void selectNumber(){
        System.out.println("-------------请选择您喜欢的美食类别-------------");
        System.out.println("-------------1.中餐");
        System.out.println("-------------2.西餐");
        System.out.println("-------------3.甜点");
        System.out.println("-------------4.水果");
        System.out.println("-------------5.返回上一层----------------------");

        int num=menuNum.nextInt();
        choosing(num);
    }
    private void choosing(int n){
        switch (n){
            case 1:
                chineseFood();
                break;
            case 2:
                System.out.println("您选择了西餐");
                break;
            case 3:
                System.out.println("您选择了甜点");
                break;
            case 4:
                System.out.println("您选择了水果");
                break;
            case 5:
                mainMenu();
                break;
                default:
                    System.out.println("木有此菜单，请重新输入");
                    selectNumber();
        }
    }
    private void chineseFood(){
        System.out.println("欢迎来到中餐区！请根据提示选择种类！^_^");
        System.out.println("中餐菜系分类：");
        System.out.println("1.川菜");
        System.out.println("2.粤菜");
        System.out.println("3.湘菜");
        System.out.println("4.返回上一层");
        int num=menuNum.nextInt();
        chooseChinese(num);
    }
    private void chooseChinese(int n){
        switch (n){
            case 1:
                allChineseFood(n);
                break;
            case 2:
                allChineseFood(n);
                break;
            case 3:
                allChineseFood(n);
                break;
            case 4:
                selectNumber();
                break;
            default:
                System.out.println("木有此菜单，请重新输入");
                chineseFood();
        }
    }
    private void allChineseFood(int n){
        String s;
        if(n==1){
            s="川";
        }else if(n==2){
            s="粤";
        }else{
            s="湘";
        }
        System.out.println("欢迎来到"+s+"菜区！祝您用餐愉快！^_^");
        System.out.println("----------------------------------------------");
        System.out.println("继续留在中餐区请输入Y；返回主菜单X；退出系统输入N");
        System.out.println("----------------------------------------------");
        char choose=menuNum.next().charAt(0);
        chooseQuite(choose);
    }
    private void chooseQuite(char n){
        switch (n){
            case 'Y':
                chineseFood();
                break;
            case 'X':
                mainMenu();
            case 'N':
                System.out.println("欢迎您下次光临本餐厅！o(*￣︶￣*)o");
                System.out.println("您本次没有点餐，欢迎下次光临！");
                break;
        }
    }
}
