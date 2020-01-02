/**
 * <一句话功能简述>
 * <p>
 * 控制点灯on()的方法
 *
 * @author sunmeng
 * @create 2019/12/29   21:23
 */
package orderModel.simpleRemoteControl.light;

import orderModel.simpleRemoteControl.Command;

public class LightOnCommand implements Command {
	Light light;
	public LightOnCommand(Light light){
		this.light=light;
	}
	@Override
	public void execute() {
		light.on();
	}
}
