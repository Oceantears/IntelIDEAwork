/**
 * <一句话功能简述>
 * <p>
 * 吟游诗人类，记录骑士的所有事迹（面向切面编程，不影响主线运作）
 *
 * @author sunmeng
 * @create 2020/1/9   17:28
 */
package sia.knights;

import org.springframework.scheduling.annotation.Async;

import java.io.PrintStream;


public class Minstrel {
	private PrintStream steam;
	public Minstrel(PrintStream stream){
		this.steam=stream;
	}

	//探险之前调用
	public void singBeforeQuest(){
		steam.println("骑士真勇敢~~");
	}
	//探险之后调用
	public void singAfterQuest(){
		steam.println("勇士去漂流归来~~");
	}
}
