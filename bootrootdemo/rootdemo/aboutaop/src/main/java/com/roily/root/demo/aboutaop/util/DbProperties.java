package com.roily.root.demo.aboutaop.util;

import lombok.Getter;

@Getter
public enum DbProperties {

    URL("url", "jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&charactEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8"),
    USER("user", "root"),
    PASSWORD("pass", "123456");

    private String property;
    private String value;

    DbProperties(String prop, String value) {
        this.property = prop;
        this.value = value;
    }
}
