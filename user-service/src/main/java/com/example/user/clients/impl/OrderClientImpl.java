package com.example.user.clients.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.user.clients.OrderClient;
import org.springframework.stereotype.Component;

import com.blue.user.utils.JsonUtils;

@Component
public class OrderClientImpl implements OrderClient {

	public String findByUserId(Long uid) {
		System.out.println("订单服务findByUserId异常报警，即时通知管理员");
		Map<String,Object> msgMap=new HashMap<>();
		msgMap.put("code", "-1");
		msgMap.put("msg", "订单服务正在维护中，请稍后重试");
		return JsonUtils.Obj2Json(msgMap);
	}

	public void saveOrder(Map<String, Object> orderMap) {
		System.out.println("订单服务saveOrder异常报警，即时通知管理员");
	}

}
