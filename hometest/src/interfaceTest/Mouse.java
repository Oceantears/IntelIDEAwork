/**
 * <一句话功能简述>
 * <鼠标类>
 *
 * @author Administrator
 * @create 2019/9/12
 */
package interfaceTest;

public class Mouse implements USB {
    @Override
    public void open(){
        System.out.println("鼠标连接上了。");
    }
    @Override
    public void close(){
        System.out.println("鼠标断开了。");
    }
}
