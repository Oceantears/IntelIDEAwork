/**
 * <一句话功能简述>
 * <p>
 * 反射测试
 *
 * @author sunmeng
 * @create 2020/1/3   10:35
 */
package reflection;

import java.lang.reflect.InvocationTargetException;

public class Reflection_test1 {
	public static void main(String[] args) {
		String s="java.util.Random";
		try {
			Object m=Class.forName(s).newInstance();
			System.out.println(m.getClass().getName());

			Object n=Class.forName(s).getConstructor().newInstance();
			System.out.println(n.getClass().getName());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
