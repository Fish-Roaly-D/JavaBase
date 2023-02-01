package com.roily.root.demo.aboutaop.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.roily.root.demo.aboutaop.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author roilyFish
 * @since 2022-09-05
 */
public interface UserService extends IService<User> {

    Page<User> page();

}
