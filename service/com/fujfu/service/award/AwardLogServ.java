package com.fujfu.service.award;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.award.AwardLogVO;

public interface AwardLogServ {
	/**
	 * 添加红包使用记录
	 * @param awardLog
	 * @return
	 */
	public int addAwardLog(AwardLogVO awardLog);
	
	/**
	 * 更新红包使用记录
	 * @param awardLog
	 * @return
	 */
	public int updateAwardLog(AwardLogVO awardLog);
	
	/**
	 * 删除红包使用记录
	 * @param awardLogId
	 * @return
	 */
	public int delAwardLog(int awardLogId);
	
	/**
	 * 条件查询红包使用记录
	 * @param awardLog
	 * @param page
	 * @return
	 */
	public Page findAwardLogByCondition(AwardLogVO awardLog,Page page);
}
