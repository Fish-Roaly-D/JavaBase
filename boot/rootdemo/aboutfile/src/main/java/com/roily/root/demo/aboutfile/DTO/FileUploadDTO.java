package com.roily.root.demo.aboutfile.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0
 * @Description 文件上传dto
 * @ClassName FileUploadDTO.java
 * @author: RoilyFish
 * @date: 2022/5/28 1:00
 */
@ApiModel(value = "FileUploadDTO", description = "文件上传dto")
@Data
@Accessors(chain = true)
public class FileUploadDTO {

    @ApiModelProperty("文件路径")
    String filePath;

    @ApiModelProperty("文件名")
    String fileName;

}
