package com.roily.mp01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.roily.mp01.entity.Address;
import com.roily.mp01.mapper.AddressMapper;
import com.roily.mp01.service.AddressService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author roilyFish
 * @since 2023-02-02
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
