package com.roly.redisresolve.dto;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: rolyfish
 */
@ApiModel(description = "用户")
@Data
@Accessors(chain = true)
@Builder
public class UserDto {
    private String name;
    private Integer id;
    private String phone;
}
