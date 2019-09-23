/**
 * <一句话功能简述>
 * <Worker类>
 *
 * @author sunmeng
 * @create 2019/9/20   14:53
 */
package practice20190920.worker;

public class Worker {
    private Address addr;
    private String name;
    private int age;
    private double salary;

    public Worker(String name,int age,double salary,Address addr){
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.addr=addr;
    }

    public static void main(String[] args) {
        Address address=new Address("北京市海淀区清华园 1 号","100084");
        Worker worker=new Worker("zhangsan",25,2500,address);
        System.out.println(worker.name);
        System.out.println(worker.age);
        System.out.println(worker.salary);
        System.out.println(worker.addr.getAddress());
        System.out.println(worker.addr.getZipCode());
    }
}
