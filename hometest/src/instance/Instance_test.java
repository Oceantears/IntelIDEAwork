/**
 * <一句话功能简述>
 *
 * <关于反射的练习>
 *
 * @author sunmeng
 * @create 2019/12/3   14:06
 */
package instance;

public class Instance_test {

	public static void main(String[] args) {
		//获取类内的方法
		// try {
		// 	Method[] methods =Class.forName("java_base.Int_test").getMethods();
		// 	for (Method meth:methods) {
		// 		System.out.println(meth.getName());
		// 	}
		// } catch (ClassNotFoundException e) {
		// 	e.printStackTrace();
		// }


		//newInstance()返回无参数构造器构造的一个新实例
		//newInstance实际上是把new这个方式分解为两步,即，首先调用class的加载方法加载某个类，然后实例化。
		//      这样分步的好处是显而易见的。我们可以在调用class的静态加载方法forName时获得更好的灵活性，提供给了我们降耦的手段。
		Class claz= null;
		// try {
		// 	claz = Class.forName("instance.Test2");         //获取Mouse类
		// 	Itest itest=(Itest) claz.newInstance();					//实例化Mouse类的父类或者接口的无参构造实例
		// 	itest.hello();
		// 	System.out.println(itest.call());
		// } catch (ClassNotFoundException e) {
		// 	e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// 	e.printStackTrace();
		// } catch (InstantiationException e) {
		// 	e.printStackTrace();
		// }


		Itest itest=new Test1();
		Class cl=itest.getClass();
		System.out.println(itest.getClass().getName());


		//警告： 鉴于历史原 getName 方法在应用于数组类型的时候会返回一个很奇怪的名字
		System.out.println(Double[].class.getName());
		System.out.println(int[].class.getName());
		System.out.println(char[].class.getName());



	}
}
