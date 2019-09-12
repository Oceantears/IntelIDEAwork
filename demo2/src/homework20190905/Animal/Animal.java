package homework20190905.Animal;

/**
 * 创建一个动物类，
 * 属性：
 * 体重，名字，年龄
 * 方法：
 * 吃东西
 * 睡觉
 * 移动(走路)
 * 吼叫
 * =========================================
 * 创建狮子类（lion)，创建猫类（cat)，创建狗类（dog)，创建海豚类（bluefish)，继承自动物
 * 类，
 * 根据以下的规律，设计函数的重写
 * 1：这四种动物的吃东西方式都是一样的（咀嚼）。
 * 2：狮子，猫，狗的走路方式，睡觉方式都是一样的。
 *  3：海豚的移动方式，睡觉与其它三种不同。
 * 4：所有动物的吼叫不同。
 */
public abstract class Animal {
    private double weight;
    private String name;
    private int age;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

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

    public void eat(){
        System.out.println("咀嚼");
    }
    public void sleep(){
        System.out.println("趴着睡");
    }
    public void move(){
        System.out.println("四只腿走");
    }
    public abstract void shout();
}
