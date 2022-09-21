package com.roily.booknode.javatogod._07Annotation.a03.demo;

import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyComponent;
import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyValue;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

/**
 * @Date: 2022/08/31/17:14
 * @Description: bean工厂
 */
public class BeanFactory {
    //扫描启动类所在包下所有类，将类的全限定名称保存在此list中
    public static List<String> classPaths = new ArrayList<>();

    //bean工厂
    private static Map<String, Object> beanFactory = new HashMap<>();

    static {
        try {
            init();
            initBean();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void init() throws FileNotFoundException {
        //获取类路径，到****/classes/
        final String classPath = ResourceUtils.getURL("classpath:").getPath();
        //获取package名com.xx.xx.xx
        final String packageName = DemoApplication.class.getPackage().getName();
        //replace正则匹配进行替换，. --> \\.   File.separator 在win下为\会被当成转译字符
        final String packageNameNew =
                packageName.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
        //当前类所在包路径
        String rootPath = String.join("", classPath, packageNameNew);
        final File rootFile = new File(rootPath);
        dir(Collections.singletonList(rootFile));
        System.err.println("========待加载的类:========");
        for (String path : classPaths) {
            System.out.println(path);
        }
        System.err.println("=========================");
    }

    /**
     * 扫描某路径下的所有文件
     */
    public static void dir(List<File> dirList) {
        //遍历当前类，将文件分组，文件夹一组、非文件夹一组。非文件夹记录进集合，文件夹继续操作
        final HashMap<Boolean, List<File>> fileMap =
                dirList.stream().collect(Collectors.groupingBy(File::isDirectory, HashMap::new, Collectors.toList()));
        //文件
        final List<File> fileList = fileMap.get(false);
        final List<File> dir2List = fileMap.get(true);

        files(Optional.ofNullable(fileList).orElse(Collections.emptyList()));

        if (!CollectionUtils.isEmpty(dir2List)) {
            //文件夹
            for (File file : dir2List) {
                dir(Arrays.asList(Optional.ofNullable(file.listFiles()).orElse(new File[0])));
            }
        }

    }

    public static void files(List<File> fileList) {
        final List<String> fileNameList = fileList.stream().map(file -> {
            //得到 com/xx/xx
            final String str1 = file.getPath().split("classes" + Matcher.quoteReplacement(File.separator))[1];
            final String str2 = str1.replaceAll(Matcher.quoteReplacement(File.separator), ".");
            final String str3 = str2.substring(0, str2.lastIndexOf("."));
            return str3;
        }).collect(Collectors.toList());
        classPaths.addAll(fileNameList);
    }

    public static void initBean() {
        System.out.println("+++++++++++++创建类放入bean容器中++++++++++++");
        for (String classPath : classPaths) {
            createBeanByName(classPath);
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    }

    private static void createBeanByName(String classPath) {
        Class<?> beanClass;
        try {
            //默认触发初始化
            beanClass = Class.forName(classPath);
            //判断是否需要创建
            if (!shouldInit(beanClass)) {
                return;
            }
            final Object bean = beanClass.newInstance();
            //注入属性
            initProperty(bean);
            beanFactory.put(beanClass.getSimpleName(), bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initProperty(Object bean) throws IllegalAccessException {
        //获取所有的Field
        final List<Field> fields = Arrays.asList(bean.getClass().getDeclaredFields());

        for (Field field : fields) {
            //设置允许访问
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            //获取RolyValue注解的属性
            final RolyValue declaredAnnotation = field.getDeclaredAnnotation(RolyValue.class);
            if (null != declaredAnnotation) {
                field.set(bean, declaredAnnotation.value());
            }

        }
    }

    /**
     * 判断beanClass是否需要 自动注入 也就是是否包含@RolyComponent注解
     *
     * @param beanClass
     * @return
     */
    public static boolean shouldInit(Class beanClass) {

        final List<Annotation> annotations = Arrays.asList(beanClass.getDeclaredAnnotations());
        if (annotations.isEmpty()) {
            return false;
        } else {
            final List<? extends Class<? extends Annotation>> annotationTypes = annotations.stream().map(Annotation::annotationType).collect(Collectors.toList());
            if (annotationTypes.contains(RolyComponent.class)) {
                return true;
            }
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == RolyComponent.class) {
                    return true;
                }
                return shouldInit(annotation.annotationType());
            }
        }
        return false;
    }

    public static Map<String, Object> objList() {

        return beanFactory;
    }

    public static Object getObjByName(String name) {

        return beanFactory.get(name);
    }


}
