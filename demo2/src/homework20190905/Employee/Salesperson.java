package homework20190905.Employee;

/**
 * 销售
 */
public class Salesperson extends Employee {
    private double totalSell;

    public double getTotalSell() {
        return totalSell;
    }

    public void setTotalSell(double totalSell) {
        if(totalSell>0){
            this.totalSell = totalSell;
        }
        else
            System.out.println("销量太少，好好反省。");
    }
    //重写工资计算
    @Override
    public double payment(){
        double payment=0;               //提成
        if(getTotalSell()<10000){
            payment=getTotalSell()*10/100;
        }
        else if(getTotalSell()>=10000&&getTotalSell()<=100000){
            payment=getTotalSell()*15/100;
        }
        else {
            payment=getTotalSell()*18/100;
        }

        return getSalary()+payment;
    }
}
