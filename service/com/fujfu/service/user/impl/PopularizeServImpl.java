package com.fujfu.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.user.PopularizeMapper;
import com.fujfu.pojo.user.PopularizeVO;
import com.fujfu.pojo.user.PopularizePOJO;
import com.fujfu.service.user.PopularizeServ;
@Service("popularizeSer")
public class PopularizeServImpl implements PopularizeServ {
	@Resource
	public PopularizeMapper popularizeMapper;
	@Override
	public int addPopularizeServ(PopularizeVO popularize) {
		return popularizeMapper.insertSelective(popularize);
	}

	@Override
	public Page findPopularizeByCondition(PopularizePOJO popularizeVo, Page page) {
		page.setTotalCount(popularizeMapper.countPopularize(popularizeVo));
		page.setItems(popularizeMapper.findPopularizeByCondition(popularizeVo, page));
		return page;
	}

	@Override
	public Page findUsersByInviterId(int inviterId, Page page) {
		page.setTotalCount(popularizeMapper.countUsersByInviterId(inviterId));
		page.setItems(popularizeMapper.findUsersByInviterId(inviterId, page));
		return page;
	}

}
