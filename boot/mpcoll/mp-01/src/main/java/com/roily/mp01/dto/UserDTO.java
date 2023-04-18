package com.roily.mp01.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author: rolyfish
 */
@Data
public class UserDTO {

    private Integer id;


    private String name;

    private String email;

    private Integer isDelete;

    private Integer version;

    private Date createTime;

    private Date updateTime;

    private Integer userId;

    private String city;

    private String address;

}
