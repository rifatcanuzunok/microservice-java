package com.rifatcanuzunok.orderservice.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rifatcanuzunok.orderservice.client.InventoryClient;
import com.rifatcanuzunok.orderservice.dto.OrderRequest;
import com.rifatcanuzunok.orderservice.model.Order;
import com.rifatcanuzunok.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final InventoryClient inventoryClient;
    private final OrderRepository orderRepository;

    public void palceOrder(OrderRequest orderRequest) {
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (!isProductInStock)
            throw new RuntimeException("Product with skuCode " + orderRequest.skuCode() + " is not in stock");

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());

        orderRepository.save(order);
    }

}
