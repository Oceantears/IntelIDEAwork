package homework20190905.CreditCard;

public class SliverCard extends CreditCard {
    public SliverCard(){
        super();
        //没有透支余额
        double maxOverdraft=0;
    }
    @Override
    //重写取款方法
    public void withdraw(double getMoney){
        if(getMoney>10000){
            System.out.println("取款超出限额，请重新输入！");
        }
        else{          //允许取款
            if(getBalance()>=getMoney){
                setBalance(getBalance()-getMoney);
            }
            else
                System.out.println("取款超出存款额度，无法取款！");
        }
    }
}
