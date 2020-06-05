/**
 * <一句话功能简述>
 * <p>
 * 更多的线程驱动更多的任务
 *
 * @author sunmeng
 * @create 2020/6/1   9:24
 */
package demo20200601.multithreadingDemo1;

public class MoreBasicThreads {
	public static void main(String[] args) {
		for (int i = 0; i <5 ; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for Lift Off!");
	}
}
