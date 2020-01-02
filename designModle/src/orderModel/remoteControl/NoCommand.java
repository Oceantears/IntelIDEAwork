/**
 * <一句话功能简述>
 *
 * @author sunmeng
 * @create 2019/12/30   11:48
 */
package orderModel.remoteControl;

public class NoCommand implements Command {
	@Override
	public void execute() {
		System.out.println("========没有命令=========");
	}
}
