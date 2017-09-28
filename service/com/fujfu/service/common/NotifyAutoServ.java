package com.fujfu.service.common;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.common.NotifyAutoVO;

public interface NotifyAutoServ {
	/**
	 * 添加
	 * @param notifyAuto
	 * @return
	 */
	public int addNotifyAuto(NotifyAutoVO notifyAuto);
	
	/**
	 * 修改
	 * @param notifyAuto
	 * @return
	 */
	public int updateNotifyAuto(NotifyAutoVO notifyAuto);
	
	/**
	 * 条件查询
	 * @param notifyAuto
	 * @param page
	 * @return
	 */
	public Page findNotifyAutoByCondition(NotifyAutoVO notifyAuto,Page page);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public NotifyAutoVO findNotifyAutoById(int id);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public int delNotifyAutoById(int id);
	
}
