package com.roily.mp01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roily.mp01.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author roilyFish
 * @since 2023-02-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selOneXml();

}
