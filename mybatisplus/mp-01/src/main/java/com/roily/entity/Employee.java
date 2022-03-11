package com.roily.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private long id;
    @TableField("empName")
    private String empName;
    private long deptId;
    private long salary;
    @TableLogic
    @TableField("`delete`")
    private long delete;
    private Date createTime;
    private Date modifyTime;

}
