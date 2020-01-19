/**
 * <一句话功能简述>
 * <p>
 * 执行类
 *
 * 通过ClassPathXmlApplicationContext加载xml文件注入类
 * (也可以用KnightConfig类进行注入，用AnnotationConfigApplicationContext加载config类)
 *
 * @author sunmeng
 * @create 2020/1/9   15:40
 */
package sia.knights;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sia.knights.congig.KnightConfig;

public class KnightMain {
	public static void main(String[] args) {
		//加载spring上下文
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/knight.xml");
		//获取knight bean
		Knight knight=context.getBean(Knight.class);
		//使用knight
		knight.embarkOnQuest();
		context.close();



		// //用KnightConfig类Bean注入
		// AnnotationConfigApplicationContext aca=new AnnotationConfigApplicationContext(KnightConfig.class);
		// Knight knight1= (Knight) aca.getBean("knight");       //需要强转
		// knight1.embarkOnQuest();
		// aca.close();
	}


}
