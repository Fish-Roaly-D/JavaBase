package com.roily.booknode.javatogod._08date;

import org.junit.Test;
import sun.security.action.GetPropertyAction;

import javax.xml.crypto.Data;
import java.security.AccessController;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Date: 2022/09/01/10:53
 * @Description:
 */
public class TestDate01 {

    /**
     * 时间戳
     */
    @Test
    public void test01() {
        xxx
        final Date time = Calendar.getInstance().getTime();
        final long timeStamp = time.getTime();
        System.out.println("当前时间：=>" + time);
        System.out.println("当前时间戳：=>" + timeStamp);
        final Date date = new Date(timeStamp + 1000);
        System.out.println("使用时间戳创建日期：=>" + date);
    }

    /**
     * simpleDateFormat
     */
    @Test
    public void testSimpleDateFormat() {
        final Date time = Calendar.getInstance().getTime();
        System.out.println("date的toString：===>" + time);

        System.out.println("模式字符串:==>>  yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));

        //从后往前截取  2022 ==>> 22
        System.out.println("模式字符串:==>>  yy-M-dd HH:mm:ss");
        simpleDateFormat = new SimpleDateFormat("yy-M-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));

        //w代表周  大写代表月中的周 小写代表年中的周
        System.out.println("模式字符串:==>>  yyyy-MM-dd WW周/月 ww周/年 HH:mm:ss");
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd WW周/月 ww周/年 HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));

        //d代表天  大写代表年中的天 小写代表月中的天
        System.out.println("模式字符串:==>>   yyyy-MM-dd DD天/年 dd天/月 HH:mm:ss");
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd DD天/年 dd天/月 HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));

        //F代表月份中的星期（不好用） 一般用EE代表周几
        System.out.println("模式字符串:==>>  yyyy-MM-dd FF/月 EE/周 HH:mm:ss");
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd FF/月 EE/周 HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));

        //a上下午标志 am pm
        System.out.println("模式字符串:==>>  yyyy-MM-dd aa HH:mm:ss");
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd aa HH:mm:ss");
        System.out.println(simpleDateFormat.format(time));

        //小时数 HH 24小时制 hh 12小时制
        System.out.println("模式字符串:==>>  yyyy-MM-dd HH:mm:ss aa hh:mm:ss");
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa hh:mm:ss");
        System.out.println(simpleDateFormat.format(time));

        //ss秒数  SS毫秒数
        System.out.println("模式字符串:==>>  yyyy-MM-dd HH:mm:ss aa hh:mm:ss");
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SS毫秒");
        System.out.println(simpleDateFormat.format(time));

        //时区信息
        System.out.println("模式字符串:==>>  yyyy-MM-dd zzzz ZZZZ");
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd zzzz ZZZZ");
        System.out.println(simpleDateFormat.format(time));
    }

    @Test
    public void testTimeZone() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss 时区:zzzz");
        System.out.println("系统时区:===>>" + simpleDateFormat.format(Calendar.getInstance().getTime()));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println("America/New_York:===>>" + simpleDateFormat.format(Calendar.getInstance().getTime()));
    }

}
