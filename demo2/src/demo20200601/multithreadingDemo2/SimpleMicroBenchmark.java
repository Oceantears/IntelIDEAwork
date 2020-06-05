/**
 * <一句话功能简述>
 * <p>
 * 比较各类互斥技术，测试synchronized关键字Lock和Atomic类
 *
 * @author sunmeng
 * @create 2020/6/1   16:51
 */
package demo20200601.multithreadingDemo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class Incrementable{
	protected long counter = 0;
	public abstract void increment();
}

class SynchronizingTest extends Incrementable{

	@Override
	public synchronized void increment() {
		++counter;
	}
}

class LockingTest extends Incrementable{
	private Lock lock = new ReentrantLock();
	@Override
	public void increment() {
		lock.lock();
		try {
			++counter;
		} catch (Exception e) {
			lock.unlock();
		}
	}
}

public class SimpleMicroBenchmark {
	static long test(Incrementable inc){
		long start = System.nanoTime();
		for (long i = 0; i < 10000000L; i++) {
			inc.increment();
		}
		return System.nanoTime() - start;
	}

	public static void main(String[] args) {
		long synchTime = test(new SynchronizingTest());
		long lockTime = test(new LockingTest());
		System.out.printf("synchronized:%1$10d\n",synchTime);
		System.out.printf("Lock:	    %1$10d\n",lockTime);
		System.out.printf("Lock/synchronized = %1$.3f",(double)lockTime/(double)synchTime);
	}
}
