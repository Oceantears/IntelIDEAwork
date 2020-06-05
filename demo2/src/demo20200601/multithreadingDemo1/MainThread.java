/**
 * <一句话功能简述>
 * <p>
 * 主线程执行
 *
 * @author sunmeng
 * @create 2020/6/1   9:07
 */
package demo20200601.multithreadingDemo1;

public class MainThread {
	public static void main(String[] args) {
		LiftOff launch = new LiftOff();
		launch.run();
	}
}
