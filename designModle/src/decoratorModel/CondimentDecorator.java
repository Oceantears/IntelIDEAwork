/**
 * <一句话功能简述>
 * <p>
 * 调料抽象类，也就是装饰者类
 *
 * @author sunmeng
 * @create 2019/12/12   10:07
 */
package decoratorModel;

//必须让CondimentDecorator能够取代Beverage
public abstract class CondimentDecorator extends Beverage {
	//所有的调料装饰者都必须重新实现getDescription()方法
	public abstract String getDescription();
}
