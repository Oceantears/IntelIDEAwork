/**
 * <一句话功能简述>
 * <p>
 * 自定义UseCase注解
 *
 * @author sunmeng
 * @create 2020/5/30   9:15
 */
package demo20200530.annotationDemo1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	public int id();
	public String description()
			default "no description";
}
