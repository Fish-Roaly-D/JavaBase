package com.roily.booknode.javatogod._08date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Date: 2022/09/01/18:01
 * @Description:
 */
public class TestDFIsNotSyn {
    /**
     * 定义一个全局的SimpleDateFormat
     */
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    final static Set<Calendar> calendars = Collections.synchronizedSet(new HashSet<>());

    final static Set<String> dates = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            new Thread(() -> {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, finalI);
                calendars.add(calendar);
                final String format = simpleDateFormat.format(calendar.getTime());
                dates.add(format);
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(calendars.size());
        System.out.println(dates.size());
    }
}
