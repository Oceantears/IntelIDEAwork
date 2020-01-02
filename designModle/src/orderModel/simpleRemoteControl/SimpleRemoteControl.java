/**
 * <一句话功能简述>
 * <p>
 * 遥控器类，只有一个按钮和对应的插槽，可以控制一个装置
 *
 * @author sunmeng
 * @create 2019/12/29   21:29
 */
package orderModel.simpleRemoteControl;

public class SimpleRemoteControl {
	Command slot;                 //有一个插槽持有命令，而这个命令控制着一个装置
	public SimpleRemoteControl(){

	}
	public void setCommand(Command command){
		slot=command;
	}
	public void buttonWasPressed(){
		slot.execute();
	}
}
