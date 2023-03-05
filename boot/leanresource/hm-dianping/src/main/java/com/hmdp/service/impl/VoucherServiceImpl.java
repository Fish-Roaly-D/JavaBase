package com.hmdp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.entity.Voucher;
import com.hmdp.mapper.VoucherMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.hmdp.utils.RedisConstants.SECKILL_STOCK_KEY;

/**
 * <p>
 *  服务实现类
 * </p>
 *

 */
@Service
public class VoucherServiceImpl extends ServiceImpl<VoucherMapper, Voucher> implements IVoucherService {

    @Resource
    private ISeckillVoucherService seckillVoucherService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result queryVoucherOfShop(Long shopId) {
        // 查询优惠券信息
        List<Voucher> vouchers = getBaseMapper().queryVoucherOfShop(shopId);
        // 返回结果
        return Result.ok(vouchers);
    }

    @Override
    @Transactional
    public void addSeckillVoucher(Voucher voucher) {
        // 保存优惠券
        save(voucher);
        // 保存秒杀信息
        final SeckillVoucher seckillVoucher = SeckillVoucher.builder()
                .voucherId(voucher.getId())
                .stock(voucher.getStock())
                .beginTime(voucher.getBeginTime())
                .endTime(voucher.getEndTime()).build();
        seckillVoucherService.save(seckillVoucher);
        // 保存秒杀库存到Redis中
        stringRedisTemplate.opsForValue().set(SECKILL_STOCK_KEY + voucher.getId(), voucher.getStock().toString());
    }

    @Override
    @Transactional
    public void saveVoucher(Voucher voucher) {
        this.save(voucher);
        // 秒杀券 添加到 skill_voucher表中
        if (Integer.valueOf(1).equals(voucher.getType())) {
            final SeckillVoucher seckillVoucher = SeckillVoucher.builder()
                    .voucherId(voucher.getId())
                    .stock(voucher.getStock())
                    .createTime(voucher.getCreateTime())
                    .beginTime(voucher.getBeginTime())
                    .endTime(voucher.getEndTime())
                    .updateTime(voucher.getUpdateTime()).build();
            seckillVoucherService.save(seckillVoucher);
            // 秒杀券 库存存入 redis
            stringRedisTemplate.opsForValue().set(SECKILL_STOCK_KEY,(seckillVoucher.getStock()+"").intern());
        }
    }
}
