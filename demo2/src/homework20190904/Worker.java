package homework20190904;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

public class Worker {
    String name;
    int age;
    double salary;
    Address add;
    public Worker(){

    }
    Worker(String name,int age,double salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
    void work(){

    }
    void work(int hours){

    }

    public static void main(String[] args) {
        Worker worker=new Worker("zhangsan",25,2500);
    }
}
