/**
 * <һ�仰���ܼ���>
 * <�̲߳�����1>
 *
 *     һ������һ���߳��࣬����Ĺ��췽���������߳����ƣ����̵߳Ĺ����Ǵ�1��ӡ��100��
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
