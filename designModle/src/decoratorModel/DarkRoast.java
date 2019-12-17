/**
 * <一句话功能简述>
 * <p>
 * 深焙咖啡类
 *
 * @author sunmeng
 * @create 2019/12/12   11:14
 */
package decoratorModel;

public class DarkRoast extends Beverage {
	public DarkRoast(){
		description="Dark Roast";
	}

	@Override
	public double cost() {
		return 0.99;
	}
}
