/**
 * <一句话功能简述>
 * <p>
 * CDPlayer的Bean类
 *
 * @author sunmeng
 * @create 2020/1/14   14:12
 */
package sia.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component
public class CDPlayer implements MediaPlayer {
	private CompactDisc cd;
	@Autowired
	public CDPlayer(CompactDisc cd){
		this.cd=cd;
	}
	public void play() {
		cd.play();
	}
}
