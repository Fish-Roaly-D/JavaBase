---
--- Generated by Luanalysis
--- Created by rolyfish.
--- DateTime: 2023/3/12 15:02
---

-- 用户ID
local userId = ARGV[1]
-- 优惠券id
local voucherId = ARGV[2]
-- 订单key
local orderKey = ARGV[3]
-- stream队列key
local streamQueueKey = ARGV[4]

-- 库存 key
local stockKey = "seckill:stock:" .. voucherId
-- 优惠券 key
local voucherKey = "seckill:order:" .. voucherId


-- 1.1 判断库存是否充足
if (redis.call("exists", stockKey) == 0 or tonumber(redis.call("get", stockKey)) <= 0) then
    -- 不充足返回1
    return 1
end
-- 订单充足 判断一人一单
if (redis.call("sismember", voucherKey, userId) == 1) then
    -- 已经下过单了 返回2
    return 2
end
-- 定单充足，且没有下过单 返回0
-- 3.1 库存减一
-- 3.2 加入订单set
redis.call("incrby", stockKey, -1)
redis.call("sadd", voucherKey, userId)
-- 3.3 订单信息加入消息队列
--   XADD key [NOMKSTREAM] [MAXLEN|MINID [=|~] threshold [LIMIT count]] *|ID field value [field value ...]
redis.call("xadd", streamQueueKey, "*", "userId", userId, "voucherId", voucherId, "id", orderKey)
return 0