/**
 * <一句话功能简述>
 * <p>
 * 纽约披萨店
 *
 * @author sunmeng
 * @create 2019/12/17   11:52
 */
package abstractFactoryModel;


import abstractFactoryModel.PizzaStyle.CheesePizza;
import abstractFactoryModel.PizzaStyle.Pizza;
import abstractFactoryModel.PizzaStyle.VeggiePizza;

public class NYPizzaStore extends PizzaStore {


	@Override
	protected Pizza createPizza(String type) {
		Pizza pizza=null;
		PizzaIngredientFactory ingredientFactory=new NYPizzaIngredientFactory();
		if(type.equals("cheese")){
			pizza=new CheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza!");
		}else if(type.equals("veggie")){
			pizza=new VeggiePizza(ingredientFactory);
		}
		Integer


		return pizza;
	}
}
