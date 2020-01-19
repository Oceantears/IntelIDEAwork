/**
 * <一句话功能简述>
 * <p>
 * 披头士乐队专辑 《佩珀军士的孤独之心俱乐部乐队》
 *
 * @author sunmeng
 * @create 2020/1/13   22:50
 */
package sia.soundsystem;

import org.springframework.stereotype.Component;

// @Component                    //此注解表明该类会作为组件类，并告知Spring为这个类创建Bean
public class SgtPeppers implements CompactDisc {
	private String title="Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";
	public void play() {
		System.out.println("Playing "+title+" by "+artist);
	}
}
