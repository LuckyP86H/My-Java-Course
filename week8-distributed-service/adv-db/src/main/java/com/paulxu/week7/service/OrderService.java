package com.paulxu.week7.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.paulxu.week7.model.OrderEntity;

public interface OrderService extends IService<OrderEntity> {
    OrderEntity getOrder(String id);

    OrderEntity addOrder();
}
