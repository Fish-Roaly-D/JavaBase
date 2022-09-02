package com.roily.booknode.javatogod._08date.time;

import org.apache.commons.lang3.time.DurationUtils;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

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

        System.out.println("当下日期:=>"+LocalDate.now());
        System.out.println("自定义日期:=>"+LocalDate.of(1999, Month.FEBRUARY,1));
        System.out.println("withXXX修改日期:=>"+LocalDate.of(1999, Month.FEBRUARY,1).withMonth(12));
    }
    @Test
    public void test3() {

        System.out.println("当下时间:=>"+ LocalTime.now());
        System.out.println("自定义时间:=>"+LocalTime.of(12, 0,1,1));
        System.out.println("withXXX修改时间:=>"+LocalTime.of(12, 0,1,1).withHour(13));
    }
    @Test
    public void test4() {

        System.out.println("当下时间:=>"+ LocalDateTime.now().toString().replaceAll("T"," "));
        System.out.println("自定义时间:=>"+LocalTime.of(12, 0,1,1));
        System.out.println("withXXX修改时间:=>"+LocalTime.of(12, 0,1,1).withHour(13));
    }

}
