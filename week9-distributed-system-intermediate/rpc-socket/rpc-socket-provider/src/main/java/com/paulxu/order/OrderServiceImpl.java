package com.paulxu.order;

import com.paulxu.order.domain.entity.Order;
import com.paulxu.order.domain.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order getByOrderNo(String orderNo) {
        return new Order(1, orderNo);
    }
}
