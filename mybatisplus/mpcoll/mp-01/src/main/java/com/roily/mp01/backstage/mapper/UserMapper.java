package com.roily.mp01.backstage.mapper;

import com.roily.mp01.backstage.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author roilyFish
 * @since 2022-04-05
 */
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

}
