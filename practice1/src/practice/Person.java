package practice;

public class Person {
//    private Person(){
//        name="aaa";
//    }
    //3 开发一个Person类，要求如下：
    //1.	该类包含实例属性：姓名、性别、年龄、地址，要求所有的属性定义私有的，
    // 并为每一个属性分别编写设置值和读取值的方法；
    //开发一个测试类（即包含主方法的类）（测试上述类生成该类的一个对象即可)。
    String name;
    char sex;
    int age;
    String address;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public char getSex(){
        return sex;
    }
    public void setSex(char sex){
        this.sex=sex;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
}
