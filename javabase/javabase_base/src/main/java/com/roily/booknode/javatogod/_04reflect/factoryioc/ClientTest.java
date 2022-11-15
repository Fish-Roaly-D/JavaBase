package com.roily.booknode.javatogod._04reflect.factoryioc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @classname：ClientTest
 * @author: rolyfish
 * @description:
 * @date: 2022/8/26 00:21
 */
public class ClientTest {


    static {
        final InputStream in = ClientTest.class.getResourceAsStream("/bean.properties");
        final Properties properties = new Properties();
        try {
            properties.load(in);
            properties.keySet().forEach(ele -> MyCustomizeFactory.getInstanceWithReflect((String) ele, (String) properties.get(ele)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //final Fruit apple = MyCustomizeFactory.getInstance("Apple");
        //System.out.println(apple);
        //final Fruit banana = MyCustomizeFactory.getInstance("Banana");
        //System.out.println(banana);
        //final Fruit apple = MyCustomizeFactory.getInstanceWithReflect("apple","com.com.roily.booknode.javatogod._04reflect.factoryioc.Apple");
        //System.out.println(apple.getClass());
        //final Fruit banana = MyCustomizeFactory.getInstanceWithReflect("banana","com.com.roily.booknode.javatogod._04reflect.factoryioc.Banana");
        //System.out.println(banana.getClass());
        //final Fruit orange = MyCustomizeFactory.getInstanceWithReflect("orange","com.com.roily.booknode.javatogod._04reflect.factoryioc.Orange");
        //System.out.println(orange.getClass());
        final Fruit apple = MyCustomizeFactory.getInstanceWithReflect("Apple");
        System.out.println(apple.getClass());
        final Fruit banana = MyCustomizeFactory.getInstanceWithReflect("Banana");
        System.out.println(banana.getClass());
        final Fruit orange = MyCustomizeFactory.getInstanceWithReflect("Orange");
        System.out.println(orange.getClass());

    }

}
