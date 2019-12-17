/**
 * <一句话功能简述>
 * <p>
 * 芝加哥披萨商店
 *
 * @author sunmeng
 * @create 2019/12/15   23:40
 */
package factoryModel.ChicagoPizza;

import factoryModel.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {
	public ChicagoStyleCheesePizza(){
		name="Chicago Style Deep Dish Cheese Pizza";
		dough="Extra Thick Crust Dough";
		sauce="Plum Tomato sauce";

		toppings.add("Shredded Mozzarella Cheese");
	}

	//覆盖了cut()方法，将披萨切成正方形
	@Override
	protected void cut(){
		System.out.println("Cutting the pizza into square slices");
	}
}
