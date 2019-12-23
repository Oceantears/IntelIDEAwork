/**
 * <一句话功能简述>
 * <p>
 * 芝加哥原料工厂
 *
 * @author sunmeng
 * @create 2019/12/17   10:47
 */
package abstractFactoryModel;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	@Override
	public Cheese createCheese() {
		return new ;
	}

	@Override
	public Veggies[] createVeggies() {
		return new Veggies[0];
	}

	@Override
	public Pepperoni createPepperoni() {
		return new SllcedPepperonl();
	}

	@Override
	public Clams createClams() {
		return null;
	}
}
