/**
 * <一句话功能简述>
 * <p>
 * 浓缩咖啡类
 *
 * @author sunmeng
 * @create 2019/12/12   11:06
 */
package decoratorModel;

//因为Espresso是一种饮料，所以扩展自Beverage
public class Espresso extends Beverage {
	public Espresso(){
		description="Espresso";
	}
	@Override
	public double cost() {
		return 1.99;
	}
}
