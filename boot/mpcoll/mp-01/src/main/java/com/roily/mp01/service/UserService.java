package com.roily.mp01.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.roily.mp01.entity.User;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author roilyFish
 * @since 2023-02-02
 */
public interface UserService extends IService<User> {
    User selOneXml();
}
