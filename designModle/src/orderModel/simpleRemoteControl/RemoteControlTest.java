/**
 * <一句话功能简述>
 * <p>
 * 命令模式的客户
 *
 * @author sunmeng
 * @create 2019/12/29   21:35
 */
package orderModel.simpleRemoteControl;

import orderModel.simpleRemoteControl.garageDoor.GarageDoor;
import orderModel.simpleRemoteControl.garageDoor.GarageDoorOpenCommand;
import orderModel.simpleRemoteControl.light.Light;
import orderModel.simpleRemoteControl.light.LightOnCommand;

public class RemoteControlTest {
	public static void main(String[] args) {
		SimpleRemoteControl remote=new SimpleRemoteControl();	//遥控器是调用者，传入一个命令对象，可以用来发出请求
		Light light=new Light();	//创建一个点灯对象，此对象是请求的接收者
		GarageDoor garageDoor=new GarageDoor();

		LightOnCommand lightOn=new LightOnCommand(light);	//创建一个命令，然后将接收者传给它
		GarageDoorOpenCommand garageDoorOpen=new GarageDoorOpenCommand(garageDoor);

		remote.setCommand(lightOn);		//把命令传给调用者
		remote.buttonWasPressed();		//模拟按下按钮

		remote.setCommand(garageDoorOpen);
		remote.buttonWasPressed();
	}
}
