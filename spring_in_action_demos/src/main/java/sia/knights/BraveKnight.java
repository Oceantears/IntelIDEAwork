/**
 * <一句话功能简述>
 * <p>
 * 勇敢的骑士
 *
 * @author sunmeng
 * @create 2020/1/9   14:44
 */
package sia.knights;

public class BraveKnight implements Knight {
	private Quest quest;
	public BraveKnight(Quest quest){
		this.quest=quest;
	}
	public void embarkOnQuest() {
		quest.embark();
	}
}
