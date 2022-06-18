package com.roily.designpatterns.dpmain.chainofresponsibility.demo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @className：Person
 * @author: rolyfish
 * @description: 投保人
 * @dte: 2022/6/18 00:26
 */
@Data
@Accessors(chain = true)
public class Person {
    private String name;
    private String idNo;
    private Integer age;
    private Integer smokeYear;
    private Boolean isDanger;
    private Integer jobLv;
}
