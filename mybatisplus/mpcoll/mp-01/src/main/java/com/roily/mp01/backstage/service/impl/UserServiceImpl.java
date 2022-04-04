package com.roily.mp01.backstage.service.impl;

import com.roily.mp01.backstage.entity.UserEntity;
import com.roily.mp01.backstage.mapper.UserMapper;
import com.roily.mp01.backstage.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author roilyFish
 * @since 2022-04-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
