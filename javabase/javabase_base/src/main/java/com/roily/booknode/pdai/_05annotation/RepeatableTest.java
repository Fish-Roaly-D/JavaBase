package com.roily.booknode.pdai._05annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @classname：RepeatableTest
 * @author: rolyfish
 * @description:
 * @date: 2022/10/31 21:30
 */
public class RepeatableTest {


}

/**
 * java8之前想达到重复注解的效果，如下操作
 *
 * @author rolyfish
 */
@interface Role {
    String role() default "";
}

/**
 * @author rolyfish
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Roles {
    Role[] roles();
}

@Roles(roles = {@Role(role = "男的"), @Role(role = "学Java的")})
class Test1 {
    public static void main(String[] args) {
        final Annotation[] declaredAnnotations = Test1.class.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            if (declaredAnnotation instanceof Roles) {
                Roles roles = (Roles) declaredAnnotation;
                for (Role role : roles.roles()) {
                    System.out.println(role.role());
                }
            }
        }
    }
}

/**
 * jad8提供的Repeatable注解可实现重复
 *
 * @author rolyfish
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RolesX.class)
@interface RoleX {
    String role();
}

/**
 * @author rolyfish
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface RolesX {
    RoleX[] value();
}

@RoleX(role = "男的")
@RoleX(role = "学java的")
class Test2 {
    public static void main(String[] args) {
        final Annotation[] declaredAnnotations = Test2.class.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            if (declaredAnnotation instanceof RolesX) {
                RolesX rolesX = (RolesX) declaredAnnotation;
                for (RoleX roleX : rolesX.value()) {
                    System.out.println(roleX.role());
                }
            }
        }

        final Annotation[] annotations = Test2.class.getAnnotations();

        final Annotation[] annotationsByType = Test2.class.getAnnotationsByType(RoleX.class);

        final Annotation[] declaredAnnotationsByType = Test2.class.getDeclaredAnnotationsByType(RoleX.class);
        final Annotation[] declaredAnnotations1 = Test2.class.getDeclaredAnnotations();
    }
}