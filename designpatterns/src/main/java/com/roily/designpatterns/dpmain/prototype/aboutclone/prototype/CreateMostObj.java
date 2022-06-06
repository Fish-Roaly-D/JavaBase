package com.roily.designpatterns.dpmain.prototype.aboutclone.prototype;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0.0
 * @Description 测试创建多个对象消耗时间
 * @ClassName CreateMostObj.java
 * @author: RoilyFish
 * @date: 2022/6/6 11:58
 */
public class CreateMostObj {

    @Test
    public void testWithoutClone() {
        long start = Calendar.getInstance().getTime().getTime();
        System.out.println(start);
        for (int i = 0; i < 100000; i++) {
            Prototype prototype = new Prototype(i, 21, "" + i, new StringBuffer("" + i), Calendar.getInstance().getTime());
        }
        long end = Calendar.getInstance().getTime().getTime();

        System.out.println("消耗时长：" + (end - start));
    }

    @Test
    public void testWithClone() throws CloneNotSupportedException {

        long start = Calendar.getInstance().getTime().getTime();
        Prototype prototype = new Prototype(1, 21, "" + 1, new StringBuffer("" + 1), Calendar.getInstance().getTime());
        for (int i = 0; i < 100000; i++) {
            Prototype clone = prototype.clone();
            clone.setId(i);
            clone.setAge(i);
            //clone.setSb(new StringBuffer("" + i));
            //clone.setCreateTime(Calendar.getInstance().getTime());

        }
        long end = Calendar.getInstance().getTime().getTime();

        System.out.println("消耗时长：" + (end - start));

    }


}
