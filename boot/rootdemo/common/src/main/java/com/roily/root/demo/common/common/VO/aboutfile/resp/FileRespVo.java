package com.roily.root.demo.common.common.VO.aboutfile.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @version 1.0.0
 * @Description 文件返回VO（View Object 视图展示对象）
 * @ClassName FileRespVo.java
 * @author: RoilyFish
 * @date: 2022/5/28 0:37
 */
@ApiModel(value = "FileRespVo", description = "文件信息回显VO")
@Data
@Accessors(chain = true)
public class FileRespVo {

    @ApiModelProperty("文件路径")
    String filePath;

    @ApiModelProperty("文件名")
    String fileName;

    @ApiModelProperty("文件存储名")
    String fileStorageName;

    @ApiModelProperty("文件类型")
    String fileType;

    @ApiModelProperty("文件大小")
    String size;
}
