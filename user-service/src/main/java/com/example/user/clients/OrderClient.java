package com.example.user.clients;

import java.util.Map;

import com.example.user.clients.impl.OrderClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ORDER-SERVICE",fallback= OrderClientImpl.class)
public interface OrderClient {
	
	@GetMapping("/order/findByUser")
	String findByUserId(@RequestParam("uid")Long uid);

	@PostMapping("/order/saveOrder")
	void saveOrder(Map<String, Object> orderMap);
	
}
