package com.hmdp.dto;

import lombok.Data;

/**
 * 登录表单对象
 * @author rolyfish
 */
@Data
public class LoginFormDTO {
    private String phone;
    private String code;
    private String password;
}
