/**
 * <一句话功能简述>
 * <Thread测试类2>
 *
 * 二、开发一个功能类（该类未继承Thread类），该类有一个公有实例方法，功能为从201打印到300；再实现一个线程，该线程的父类是功能类，该线程的功能通过调用父类的功能方法实现。
 *
 * @author sunmeng
 * @create 2019/12/4   18:56
 */
package threadTest;

public class Thread2 extends Thread2Father implements Runnable {

	public Thread2(Thread thread) {
		super(thread);
	}

	@Override
	public void run() {
		numb();
	}
}
