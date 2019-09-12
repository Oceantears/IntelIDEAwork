package homework20190905.CreditCard;

public class DragonCard extends CreditCard {
    public DragonCard(){
        //如果父类没有无参数的构造方法，那么子类必须显示调用父类带参数的构造方之一
        super();
    }
    //重写取款方法
    @Override
    public void withdraw(double getMoney){
        if(getMoney>5000){
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
    //电话缴费方法
    public void payment(double telPay){
        if(getBalance()>telPay){
            setBalance(getBalance()-telPay);
        }
        else
            System.out.println("余额不足，请存款。");
    }
}
