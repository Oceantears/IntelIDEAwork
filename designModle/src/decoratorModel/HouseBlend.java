/**
 * <一句话功能简述>
 * <p>
 * 综合咖啡类
 *
 * @author sunmeng
 * @create 2019/12/12   11:09
 */
package decoratorModel;

public class HouseBlend extends Beverage {
	public HouseBlend(){
		description="House Blend Coffee";
	}
	@Override
	public double cost() {
		return 0.89;
	}
}
