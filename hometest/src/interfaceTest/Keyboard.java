/**
 * <一句话功能简述>
 * <键盘类>
 *
 * @author Administrator
 * @create 2019/9/12
 */
package interfaceTest;

public class Keyboard implements USB {

    @Override
    public void open() {
        System.out.println("键盘连接上了。");
    }

    @Override
    public void close() {
        System.out.println("键盘断开连接。");
    }
}
