/**
 * <一句话功能简述>
 * <p>
 * 芝加哥披萨店
 *
 * @author sunmeng
 * @create 2019/12/16   17:27
 */
package factoryModel;

import factoryModel.ChicagoPizza.ChicagoStyleCheesePizza;
import factoryModel.ChicagoPizza.ChicagoStyleClamPizza;
import factoryModel.ChicagoPizza.ChicagoStylePepperoniPizza;
import factoryModel.ChicagoPizza.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {
	@Override
	protected Pizza createPizza(String type) {

		if(type.equals("cheese")){
			return new ChicagoStyleCheesePizza();
		}else if(type.equals("veggie")){
			return new ChicagoStyleVeggiePizza();
		}else if(type.equals("clam")){
			return new ChicagoStyleClamPizza();
		}else if(type.equals("pepperoni")){
			return new ChicagoStylePepperoniPizza();
		}
		else return null;
	}
}
