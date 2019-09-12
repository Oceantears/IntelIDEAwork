package homework20190904;

class ClassA1{
    public ClassA1(){
        System.out.println("ClassA1");
    }
}
class ClassB1{
    public ClassB1(){
        System.out.println("ClassB1");
    }
}
class ClassC1{
    ClassA1 classA1=new ClassA1();
    ClassB1 classB1;
    public ClassC1(){
        System.out.println("ClassC1");
        classB1=new ClassB1();
    }
}

public class TestConstructor {
    public static void main(String[] args) {
        ClassC1 c1=new ClassC1();
    }
}
