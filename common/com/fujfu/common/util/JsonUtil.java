package com.fujfu.common.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * <p>json工具类</p>
 * @author hjz
 */
public class JsonUtil {

	private static Logger log = Logger.getLogger(JsonUtil.class);
	
	private static ObjectMapper mapper;
	
	public static synchronized ObjectMapper getMapperInstance() {   
		if (mapper == null) {   
            mapper = new ObjectMapper();   
        }   
        return mapper;   
    } 
	
	/**
	 * bean对象转化成json对象<br>
	 * Include.NON_EMPTY,属性为 ""或者为NULL都不序列化 <br>
	 * @throws Exception 
	 */
	public static String parseToJson(Object obj) {
		try {
			ObjectMapper objectMapper = getMapperInstance();
			objectMapper.setSerializationInclusion(Include.NON_EMPTY);
			String json = mapper.writeValueAsString(obj);
			return json;
		}catch (Exception e) {
			log.error("json序列化异常", e);
            throw new IllegalArgumentException("转换为JSON字符串时异常", e);
		}		
	}
	
	/**
	 * bean对象转化成json对象 <br>
	 * @throws Exception 
	 */
	public static String parseToJson2(Object obj)  {
		try {
			ObjectMapper objectMapper = getMapperInstance();
			String json = objectMapper.writeValueAsString(obj);
			return json;
		} catch (Exception e) {
			log.error("json序列化异常", e);
            throw new IllegalArgumentException("转换为JSON字符串时异常", e);
		}		
	}
	
    /**
     * 将JSON字符串转换为对象 <br>
     * @param json <br>
     * @param clazz <br>
     * @return
     */
    public static <T> T parseToBean(String json, Class<T> clazz) {
        try {
        	ObjectMapper objectMapper = getMapperInstance();
        	//设置出现未知属性时不报错
        	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("json反序列化异常", e);
            throw new IllegalArgumentException("由JSON字符串时转换为对象时异常", e);
        }
    }
 
      public static ObjectMapper getMapper() 
    		  throws JsonParseException, JsonMappingException, IOException { 
    	  ObjectMapper objectMapper = getMapperInstance();
    	  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
          return objectMapper;
      }   
}
