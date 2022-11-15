package com.roily.booknode.javatogod._04reflect;

import com.roily.booknode.javatogod._04reflect.source.AnnotationTest;
import com.roily.booknode.javatogod._04reflect.source.ClassPerson;
import com.roily.booknode.javatogod._04reflect.source.ClassPersonPrivate;
import com.roily.booknode.javatogod._04reflect.source.ClassSon;
import com.roily.booknode.javatogod._04reflect.source.InterfaceTest;
import com.roily.booknode.javatogod._04reflect.source.InterfaceTestImpl;
import com.roily.booknode.javatogod._04reflect.source.TestClass;
import org.junit.Test;
import org.openjdk.jol.vm.VM;

import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @classname：AboutClass
 * @author: rolyfish
 * @description: Class类
 * @date: 2022/8/25 01:41
 */
public class AboutClass {

    /**
     * 获取Class对象的方式
     */
    @Test
    public void test() {
        final ClassPerson classPerson = new ClassPerson();
        //对象.getClass
        final Class<? extends ClassPerson> aClass = classPerson.getClass();
        //类名.class
        final Class<ClassPerson> classPersonClass = ClassPerson.class;

        try {
            //Class.forName  第二个参数boolean值表示是否触发初始化
            final Class<?> aClass1 = Class.forName("com.roily.booknode.javatogod._04reflect.source.ClassPerson");
            final Class<?> aClass2 = Class.forName("com.roily.booknode.javatogod._04reflect.source.ClassPerson", true, ClassLoader.getSystemClassLoader());
            System.out.println(VM.current().addressOf(aClass1));
            System.out.println(VM.current().addressOf(aClass2));
        } catch (Exception e) {
        }
        System.out.println(VM.current().addressOf(aClass));
        System.out.println(VM.current().addressOf(classPersonClass));
    }

    /**
     * Class 类Api isInstance
     * <p>
     * isInstance方法，是instanceOf的平替
     */
    @Test
    public void testIsInstance() {
        System.out.println("如果Object参数为该类实例，返回true" + ClassPerson.class.isInstance(new ClassPerson()));
        System.out.println("如果Object参数为该类或其任意子类的实例，返回true" + ClassPerson.class.isInstance(new ClassSon()));
        System.out.println("如果Object参数为该接口实现类，返回true" + InterfaceTest.class.isInstance(new InterfaceTestImpl()));

        //如果是数组类型，可强制转化不报CastException异常
        final Object[] objects = new Object[1024];
        System.out.println(objects.getClass().isInstance(new Integer[11]));

    }


    /**
     * 如果此类的构造器是public的，则可使用class.newInstance()方法创建实例
     * 切会触发类的初始化
     */
    @Test
    public void testNewInstance1() throws InstantiationException, IllegalAccessException {
        final ClassPerson classPerson = ClassPerson.class.newInstance();
        System.out.println(classPerson);
    }

    /**
     * 如果此类的构造器是private的，则不可使用class.newInstance()方法创建实例
     * 会报java.lang.IllegalAccessException异常
     */
    @Test
    public void testNewInstance2() throws InstantiationException, IllegalAccessException {
        final ClassPersonPrivate classPersonPrivate = ClassPersonPrivate.class.newInstance();
        System.out.println(classPersonPrivate);
    }
    @Test
    public void testNewInstance22() throws InstantiationException, IllegalAccessException {
        final ClassPersonPrivate classPersonPrivate = ClassPersonPrivate.class.newInstance();
        System.out.println(classPersonPrivate);
    }

    /**
     * Class的getConstructor方法可以获取，任意类的非私有构造器
     * 可以指构造参数
     */
    @Test
    public void testGetConstructor1() throws Exception {
        final Class<ClassPerson> classPersonClass = ClassPerson.class;
        //无参构造
        final Constructor<ClassPerson> constructorWithOutParams = classPersonClass.getConstructor(null);
        final ClassPerson classPerson1 = constructorWithOutParams.newInstance(null);
        System.out.println(classPerson1);
        //有参构造
        final Constructor<ClassPerson> constructorWithParams = classPersonClass.getConstructor(String.class);
        final ClassPerson classPerson2 = constructorWithParams.newInstance("小可爱");
        System.out.println(classPerson2);
    }

