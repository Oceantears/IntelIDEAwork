package homework20190904;



public class Worker {
    String name;
    int age;
    double salary;
    // AddressNode.Address add;
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
