/**
 * <一句话功能简述>
 * <p>
 * 单例模式测试1
 *
 * @author sunmeng
 * @create 2019/12/27   10:57
 */
package singleton;

public class Singleton1 {
	private static Singleton1 instance=new Singleton1();
	public Singleton1(){
		x++;
		y++;
	}
	public static int x=0;
	public static int y;
	public static Singleton1 getInstance(){
		return instance;
	}

	public static void main(String[] args) {
		Singleton1 instance=getInstance();
		System.out.println("x==============>"+instance.x);
		System.out.println("y==============>"+instance.y);
	}
}
