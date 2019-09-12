package practice20190909;

class Animal{
    private String name;
    public String getName(){
        return name;
    }
    public Animal(String name){
        this.name=name;
    }
}

class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
}
class Cat extends Animal{
    public Cat(String name){
        super(name);
    }
}
public class TestAnimal {
    public static void main(String[] args) {
        Animal[] as=new Animal[]{
                new Dog("Pluto"),
                new Cat("Tom"),
                new Dog("Snoopy"),
                new Cat("Garfield")
        };
        Dog[] dogs=getAllDogs(as);
        for(int i=0;i<dogs.length;i++){
            System.out.println(dogs[i].getName());
        }
    }

    public static Dog[] getAllDogs(Animal[] as){
        int count=0;
        for(int i=0;i<as.length;i++){
            if(as[i] instanceof Dog){
                count++;
            }
        }
        Dog[] dogs=new Dog[count];

        int n=0;
        for(int j=0;j<count;j++){
            for (int k=n;k<as.length;k++){
                if(as[k] instanceof Dog){
                    dogs[j]=(Dog) as[k];
                    n=k+1;
                    break;
                }
            }
        }
        return dogs;
    }
}
