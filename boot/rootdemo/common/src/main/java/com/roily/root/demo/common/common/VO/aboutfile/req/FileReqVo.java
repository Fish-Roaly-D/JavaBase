package com.roily.root.demo.common.common.VO.aboutfile.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @version 1.0.0
 * @Description 文件请求VO
 * @ClassName FileRespVo.java
 * @author: RoilyFish
 * @date: 2022/5/28 0:37
 */
@ApiModel(value = "FileReqVo", description = "文件请求VO")
@Data
@Accessors(chain = true)
public class FileReqVo {

    @ApiModelProperty("文件路径")
    @NotBlank(message = "filePath不能为空")
    String filePath;

    @ApiModelProperty("文件名")
    @NotBlank(message = "fileName不能为空")
    String fileName;

}
