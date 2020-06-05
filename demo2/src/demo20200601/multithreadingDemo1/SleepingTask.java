/**
 * <一句话功能简述>
 * <p>
 * 调用sleep()方法，停止任务
 *
 * @author sunmeng
 * @create 2020/6/1   14:44
 */
package demo20200601.multithreadingDemo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
	public void run(){
		try {
			while (countdown-- >0){
				System.out.println(status());

					TimeUnit.MILLISECONDS.sleep(100);
				}
			}catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}
}
