package com.fujfu.service.common;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.common.MessageVO;
import com.fujfu.pojo.common.MessagePOJO;

public interface MessageServ {

	/**
	 * 新增站内信
	 * @param message
	 * @return
	 */
	public int addMessage(MessageVO message);
	
	/**
	 * 修改站内信(状态)
	 * @param message
	 * @return
	 */
	public int updateMessage(MessageVO message);
	
	/**
	 * 分页条件查询
	 * @param message
	 * @param page
	 * @return
	 */
	public Page findMessageByCondition(MessagePOJO message,Page page);
	
	/**
	 * 批量添加
	 * @param list
	 * @return
	 */
	public int batchInsert(String title,String content);
	public int updateMeDel(String[] checkedId);  
	public int updateMeSta(String[] checkedId);  
}
