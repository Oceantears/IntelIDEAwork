/**
 * <һ�仰���ܼ���>
 *
 * <Thread������2�ĸ���>
 *
 * @author sunmeng
 * @create 2019/12/4   18:55
 */
package threadTest;

public class Thread2Father {
	Thread thread;
	public Thread2Father(Thread thread){
		this.thread=thread;
	}
	public void numb(){
		for(int i=201;i<=300;i++){
			// try {
			// 	Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// 	e.printStackTrace();
			// }
			System.out.println("������֣�"+i);
			if(i==220){
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
