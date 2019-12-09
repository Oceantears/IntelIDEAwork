/**
 * <一句话功能简述>
 * <绿头鸭类>
 *
 * @author sunmeng
 * @create 2019/12/8   19:23
 */
package ducks;

public class MallardDuck extends Duck {
	public MallardDuck(){
		quackBehavior=new Quack();
		flyBehavior=new FlyWithWing();
	}
	@Override
	public void display() {
		System.out.println("这是一只真正的活着的鸭子！！");
	}
}
