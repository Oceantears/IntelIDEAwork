/**
 * <一句话功能简述>
 * <p>
 * 披萨商店类
 *
 * @author sunmeng
 * @create 2019/12/15   23:10
 */
package abstractFactoryModel;


import abstractFactoryModel.PizzaStyle.Pizza;

public abstract class PizzaStore {
	// SimplePizzaFactory factory;
	// public PizzaStore(SimplePizzaFactory factory){
	// 	this.factory=factory;
	// }

	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza=createPizza(type);


		return pizza;
	}
	protected abstract Pizza createPizza(String type);    //abstract Product factoryMethod(String type)
}
