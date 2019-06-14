package com.example.user.controller;

import java.util.List;

import com.example.common.domain.ResultMap;
import com.example.common.domain.User;
import com.example.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * CREATE TABLE `t_user` (
  `_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `_name` varchar(100) DEFAULT NULL,
  `_code` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  UNIQUE KEY `_id` (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 */
@RestController
@RequestMapping("user")
public class UserController {
	private static Logger log=LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping(path = "/findUser={id}")
    public ResultMap findUser(@PathVariable("id") Long id) {
        ResultMap result = ResultMap.createResultMap();
        try {
            User user = userService.findById(id);
            result.setTransport(user);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @GetMapping("allUser")
    public ResultMap allUser() {
        ResultMap result = ResultMap.createResultMap();
        try {
            List<User> list = userService.findAll();
            result.setTransport(list);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }
    
    @GetMapping("findOrder")
    public ResultMap findOrder(@RequestParam("id")Long id) {
    	ResultMap result = ResultMap.createResultMap();
    	try {
    		JsonNode node=userService.findOrder(id);
			if(node!=null){
				result.setTransport(node); 
			}
    	} catch (Exception e) {
    		result.setCode("0");
    		result.setMsg(e.getMessage());
    	}
    	return result;
    }

    @GetMapping("findProduct")
    public ResultMap findProduct(@RequestParam("id")Long id) {
    	ResultMap result = ResultMap.createResultMap();
    	try {
    		JsonNode node=userService.findProduct(id);
			if(node!=null){
				result.setTransport(node);
			}
    	} catch (Exception e) {
    		result.setCode("0");
    		result.setMsg(e.getMessage());
    	}
    	return result;
    }

    @PostMapping("saveUser")
    public ResultMap saveUser(@RequestBody User user) {
        ResultMap result = ResultMap.createResultMap();
        try {
            userService.save(user);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }
    
    @PostMapping("updateUser")
    public ResultMap updateUser(User user) {
        ResultMap result = ResultMap.createResultMap();
        try {
            userService.update(user);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @DeleteMapping(path = "/deleteUser={id}")
    public ResultMap deleteUser(@PathVariable("id") Long id) {
        ResultMap result = ResultMap.createResultMap();
        try {
            userService.delete(id);
        } catch (Exception e) {
            result.setCode("0");
            result.setMsg(e.getMessage());
        }
        return result;
    }

}
