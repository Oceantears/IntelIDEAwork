/**
 * <一句话功能简述>
 * <p>
 * 披萨原料工厂
 *
 * @author sunmeng
 * @create 2019/12/17   10:32
 */
package abstractFactoryModel;

/**
* 如果每个工厂实例内都有某一种通用的“机制”需要实现，就可以把这个例子改成抽象类
*/
public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClams();
}
