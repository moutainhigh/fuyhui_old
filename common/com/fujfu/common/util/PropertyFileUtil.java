package com.fujfu.common.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtil {
	private static Properties propertie=null;
    static{   propertie = new Properties();
        try(InputStream inputFile = PropertyFileUtil.class.getClassLoader().getResourceAsStream("config/filePath.properties")){
            propertie.load(inputFile);
        } catch (FileNotFoundException ex) {
            System.out.println("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("装载文件--->失败!");
            ex.printStackTrace();
        }
    }
    public static String getProperty(String key){
    	return (String)propertie.get(key);
    }
}
