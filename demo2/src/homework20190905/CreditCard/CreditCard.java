package homework20190905.CreditCard;

/**
 * 制作以下信用卡类：
 * 普通信用卡类：类名 CreditCard
 * 属性：
 *  double maxOverdraft ; //透支限额
 *  double balance ; //存款余额
 *  int cardNumber; //卡号
 *  String name; //姓名
 * 构造方法：
 *  功能说明: 给透支余额,存款余额赋值
 * 存款方法: deposit
 *  功能说明: 给存款余额累加
 * 取款方法: withdraw
 *  功能说明: 一次不能超过 5000
 *  如果余额不足，需要透支的情况下，不能超过透支额
 * 查询账号余额 getBalance
 *  功能说明：返回存款余额
 *  ====================================================
 * 子类 : DragonCard 继承信用卡类
 * 方法：
 *  1 重写取款方法，不能透支额度
 *  2 电话交费方法 payment
 *  功能 支付电话费，从余额中扣除费用
 *  参数：要交纳的电话费数
 *  ==========================================================
 * 子类 : SliverCard 继承信用卡类
 * 方法：
 *  1 重写取款方法，
 *  一次不能超过 100000，没有透支额
 * 在 main 函数中生成这三种信用卡的对象，
 * 向普通信用卡对象中存入 3000，取出 4000；
 * 向龙卡中存入 3000，取出 2900，再交 500 块钱电话费。
 * 向银卡中存入 3000，取出 10000 块钱。
 */
public class CreditCard {
    private double maxOverdraft;
    private double balance;
    private int cardNumer;
    private String name;
    private double maxOverLevel=3000;         //初始固定额度线
    private double balanceLevel=1000;         //初始设置的存款
    private double getMoneyLevel=5000;         //取款额度

    public double getMaxOverdraft() {
        return maxOverdraft;
    }

    public void setMaxOverdraft(double maxOverdraft) {
        this.maxOverdraft = maxOverdraft;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCardNumer() {
        return cardNumer;
    }

    public void setCardNumer(int cardNumer) {
        this.cardNumer = cardNumer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditCard(double balance){
        setBalance(balance);
    }
    //构造函数：给透支余额和存款余额赋值
    public CreditCard(){
        setMaxOverdraft(maxOverLevel);          //初始设定限额
        setBalance(balanceLevel);
    }
    //存款余额累加
    public void deposit(double sendMoney){
        //如果有透支额度(maxOverdraft<maxOverLevel)，用存入的钱减去透支额度，再加余额；如果没有透支，则直接加
        //没有透支情况
        if(getMaxOverdraft()>=maxOverLevel){
            setBalance(getBalance()+sendMoney);
        }
        //有透支
        else {
            //如果存进去的钱低于透支额度
            if(sendMoney<(maxOverLevel-getMaxOverdraft())){
                setBalance(getBalance());
                setMaxOverdraft(getMaxOverdraft()+sendMoney);
            }
            //存进去的钱大于等于透支额度
            else {
                setBalance(getBalance()+sendMoney-(maxOverLevel-getMaxOverdraft()));        //此处不能写颠倒
                setMaxOverdraft(maxOverLevel);
            }
        }
    }
    //取款方法
    public void withdraw(double getMoney){
        if(getMoney>getMoneyLevel){
            System.out.println("取款超出限额，请重新输入！");
        }
        else{          //允许取款
            if(getBalance()+getMaxOverdraft()>=getMoney){
                if(getBalance()>=getMoney){
                    setBalance(getBalance()-getMoney);
                }
                else {
                    setMaxOverdraft(getMaxOverdraft()+getBalance()-getMoney);          //此数不能写颠倒
                    setBalance(0);
                }
            }
            else
                System.out.println("取款超出透支额度，无法取款！");
        }
    }

}
