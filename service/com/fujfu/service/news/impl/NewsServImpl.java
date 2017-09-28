package com.fujfu.service.news.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.news.NewsMapper;
import com.fujfu.pojo.news.NewsVO;
import com.fujfu.pojo.news.NewsDTO;
import com.fujfu.pojo.news.NewsPOJO;
import com.fujfu.service.news.NewsServ;
@Service("newsSer")
public class NewsServImpl implements NewsServ {
	@Resource
	public NewsMapper newsMapper;
	@Override
	public int addNews(NewsVO news) {
		return newsMapper.insertSelective(news);
	}

	@Override
	public int updateNews(NewsVO news) {
		return newsMapper.updateByPrimaryKeySelective(news);
	}

	@Override
	public Page findNewsByCondition(NewsDTO newsQueryVo, Page page) {
		page.setTotalCount(newsMapper.countNews(newsQueryVo, page));
		page.setItems(newsMapper.findNews(newsQueryVo, page));
		return page;
	}

	@Override
	public NewsPOJO findNewsVoById(int id) {
		return newsMapper.selectByPrimaryKey(id);
	}

}
