package com.fujfu.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	//汇付配置文件
	private static final String HF_CONFIG_PROPERTIES = "com/fujfu/common/payment/chinapnr/config.properties";
	
	public static String getHFValue(String key){
		String value = null;
		InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(HF_CONFIG_PROPERTIES);
		Properties props = new Properties();
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		value = props.getProperty(key);
		return value;
	}
	
	
	public static String getHFKeyPath(String path) throws IOException {
		String realPath = Thread.currentThread().getContextClassLoader()
				.getResource(path).getPath();
		return realPath;
	}
	
	public static String getFyKeyPath(String path) throws IOException {
		String realPath = Thread.currentThread().getContextClassLoader()
				.getResource(path).getPath();
		return realPath;
	}

}
