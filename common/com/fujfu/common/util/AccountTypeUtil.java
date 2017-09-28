package com.fujfu.common.util;

import java.util.HashMap;
import java.util.Map;

/**
	 * 账户类型属性文件，fu_user_account_log 流水表的 type字段
	 * @author hjz 
	 * @create 2016-7-14
	 */
public class AccountTypeUtil {
	public static void main(String[] args){
		System.out.println(AccountTypeUtil.acctType.get(1000));
	}
	
	   public static final Map<Integer,String> acctType = new HashMap<Integer,String>(){
	   
		   private static final long serialVersionUID = 1L;

		  {
			  //充值提现
			  put(4100, "充值成功");
			  put(4101, "充值手续费");
			  put(4102, "提现成功");
			  put(4103, "提现手续费");
			  
			  //投资人
			  put(4201, "投资冻结");
			  put(4202, "投资成功");
			  put(4203, "回款成功"); 
			  put(4204, "投资服务费");
			  
			  // --------- //
			  put(4203, "逾期回款成功");  //逾期回款：本息
			  put(4205, "逾期罚息");
			  put(4206, "提前回款成功");
			  put(4207, "提前回款违约金");	
			  
			  //借款人
			  put(4301, "借款成功"); 
			  put(4302, "融资服务费");
			  put(4303, "还款成功");
			  
			  // --------- //
			  put(4304, "逾期还款成功");		  //还款：本息
			  put(4305, "逾期服务费");   //给平台
			  put(4306, "逾期罚息");     //给投资人
			  put(4307, "提前还款成功");  //给投资人本息
			  put(4308, "提前还款违约金");  //给投资人违约金
			  put(4309, "提前还款服务费");   //给平台 违约服务费
			  
			  //担保机构垫款
			  put(4401, "正常垫付");   //本息
			  put(4402, "逾期垫付");   //本息
			  put(4403, "逾期垫付罚息"); //罚息
			  put(4404, "逾期垫付服务费"); //给平台
			  
			  put(1033, "推荐收入");
			  
			  //预留
			  put(1000, "充值成功");
			  put(1010, "费用收入");
			  put(1011, "逾期罚息");
			  put(1012, "提前还款罚息");
			  put(1013, "网站垫付");
			  put(1020, "回款成功");
			  put(1021, "借款成功");
			  put(1031, "分帐收入");
			  put(1032, "红包收入");
			  put(1034, "债权转让收入");
			  put(1035, "补仓收入");
			  put(1036, "加息券收入");
			  put(1037, "奖励标收益");
			  put(1038, "提前还款罚息");
			  put(1039, "投资返现收益");
			  put(1040, "推荐返现收益");
			  put(1100, "流标解冻");
			  put(1101, "提现失败");
			  put(1102, "提现失败");
			  put(1103, "末投资转为可提现");
			  put(1104, "转入生利宝");
			  put(1105, "转出生利宝");
			  put(1106, "债权转让支出");
			  put(2000, "费用支出");
			  put(2001, "逾期罚息");
			  put(2002, "提前还款罚息");
			  put(2003, "还款给网站垫付");
			  put(2010, "提现支出");
			  put(2011, "还款成功");
			  put(2012, "投资成功");
			  put(2013, "提现手续费");
			  put(2014, "配资转出");
			  put(2015, "补仓支出");
			  put(2100, "投资冻结");
			  put(2101, "提现冻结");
			  put(2102, "提现冻结");
			  put(2103, "资金冻结");
			  put(3000, "充值手续费");
			  put(3001, "提现退票");
			  put(3002, "提现手续费退还");
		   }
		  };
	
}
