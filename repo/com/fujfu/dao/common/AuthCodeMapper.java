package com.fujfu.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.pojo.AuthCodeVO;

public interface AuthCodeMapper {

	public int insertSmsCode(AuthCodeVO bean);

	public List<AuthCodeVO> checkCode(@Param(value = "mobile") String mobile, @Param(value = "type") String type);

	public int regSendTimes(@Param(value = "mobile") String mobile, @Param(value = "type") String type,
			@Param(value = "startDate") int startDate, @Param(value = "endDate") int endDate);

}