package demo_20210512_AnnotationDemo.NO1_useCase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target      表示该注解可以用于什么地方。可能的ElementType参数：
 *                  CONSTRUCTOR:构造器的声明
 *                  FIELD:域声明（包括enum实例）
 *                  LOCAL_VARIABLE:局部变量声明
 *                  METHOD:方法声明
 *                  PACKAGE:包声明
 *                  PARAMETER:参数声明
 *                  TYPE:类、接口（包括注解类型）或enum声明
 *
 * @Retention    表示需要在什么级别保存该注释信息。可选的RetentionPolicy参数：
 *                  SOURCE:注释将被编译器丢弃
 *                  CLASS:注释在class文件中可用，但会被VM丢弃
 *                  RUNTIME:VM将在运行期也保留注解，因此可以通过反射机制读取注解的信息
 *
 * @Documented    将此注解包含在Javadoc中
 *
 * @Inherited     允许子类继承父类中的注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    /**
     * 注解元素可用的类型有：
     * （1）所有基本类型（int,float,boolean等）
     * （2）String
     * （3）Class
     * （4）enum
     * （5）Annotation（注解）
     * （6）以上类型的数组（*不是集合）
     * @return
     */
    public int id();
    public String description() default "no description";
}
