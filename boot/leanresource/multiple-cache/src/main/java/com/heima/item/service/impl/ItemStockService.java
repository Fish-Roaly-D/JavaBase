package com.heima.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.item.mapper.ItemStockMapper;
import com.heima.item.pojo.ItemStock;
import com.heima.item.service.IItemStockService;
import org.springframework.stereotype.Service;

@Service
public class ItemStockService extends ServiceImpl<ItemStockMapper, ItemStock> implements IItemStockService {
}
