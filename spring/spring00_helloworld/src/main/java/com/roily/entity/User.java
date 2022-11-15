package com.roily.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

/**
 * @Date: 2022/09/22/19:07
 * @Description:
 */
@Setter
@Data
@AllArgsConstructor
public class User {

    String name;
    String email;

}
