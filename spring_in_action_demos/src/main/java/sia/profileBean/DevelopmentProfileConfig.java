/**
 * <一句话功能简述>
 * <p>
 * 嵌入式数据库的DataSource可以的配置
 *
 * @author sunmeng
 * @create 2020/1/16   15:30
 */
package sia.profileBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

// @Configuration
// @Profile("dev")
// public class DevelopmentProfileConfig {
// 	@Bean(destroyMethod = "shutdown")
// 	public DataSource dataSource(){
// 		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("class")
// 	}
// }
