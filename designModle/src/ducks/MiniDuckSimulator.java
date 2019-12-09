/**
 * <一句话功能简述>
 * <鸭子测试类>
 *
 * @author sunmeng
 * @create 2019/12/8   19:27
 */
package ducks;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard=new MallardDuck();
		//调用继承的行为(quackBehavior)引用对象的行为(Quack)显示
		mallard.performFly();
		//mallard.setQuackBehavior(new MuteQuack());
		mallard.performQuack();
	}
}
