package com.roly.cloud.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: rolyfish
 */
@Data
@Accessors(chain = true)
@Builder
public class User implements Serializable {
    Long id;
    String name;
    String phone;
    String password;
    String nickName;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
