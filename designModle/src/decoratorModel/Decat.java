/**
 * <一句话功能简述>
 * <p>
 * 低咖啡因咖啡类
 *
 * @author sunmeng
 * @create 2019/12/12   11:18
 */
package decoratorModel;

public class Decat extends Beverage {
	public Decat(){
		description="Decat";
	}
	@Override
	public double cost() {
		return 1.05;
	}
}
