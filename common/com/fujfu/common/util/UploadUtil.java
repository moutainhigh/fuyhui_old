package com.fujfu.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;


public class UploadUtil {
	/**
	 * 上传文件并重命名
	 * @param absolutePath 绝对路径
	 * @param is 输入流
	 * @param originalName 原文件名
	 * @param fileName 新文件名
	 */
	public static boolean uploadFile(String absolutePath, InputStream is, String originalName, String fileName) {
		OutputStream out = null;
		try {
			File parent = null;
			parent = new File(absolutePath);// 文件绝对路径
			if (!parent.exists()) {
				parent.mkdirs();
			}
			//文件重命名
			File saveNavitePath = FileUtil.reNameFile(parent, originalName, fileName);
			if (saveNavitePath.isFile() && saveNavitePath.exists()) {
				saveNavitePath.delete();
			}
			IOUtils.copy(is, out = new FileOutputStream(saveNavitePath));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			IOUtils.closeQuietly(out);
		}
		return true;
	}
	
	
	/**
	 * 单文件上传
	 * @param absolutePath
	 * @param is
	 * @param fileName
	 * @return
	 */
	public static boolean importFile(String absolutePath, InputStream is, String fileName) {
		OutputStream out = null;
		try {
			File parent = new File(absolutePath);// 文件绝对路径
			if (!parent.exists()) {
				parent.mkdirs();
			}
			File saveNavitePath = new File(absolutePath + File.separator + fileName);
			if (saveNavitePath.isFile() && saveNavitePath.exists()) {
				saveNavitePath.delete();
			}
			IOUtils.copy(is, out = new FileOutputStream(saveNavitePath));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			IOUtils.closeQuietly(out);
		}
		return true;
	}
	
	/**
	 * 上传文件
	 * @param file
	 * @param pathRoot
	 * @throws Exception
	 */
	public static boolean upload(MultipartFile file,String pathRoot,String path){
		//获得文件类型（可以判断如果不是图片，禁止上传）  
        String contentType=file.getContentType();  
        //获得文件后缀名称  
        String imageName=contentType.substring(contentType.indexOf("/")+1);  
        if(imageName.equalsIgnoreCase("jpg")|| imageName.equalsIgnoreCase("png") || imageName.equalsIgnoreCase("jpeg")){
        	path = path + StringUtil.getUUID() + "." + imageName;
        	try {
				file.transferTo(new File(pathRoot + path));
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
        return true;
	}
}
