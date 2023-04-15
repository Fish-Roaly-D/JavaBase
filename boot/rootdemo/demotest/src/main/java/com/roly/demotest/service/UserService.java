package com.roly.demotest.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.roily.root.demo.aboutaop.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author roilyFish
 * @since 2022-09-05
 */
public interface UserService extends IService<User> {

    Page<User> page(int current);

}
