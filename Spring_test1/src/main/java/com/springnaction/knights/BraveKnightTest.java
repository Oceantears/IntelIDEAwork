/**
 * <一句话功能简述>
 * <p>
 * 测试类
 *
 * @author sunmeng
 * @create 2019/12/23   10:16
 */
package com.springnaction.knights;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class BraveKnightTest {
	@Test
	public void knightShouldEmbarkOnQuest(){
		Quest mockQuest=mock(Quest.class);
		BraveKnight knight=new BraveKnight(mockQuest);
		knight.embarkOnQuest();
		verify(mockQuest,times(1)).embark();
	}
}
