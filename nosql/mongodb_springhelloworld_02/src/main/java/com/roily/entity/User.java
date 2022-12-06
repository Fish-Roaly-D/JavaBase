package com.roily.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Date: 2022/11/29/11:07
 * @Description:
 */
@Data
@Accessors(chain = true)
public class User {
    String name;
    Integer age;
    List<Score> scoreList;

}
