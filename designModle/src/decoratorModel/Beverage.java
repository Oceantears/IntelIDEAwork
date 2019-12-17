/**
 * <一句话功能简述>
 *
 * 装饰者模式中  饮料抽象类
 *
 * @author sunmeng
 * @create 2019/12/12   9:59
 */
package decoratorModel;

public abstract class Beverage {
	String description="Unknow Beverage";
	public String getDescription(){
		return description;
	}
	//cost（）需要在子类中实现
	public abstract double cost();
}
