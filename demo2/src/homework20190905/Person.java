package homework20190905;

public class Person {
    protected String name;
    protected String addr;
    protected char sex;
    protected int age;

    public Person(){}
    public Person(String name,char sex){
        this.name=name;
        this.sex=sex;
    }
    public Person(String name,String addr,char sex,int age){
        this.name=name;
        this.addr=addr;
        this.sex=sex;
        this.age=age;
    }

    public void setMessage(){
        System.out.println("name"+this.name+"age"+this.age+"sex"+this.sex+"age"+this.age);
    }
}
