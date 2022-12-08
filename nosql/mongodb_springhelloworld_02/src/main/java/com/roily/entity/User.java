package com.roily.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @Date: 2022/12/08/16:39
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // @Id
    private String idx;

    // @Id
    private String name;

    private int age;

}

