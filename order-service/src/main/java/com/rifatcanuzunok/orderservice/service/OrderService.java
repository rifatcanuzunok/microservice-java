package com.rifatcanuzunok.orderservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rifatcanuzunok.orderservice.dto.OrderRequest;
import com.rifatcanuzunok.orderservice.model.Order;
import com.rifatcanuzunok.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void palceOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        orderRepository.save(order);
    }

}
