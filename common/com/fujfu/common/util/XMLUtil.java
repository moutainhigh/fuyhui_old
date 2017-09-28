package com.fujfu.common.util;

import java.io.File;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyElement;

/**
 * xml工具类
 * @author hjz
 *
 */
public class XMLUtil {
    
    private JAXBContext jaxbContext;

    /**
     * @param types 所有需要序列化的Root对象的类型.
     */
    public XMLUtil(Class<?>... types) {
        try {
            jaxbContext = JAXBContext.newInstance(types);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
   
    /**
     * Xml->Java Object.
     */
    @SuppressWarnings("unchecked")
    public static <T> T toBean(Class<T> clazz,String xml) {
        try {
        	JAXBContext jc = JAXBContext.newInstance(clazz);
            StringReader reader = new StringReader(xml);
            return (T) jc.createUnmarshaller().unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Xml->Java Object2.
     */
    @SuppressWarnings("unchecked")
    public <T> T toBean2(String xml) {
        try {
            StringReader reader = new StringReader(xml);
            return (T) createUnmarshaller().unmarshal(reader);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 创建UnMarshaller.
     */
    public Unmarshaller createUnmarshaller() {
        try {
            return jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 封装Root Element 是 Collection的情况.
     */
    public static class CollectionWrapper {
        @SuppressWarnings("rawtypes")
		@XmlAnyElement
        protected Collection collection;
    }


    @SuppressWarnings("unchecked")
    public <T> T fromXML(String fileName) {
        return (T)fromXML(new File(fileName));
    }


    @SuppressWarnings("unchecked")
    public <T> T fromXML(File file) {
        try {
            Unmarshaller unmarshaller = createUnmarshaller();
            return (T) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("unchecked")
    public <T> T fromXML(InputStream stream) {
        try {
            Unmarshaller unmarshaller = createUnmarshaller();
            return (T) unmarshaller.unmarshal(stream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    
	/**
	 * 截取富友响应参数plain之间的数据，用于验签
	 * @param xmlData
	 */
	public static String getSignData(String xmlData) {   
		String str = null;
		int p1 = xmlData.lastIndexOf("<plain>");
		int p2 = xmlData.lastIndexOf("</plain>");
		if(p1 != -1 && p2 != -1){
			str = xmlData.substring(p1,p2) + "</plain>";
			return str;
		}
		return "";
	}
	/** 
     * JavaBean转换成xml 
     * @param obj 
     * @param encoding  
     * @return  
     */  
    public static String bToXml(Object obj, String encoding) {  
        String result = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(obj.getClass());  
            Marshaller marshaller = context.createMarshaller();  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);  
  
            StringWriter writer = new StringWriter();  
            marshaller.marshal(obj, writer);  
            result = writer.toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return result;  
    }  
}
