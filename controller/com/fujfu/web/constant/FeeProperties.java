package com.fujfu.web.constant;

import java.util.HashMap;
import java.util.Map;

/**
	 * 费用计算属性表.
	 * @author 
	 * @create 2016-7-11
	 */
public class FeeProperties {
	   // 标的类型
	   public static final String[] LOAN_CATEGORY = {"信用标","抵押标","担保标"};
	   
	   // 产品来源
	   public static final String[] PRODUCT_SOURCE = {"富车贷","富薪贷","金交所"};
	   
	   // 全部费用
	   public static final String[] FEE = {"个人快捷充值手续费","个人网银充值手续费","借款人企业网银充值手续费","借款人个人网银充值手续费","机构企业网银充值手续费","机构个人网银充值手续费",
			   "投资人提现手续费","借款人提现手续费","机构提现手续费",
			   "投资服务费",
			   "融资服务费",
			   "提前还款服务费",
			   "线下债转手续费",
			   "线上债转手续费",
			   "线上债转服务费",
			   "逾期利息",
			   "逾期违约金",
			   "红包支出",
			   "推荐支出"
			   };
	   
	   
	   // 借款成交服务费比例
	   public static final double[] DROPDOWN_LOAN_SUCCESS_FEE = {};
	   
	   // 借款用途
	   public static final String[] USAGE_OF_LOAN = {};
	   
	   // 还款方式
	   public static final Map<Integer,String> REPAYMENT_METHOD = new HashMap<Integer,String>(){{
		   put(1,"按月付息，到期一次性还本");
		   put(2,"到期一次性还本付息");
//		   put(3,"等额本息");
//		   put(4,"等额本金");
		   put(5,"按季付息，到期一次性还本");
		}};
		   
	   
//	   // 借款期限
//	   public static final int[] TERM_OF_LOAN = {
//			  30,90,180,360
//	   };
	   
	   // 总成本
	   public static final double[] TOTAL_COST = {};
	  
	   // fee 费用计息基数
	   public static final Map<String,String> DROPDOWN_FEE_BASE = new HashMap<String,String>(){{
		   put("borrow_amount","借款总额");
		   put("hand_amount","到手金额");
		   put("borrow_principal","借款本金");
		   put("borrow_interest","借款利息");
		   
		   put("remainder_amount","借款剩余总额");
		   put("remainder_principal","借款剩余本金");
		   put("remainder_interest","借款剩余利息");
		   
		   put("current_amount","当期逾期本息");
		   put("current_principal","当期逾期本金");
		   put("current_interest","当期逾期利息");
		   
		   put("invest_amount","投资总额");
		   put("reimbursement_amount","投资回款总额");
		   put("reimbursement_principal","投资回款本金");
		   put("reimbursement_interest","投资回款利息");
		   
		   put("remainder_reimbursement_amount","投资剩余回款总额");
		   put("remainder_reimbursement_principal","投资剩余回款本金");
		   put("remainder_reimbursement_interest","投资剩余回款利息");
		   
		   put("withdrawal_amount","提现金额");
		   put("recharge_amount","充值金额");
	   }};
	   
	   /**
	    * fee 公式类型
	    */
	   public static final Map<Integer,String> DROPDOWN_FORMULA_TYPE = new HashMap<Integer,String>(){{
		   put(1,"比例");
		   put(2,"定额");
	   }};
	   
	   /**
	    * 收费方式 
	    */
	   public static final Map<String,String> BILLING_METHOD = new HashMap<String,String>(){{
		   put("borrow_start","充值收费法");
		   put("borrow_repay","提前还款法");
	   }};
	   /**
	    * 客户类型
	    */
	   public static final Map<String,String> USER_TYPE = new HashMap<String,String>(){{
		   put("1","个人用户");
		   put("2","企业用户");
		   put("3","担保公司");
	   }};
	   
	   /**
	    * fee_type收费时间点
	    */
	   public static final Map<String,String> DROPDOWN_CHARGE_TIME = new HashMap<String,String>(){{
		   put("apply","借款成功");
		   put("repay","正常还款");
		   put("last_repay","逾期还款");
		   put("pre_payment","提前还款");
		   put("withdrawal","提现成功");
		   put("recharge_succes","充值成功");
		   put("invest_success","投资成功");
		   put("reimbursement","回款成功");
		   put("buy_vip","vip购买成功");
		   put("sell_credit_assignment_success","债权转让购买成功");
	   }};
	   
	   /**
	    * fee_type 计费开始时间 
	    */
	   public static final Map<String,String> DROPDOWN_BILLING_START_TIME = new HashMap<String,String>(){{
		   put("borrow_start","借款开始日");
		   put("borrow_repay","借款还款日");
		   put("borrow_last","借款逾期日");
		   put("last_advance","逾期垫付日");
	   }};
	   
	   public static final Map<String,String> NOTIFY_TIME = new HashMap<String,String>(){{
		   put("apply","借款成功");
		   put("repay","正常还款");
		   put("last_repay","逾期还款");
		   put("pre_payment","提前还款");
		   put("withdrawal","提现成功");
		   put("recharge_succes","充值成功");
		   put("invest_success","投资成功");
		   put("reimbursement","回款成功");
		   put("buy_vip","vip购买成功");
		   put("sell_credit_assignment_success","债权转让购买成功");
	   }};
}
