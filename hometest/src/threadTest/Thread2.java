/**
 * <һ�仰���ܼ���>
 * <Thread������2>
 *
 * ��������һ�������ࣨ����δ�̳�Thread�ࣩ��������һ������ʵ������������Ϊ��201��ӡ��300����ʵ��һ���̣߳����̵߳ĸ����ǹ����࣬���̵߳Ĺ���ͨ�����ø���Ĺ��ܷ���ʵ�֡�
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
