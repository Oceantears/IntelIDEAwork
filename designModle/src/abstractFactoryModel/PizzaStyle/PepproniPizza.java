/**
 * <一句话功能简述>
 * <p>
 * 意大利肉肠披萨
 *
 * @author sunmeng
 * @create 2019/12/24   15:18
 */
package abstractFactoryModel.PizzaStyle;

import abstractFactoryModel.PizzaIngredientFactory;

public class PepproniPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
	public PepproniPizza(PizzaIngredientFactory ingredientFactory){
		this.ingredientFactory=ingredientFactory;
	}
	@Override
	void prepare() {
		System.out.println("Preparing "+name);
		dough=ingredientFactory.createDough();
		sauce=ingredientFactory.createSauce();
		cheese=ingredientFactory.createCheese();
	}
}
