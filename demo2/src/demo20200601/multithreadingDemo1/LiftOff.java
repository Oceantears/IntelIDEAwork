/**
 * <一句话功能简述>
 * <p>
 * 显示发射之前的倒计时
 *
 * @author sunmeng
 * @create 2020/6/1   8:58
 */
package demo20200601.multithreadingDemo1;

public class LiftOff implements Runnable {
	protected int countdown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;
	public LiftOff(){}
	public LiftOff(int countdown){
		this.countdown = countdown;
	}
	public String status(){
		return "===>" + id + "(" + (countdown>0?countdown:"liftOff!") + ").";
	}
	@Override
	public void run() {
		while (countdown-- >0){
			System.out.println(status());
			Thread.yield();
		}
	}
}
