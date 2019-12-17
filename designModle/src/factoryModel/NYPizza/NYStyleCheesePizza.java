/**
 * <一句话功能简述>
 * <p>
 * 纽约模式披萨
 *
 * @author sunmeng
 * @create 2019/12/16   10:18
 */
package factoryModel.NYPizza;

import factoryModel.Pizza;

public class NYStyleCheesePizza extends Pizza {
	public NYStyleCheesePizza(){
		name="NY Style Sauce and Cheese Pizza";
		dough="Thin Crust Dough";
		sauce="Marinara Sauce";

		toppings.add("Grated Reggiano Cheese");
	}
}
