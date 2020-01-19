import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sia.soundsystem.CompactDisc;
import sia.soundsystem.MediaPlayer;
import sia.soundsystem.config.CDPlayerConfig;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

/**
 * <一句话功能简述>
 * <p>
 * CD测试类
 *
 * @author sunmeng
 * @create 2020/1/14   10:25
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
	//一个JUnit规则，该规则基于控制台的输出编写断言。这里断言了SgtPeppers.play()方法的输出被发送到控制台上。
	@Rule
	public final StandardOutputStreamLog log=new StandardOutputStreamLog();

	@Autowired
	private MediaPlayer plyaer;

	@Autowired       //自动生成一个CompactDisc的Bean并完成自动装配的工作
	private CompactDisc cd;
	@Test
	public void cdShouldNotBeNull(){
		assertNotNull(cd);
	}
	@Test
	public void play(){
		plyaer.play();
		assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band by The Beatles\n",log.getLog());
	}
}
