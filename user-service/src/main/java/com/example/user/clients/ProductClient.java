package com.example.user.clients;

import java.util.Map;

import com.example.user.clients.impl.ProductClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PRODUCT-SERVICE",fallback= ProductClientImpl.class)
public interface ProductClient {

	@GetMapping("/product/findByUser")
	String findByUserId(@RequestParam("uid") Long uid);

	@GetMapping("/product/saveProduct")
	void saveProduct(Map<String, Object> productMap) throws RuntimeException;
	
}
