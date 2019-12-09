/**
 * <一句话功能简述>
 * <不能飞行类>
 *
 * @author sunmeng
 * @create 2019/12/8   19:17
 */
package ducks;

public class FlyNoWay implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("我没办法飞！！！");
	}
}
