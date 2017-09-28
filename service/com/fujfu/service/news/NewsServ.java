package com.fujfu.service.news;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.news.NewsVO;
import com.fujfu.pojo.news.NewsDTO;
import com.fujfu.pojo.news.NewsPOJO;

public interface NewsServ {
	/**
	 * 新增新闻
	 * @param news
	 * @return
	 */
	public int addNews(NewsVO news);
	
	/**
	 * 更新新闻信息
	 * @param news
	 * @return
	 */
	public int updateNews(NewsVO news);
	
	/**
	 * 条件查询
	 * @param news
	 * @param page
	 * @return
	 */
	public Page findNewsByCondition(NewsDTO newsQueryVo,Page page);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public NewsPOJO findNewsVoById(int id);
}
