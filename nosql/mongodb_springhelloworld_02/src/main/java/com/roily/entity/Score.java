package com.roily.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Date: 2022/11/29/11:08
 * @Description:
 */
@Data
@AllArgsConstructor
public class Score {

    String name;

    Integer score;

    Integer sort;
}
