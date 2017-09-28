package com.fujfu.common.util;

import java.io.File;
import java.util.Arrays;

public class FileUtil{
	  /**
	   * 获取文件名后缀
	   * 
	   * @param filename
	   * @return
	   */
	  public static String getFileExt(String filename){
	    int point = filename.lastIndexOf(".");
	    return filename.substring(point);
	  }
	  
	  /**
	   * 获取文件名(不包含后缀)
	   * 
	   * @param filename
	   * @return
	   */
	  public static String getFileName(String filename){
	    filename = getFileNameWithExt(filename);
	    int point = filename.lastIndexOf(".");
	    return filename.substring(0, point);
	  }

	  /**
	   * 获取文件名(包含后缀)
	   * 
	   * @param filename
	   * @return
	   */
	  public static String getFileNameWithExt(String filename){
	    int slash = filename.lastIndexOf("/");
	    return filename.substring(slash + 1);
	  }

	  /**
	   * 判断指定格式是否为图片
	   * 
	   * @param ext
	   * @return
	   */
	  public static boolean isImageExt(String ext){
	    return ext != null && Arrays.asList(".jpg", ".jpeg", ".png").contains(ext.toLowerCase());
	  }

	  /**
	   * 生成文件存储名
	   * 
	   * @param parent
	   * @param fileName
	   * @return
	   */
	  public static File determineFile(File parent, String fileName){
	    String name = getFileName(fileName);
	    String ext = getFileExt(fileName);
	    File temp = new File(parent, fileName);
	    for(int i = 1; temp.exists(); i++){
	      temp = new File(parent, name + i + ext);
	    }
	    return temp;
	  }
	  
	  /**
	   * 重命名
	   * 
	   * @param parent 路径
	   * @param originalName 原名称
	   * @return fileName 新名称
	   */
	  public static File reNameFile(File parent,String originalName, String fileName){
	    String ext = getFileExt(originalName);//获取文件后缀
	    File temp = new File(parent, (new StringBuffer(fileName)).append(ext).toString());
	    return temp;
	  }
	  
	  
	public static void renameFile(String path, String oldname, String newname) {
		if (!oldname.equals(newname)) {// 新的文件名和以前文件名不同时,才有必要进行重命名
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (!oldfile.exists()) {
				return;// 重命名文件不存在
			}
			if (newfile.exists())// 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
				System.out.println(newname + "已经存在！");
			else {
				oldfile.renameTo(newfile);
			}
		} else {
			System.out.println("新文件名和旧文件名相同...");
		}
	}

	}
