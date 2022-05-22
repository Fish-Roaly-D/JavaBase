package com.roily.classloader;

import com.sun.javafx.animation.TickCalculation;
import org.junit.Test;

/**
 * descripte:类加载器总结
 *
 * @author: RoilyFish
 * @date: 2022/2/20
 */
public class ClassLoaderTest {
    /**
     * 类的主动引用和被动应用（类的初始化 cinit<>() init<>()）
     * 创建类的实例
     * 访问某个类或接口的静态变量，或者对该静态变量赋值
     * 调用类的静态方法I
     * 反射（比如：Class.forName（"com.atguigu.Test"））
     * 初始化一个类的子类
     * Java虚拟机启动时被标明为启动类的类
     * JDK7开始提供的动态语言支持：
     * java.lang.invoke.MethodHandle实例的解析结果REF getStatic、REF putStatic、REF invokeStatic句柄对应的类没有初始化，则初始化
     */

    /**
     * 双亲委派机制
     *      加载一个类会一层一层的去委派父加载器去加载，（如果加载不了该类）然后再回头
     *
     * 沙箱安全机制
     *      字节码校验器（保证字节码规范）
     *      双亲委派机制（确保自定义的同类名和java基本类库（优先加载核心类库））
     */
    @Test
    public void test01(){

        //系统类加载器，又叫app类加载器，就是程序员自己写的java类
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        System.out.println(ClassLoaderTest.class.getClassLoader());

        //扩展类加载器  jre/lib/ext下的类及子包下的类都是由ext加载器加载
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        System.out.println(TickCalculation.class.getClassLoader());

        //根加载器  代码无法获取根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //String类就是通过根加载器加载的  rt.jar包下的类都是通过根加载器加载的
        System.out.println(String.class.getClassLoader());

    }

}
