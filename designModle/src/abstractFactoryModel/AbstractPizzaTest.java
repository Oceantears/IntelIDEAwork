/**
 * <一句话功能简述>
 * <p>
 * 抽象工厂测试
 *
 * @author sunmeng
 * @create 2019/12/25   22:48
 */
package abstractFactoryModel;

public class AbstractPizzaTest {
	public static void main(String[] args) {
		PizzaStore pizzaStore=new NYPizzaStore();
		System.out.println(pizzaStore.orderPizza("cheese"));
	}
}
