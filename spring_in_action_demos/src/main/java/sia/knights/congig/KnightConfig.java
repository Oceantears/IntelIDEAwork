/**
 * <一句话功能简述>
 * <p>
 * 骑士注入到勇士
 *
 * @author sunmeng
 * @create 2020/1/9   15:28
 */
package sia.knights.congig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sia.knights.BraveKnight;
import sia.knights.Knight;
import sia.knights.Quest;
import sia.knights.SlayDragonQuest;

@Configuration
public class KnightConfig {
	// @Bean(value = "knight")
	@Bean
	public Knight knight(){
		return new BraveKnight(quest());
	}
	@Bean
	public Quest quest(){
		return new SlayDragonQuest(System.out);
	}
}
