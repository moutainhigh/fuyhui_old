package com.fujfu.dao.news;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.news.NewsCategoryVO;
import com.fujfu.pojo.news.NewsCategoryPOJO;

public interface NewsCategoryMapper {
    int deleteByPrimaryKey(Short id);

    int insert(NewsCategoryVO record);

    int insertSelective(NewsCategoryVO record);

    NewsCategoryPOJO selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(NewsCategoryVO record);

    int updateByPrimaryKey(NewsCategoryVO record);
    
    List<NewsCategoryPOJO> findNewsCategory(@Param("newsCategory")NewsCategoryVO newsCategory,@Param("page")Page page);
    
    int countNewsCategory(@Param("newsCategory")NewsCategoryVO newsCategory,@Param("page")Page page);
    
    List<NewsCategoryPOJO> findAllNewsCategory();
}