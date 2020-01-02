/**
 * <一句话功能简述>
 * <p>
 * CD机音响控制器
 *
 * @author sunmeng
 * @create 2020/1/2   11:52
 */
package orderModel.remoteControl;

public class StereoOnWithCDCommand implements Command {
	Stereo stereo;
	public StereoOnWithCDCommand(Stereo stereo){
		this.stereo=stereo;
	}
	@Override
	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.setVolume(11);
	}
}