    /**
     * Class的getConstructor方法可以获取，任意类的非私有构造器
     * 可以指构造参数
     */
    @Test
    public void testGetConstructor2() throws Exception {
        final Constructor<ClassPersonPrivate> constructor = ClassPersonPrivate.class.getConstructor(null);
        constructor.newInstance(null);
    }

    /**
     * Class的getDeclaredConstructor方法可以获取，任意类的构造器
     * 可以指构造参数,如果是私有需要设置可访问,否则会爆出IllegalAccessException异常
     */
    @Test
    public void testGetDeclaredConstructor1() throws Exception {
        final Constructor<ClassPerson> declaredConstructor1 = ClassPerson.class.getDeclaredConstructor(null);
        declaredConstructor1.newInstance(null);
        final Constructor<ClassPersonPrivate> declaredConstructor2 = ClassPersonPrivate.class.getDeclaredConstructor(null);
        //设置可访问
        declaredConstructor2.setAccessible(true);
        declaredConstructor2.newInstance(null);
    }

    @Test
    public void testField1() throws Exception {
        //getField获取public 属性
        final Field name = ClassPerson.class.getField("name");
        System.out.println("field name :  => " + name.getName());
        System.out.println("field type :  => " + name.getType());
    }

    @Test
    public void testField2() throws Exception {
        final Field[] fields = ClassPerson.class.getDeclaredFields();
        Arrays.asList(fields).forEach(field -> field.setAccessible(true));
        for (Field field : fields) {
            System.out.println("field name :  => " + field.getName());
            System.out.println("field type :  => " + field.getType());
        }
    }

    @Test
    public void testField3() throws Exception {
        final ClassPerson classPerson = new ClassPerson();
        System.out.println("ClassPerson =>" + classPerson);
        //得到所有
        final Field[] fields = classPerson.getClass().getDeclaredFields();
        Arrays.asList(fields).forEach(field -> {
            field.setAccessible(true);
            Object obj;
            switch (field.getName()) {
                case "name":
                    obj = "name";
                    break;
                case "age":
                    obj = 20;
                    break;
                case "num":
                    obj = 10;
                    break;
                case "values":
                    obj = new String[]{"values"};
                    break;
                default:
                    obj = null;
                    break;
            }
            try {
                field.set(classPerson, obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println(classPerson);
    }

    /**
     * 操作方法
     *
     * @throws Exception
     */
    @Test
    public void testMethod1() throws Exception {
        final ClassPerson classPerson = new ClassPerson();
        System.out.println("ClassPerson =>" + classPerson);
        //获取public方法
        final Method methodWithoutParam = classPerson.getClass().getMethod("publicMethod");
        System.out.println("方法名:=>" + methodWithoutParam.getName());
        methodWithoutParam.invoke(classPerson);
        //获取public方法
        final Method methodWithParam = classPerson.getClass().getMethod("publicWithParamMethod", String.class, int.class);
        System.out.println("方法名:=>" + methodWithParam.getName());
        methodWithParam.invoke(classPerson, "str", 100);
    }

    /**
     * 使用反射获取其他信息
     */
    @Test
    public void testGetOtherInfo() throws FileNotFoundException {
        final String string = new String();
        final Class<TestClass> testClassClass = TestClass.class;
        System.out.println("类名  => " + testClassClass.getSimpleName());
        System.out.println("类全限定名  => " + testClassClass.getName());
        System.out.println("包名  => " + testClassClass.getPackage());
        //获取类加载器，我们写的类，一般都是应用类加载器，也叫app加载器
        System.out.println("类加载器  =>");
        //其他加载器，扩展类加载器ext,引导类加载器我们得不到会返回null
        System.out.println("扩展类加载器 =>" + testClassClass.getClassLoader().getParent());
        System.out.println("扩展类加载器 =>" + testClassClass.getClassLoader().getParent().getParent());
        //注意如果注解的保留策略需设置为@Retention(RetentionPolicy.RUNTIME)
        System.out.println("runtime注解，运行期由VM保留  => " + testClassClass.getAnnotation(AnnotationTest.class));
        for (Class<?> anInterface : testClassClass.getInterfaces()) {
            System.out.println("获取接口  => " + anInterface);
        }
        System.out.println("获取父类  => " + testClassClass.getSuperclass());
        System.out.println("获取类路径下，也就是classes根目录下的某个资源文件输入流   => " + testClassClass.getResourceAsStream("/test.properties"));

    }

}
