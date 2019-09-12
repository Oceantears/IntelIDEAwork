package homework20190904;

class ClassA2{
    int value;
}
public class TestClassA {
    public static void main(String[] args) {
        int value=10;
        changeInt(value);
        System.out.println(value);

        ClassA2 classA2=new ClassA2();
        classA2.value=10;
        changeObject(classA2);
        System.out.println(classA2.value);
    }
    public static void changeInt(int value){
        value++;
    }
    public static void changeObject(ClassA2 ca){
        ca.value++;
    }
}
