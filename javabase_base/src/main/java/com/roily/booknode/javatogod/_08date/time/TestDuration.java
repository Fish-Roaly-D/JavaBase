package com.roily.booknode.javatogod._08date.time;

import org.junit.Test;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * @Date: 2022/09/02/17:29
 * @Description:
 */
public class TestDuration {

    /**
     * 可以得到某段时间间隔
     */
    @Test
    public void test1() {

        final Duration durationDay = Duration.ofDays(1);
        System.out.println("间隔一天，多少秒：" + durationDay.get(durationDay.getUnits().get(0)));
        System.out.println(24 * 60 * 60);

        final Duration durationMin = Duration.ofMinutes(5);
        System.out.println("间隔5分钟，多少秒：" + durationMin.get(durationMin.getUnits().get(0)));
        System.out.println(5 * 60);

        final Duration plus = durationMin.plus(1, durationDay.getUnits().get(0));
        System.out.println("加一秒，多少秒：" + plus.get(plus.getUnits().get(0)));

        final Duration minus = durationDay.minus(Duration.ofMinutes(10).getSeconds(), durationDay.getUnits().get(0));
        System.out.println("减10分钟" + minus.getSeconds());
    }

    @Test
    public void test2() {

        System.out.println("当下日期:=>" + LocalDate.now());
        System.out.println("自定义日期:=>" + LocalDate.of(1999, Month.FEBRUARY, 1));
        System.out.println("withXXX修改日期:=>" + LocalDate.of(1999, Month.FEBRUARY, 1).withMonth(12));
    }

    @Test
    public void test3() {

        System.out.println("当下时间:=>" + LocalTime.now());
        System.out.println("自定义时间:=>" + LocalTime.of(12, 0, 1, 1));
        System.out.println("withXXX修改时间:=>" + LocalTime.of(12, 0, 1, 1).withHour(13));
    }

    @Test
    public void test4() {

        final Period period = Period.of(1, 05, 20);
        System.out.println("创建时期:=>" + period);

        final Period between = Period.between(LocalDate.of(1999, 5, 20), LocalDate.of(2022, 9, 2));
        System.out.println("间隔日期,用于计算年龄:=>" + between);

        final Period period1 = period.withDays(10);
        System.out.println("withday修改day: =>" + period1);

        final Period period2 = period.plusDays(1);
        System.out.println("plus加一天、minu减一天: =>" + period2);
    }

    @Test
    public void test5() {


        System.out.println("默认时区偏移量：+》" + ZoneOffset.systemDefault());


        System.out.println("带时区的时间：=》" + ZonedDateTime.now());


        System.out.println("默认时钟:+>" + Clock.systemDefaultZone());
        final Clock America = Clock.system(ZoneId.of("America/Los_Angeles"));
        System.out.println("美国时钟:+>" + America);
        final LocalDateTime now = LocalDateTime.now(America);
        System.out.println("美国时间:+>" + now);

    }


}
