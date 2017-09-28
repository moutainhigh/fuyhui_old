package com.fujfu.service.loan;

import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.loan.LoanTypeVO;

public interface LoanTypeServ {
	/**
	 * 添加借款类型
	 * @return
	 */
	public int addLoanType(LoanTypeVO loanType);
	
	/**
	 * 更新借款类型
	 * @return
	 */
	public int updateLoanType(LoanTypeVO loanType);
	
	/**
	 * 删除借款类型
	 * @return
	 */
	public int delLoanType(int id);
	
	/**
	 * 列出所有借款类型
	 * @return
	 */
	public List<LoanTypeVO> listAllLoanType();
	
	/**
	 * 条件查询
	 * @param loanType
	 * @param page
	 * @return
	 */
	public Page findLoanTypeByCondition(LoanTypeVO loanType,Page page);
	
	/**
	 * 根据id查询产品类型信息
	 * @param id
	 * @return
	 */
	public LoanTypeVO findLoanTypeById(int id);
	/**
	 * 根据name查询产品id  （有多个则查询最大值）
	 * @param name
	 * @return
	 */
	
	public Integer findloanTypeIdByName(String name);
}
