/**
 * <一句话功能简述>
 * <p>
 * 用Thread来驱动LiftOff类
 *
 * @author sunmeng
 * @create 2020/6/1   9:19
 */
package demo20200601.multithreadingDemo1;

public class BasicThreads {
	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
		System.out.println("Waiting for Lift Off!");
	}
}
