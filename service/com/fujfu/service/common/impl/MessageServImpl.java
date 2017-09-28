package com.fujfu.service.common.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.common.MessageMapper;
import com.fujfu.dao.user.UserMapper;
import com.fujfu.pojo.common.MessageVO;
import com.fujfu.pojo.common.MessagePOJO;
import com.fujfu.service.common.MessageServ;
@Service("messageSer")
public class MessageServImpl implements MessageServ {
	@Resource
	public MessageMapper messageMapper;
	@Resource
	public UserMapper userBeanMapper;
	@Override
	public int addMessage(MessageVO message) {
		return messageMapper.insertSelective(message);
	}

	@Override
	public int updateMessage(MessageVO message) {
		return messageMapper.updateByPrimaryKeySelective(message);
	}

	@Override
	public Page findMessageByCondition(MessagePOJO message, Page page) {
		page.setTotalCount(messageMapper.countMessage(message, page));
		page.setItems(messageMapper.findMessage(message, page));
		return page;
	}

	@Override
	public int batchInsert(String title,String content) {
		List<MessageVO> messageList = new ArrayList<MessageVO>();
		List<Integer> userIdList = userBeanMapper.findAllUserId();
		for(Integer userId : userIdList){
			MessageVO msg  = new MessageVO();
			msg.setTitle(title);
			msg.setContent(content);
			msg.setCreated(DateUtil.getUnixTime());
			msg.setUserId(userId);
			messageList.add(msg);
		}
		return messageMapper.batchInsert(messageList);
	}

	@Override
	public int updateMeDel(String[] checkedId) {
		// TODO Auto-generated method stub
		return  messageMapper.updateMeDel(checkedId);
	}
	@Override
	public int updateMeSta(String[] checkedId) {
		// TODO Auto-generated method stub
		return  messageMapper.updateMeSta(checkedId);
	}

}
