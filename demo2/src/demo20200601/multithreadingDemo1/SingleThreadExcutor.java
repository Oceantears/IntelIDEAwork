/**
 * <一句话功能简述>
 * <p>
 * 相当于线程数量为1的FixedThreadPool，对多个任务进行排队，单个按顺序执行
 *
 * @author sunmeng
 * @create 2020/6/1   10:42
 */
package demo20200601.multithreadingDemo1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExcutor {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
