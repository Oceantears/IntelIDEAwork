package homework20190905;

public class Student extends Person {
    //Person per=new Person();
    int math;
    int english;

    public Student() {
    }

    public Student(String name, char sex) {
        super(name, sex);
    }

    public Student(String name, String addr, char sex, int age, int math,int english) {
        super(name, addr, sex, age);
        this.math = math;
        this.english=english;
    }

    @Override
    public void setMessage() {
        System.out.println("name"+this.name+"age"+this.age+"sex"+this.sex+"age"+this.age+"math"+this.math+"english"+this.english);
    }

}
