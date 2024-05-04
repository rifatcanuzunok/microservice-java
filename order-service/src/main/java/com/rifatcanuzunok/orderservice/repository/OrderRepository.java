package com.rifatcanuzunok.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rifatcanuzunok.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
