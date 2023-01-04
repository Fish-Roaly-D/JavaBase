package com.roily.mp01.util.AboutCodeMake;

import lombok.Data;
import lombok.Getter;

/**
 * @version 1.0.0
 * @Description TODO
 * @ClassName DbProperties.java
 * @author: RoilyFish
 * @date: 2022/4/4 21:46
 */
@Getter
public enum DbProperties {

    URL("url", "jdbc:mysql://localhost:3306/spring_all?useUnicode=true&charactEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8"),
    USER("user", "root"),
    PASSWORD("pass", "123456");

    private String property;
    private String value;

    DbProperties(String prop, String value) {
        this.property = prop;
        this.value = value;
    }
}
