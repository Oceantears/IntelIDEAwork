package homework20190905.Animal;

public class Main {
    public static void main(String[] args) {
        Animal lion=new Lion();
        Animal dog=new Dog();
        Animal cat=new Cat();
        Animal bluefish=new Bluefish();

        lion.shout();
        dog.shout();
        cat.shout();
        bluefish.shout();
    }
}
