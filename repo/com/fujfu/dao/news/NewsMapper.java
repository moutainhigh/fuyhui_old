package com.fujfu.dao.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.news.NewsVO;
import com.fujfu.pojo.news.NewsDTO;
import com.fujfu.pojo.news.NewsPOJO;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewsVO record);

    int insertSelective(NewsVO record);

    NewsPOJO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewsVO record);

    int updateByPrimaryKeyWithBLOBs(NewsVO record);

    int updateByPrimaryKey(NewsVO record);
    
    List<NewsPOJO> findNews(@Param("newsQueryVo")NewsDTO newsQueryVo,@Param("page")Page page);
    
    int countNews(@Param("newsQueryVo")NewsDTO newsQueryVo,@Param("page")Page page);
}