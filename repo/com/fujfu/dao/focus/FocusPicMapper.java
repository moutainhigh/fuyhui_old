package com.fujfu.dao.focus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.focus.FocusPicVO;

public interface FocusPicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FocusPicVO record);

    int insertSelective(FocusPicVO record);

    FocusPicVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FocusPicVO record);

    int updateByPrimaryKey(FocusPicVO record);
    
    List<FocusPicVO> findBannerByDevice(Integer displayDevice);
    
    List<FocusPicVO> findFocusPic(@Param("focusPic")FocusPicVO focusPic,@Param("page")Page page);
    
    int countFocusPic(@Param("focusPic")FocusPicVO focusPic,@Param("page")Page page);

}