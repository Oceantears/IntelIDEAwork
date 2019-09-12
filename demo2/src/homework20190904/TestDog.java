package homework20190904;

class Dog{
    String name;
    int age;
    boolean sexual;
    public Dog(){

    }
    public Dog(String name,int age,boolean sexual){
        this.name=name;
        this.age=age;
        this.sexual=sexual;
    }
    public void play(){
        System.out.println(name+"play");
    }
    public void play(int n){
        System.out.println(name+"play"+n+"minutes");
    }
}
public class TestDog {
    public static void main(String[] args) {
        Dog d;
        d=new Dog("joy",2,false);
        d.play();
        d.play(30);
    }
}
