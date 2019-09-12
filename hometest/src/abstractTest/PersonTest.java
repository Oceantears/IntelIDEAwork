/**
 * <一句话功能简述>
 * <抽象类的练习,通过Person类产生Student类和Employee类>
 *
 * @author Administrator
 * @create 2019/9/11
 */
package abstractTest;

import java.util.Date;
import java.util.GregorianCalendar;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people=new Person[2];

        //fill the people array with Student and Employee objects;
        people[0]=new Employee("田小强",50000,1989,10,1);
        people[1]=new Student("田志强","computer science");

        //print out names and descriptions of all Person objects
        for(Person p:people){
            System.out.println(p.getName()+","+p.getDescription());
        }
    }
}
abstract class Person{
    public Person(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    private String name;
}
//员工
class Employee extends Person{
    private double salary;
    private Date hireDay;

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }
    public String getDescription(){
        return String.format("an employee with a salary of $%.2f",salary);
    }
    public void raiseSalary(double byPercent){
        double raise=salary*byPercent/100;
        salary+=raise;
    }

    public Employee(String name, double salary, int year, int month, int day){
        super(name);
        this.salary=salary;
        GregorianCalendar calendar=new GregorianCalendar(year,month-1,day);         //
        hireDay=calendar.getTime();
    }
}

//学生
class Student extends Person{
    private String major;
    public Student(String name,String major){
        super(name);
        this.major=major;
    }
    public String getDescription(){
        return "a student majoring in"+major;
    }
}