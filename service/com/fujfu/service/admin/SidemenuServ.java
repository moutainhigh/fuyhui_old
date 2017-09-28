package com.fujfu.service.admin;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.SidemenuVO;

public interface SidemenuServ {
	/**
	 * 添加
	 * @param SidemenuVO
	 * @return
	 */
	public int addSidemenu(SidemenuVO sidemenu);
	
	/**
	 * 修改
	 * @param sidemenu
	 * @return
	 */
	public int updateSidemenu(SidemenuVO sidemenu);
	
	/**
	 * 删除
	 * @param sidemenuId
	 * @return
	 */
	public int delSidemenu(int sidemenuId);
	
	/**
	 * 查询
	 * @param page
	 * @return
	 */
	public Page listAllsidemenu(Page page);
}
