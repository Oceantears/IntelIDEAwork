/**
 * <一句话功能简述>
 * <p>
 * 单例模式测试2
 *
 * @author sunmeng
 * @create 2019/12/27   11:00
 */
package singleton;

public class Singleton2 {

	public Singleton2(){
		x++;
		y++;
	}
	public static int x=0;
	public static int y;
	private static Singleton2 instance=new Singleton2();              //移动了Singleton1中此方法的位置
	public static Singleton2 getInstance(){
		return instance;
	}

	public static void main(String[] args) {
		Singleton2 instance=getInstance();
		System.out.println("x==============>"+instance.x);
		System.out.println("y==============>"+instance.y);
	}
}
