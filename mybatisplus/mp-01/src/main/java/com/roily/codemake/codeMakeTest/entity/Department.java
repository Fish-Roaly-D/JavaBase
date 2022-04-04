package com.roily.codemake.codeMakeTest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2022-04-04
 */
@ApiModel(value = "Department对象", description = "")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("部门id")
    @TableId(value = "deptId", type = IdType.AUTO)
    private Integer deptId;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("逻辑删除字段")
    private Integer delete;

    @ApiModelProperty("插入时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改时间")
    private LocalDateTime modifyTime;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Department{" +
            "deptId=" + deptId +
            ", deptName=" + deptName +
            ", delete=" + delete +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
        "}";
    }
}
