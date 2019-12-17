/**
 * <一句话功能简述>
 * <p>
 * 咖啡测试类
 *
 * @author sunmeng
 * @create 2019/12/12   14:10
 */
package decoratorModel;


public class StarbuzzCoffee {
	public static void main(String[] args) {
		Beverage beverage=new Espresso();
		System.out.println(beverage.getDescription()+"的花费是：$"+beverage.cost());

		Beverage beverage1=new DarkRoast();
		beverage1=new Mocha(beverage1);
		beverage1=new Mocha(beverage1);
		beverage1=new Whip(beverage1);
		System.out.println(beverage1.getDescription()+"的花费是：$"+beverage1.cost());

		Beverage beverage2=new HouseBlend();
		beverage2=new Soy(beverage2);
		beverage2=new Mocha(beverage2);
		beverage2=new Whip(beverage2);
		System.out.println(beverage2.getDescription()+"的花费是：$"+beverage2.cost());
	}
}
