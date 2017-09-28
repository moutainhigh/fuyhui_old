package com.fujfu.service.common;

import java.util.List;

import com.fujfu.pojo.common.SelCodeVO;

public interface SelCodeServ {

	/**
	 * 查找
	 * @param message
	 * @return
	 */
	public List<SelCodeVO>  findSelCodeByStyle(String code, String style);
	
	/**
	 * 查找
	 * @param message
	 * @return
	 */
	public List<SelCodeVO>  findSelCodeByBelongItemno(String code,String belongitemno);
	
	public SelCodeVO selectByitemno( String code, String itemno);
}
