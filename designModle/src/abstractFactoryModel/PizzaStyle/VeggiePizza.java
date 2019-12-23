/**
 * <一句话功能简述>
 * <p>
 * 蔬菜披萨
 *
 * @author sunmeng
 * @create 2019/12/20   11:56
 */
package abstractFactoryModel.PizzaStyle;

import abstractFactoryModel.PizzaIngredientFactory;

public class VeggiePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
	public VeggiePizza(PizzaIngredientFactory ingredientFactory){
		this.ingredientFactory=ingredientFactory;
	}
	@Override
	void prepare() {
		System.out.println("Preparing "+name);
		dough=ingredientFactory.createDough();
		sauce=ingredientFactory.createSauce();
		cheese=ingredientFactory.createCheese();
		clams=ingredientFactory.createClams();
	}
}
