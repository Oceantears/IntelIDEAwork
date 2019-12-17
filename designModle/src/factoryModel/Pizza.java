/**
 * <一句话功能简述>
 * <p>
 * 披萨类
 *
 * @author sunmeng
 * @create 2019/12/15   23:03
 */
package factoryModel;

import java.util.ArrayList;

public abstract class Pizza {
	protected String name;
	protected String dough;     //面团类型
	protected String sauce;		//酱料
	protected ArrayList toppings=new ArrayList();       //佐料

	protected void prepared(){
		System.out.println("Preparing"+name);
		System.out.println("Tossing dough...");
		System.out.println("Adding sauce...");
		System.out.println("Adding topping:");
		for (int i = 0; i <toppings.size() ; i++) {
			System.out.println("	"+toppings.get(i));
		}
	}
	protected void bake(){
		System.out.println("Bake for 25 minutes at 350");
	}
	protected void cut(){
		System.out.println("Cutting the Pizza into diagonal slices");
	}
	protected void box(){
		System.out.println("Place pizza in official PizzaStore box");
	}
	public String getName(){
		return name;
	}
}
