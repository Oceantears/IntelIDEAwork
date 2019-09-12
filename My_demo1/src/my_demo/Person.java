package my_demo;

public class Person {
    private String name="Unamed";       //Alt+Insert    代码自动生成方法
    private int age=10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

}
