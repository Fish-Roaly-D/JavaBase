package com.roily.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Department {

    @TableField("`deptId`")
    private long deptId;
    @TableField("`deptName`")
    private String deptName;
    //mp 中处理 sql语句中存在mysql关键词
    @TableLogic
    @TableField("`delete`")
    private long delete;
    private Date createTime;
    private Date modifyTime;

}
