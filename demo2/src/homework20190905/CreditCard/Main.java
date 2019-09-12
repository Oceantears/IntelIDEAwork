package homework20190905.CreditCard;

public class Main {
    public static void main(String[] args) {
        CreditCard cc=new CreditCard();    //透支额度3000，存款1000
        DragonCard dc=new DragonCard();
        SliverCard sc=new SliverCard();
        //向普通信用卡对象中存入 3000，取出 5000；
        cc.deposit(3000);
        cc.withdraw(5000);
        System.out.println("普通信用卡中存款额度为："+cc.getBalance());
        System.out.println("普通信用卡中透支额度为:"+cc.getMaxOverdraft());
        System.out.println();
        cc.deposit(3000);
        System.out.println("普通信用卡中存款额度为："+cc.getBalance());
        System.out.println("普通信用卡中透支额度为:"+cc.getMaxOverdraft());
        System.out.println("======================================================");
        //向龙卡中存入 3000，取出 2900，再交 500 块钱电话费。
        dc.deposit(3000);
        dc.withdraw(2900);
        dc.payment(500);
        System.out.println("龙卡中存款额度为："+dc.getBalance());
        System.out.println("======================================================");
        //向银卡中存入 3000，取出 10000 块钱。
        sc.deposit(3000);
        sc.withdraw(10000);
        System.out.println("银卡中存款额度为："+sc.getBalance());




        //小测试
//        int a=1;
//        int b=2;
//        a++;
//        b+=++a;
//        System.out.println("运算结果是："+a+++b+++(++a));
    }
}
