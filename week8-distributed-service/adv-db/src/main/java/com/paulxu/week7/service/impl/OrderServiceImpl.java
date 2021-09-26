package com.paulxu.week7.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.paulxu.week7.mapper.OrderMapper;
import com.paulxu.week7.model.OrderEntity;
import com.paulxu.week7.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {
    @Resource
    private OrderMapper orderMapper;


    @Override
    public OrderEntity getOrder(String id) {
        return orderMapper.selectById(Long.parseLong(id));
    }

    @Override
    public OrderEntity addOrder() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(1L);
        orderEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
        orderMapper.insert(orderEntity);
        return orderEntity;
    }
}
