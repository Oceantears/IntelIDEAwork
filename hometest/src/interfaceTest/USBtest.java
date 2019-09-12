/**
 * <一句话功能简述>
 * <模拟鼠标键盘通过USB接口连接电脑>
 *
 * @author Administrator
 * @create 2019/9/11
 */
package interfaceTest;

public class USBtest {
    public static void main(String[] args) {
        Computer computer=new Computer();
        computer.run();

        Mouse mouse=new Mouse();
        computer.useUSB(mouse);

        Keyboard kb=new Keyboard();
        computer.useUSB(kb);

        computer.shutDown();
    }

}
