/**
 * <一句话功能简述>
 * <p>
 * 骑士类
 *
 * @author sunmeng
 * @create 2019/12/23   10:07
 */
package com.springnaction.knights;

public class BraveKnight implements Knight {
	private Quest quest;
	public BraveKnight(Quest quest){
		this.quest=quest;
	}
	public void embarkOnQuest(){
		quest.embark();
	}

}
