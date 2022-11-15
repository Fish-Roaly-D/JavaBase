package com.roily.mapper;

import com.roily.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Date: 2022/09/26/14:18
 * @Description:
 */
@Mapper
public interface UserMapper {

    List<User> getAll();

}
