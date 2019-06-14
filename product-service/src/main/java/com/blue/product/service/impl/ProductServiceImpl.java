package com.blue.product.service.impl;

import java.util.List;
import java.util.Map;

import com.example.common.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blue.product.mapper.ProductMapper;
import com.blue.product.service.ProductService;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    public Product findById(Long id) {
        return productMapper.findById(id);
    }

    public List<Product> findAll() {
        return productMapper.findAll();
    }

//    public void save(Product product) {
//        productMapper.insert(product);
//    }

    public void update(Product product) {
        productMapper.update(product);
    }

    public void delete(Long id) {
        productMapper.delete(id);
    }

    public List<Product> findByUser(Long uid) {
        return productMapper.findByUser(uid);
    }

    @LcnTransaction
	public void save(Map<String, Object> product) throws RuntimeException{
		productMapper.insert(product);
//		int i=3/0;
	}

}
