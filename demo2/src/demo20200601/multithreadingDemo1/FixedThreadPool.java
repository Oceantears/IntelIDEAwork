/**
 * <一句话功能简述>
 * <p>
 * 限定线程数量的多线程
 *
 * @author sunmeng
 * @create 2020/6/1   10:13
 */
package demo20200601.multithreadingDemo1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {

			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
