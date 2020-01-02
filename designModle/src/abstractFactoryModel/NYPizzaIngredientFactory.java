/**
 * <一句话功能简述>
 * <p>
 * 纽约原料工厂
 *
 * @author sunmeng
 * @create 2019/12/17   10:39
 */
package abstractFactoryModel;

import abstractFactoryModel.styles.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	@Override
	public Veggies[] createVeggies() {
		Veggies veggies[]={new Garlic(),new Onion(),new Mushroom(),new RedPepper()};
		return veggies;
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	@Override
	public Clams createClams() {
		return new FreshClams();
	}
}
