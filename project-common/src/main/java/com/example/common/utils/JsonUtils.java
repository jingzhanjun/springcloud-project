package com.blue.user.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {
	private static Logger log=LoggerFactory.getLogger(JsonUtils.class);
	private static final ObjectMapper mapper=new ObjectMapper();
	static {
	    // 转换为格式化的json
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    // 如果json中有新增的字段并且是实体类类中不存在的，不报错
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public static JsonNode str2JsonNode(String json){
		JsonNode node=null;
		try {
			node=mapper.readTree(json);
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return node;
	}
	
	public static String Obj2Json(Object obj){
		String json=null;
		try {
			json = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
		return json;
	}
	
}
