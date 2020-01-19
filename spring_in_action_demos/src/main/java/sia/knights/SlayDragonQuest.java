/**
 * <一句话功能简述>
 * <p>
 * 屠龙
 *
 * @author sunmeng
 * @create 2020/1/9   15:22
 */
package sia.knights;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {
	private PrintStream stream;
	public SlayDragonQuest(PrintStream stream){
		this.stream=stream;
	}
	public void embark() {
		stream.println("Embarking on quest to slay the dragon!");
	}
}
