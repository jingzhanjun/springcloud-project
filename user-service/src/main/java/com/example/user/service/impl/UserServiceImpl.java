package com.example.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.common.domain.User;
import com.example.user.clients.OrderClient;
import com.example.user.clients.ProductClient;
import com.example.user.mapper.UserMapper;
import com.example.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blue.user.utils.JsonUtils;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.fasterxml.jackson.databind.JsonNode;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private static Logger log=LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	OrderClient orderClient;
    @Autowired
	ProductClient productClient;
    @Autowired
	UserMapper userMapper;

    public User findById(Long id) {
        return userMapper.findById(id); 
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    @LcnTransaction 
    public void save(User user) {
    	if(user!=null){
//    		Map<String,Object> orderMap=new HashMap<>();
//    		orderMap.put("userName", user.getName());
//    		orderMap.put("name", "testOrder");
//    		OrderClient.saveOrder(orderMap);
    		Map<String,Object> productMap=new HashMap<>();
    		productMap.put("name", user.getName());
    		productMap.put("code", user.getCode());
    		productClient.saveProduct(productMap);
    		userMapper.insert(user);
//    		int i=2/0;
    	}
    }

    public void update(User product) {
        userMapper.update(product);
    }

    public void delete(Long id) {
        userMapper.delete(id);
    }

	public JsonNode findOrder(Long id) {
		log.info("OrderClient:findOrder");
		String json=orderClient.findByUserId(id);
		if(json!=null&&!json.equals("")){
			return JsonUtils.str2JsonNode(json);
		}
		return null;
	}

	public JsonNode findProduct(Long id) {
		log.info("productClient:findProduct");
		String json=productClient.findByUserId(id);
		if(json!=null&&!json.equals("")){
			return JsonUtils.str2JsonNode(json);
		}
		return null;
	}

}
