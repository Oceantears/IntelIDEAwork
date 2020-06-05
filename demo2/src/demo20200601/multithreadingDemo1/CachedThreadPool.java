/**
 * <一句话功能简述>
 * <p>
 * java.util.concurrent包中Excutor(执行器)为你管理Thread对象，从而简化了并发
 *
 * @author sunmeng
 * @create 2020/6/1   9:51
 */
package demo20200601.multithreadingDemo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
