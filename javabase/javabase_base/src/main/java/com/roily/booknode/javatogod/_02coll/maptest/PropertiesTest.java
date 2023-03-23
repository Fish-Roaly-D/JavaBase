package com.roily.booknode.javatogod._02coll.maptest;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @Date: 2023/03/21/11:34
 * @Description:
 */
public class PropertiesTest {


    /**
     * - 作为普通map使用
     * - 作为properties使用
     */
    @Test
    public void test1() {

        final Properties properties = new Properties();
        properties.setProperty("name", "于延闯");
        properties.put(1, "age");

        System.out.println(properties.get(1));
        System.out.println(properties.getProperty("name"));
    }

    @Test
    public void loadFromXmlOrProperties() throws IOException {

        // loadFromProperties
        final Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("test.properties"));
        System.out.println(properties);


        final Properties propertiesxml = new Properties();
        propertiesxml.loadFromXML(this.getClass().getClassLoader().getResourceAsStream("testxml.xml"));
        System.out.println(propertiesxml);


    }
    @Test
    public void storeToXmlOrProperties() throws IOException {

        // loadFromProperties
        final Properties properties = new Properties();
        properties.load(this.getClass().getClassLoader().getResourceAsStream("test.properties"));
        System.out.println(properties);

        properties.storeToXML(new FileOutputStream("D:\\demo.xml"),"测试", StandardCharsets.UTF_8);

    }


}
