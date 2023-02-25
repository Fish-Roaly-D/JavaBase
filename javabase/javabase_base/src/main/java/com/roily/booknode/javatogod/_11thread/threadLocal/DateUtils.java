package com.roily.booknode.javatogod._11thread.threadLocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {

            new Thread(()->{
                final String currentStr = df.get().format(Calendar.getInstance().getTime());
                try {
                    Date parseDate = df.get().parse(currentStr);
                    String dateStrCheck = df.get().format(parseDate);
                    boolean equals = currentStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(equals + " " + currentStr + " " + dateStrCheck);
                    } else {
                        System.out.println(equals);
                    }
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }).start();

        }

    }
}


class DateUtils2 {

    private final  static  SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");

    public static SimpleDateFormat getSp(){
        return sp;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {

            new Thread(()->{
                final String currentStr = DateUtils2.getSp().format(new Date());
                try {
                    Date parseDate = DateUtils2.getSp().parse(currentStr);
                    String dateStrCheck = DateUtils2.getSp().format(parseDate);
                    boolean equals = currentStr.equals(dateStrCheck);
                    if (!equals) {
                        System.out.println(equals + " " + currentStr + " " + dateStrCheck);
                    } else {
                        System.out.println(equals);
                    }
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }).start();

        }

    }
}
