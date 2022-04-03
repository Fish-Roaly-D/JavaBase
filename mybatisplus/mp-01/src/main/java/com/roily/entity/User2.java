package com.roily.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.roily.enums.IsDeleted;
import com.roily.typeHandler.MyStringHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "user")
public class User2 {

    @TableId(value = "id", type = IdType.AUTO)
    @OrderBy(asc = true)
    private Long id;
    //@TableField(whereStrategy = FieldStrategy.NOT_EMPTY)
    private String name;
    private String email;
    @TableLogic(value = "0",delval = "1")
    private IsDeleted deleted;
    @Version
    private long version;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(exist = false)
    private String test;

    @TableField("tb_user_test_colum")
    private String  tb_user_test_colum;
}
