/**
 * <一句话功能简述>
 * <不会发声的类>
 *
 * @author sunmeng
 * @create 2019/12/8   19:21
 */
package ducks;

public class MuteQuack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("安静~~~~~~~~~");
	}
}
