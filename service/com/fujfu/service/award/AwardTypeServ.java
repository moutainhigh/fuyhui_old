package com.fujfu.service.award;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.award.AwardTypeVO;

public interface AwardTypeServ {
	/**
	 * 添加红包
	 * @param awardType
	 * @return
	 */
	public int addAwardType(AwardTypeVO awardType);
	
	/**
	 * 更新红包
	 * @param awardType
	 * @return
	 */
	public int updateAwardType(AwardTypeVO awardType);
	
	/**
	 * 删除红包
	 * @param awardTypeId
	 * @return
	 */
	public int delAwardType(int awardTypeId);
	
	/**
	 * 条件查询红包
	 * @param awardType
	 * @param page
	 * @return
	 */
	public Page findAwardTypeByCondition(AwardTypeVO awardType,Page page);
}
