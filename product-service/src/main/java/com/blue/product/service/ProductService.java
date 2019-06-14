package com.blue.product.service;

import com.example.common.domain.Product;

import java.util.List;
import java.util.Map;


public interface ProductService {

    Product findById(Long id);

    List<Product> findAll();

//    void save(Product product);

    void update(Product product);

    void delete(Long id);

    List<Product> findByUser(Long uid);

	void save(Map<String, Object> product)throws RuntimeException;
}
