/**
 * <一句话功能简述>
 * <p>
 * 披萨测试类
 *
 * @author sunmeng
 * @create 2019/12/16   17:23
 */
package factoryModel;

public class PizzaTest {
	public static void main(String[] args) {
		PizzaStore nyStore=new NYPizzaStore();
		PizzaStore chicagoStore=new ChicagoPizzaStore();

		Pizza pizza=nyStore.orderPizza("cheese");
		System.out.println("田志强订了一个"+pizza.getName()+"\n");

		pizza=chicagoStore.orderPizza("cheese");
		System.out.println("闫宝宁订了一个"+pizza.getName()+"\n");

	}
}
