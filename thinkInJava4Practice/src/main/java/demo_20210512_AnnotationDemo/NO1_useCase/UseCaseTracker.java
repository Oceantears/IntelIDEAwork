package demo_20210512_AnnotationDemo.NO1_useCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @date ：Created in 2021/5/12 15:25
 * @version: java 8
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases,Class<?> cl){
        for (Method m:cl.getDeclaredMethods()) {        //getDeclaredMethods()方法返回指定类中的方法
            UseCase uc = m.getAnnotation(UseCase.class);        //getAnnotation()方法返回指定类型的注解对象
            if (uc != null){
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for (int i:useCases) {
            System.out.println("Warning:Missing Use Case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackUseCases(useCases,PassWordUtils.class);
    }
}
