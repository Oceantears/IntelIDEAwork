/**
 * <一句话功能简述>
 * <p>
 * 芝士披萨
 *
 * @author sunmeng
 * @create 2019/12/17   11:40
 */
package abstractFactoryModel.PizzaStyle;

import abstractFactoryModel.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
	public CheesePizza(PizzaIngredientFactory ingredientFactory){
		this.ingredientFactory=ingredientFactory;
		prepare();
	}
	@Override
	void prepare() {
		System.out.println("Preparing "+name);
		dough=ingredientFactory.createDough();
		sauce=ingredientFactory.createSauce();
		cheese=ingredientFactory.createCheese();
	}
}
