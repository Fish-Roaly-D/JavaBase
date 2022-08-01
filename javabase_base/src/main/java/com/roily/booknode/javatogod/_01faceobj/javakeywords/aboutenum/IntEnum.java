package com.roily.booknode.javatogod._01faceobj.javakeywords.aboutenum;

import lombok.AllArgsConstructor;
import org.junit.Test;

/**
 * @classname：IntEnum
 * @author: rolyfish
 * @description:
 * @date: 2022/8/2 00:19
 */
public class IntEnum {

    @Test
    public void test1() {
        final int spring = Season.SPRING;
        season(spring);
    }

    public void season(int value) {
        switch (value) {
            case 1:
                System.out.println("春天");
                break;
            case 2:
                System.out.println("夏天");
                break;
            case 3:
                System.out.println("秋天");
                break;
            case 4:
                System.out.println("冬天");
                break;
            default:
                System.out.println("输入不合法");
                break;
        }

    }

    public void seasonUseEnum(Season2 season) {
        System.out.println(Season2.SPRING);
        switch (season) {
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
            default:
                System.out.println("输入不合法");
                break;
        }
    }

    @Test
    public void test2() {
        seasonUseEnum(Season2.SPRING);
    }

    public void seasonUseEnum(Season3 season) {
        System.out.println(Season2.SPRING);
        final StringBuilder sb = new StringBuilder();
        switch (season) {
            case SPRING:
            case WINTER:
            case AUTUMN:
            case SUMMER:
                sb.append(season.msg);
                break;
            default:
                System.out.println("输入不合法");
                break;
        }
        System.out.println(sb.toString());
    }

    @Test
    public void test3() {
        seasonUseEnum(Season3.SPRING);
    }

}

/**
 * 枚举类型一般会被系统共享，所以其访问修饰符一般为public
 */
class Season {

    public static final int SPRING = 1;
    public static final int SUMMER = 2;
    public static final int AUTUMN = 3;
    public static final int WINTER = 4;

}


enum Season2 {

    SPRING, SUMMER, AUTUMN, WINTER;

}

@AllArgsConstructor
enum Season3 {

    SPRING(1, "春天"),
    SUMMER(1, "春天"),
    AUTUMN(1, "春天"),
    WINTER(1, "春天");
    int code;
    String msg;

}