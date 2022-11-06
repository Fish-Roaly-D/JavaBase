package com.roily.booknode.pdai.newspecial.repeatannotation;

import java.lang.annotation.Repeatable;

/**
 * @classname：Demo01
 * @author: rolyfish
 * @description: todo
 * @date: 2022/11/6 21:55
 */
public class Demo01 {
}


/**
 * java8之前
 */
@interface Job {
    String value();
}

@interface Jobs {
    Job[] value();
}

class JobC {
    @Jobs(value = {@Job(value = "1"), @Job(value = "2")})
    String job;
}

@Repeatable(Jobs8.class)
@interface Job8 {
    String value();
}

@interface Jobs8 {
    Job8[] value();
}

class JobC8 {
    @Job8(value = "1")
    @Job8(value = "2")
    String job;
}

