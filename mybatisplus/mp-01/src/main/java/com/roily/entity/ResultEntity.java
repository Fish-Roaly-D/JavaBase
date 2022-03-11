package com.roily.entity;

import lombok.Builder;
import lombok.Data;

/**
 * descripte:
 *
 * @author: RoilyFish
 * @date: 2022/3/10
 */
@Builder
@Data
public class ResultEntity {

    private Integer empId;
    private String empName;
    private String department;

}
