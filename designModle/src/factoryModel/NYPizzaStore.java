/**
 * <一句话功能简述>
 * <p>
 * 纽约披萨商店
 *
 * @author sunmeng
 * @create 2019/12/15   23:33
 */
package factoryModel;

import factoryModel.NYPizza.NYStyleCheesePizza;
import factoryModel.NYPizza.NYStyleClamPizza;
import factoryModel.NYPizza.NYStylePepperoniPizza;
import factoryModel.NYPizza.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore {
	@Override
	protected Pizza createPizza(String type) {
		if(type.equals("cheese")){
			return new NYStyleCheesePizza();
		}else if(type.equals("veggie")){
			return new NYStyleVeggiePizza();
		}else if(type.equals("clam")){
			return new NYStyleClamPizza();
		}else if(type.equals("pepperoni")){
			return new NYStylePepperoniPizza();
		}
		else return null;
	}
}
