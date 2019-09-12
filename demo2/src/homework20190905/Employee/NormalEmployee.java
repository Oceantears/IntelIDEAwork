package homework20190905.Employee;

/**
 * 普通员工
 */
public class NormalEmployee extends Employee {
    private int hour;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    //重写工资计算
    @Override
    public double payment(){
        double extraPay=0;
        if(getHour()>196){
            extraPay=(getHour()-196)*200;
        }
        return getSalary()+extraPay;
    }
}
