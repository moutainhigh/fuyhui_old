package com.fujfu.service.common.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.dao.common.SelCodeMapper;
import com.fujfu.pojo.common.SelCodeVO;
import com.fujfu.service.common.SelCodeServ;
@Service("SelCodeSer")
public class SelCodeServImpl implements SelCodeServ{
	@Resource
	private SelCodeMapper mapper;
	
	/**
	 * 查找
	 * @param message
	 * @return
	 */
	@Override
	public List<SelCodeVO>  findSelCodeByStyle(String code, String style){
		List<SelCodeVO> items =mapper.findSelCodeByStyle(code, style);
		return items;
	}
	
	/**
	 * 查找
	 * @param message
	 * @return
	 */
	@Override
	public List<SelCodeVO>  findSelCodeByBelongItemno(String code,String belongitemno){
		List<SelCodeVO> items =mapper.findSelCodeByBelongItemno(code, belongitemno);
		return items;
	}

	@Override
	public SelCodeVO selectByitemno(String code,  String itemno) {
		SelCodeVO selcode =mapper.selectByitemno(code, itemno);
		return selcode;
	}
	
	
}
