/**
 * <一句话功能简述>
 * <p>
 * 车库门开关
 *
 * @author sunmeng
 * @create 2019/12/29   21:58
 */
package orderModel.simpleRemoteControl.garageDoor;

import orderModel.simpleRemoteControl.Command;

public class GarageDoorOpenCommand implements Command {
	GarageDoor garageDoor;
	public GarageDoorOpenCommand(GarageDoor garageDoor){
		this.garageDoor=garageDoor;
	}
	@Override
	public void execute() {
		garageDoor.up();
	}
}
