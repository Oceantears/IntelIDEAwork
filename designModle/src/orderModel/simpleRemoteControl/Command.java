/**
 * <一句话功能简述>
 * <p>
 * 让所有命令对象实现相同的包含一个方法的接口
 *
 * @author sunmeng
 * @create 2019/12/29   21:18
 */
package orderModel.simpleRemoteControl;

public interface Command {
	public void execute();      //"执行"的方法
}
