package homework20190904;

class ClassA3{
    int value;
}
public class ChangeRef {
    public static void main(String[] args) {
        ClassA3 ca = new ClassA3();
        changeValue(ca);
        System.out.println(ca.value);
        changeRef(ca);
        System.out.println(ca.value);
    }
    public static void changeValue(ClassA3 ca){
        ca.value = 100;
    }public static void changeRef(ClassA3 ca){
        ca=new ClassA3();
        ca.value = 200;
    }

}
