package com.fujfu.service.news;

import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.news.NewsCategoryVO;
import com.fujfu.pojo.news.NewsCategoryPOJO;

public interface NewsCategoryServ {
	/**
	 * 新增新闻类别
	 * @param NewsCategoryServ
	 * @return
	 */
	public int addNewsCategory(NewsCategoryVO newsCategory);
	
	/**
	 * 更新新闻类别
	 * @param NewsCategoryServ
	 * @return
	 */
	public int updateNewsCategory(NewsCategoryVO newsCategory);
	
	/**
	 * 条件查询
	 * @param NewsCategoryServ
	 * @param page
	 * @return
	 */
	public Page findNewsCategoryByCondition(NewsCategoryVO newsCategory,Page page);
	
	/**
	 * 查询出所有的新闻类别
	 * @return
	 */
	public List<NewsCategoryPOJO> listAllNewsCategory();
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public NewsCategoryPOJO findNewsCategoryById(short id);
}
