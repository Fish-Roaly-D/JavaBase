package com.roily.pojo;


import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private long id;
    private String empName;
    private long deptId;
    private long salary;
    private long delete;
    private Date createTime;
    private Date modifyTime;
    private Department2 department;
}
