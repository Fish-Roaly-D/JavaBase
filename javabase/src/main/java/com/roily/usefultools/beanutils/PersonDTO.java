package com.roily.usefultools.beanutils;

import lombok.Data;
import lombok.ToString;

/**
 * @className：PersonDTO
 * @author: rolyfish
 * @description: 业务处理对象，不需要那么多属性
 * @dte: 2022/6/23 23:44
 */
@ToString
@Data
public class PersonDTO {

    String name;

    Integer age;
}
