/**
 * <一句话功能简述>
 * <p>
 * 奶泡装饰者类
 *
 * @author sunmeng
 * @create 2019/12/12   12:02
 */
package decoratorModel;

public class Whip extends CondimentDecorator {
	Beverage beverage;
	public Whip(Beverage beverage){
		this.beverage=beverage;
	}
	@Override
	public String getDescription() {
		return beverage.getDescription()+",Whip";
	}

	@Override
	public double cost() {
		return 0.10+beverage.cost();
	}
}
