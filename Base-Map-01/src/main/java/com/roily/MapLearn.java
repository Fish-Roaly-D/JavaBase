package com.roily;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/2/22
 */
public class MapLearn {


    //for循环break
    @Test
    public void forTest() {
        for (String str = "123", parm; str != null; str = parm) {
            str = "123";
            parm = "123";
            System.out.println(parm += "4");
            System.out.println(parm += "5");
            if (parm.equals("12345")) {
                break;
            }
        }
    }

    //tableSizeFor
    @Test
    public void tableSizeForTest() {
        int i = tableSizeForTest(33);
        System.out.println(i);
    }

    //HashMap的tableSizefor方法理解
    public static int tableSizeForTest(int n) {
        //对自然数e求对数。结合换底公式
        double m = Math.log(n) / Math.log(2);
        //没有小数返回，有小数向上进一
        int m2 = (int) Math.ceil(m);
        //2的m2幂次方
        return (int) Math.pow(2, m2);
    }

    @Test
    public void hashMapTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HashMap<String, String> map = new HashMap<String, String>(10);
        Class<? extends HashMap> aClass = map.getClass();
        Method putVal = aClass.getDeclaredMethod("putVal", int.class, Object.class, Object.class, boolean.class, boolean.class);
        System.out.println(putVal.getName());
    }

    @Test
    public void putValTest() {

        Roilyfish roilyfish = new Roilyfish();
        System.out.println(roilyfish.getValue("123"));

    }

    @Test
    public void putValTest2() {

        Roilyfish2<Integer> integerRoilyfish2 = new Roilyfish2<Integer>();
        System.out.println(integerRoilyfish2.getValue(12345));

    }
}

class Roilyfish {


    final String getValue(String str) {
        return str;
    }

}

class Roilyfish2<T> {

    final T getValue(T t) {
        return t;
    }

}