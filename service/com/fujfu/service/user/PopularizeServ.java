package com.fujfu.service.user;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.user.PopularizeVO;
import com.fujfu.pojo.user.PopularizePOJO;

public interface PopularizeServ {
	/**
	 * 添加推荐人
	 * @param popularize
	 * @return
	 */
	public int addPopularizeServ(PopularizeVO popularize);
	
	/**
	 * 条件查询推荐人
	 * @param popularize
	 * @param page
	 * @return
	 */
	public Page findPopularizeByCondition(PopularizePOJO popularizeVo,Page page);
	
	/**
	 * 根据邀请人id查询被邀请人信息
	 * @param inviterId
	 * @param page
	 * @return
	 */
	public Page findUsersByInviterId(int inviterId,Page page);
}
