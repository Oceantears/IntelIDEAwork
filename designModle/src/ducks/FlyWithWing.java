/**
 * <一句话功能简述>
 * <用翅膀飞行的类>
 *
 * @author sunmeng
 * @create 2019/12/8   19:16
 */
package ducks;

public class FlyWithWing implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("我用翅膀飞！！！");
	}
}
