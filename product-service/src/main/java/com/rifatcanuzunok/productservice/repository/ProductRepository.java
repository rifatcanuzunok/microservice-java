package com.rifatcanuzunok.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rifatcanuzunok.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
