package homework20190905.Employee;

public class Main {
    public static void main(String[] args) {
        HourlyWorker hw=new HourlyWorker();
        Salesperson sp=new Salesperson();
        NormalEmployee ne=new NormalEmployee();
        Employee emp=new Employee();

        hw.setSalary(3000);
        hw.setHour(200);
        hw.setPayPerHour(15);
        System.out.println("小时工的工资是："+hw.payment());

        sp.setSalary(2000);
        sp.setTotalSell(15000);
        System.out.println("销售的工资是："+sp.payment());

        ne.setSalary(4000);
        ne.setHour(200);
        System.out.println("普通员工的工资是："+ne.payment());


    }
}
