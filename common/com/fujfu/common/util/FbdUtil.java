package com.fujfu.common.util;

import java.util.HashMap;
import java.util.Map;

public class FbdUtil {

	public static final String PRI_KEY = "foxconnfbd!@#";// 签名私钥

	public static final String PWD_SALT = "PWDfoxconnfbd!@#";// 密码盐

	/**
	 * 学历 【富宝袋 -消金】
	 */
	public static final Map<String, String> EDU_CODE_MAP = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("01", "STATUS008");
			put("02", "STATUS006");
			put("03", "STATUS007");
			put("04", "STATUS004");
			put("05", "STATUS003");
			put("06", "STATUS002");
			put("07", "STATUS001");
		}
	};
	
	/**
	 * 婚姻状态 【富宝袋 -消金】
	 */
	public static final Map<String, String> MARRIED_STATUS = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("1", "Single");
			put("2", "Married");
			put("3", "Divorce");
		}
	};
	
	/**
	 * 婚姻状态 
	 */
	public static final Map<Integer, String> MARRIED_STATUS2 = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(1, "单身");
			put(2, "已婚");
			put(3, "离异");
		}
	};
	
	/**
	 * 学历
	 */
	public static final Map<String, String> EDU = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("01", "初中及以下");
			put("02", "高中");
			put("03", "中专");
			put("04", "大专");
			put("05", "本科");
			put("06", "硕士");
			put("07", "博士");

		}
	};
	
	/**
	 * 关系
	 */
	public static final Map<String, String> RELATION = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("01", "配偶");
			put("02", "父母");
			put("03", "子女");
			put("04", "兄弟姐妹");
			put("05", "亲戚");
			put("06", "朋友");
			put("07", "同事");
			put("08", "其他亲戚");
			put("99", "其他");
			
		}
	};
	
	/**
	 * 关系[富宝袋-消金]
	 */
	public static final Map<String, String> RELATIONSHIP = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("01", "Spouse");
			put("02", "Parents");
			put("03", "Children");
			put("04", "BrotherOrSister");
			put("05", "Relative");
			put("06", "Friend");
			put("07", "Colleague");
			put("08", "OtherRelative");
			put("99", "Other");
			
		}
	};
	
	/**
	 * 银行code-name
	 */
	public static final Map<String, String> BANK_LIST = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("0100", "邮储银行");
			put("0102", "中国工商银行");
			put("0103", "中国农业银行");
			put("0104", "中国银行");
			put("0105", "中国建设银行");
			put("0301", "交通银行");
			put("0302", "中信银行");
			put("0303", "中国光大银行");
			put("0305", "中国民生银行");
			put("0306", "广东发展银行");
			put("0308", "招商银行");
			put("0309", "兴业银行");
			put("0410", "中国平安银行");
			put("0310", "上海浦东发展银行");
		}
	};
	
	public static final String[] bankCodeList 
		= new String[]{"0100","0102","0103","0104","0105","0301","0302","0303","0305","0306","0308","0309","0410","0310"};
	
	/**
	 * 审核状态 【消金 - 富宝袋】
	 */
	public static final Map<String, Integer> APPLY_STATUS = new HashMap<String, Integer>() {
		private static final long serialVersionUID = 1L;
		{
			put("客服作业中", 1);
			put("电话审批中", 1);
			put("风控审批中", 1);
			put("审批完成", 2);
			put("已拒绝", 3);
		}
	};
	
	/**
	 * 分期状态 【消金 - 富宝袋】
	 * Payment(还款中)、Settled(提前结清)、Settlement(正常结清)
	 * Process(处理中)、Delay(已逾期)、Canceled(取消)、
	 * Dismiss(拒绝)
	 */
	public static final Map<String, String> LENDER_STATUS = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("Process", "3");
			put("Payment", "4");
			put("Settled", "5");
			put("Settlement", "5");
			put("Delay", "6");
			put("Canceled", "7");
			put("Dismiss", "8");
		}
	};
	
	/**
	 * 审核状态 【消金 - 富宝袋】
	 */
	public static final Map<String, String> GOODS_TYPE_CODE = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("上网本电脑", "NetBook");
			put("手机", "Mobile");
			put("平板", "Pad");
			put("电脑主机", "Computer");
			put("音响", "Audio");
			put("音响test", "Audio");
			put("智能手表", "Watch");
			put("笔记本电脑", "NoteBook");
			put("电视", "Fukeshi");
			put("随声听", "IPod");
		}
	};

	public static String getLenderStatus(String applyStatus) {
		String statusLender = LENDER_STATUS.get(applyStatus);
		return statusLender == null ? "" : statusLender;
	}
	
	public static String getGoodsTypeCode(String name) {
		String code = GOODS_TYPE_CODE.get(name);
		return code == null ? "" : code;
	}
	
	public static String getEduCode(String eduCode) {
		String code = EDU_CODE_MAP.get(eduCode);
		return code == null ? "" : code;
	}
	
	public static String getEdu(String eduCode) {
		String code = EDU.get(eduCode);
		return code == null ? "" : code;
	}
	
	public static String getRelation(String code) {
		String name = RELATION.get(code);
		return name == null ? "" : name;
	}
	
	public static String getRelationship(String code) {
		String name = RELATIONSHIP.get(code);
		return name == null ? "" : name;
	}
	
	public static String getMarried(String married) {
		String code = MARRIED_STATUS.get(married);
		return code == null ? "" : code;
	}
	
	public static String getMarried2(Integer married) {
		String status = MARRIED_STATUS2.get(married);
		return status == null ? "" : status;
	}
	
	public static int getAppStatus(String status) {
		int stat = APPLY_STATUS.get(status);
		return stat;
	}
	
	public static String getBankName(String bankCode) {
		String bankName = BANK_LIST.get(bankCode);
		return bankName == null ? "" : bankName;
	}
	
	public static void main(String[] args) {
		System.out.println(FbdUtil.getMarried("06"));
		System.out.println(FbdUtil.getMarried("3"));
		System.out.println(FbdUtil.getMarried(""));
		System.out.println(FbdUtil.getBankName("0308"));
	}
}
