package com.roily.pojo;


import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department2 {

  private long deptId;
  private String deptName;
  private long delete;
  private Date createTime;
  private Date modifyTime;
  private List<Employee> employeeList;

}
