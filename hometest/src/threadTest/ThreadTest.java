/**
 * <һ�仰���ܼ���>
 * <�̲߳�����>
 *
 * @author sunmeng
 * @create 2019/12/4   18:04
 */
package threadTest;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {


		Thread1 thread1=new Thread1("��ʼ����");
		Thread threada=new Thread(thread1);

		Thread2 thread2=new Thread2(threada);
		Thread threadb=new Thread(thread2);

		threada.start();
		threadb.start();
	}
}
