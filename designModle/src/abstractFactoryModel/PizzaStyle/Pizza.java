/**
 * <一句话功能简述>
 * <p>
 * 披萨抽象类
 *
 * @author sunmeng
 * @create 2019/12/17   11:21
 */
package abstractFactoryModel.PizzaStyle;

import abstractFactoryModel.styles.*;

import java.util.Arrays;

public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Veggies veggies[];
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clams;

	//这个方法中我们需要收集披萨所需的原料，而这些原料当然是来自原料工厂
	abstract void prepare();

	void bake(){
		System.out.println("Bake for 25 minutes at 350.");
	}
	void cut(){
		System.out.println("Cutting the pizza into diagonal slices");
	}
	void box(){
		System.out.println("Place pizza in official PizzaStore box");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"name='" + name + '\'' +
				", dough=" + dough +
				", sauce=" + sauce +
				", veggies=" + Arrays.toString(veggies) +
				", cheese=" + cheese +
				", pepperoni=" + pepperoni +
				", clams=" + clams +
				'}';
	}
}
