package com.fujfu.service.repay;

import java.math.BigDecimal;
import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.ApplyRecoverPOJO;
import com.fujfu.pojo.apply.ApplyRepayVO;
import com.fujfu.pojo.apply.ApplyRepayPlanPOJO;
import com.fujfu.pojo.apply.ApplyRepayPOJO;
import com.fujfu.pojo.apply.PrepaymentDTO;
import com.fujfu.pojo.apply.UserRepaySumPOJO;
import com.fujfu.pojo.loan.LoanApplyVO;

public interface RepayServ {
	/**
	 * 根据标的id查询还款计划
	 * @param applyId
	 * @param pageNum
	 * @return
	 */
	public List<ApplyRepayPlanPOJO> findApplyRepayPlanByApplyId(String applyId,int pageNum);
	public List<ApplyRepayPlanPOJO> findAllApplyRepayPlanByApplyId(String applyId);
	/**
	 * 根据标的id统计还款计划
	 * @param applyId
	 * @return
	 */
	public int countApplyRepayPlanByApplyId(String applyId);
	
	/**
	 * 根据id查询该记录
	 * @param id
	 * @return
	 */
	public ApplyRepayPOJO findRepayById(int id);
	/**
	 * 根据标的id查询回款计划
	 * @param applyId
	 * @return
	 */
	public List<ApplyRecoverPOJO> findRepayByApplyId(String applyId,int pageNum);
	
	public List<ApplyRecoverPOJO> findAllRepayByApplyId(String applyId);
	
	/**
	 * 根据标的id统计回款计划
	 * @param parseInt
	 * @return
	 */
	public int countRepayByApplyId(String applyId);
	
	/**
     * 根据标的id和还款期数查询当期还款计划
     * @param applyId
     * @param repayPeriod
     * @return
     */
    public ApplyRepayVO findRepayByApplyidAndRepayperiod(int applyId,int repayPeriod);
	
    /**
     * 根据标的id和回款期数查询当期回款计划
     * @param applyId
     * @param recoverPeriod
     * @return
     */
    public List<ApplyRecoverVO> findRepayByApplyidAndRecoverperiod(int applyId,int recoverPeriod);
    
    /**
     * 根据标的的id以及费用名查询费率
     * @param applyId
     * @param feeBase
     * @param feeName
     * @return
     */
    public BigDecimal findRateByApplyidAndFeename(int applyId,String feeBase,String feeName);
    
    /**
     * 更新回款计划表
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(ApplyRecoverVO record);
    
    
    /**
     * 更新还款计划表
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(ApplyRepayVO record);
    /**
	 * 
	 * 1、当期的，回款计划表金额Repay与还款计划表Recover金额是否相等？
	 * 2、借款人还款账户可用余额是否够还?
	 * 3、投资人借款服务费（利息管理费），读取费用表得到费率额，loan_appy中的loan_type,去fee_type, fee
	 * 4、对fu_loan_recover大循环（is_pnr_pay=0）
	 *    1）还款额拆分，利息按照利息管理费给平台，其他的给投资人
	 *    2）费用
	 *    生成list
	 * 5、对list循环，调用三方支付接口，进行资金划拨-解冻***********************
	 * com.fujfu.common.payment.fuyou:transferBu ，拼TransBuBean model
	 * 6、还款完成，fu_loan_recover更新status=1已还，update实际还款实际recover_done_time，is_pnr_pay置=1表示第三方存管已还。
	 * 7、还款完成，fu_loan_repay更新。
	 * 8、判断还款期数是否最后一期，如果已经还款完毕，更新fu_loan_apply,status=10
	 * 
	 */
	/**
	 * 条件查询
	 * @param applyRepay
	 * @param page
	 * @return
	 */
	public Page findApplyRepayByCondition(ApplyRepayPOJO applyRepay,Page page);
	
	/**
	 * 还款提醒
	 * @param applyRepay
	 * @param page
	 * @return
	 */
	public Page findRepaymentReminder(Page page);
	
	/**
     * 后台管理系统查询所有还款记录
     * @param 
     * @return
     */
    public Page findAllApplyRepayListByCondition(LoanInvestPOJO loanInvestQueryVo,Page page);
    
    /**
     * 后台管理系统查询所有收款记录
     * @param 
     * @return
     */
    public Page findAllApplyRecoverListByCondition(LoanInvestPOJO loanInvestQueryVo,Page page);
    
    public int countUserApplyRepayTradeDetai(LoanInvestPOJO loanInvestQueryVo,Integer userId);
  //前台我的借款查询相关汇总详情
  	 public UserRepaySumPOJO findUserRepaySumMap(String status,Integer userId,Integer applyId);
  	 
  	 
  	 /**
  	  * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>提前还款>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  	  */
  	 /**
  	  * 获取提前还款信息
  	  * @param loanApply
  	  * @param applyRepay
  	  * @return
  	  */
  	 public PrepaymentDTO getPrepaymentDetail(LoanApplyVO loanApply);
  	 
  	 /**
  	  * 提前还款处理
  	  * @param loanApply
  	  * @param prement
  	  * @return
  	 * @throws Exception 
  	  */
  	 public boolean prepayment(LoanApplyVO loanApply,PrepaymentDTO prepayment) throws Exception;
  	 
  	/**
 	  * 根据标的id和期数查询当期之前是否存在未还的
 	  * @param applyId
 	  * @param period
 	  * @return
 	  */
 	 public ApplyRepayVO isExistNotRepayByPeriod(int applyId,int period);
}
