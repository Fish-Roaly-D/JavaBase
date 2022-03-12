package com.roily.entity;


import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {

  private long deptId;
  private String deptName;
  private long delete;
  private Date createTime;
  private Date modifyTime;

}
