/**
 * <一句话功能简述>
 * <p>
 * 关灯命令
 *
 * @author sunmeng
 * @create 2020/1/2   10:07
 */
package orderModel.remoteControl;

import orderModel.simpleRemoteControl.light.Light;

public class LightOffCommand implements Command {
	Light light;

	public LightOffCommand(Light light){
		this.light=light;
	}
	@Override
	public void execute() {
		light.off();
	}

}
