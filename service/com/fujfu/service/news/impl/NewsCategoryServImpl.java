package com.fujfu.service.news.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.news.NewsCategoryMapper;
import com.fujfu.pojo.news.NewsCategoryVO;
import com.fujfu.pojo.news.NewsCategoryPOJO;
import com.fujfu.service.news.NewsCategoryServ;
@Service("newsCategorySer")
public class NewsCategoryServImpl implements NewsCategoryServ {
	@Resource
	public NewsCategoryMapper newsCategoryMapper;
	@Override
	public int addNewsCategory(NewsCategoryVO newsCategory) {
		return newsCategoryMapper.insertSelective(newsCategory);
	}

	@Override
	public int updateNewsCategory(NewsCategoryVO newsCategory) {
		return newsCategoryMapper.updateByPrimaryKeySelective(newsCategory);
	}

	@Override
	public Page findNewsCategoryByCondition(NewsCategoryVO newsCategory, Page page) {
		page.setTotalCount(newsCategoryMapper.countNewsCategory(newsCategory, page));
		page.setItems(newsCategoryMapper.findNewsCategory(newsCategory, page));
		return page;
	}

	@Override
	public List<NewsCategoryPOJO> listAllNewsCategory() {
		return newsCategoryMapper.findAllNewsCategory();
	}

	@Override
	public NewsCategoryPOJO findNewsCategoryById(short id) {
		return newsCategoryMapper.selectByPrimaryKey(id);
	}

}
