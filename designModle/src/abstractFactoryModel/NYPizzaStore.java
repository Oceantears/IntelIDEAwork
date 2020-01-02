/**
 * <一句话功能简述>
 * <p>
 * 纽约披萨店
 *
 * @author sunmeng
 * @create 2019/12/17   11:52
 */
package abstractFactoryModel;


import abstractFactoryModel.PizzaStyle.*;

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
			pizza.setName("New York Style Veggie Pizza!");
		}else if(type.equals("clam")){
			pizza=new ClamPizza(ingredientFactory);
			pizza.setName("New York Style Clams Pizza!");
		}else if(type.equals("pepperoni")){
			pizza=new PepproniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza!");
		}
		return pizza;
	}
}
