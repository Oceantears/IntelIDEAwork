/**
 * <一句话功能简述>
 * <线程测试类1>
 *
 *     一、开发一个线程类，该类的构造方法参数是线程名称，该线程的功能是从1打印到100。
 *
 * @author sunmeng
 * @create 2019/12/4   18:10
 */
package threadTest;

public class Thread1 implements Runnable {
	public Thread1(String name){

	}

	@Override
	public void run() {
		for(int i=0;i<=100;i++){
			// try {
			// 	Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// 	e.printStackTrace();
			// }
			Thread.yield();
			System.out.println("=========Thread1===========>"+i);
		}
	}
}
