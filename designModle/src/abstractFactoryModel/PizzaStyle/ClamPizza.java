/**
 * <一句话功能简述>
 * <p>
 * 蛤蜊披萨
 *
 * @author sunmeng
 * @create 2019/12/17   11:44
 */
package abstractFactoryModel.PizzaStyle;

import abstractFactoryModel.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;
	public ClamPizza(PizzaIngredientFactory ingredientFactory){
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
