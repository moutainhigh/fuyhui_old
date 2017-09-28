package com.fujfu.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.fujfu.pojo.common.SelCodeVO;

public interface SelCodeMapper {
	List<SelCodeVO> findSelCodeByStyle(@Param(value = "code") String code,@Param(value = "style") String style);
	List<SelCodeVO> findSelCodeByBelongItemno(@Param(value = "code") String code,@Param(value = "belongitemno") String belongitemno);
	SelCodeVO selectByitemno(@Param(value = "code") String code,@Param(value = "itemno") String itemno);
}