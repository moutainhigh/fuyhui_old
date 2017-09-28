package com.fujfu.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.user.GuaranteeInfoPOJO;

public interface GuaranteeInfoMapper {
	/*
	 * 查询担保信息
	 */
	List<GuaranteeInfoPOJO> findGuaranteeInfo(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo , @Param("page") Page page);
	
	/*
	 * 查询满足条件的总记录数
	 */
	int countGuaranteeInfo(@Param("loanInvestQueryVo") LoanInvestPOJO loanInvestQueryVo, @Param("page") Page page);

}