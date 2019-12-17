/**
 * <一句话功能简述>
 * <p>
 * 豆浆装饰者类
 *
 * @author sunmeng
 * @create 2019/12/12   11:59
 */
package decoratorModel;

public class Soy extends CondimentDecorator {
	Beverage beverage;
	public Soy(Beverage beverage){
		this.beverage=beverage;
	}
	@Override
	public String getDescription() {
		return beverage.getDescription()+",Soy";
	}

	@Override
	public double cost() {
		return 0.15+beverage.cost();
	}
}
