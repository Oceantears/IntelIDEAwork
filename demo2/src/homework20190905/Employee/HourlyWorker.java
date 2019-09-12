package homework20190905.Employee;

/**
 * 小时工
 */
public class HourlyWorker extends Employee {
    private int hour;
    private double payPerHour;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }
    //重写工资计算
    @Override
    public double payment(){
        return getHour()*getPayPerHour();
    }
}
