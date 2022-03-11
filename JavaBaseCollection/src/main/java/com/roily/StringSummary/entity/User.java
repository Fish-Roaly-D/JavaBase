package com.roily.StringSummary.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * descripte: final 测试所用 实体类
 *
 * @author: RoilyFish
 * @date: 2022/3/11
 */
@Data
@Builder
public class User {

    private String userName;

    private Integer age;

    private Date birthDay;

}
