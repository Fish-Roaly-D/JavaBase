package com.roily.booknode.javatogod._07Annotation.a03.annotation;

//import javax.xml.ws.ServiceMode;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rolyfish
 * @Date: 2022/08/31/15:58
 * @Description: @Component替代品  可用于类接口上（注解、枚举也可以用）
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@ServiceMode
//@Inherited
public @interface RolyComponent {

}
