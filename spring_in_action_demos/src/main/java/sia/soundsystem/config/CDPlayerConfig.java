/**
 * <一句话功能简述>
 * <p>
 * 配置Spring，开启组件扫描，让Spring寻找带有@Component注解的类，并为其创建Bean
 *
 * 通过CompactDisc创建了一个SgtPeppers()专辑bean，运用CDPlayer创建的cdPlayer()播放器的bean进行播放
 *
 * @author sunmeng
 * @create 2020/1/13   22:58
 */
package sia.soundsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sia.soundsystem.*;

@Configuration
// @ComponentScan(basePackages="sia.soundsystem")
@ComponentScan(value = "sia.soundsystem",basePackageClasses = CompactDisc.class)
public class CDPlayerConfig {
	@Bean
	public CompactDisc sgtPeppers(){
		return new SgtPeppers();
	}
	//随机创建CompactDisc的Bean
	// @Bean
	// public CompactDisc randomBeatlesCD(){
	// 	int choice=(int)Math.floor(Math.random()*4);
	// 	if(choice==0){
	// 		return new SgtPeppers();
	// 	}else if(choice==1){
	// 		return new WhiteAlbum();
	// 	}else if(choice==2){
	// 		return new HardDaysNight();
	// 	}else {
	// 		return new Revolver();
	// 	}
	// }
	@Bean
	public CDPlayer cdPlayer(){
		return new CDPlayer(sgtPeppers());
	}
}
