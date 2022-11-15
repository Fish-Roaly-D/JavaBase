package com.roily.base.collectionframework.base.map.properties;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @version 1.0.0
 * @Description  properties也是一个kv的数据结构，是hashTable的子类
 * @ClassName PropertiesTest.java
 * @author: RoilyFish
 * @date: 2022/5/20 23:40
 */
public class PropertiesTest {

    /**
     * properties作为map使用
     */
    @Test
    public void propertiesUseAsMap() {

        Properties prop = new Properties();
        prop.put(1, "a");
        prop.put(2, 2);
        prop.put("3", new Object());
        System.out.println(prop.get(1));
        System.out.println(prop.get(2));
        System.out.println(prop.get("3"));

    }

    /**
     * properties  扩展的方法
     * setProperties  getProperties
     * key  value只能是String
     *
     * @throws IOException
     */
    @Test
    public void useAsProp() {
        Properties prop = new Properties();
        prop.setProperty("name","name");
        prop.setProperty("age","23");
        prop.setProperty("email","123@qq.com");
        System.out.println(prop);
        prop.forEach((key, value) -> {
            System.out.println("{key" + key + "," + "value" + value + "}");
        });
    }


    /**
     * 有一些类自带properties
     */
    @Test
    public void sysProperty() {
        Properties properties = System.getProperties();
        System.out.println(properties);
    }


    /**
     * 也可以自己写一个配置类
     */
    @Test
    public void testMyCP() {
        Properties prop = MyPropClass.getProperties();

        System.out.println(prop);
        prop.forEach((key, value) -> {
            System.out.println("{key" + key + "," + "value" + value + "}");
        });

    }

    /**
     * 为了防止一些硬编码，可以配合properties配置文件使用
     * @throws IOException
     */
    @Test
    public void readProp() throws IOException {

        InputStream in = PropertiesTest.class.getClassLoader().getResourceAsStream("user.properties");
        Properties prop = new Properties();
        prop.load(in);
        String name = prop.getProperty("name");
        String age = prop.getProperty("age");
        String hobby = prop.getProperty("hobby");
        System.out.println("{name:" + name + "," + "age:" + age + "," + "hobby" + hobby + "}");

    }

    /**
     * 也可以输出为properties  或  xml
     * @throws IOException
     */
    @Test
    public void writeProp() throws IOException {

        //创建配置
        Properties prop = new Properties();
        prop.setProperty("name","name");
        prop.setProperty("age","23");
        prop.setProperty("email","123@qq.com");
        System.out.println(prop);
        prop.forEach((key, value) -> {
            System.out.println("{key" + key + "," + "value" + value + "}");
        });
        //创建  outputStream
        FileWriter fileWriter = new FileWriter(new File("D:\\user.properties"));
        //写入文件
        prop.store(fileWriter,"user信息");

    }
}

class MyPropClass {

    private static Properties props;

    private static final String name;
    private static final String age;
    private static final String email;

    static {
        props = new Properties();
        name = "yyc";
        age = "23";
        email = "123@qq.com";
        initProperties();
    }

    private static void initProperties() {
        props.setProperty("name", name);
        props.setProperty("age", age);
        props.setProperty("email", email);
    }


    public void setProperties(String key, String value) {
        props.setProperty(key, value);
    }

    public String getProperties(String key) {
        return props.getProperty(key);
    }

    public void setProperties(Properties properties) {

        MyPropClass.props = properties;
    }

    public static Properties getProperties() {
        return props;
    }
}