package com.paulxu.week7.controller;


import com.paulxu.week7.model.OrderEntity;
import com.paulxu.week7.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/add")
    public Long addOrder() throws Exception {
        OrderEntity orderEntity = orderService.addOrder();
        return orderEntity.getId();
    }

    @GetMapping("/info/{id}")
    public OrderEntity getTOrder(@PathVariable("id") String id) throws Exception {
        return orderService.getOrder(id);
    }


}
