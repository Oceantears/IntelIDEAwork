package demo_20210512_AnnotationDemo.NO2_DBtable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 此注解告诉注解处理器，你需要为我生成一个数据库表
 */
@Target(ElementType.TYPE)   //可以用逗号分隔的形式指定多个值
@Retention(RetentionPolicy.RUNTIME)
public @interface DBtable {
    public String name() default "";
}
