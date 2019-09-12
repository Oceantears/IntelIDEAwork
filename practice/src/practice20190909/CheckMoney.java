package practice20190909;

class Account{
    private long id;
    private double balance;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return null;
    }

    public void setPassword(String password) {
        if(password.length()==6){
            this.password = password;
        }
        else {
            System.out.println("密码长度不符，重新修改。");
        }

    }
}
class SavingAccount extends Account{
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if(interestRate>0&&interestRate<0.1){
            this.interestRate = interestRate;
        }
        else
            System.out.println("利率不对，重新输入");
    }
}
class CreditAccount extends Account{
    private double creditLine;

    public double getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(double creditLine) {
        this.creditLine = creditLine;
    }
}

public class CheckMoney {
    public static void main(String[] args) {

    }
}
