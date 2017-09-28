package com.fujfu.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.common.MessageVO;
import com.fujfu.pojo.common.MessagePOJO;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageVO record);

    int insertSelective(MessageVO record);

    MessageVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageVO record);

    int updateByPrimaryKeyWithBLOBs(MessageVO record);

    int updateByPrimaryKey(MessageVO record);

    /**
     * 分页查询总记录数
     * @param message
     * @param page
     * @return
     */
	int countMessage(@Param("message")MessagePOJO message, @Param("page")Page page);
	
	
	/**
	 * 分页查询
	 * @param message
	 * @param page
	 * @return
	 */
	List<MessageVO> findMessage(@Param("message")MessagePOJO message, @Param("page")Page page);
	
	/**
	 * 批量插入
	 * @param 
	 * @return
	 */
	int batchInsert(List<MessageVO> messageList);
	//批量更新删除状态
	int updateMeDel(String[] checkedId);  
	//批量更新状态
	int updateMeSta(String[] checkedId);  
}