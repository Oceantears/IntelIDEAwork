/**
 * <一句话功能简述>
 * <鸭的总类>
 *
 * @author sunmeng
 * @create 2019/12/6   17:44
 */
package ducks;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	public Duck(){

	}
	public abstract void display();

	//行为委托给行为类
	public void performFly(){
		flyBehavior.fly();
	}
	public void performQuack(){
		quackBehavior.quack();
	}

	public void setFlyBehavior(FlyBehavior fb){
		flyBehavior=fb;
	}
	public void setQuackBehavior(QuackBehavior qb){
		quackBehavior=qb;
	}

	public void swiming(){
		System.out.println("所有鸭子都会游泳~~~~~~~");
	}
}
