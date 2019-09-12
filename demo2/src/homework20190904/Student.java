package homework20190904;

public class Student {
    public Student(){

    }
    void init(){
        age=10;
        name="limy";
    }
    public Student(String name){
        this.init();
        this.name=name;
    }
    public Student(String name,int age){
        this(name);         //调用构造方法，必须写在第一行
        this.init();
        this.age=age;
    }

    int age;
    String name;

    public static void main(String[] args) {
        Student student=new Student("田志强",50);
        System.out.println(student.name);
        System.out.println(student.age);
    }
}
