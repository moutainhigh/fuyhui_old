package com.fujfu.service.gat;



import com.fujfu.pojo.gat.GatApproveVO;



public interface GatApproveSer {		
	/**
	 * 添加信息
	 */
	public int addGatApprove(GatApproveVO gatApprove);
	
	/**
	 * 审批通过
	 * */
	public String approvePass(String id);
	/**
	 * 审批拒绝
	 * */
	public String approveFail(String id);
	
	/**
	 * 前台展示控制状态查询
	 * */
	public int countGatApproveByStatus(GatApproveVO gatApprove);
	
	//前台查询证件号是否已使用	
	public int countGatApproveByUserId(String userID);
}
