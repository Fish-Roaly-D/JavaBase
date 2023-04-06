package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.entity.SeckillVoucherAdd;
import com.hmdp.mapper.SeckillVoucherAddMapper;
import com.hmdp.service.ISeckillVoucherAddService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 秒杀优惠券表，与优惠券是一对一关系 服务实现类
 * </p>
 *
 * @author rolyfish

 */
@Service
public class SeckillVoucherServiceAddImpl extends ServiceImpl<SeckillVoucherAddMapper, SeckillVoucherAdd> implements ISeckillVoucherAddService {

}