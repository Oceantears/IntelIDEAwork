/**
 * <一句话功能简述>
 * <电脑类>
 *
 * @author Administrator
 * @create 2019/9/12
 */
package interfaceTest;

public class Computer {
    public void run(){
        System.out.println("笔记本运行。");
    }
    public void useUSB(USB usb){
        if(usb!=null){
            usb.open();
            usb.close();
        }
    }

    public void shutDown(){
        System.out.println("笔记本关闭。");
    }
}
