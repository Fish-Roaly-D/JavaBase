package com.roily.demo.multidatasource.multidatasource.entity;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Date: 2022/11/23/13:10
 * @Description:
 */
@Data
@TableName(schema = "springall", value = "student")
@KeySequence(dbType = DbType.POSTGRE_SQL, value = "seq_student")
public class Student {
    @TableId(type = IdType.AUTO)
    Integer id;
    String sno;
    String sname;
}
