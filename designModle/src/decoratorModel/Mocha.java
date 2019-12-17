/**
 * <一句话功能简述>
 * <p>
 * 摩卡装饰者类，装饰咖啡
 *
 * @author sunmeng
 * @create 2019/12/12   11:45
 */
package decoratorModel;

public class Mocha extends CondimentDecorator {
	//（1）用一个实例变量记录饮料，也就是被装饰者
	Beverage beverage;
	//(2)想办法让被装饰者（饮料）被记录到实例变量中。这里的做法是：把饮料当做构造器的参数，再由构造器将此饮料记录在实例变量中
	public Mocha(Beverage beverage){
		this.beverage=beverage;
	}
	@Override
	public String getDescription() {
		return beverage.getDescription()+",Mocha";
	}

	@Override
	public double cost() {
		return 0.20+beverage.cost();
	}
}
