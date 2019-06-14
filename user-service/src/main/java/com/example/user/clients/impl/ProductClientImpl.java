package com.example.user.clients.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.user.clients.ProductClient;
import org.springframework.stereotype.Component;

import com.blue.user.utils.JsonUtils;

@Component
public class ProductClientImpl implements ProductClient {

	public String findByUserId(Long uid) {
		System.out.println("商品服务findByUserId异常报警，即时通知管理员");
		Map<String,Object> msgMap=new HashMap<>();
		msgMap.put("code", "-1");
		msgMap.put("msg", "商品服务正在维护中，请稍后重试");
		return JsonUtils.Obj2Json(msgMap);
	}

	public void saveProduct(Map<String, Object> productMap) {
		System.out.println("商品服务saveProduct异常报警，即时通知管理员");
	}

}
