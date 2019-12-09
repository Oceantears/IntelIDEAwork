/**
 * <一句话功能简述>
 * <呱呱叫类>
 *
 * @author sunmeng
 * @create 2019/12/8   19:19
 */
package ducks;

public class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("呱呱呱！！！！");
	}
}
