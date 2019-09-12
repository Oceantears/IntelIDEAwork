package homework20190911;

import java.util.ArrayList;

/**
 * 1）制作一个销售首饰的公司类。
 * 属性:
 * 一个保存员工的数组。
 * 方法：
 * 1, 添加一个员工。
 * 2, 通过员工的名字来删除员工。
 * 3, 通过员工的名字来显示员工的工资。
 * 4, 输出所有员工的工资和。
 * ==================================================
 * 2）定义一个抽象员工类
 * 属性： 姓名，基本工资
 * 抽象方法：计算工资。
 * ==========================================================
 * 3）子类：小时工类
 * 属性：
 * 工作的小时，每小时工资。
 * 方法：
 * 1. 设置工作的小时
 * 2. 设置每小时的工资。
 * 3. 重写计算工资方法：
 * 小时工没有基本工资，他的工资就是工作的小时*每小时工资。
 * ======================================================================
 * 4）子类：销售员工类
 * 属性：
 * 销售的总金额
 * 方法
 * 1. 设置销售的总金额
 * 2. 重写计算工资方法：
 * 基本工资+提成。
 * 提成的计算：
 * 当销售额再 10000 以下时，则提成 10%，
 * 等销售额再 10000-100000 之间是，则提成 15%。
 * 再 100000 以上是，提成 18%。
 * ====================================================================
 * 5）子类： 普通员工类
 * 属性：
 * 工作的小时
 * 方法：
 * 1. 设置工作的小时
 * 2. 重写计算工资的方法：
 * 当每月工作的小时数超过 196 小时时，超出的部分按每小时 200 元。
 * 基本工资+（工作的小时-196）*200。
 * =====================================================================
 * 6）在 main 函数中生成
 * 一个公司对象；
 * 一个小时工的对象，每小时工资 10，工作 200 小时；
 * 一个小时工的对象，每小时工资 10，工作 230 小时；
 * 一个销售员工的对象，销售额 5000；
 * 一个销售员工的对象，销售额 200000；
 * 一个普通员工对象，工作小时 205 小时。
 * 将以上员工对象加入公司对象中，然后调用输出所有员工工资和的方法，查看该公司该月应
 * 该发的工资总和。
 * ==================================================================================
 * 7）随着该公司的业务扩展，该公司决定自己生产首饰，该公司多了一种新的类型的员工，
 * 首饰工人。
 * 定义首饰工人类：
 * 属性
 * 生产首饰的数量
 * 方法
 * 1 设置生产首饰的数量
 * 2 重写计算工资的方法
 * 工资 == 设置生产首饰的数量 *50；
 * ================================================================================
 * 8）
 * 在 main 函数中多生成一个首饰工人对象，生产首饰的数量 30；
 * 将该对象加入公司对象中，
 * 然后调用输出所有员工工资和的方法，查看该公司该月应该发的工资总和。
 * 思考： 继承，多态对于程序的可维护，可扩展带来的好处。
 */
abstract class Employee{
    private String name;                 //员工姓名
    private double salary;               //员工工资
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract double getPay();
}
//小时工
class HourEmployee extends Employee{
    private int workHours;
    private double salaryEveryHour;        //每小时的工资
    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public double getSalaryEveryHour() {
        return salaryEveryHour;
    }

    public void setSalaryEveryHour(double salaryEveryHour) {
        this.salaryEveryHour = salaryEveryHour;
    }

    @Override
    public double getPay(){
        this.setSalary(0);
        return this.getWorkHours()*this.getSalaryEveryHour();
    }
}
//销售员工
class saleEmployee extends Employee{
    private double totalSale;

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    @Override
    public double getPay(){
        double commission=0;          //提成
        if(getTotalSale()<10000){
            commission=getTotalSale()*1/10;
        }
        else if(getTotalSale()>=10000&&getTotalSale()<=100000){
            commission=getTotalSale()*15/100;
        }
        else if(getTotalSale()>100000){
            commission=getTotalSale()*18/100;
        }
        else {
            System.out.println("销售额有问题。");
        }
        return getSalary()+commission;
    }
}
//普通员工
class normalEmployee extends Employee{
    private int workHour;

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }
    @Override
    public double getPay(){
        double extraSalary=0;
        if(this.getWorkHour()>196){
            extraSalary=(this.getWorkHour()-196)*200;
        }
        return getSalary()+extraSalary;
    }
}
public class JewelryCompany {
    ArrayList<Employee> emp=new ArrayList<>();
    //添加一个员工
    public void addEmp(Employee employee){
        if(employee instanceof Employee){
            emp.add(employee);
        }
    }
    //根据员工的名字来删除员工
    public void removeEmp(String name){
        for(Employee employee:emp){
            if(name.equals(employee.getName())){
                emp.remove(employee);
            }
        }
    }
    //根据员工的名字来显示员工的工资
    public void getEmp(String name){
        for(Employee employee:emp){
            if(name.equals(employee.getName())){

            }
        }
    }
}
