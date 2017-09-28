package com.fujfu.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.user.UserMapper;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.pojo.user.UserPOJO;
import com.fujfu.service.user.UserServ;
@Service
public class UserServImpl implements UserServ {
	@Resource
	private UserMapper mapper;
	@Override
	public Page findUserByCondition(UserPOJO userQueryVo, Page page) {
		page.setTotalCount(mapper.countUser(userQueryVo, page));
		page.setItems(mapper.findUser(userQueryVo, page));
		return page;
	}
	
	@Override
	public UserVO getUserByUserId(int userId) {
		return mapper.getUserByUserId(userId);
	}

	@Override
	public int updateUser(UserVO user) {
		return mapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public UserVO getUserByMobile(String mobile) {
		return mapper.getUserByMobile(mobile);
	}
	
	@Override
	public int insertUser(UserVO user) {
		return mapper.insertSelective(user);
	}

	@Override
	public List<UserVO> findUserByType(String userType) {
		return mapper.findUserByType(userType);
	}

	@Override
	public int getCountByEmail(String email) {
		// TODO Auto-generated method stub
		return mapper.getCountByEmail(email);
	}

	@Override
	public int checkUsername(String username) {
		// TODO Auto-generated method stub
		return mapper.checkUsername(username);
	}

	@Override
	public List<UserVO> getUserByjzhLoginId(String jzhloginid) {
		// TODO Auto-generated method stub
		return mapper.getUserByjzhLoginId(jzhloginid);
	}

	@Override
	public int checkCardIdExist(String cardType, String cardId) {
		// TODO Auto-generated method stub
		return mapper.checkCardIdExist(cardType, cardId);
	}

	@Override
	public int checkUserCorpNameExist(String corpName) {
		// TODO Auto-generated method stub
		return mapper.checkUserCorpNameExist(corpName);
	}

	@Override
	public int checkUserActnoExist(String capAcntNo) {
		// TODO Auto-generated method stub
		return mapper.checkUserActnoExist(capAcntNo);
	}
	
}
