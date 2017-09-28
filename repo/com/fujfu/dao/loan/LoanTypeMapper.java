package com.fujfu.dao.loan;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.loan.LoanTypeVO;

public interface LoanTypeMapper {
    int deleteByPrimaryKey(@Param("id")Integer id);

    int insert(LoanTypeVO record);

    int insertSelective(LoanTypeVO record);

    LoanTypeVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanTypeVO record);

    int updateByPrimaryKey(LoanTypeVO record);
    
    List<LoanTypeVO> listAllLoanType();

	int countLoanType(@Param("loanType")LoanTypeVO loanType);

	List<LoanTypeVO> findLoanType(@Param("loanType")LoanTypeVO loanType, @Param("page")Page page);
	Integer findloanTypeIdByName(@Param("name")String name);
}