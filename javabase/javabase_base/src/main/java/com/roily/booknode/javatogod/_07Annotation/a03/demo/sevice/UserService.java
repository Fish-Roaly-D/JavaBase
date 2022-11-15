package com.roily.booknode.javatogod._07Annotation.a03.demo.sevice;

import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyService;
import com.roily.booknode.javatogod._07Annotation.a03.annotation.RolyValue;

/**
 * @Date: 2022/08/31/15:01
 * @Description:
 */
@RolyService
public class UserService {
    @RolyValue("@RolyValue给的值")
    String name;

    String other;
}
