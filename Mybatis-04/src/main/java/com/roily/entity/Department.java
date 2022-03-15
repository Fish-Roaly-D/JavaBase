package com.roily.entity;


import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {

  private long deptId;
  private String deptName;
  private long delete;
  private Date createTime;
  private Date modifyTime;

}
