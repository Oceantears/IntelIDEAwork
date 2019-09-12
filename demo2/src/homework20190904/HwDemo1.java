package homework20190904;

public class HwDemo1 {
    public static void main(String[] args){
        ClassA ca=new ClassA();
        ca=getObject();
        ca=getObject();
        ca=getObject();
        System.out.println(ca.value);
    }
    public static ClassA getObject(){
        ClassA newObject=new ClassA();
        newObject.value+=10;
        return newObject;
    }
}
class ClassA{
    int value=10;
}

