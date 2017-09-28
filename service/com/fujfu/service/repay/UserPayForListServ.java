package com.fujfu.service.repay;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.user.PayForListPOJO;

public interface  UserPayForListServ {
	/**
	 * 查询垫资信息
	 * 
	 * @return
	 */
	public Page findPayForListByCondition(PayForListPOJO payForListQueryVo, Page page);
}
