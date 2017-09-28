package com.fujfu.service.award;

import java.math.BigDecimal;
import java.util.List;

import com.fujfu.pojo.award.UsersAwardAccountVO;

public interface AwardUserAddServ {
	
	
	public int addUserAward(String origin,String type,Integer userId,String mobile,String remark);
	
	public int  useUserAward(String awardId,BigDecimal tranAmount,Integer userId,Integer loanId,String remark);
	
	public List<UsersAwardAccountVO> searchUserAward(Integer userId,BigDecimal tranAmount);
	
	public List<UsersAwardAccountVO> searchUserAward(Integer userId,String searchType);
}
