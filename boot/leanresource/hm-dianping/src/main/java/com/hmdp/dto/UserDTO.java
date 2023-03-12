package com.hmdp.dto;

import lombok.Data;

/**
 * 简单用户对象，影藏用户敏感信息
 * @author rolyfish
 */
@Data
public class UserDTO {
    private Long id;
    private String nickName;
    private String icon;
    private String phone;
}
