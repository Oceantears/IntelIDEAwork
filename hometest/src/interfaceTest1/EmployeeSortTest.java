/**
 * <一句话功能简述>
 * <对Comeparable接口的应用(Java的sort()方法内有对Comeparable接口的实现)>
 *
 * @author sunmeng
 * @create 2019/9/23   14:37
 */
package interfaceTest1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        Employee[] staff=new Employee[3];

        staff[0]=new Employee("Harry Hacker",35000);
        staff[1]=new Employee("Carl Cracker",75000);
        staff[2]=new Employee("Tony Tester",38000);

        Arrays.sort(staff);

        //print out information about all Employee objects
        for(Employee e:staff){
            System.out.println("name="+e.getName()+",salary="+e.getSalary());
        }

    }
}

/**
 * 实现Comeparable接口的Employee类
 *
 * (Array类中的sort方法承诺可以对对象数组进行排序，但是要求满足前提：对象所属的类必须实现了Comeparable接口)
 */
class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, double salary){
        this.name=name;
        this.salary=salary;
    }
    public void raiseSalary(double byPersent){
        double raise=salary*byPersent/100;
        salary+=raise;
    }

    public int compareTo(Employee other){
        if(salary<other.salary)
            return -1;
        if(salary>other.salary)
            return 1;
        return 0;
    }

}

class Manager extends Employee{

    public Manager(String name, double salary) {
        super(name, salary);
    }
    // @Override
    // public int compareTo(Employee other){
    //     Manager otherManerger=(Manager)other;
    //     if(getSalary()<other.getSalary())
    //         return -1;
    //     if(getSalary()>other.getSalary())
    //         return 1;
    //     return 0;
    // }
}