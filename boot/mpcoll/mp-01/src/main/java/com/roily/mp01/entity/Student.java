package com.roily.mp01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: rolyfish
 */
@Getter
@Setter
@TableName("student")
@ApiModel(value = "Student对象", description = "")
public class Student extends Model<Student> {

 private static final long serialVersionUID = 1L;

 @ApiModelProperty("主键")
 @TableId(value = "id", type = IdType.AUTO)
 private Integer id;

 @ApiModelProperty("学号")
 @TableField("sno")
 private String sno;

 @ApiModelProperty("姓名")
 @TableField("sname")
 private String sname;


 @Override
 public Serializable pkVal() {
  return this.id;
 }

}