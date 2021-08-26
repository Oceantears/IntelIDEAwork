package demo_20210512_AnnotationDemo;


import org.junit.jupiter.api.Test;

/**
 * @date ：Created in 2021/5/12 14:51
 * @version: java 8
 */
public class demo1 {
    public void execute(){
        System.out.println("executing.........");
    }
    @Test
    public void testExecute(){
        execute();
    }
}
