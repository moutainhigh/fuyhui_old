package com.fujfu.dao.account;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.account.UserAccountPOJO;
import com.fujfu.pojo.account.UserAccountVO;

public interface UserAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAccountPOJO record);

    int insertSelective(UserAccountVO record);

    UserAccountPOJO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAccountVO record);

    int updateByPrimaryKey(UserAccountVO record);
    
    UserAccountVO selectByUserId(Integer userId);
    
    /**
     * 根据标的id查询出借款人账户可用余额
     */
    BigDecimal findUserCashByApplyId(@Param("applyId")int applyId);
    
    /**
     * 分页查询
     * @param page
     * @return
     */
    List<UserAccountPOJO> findUserAccount(@Param("userAccountVo")UserAccountPOJO userAccountVo,@Param("page")Page page);
    /**
     * 分页查询总记录数
     * @return
     */
    int countUserAccount(@Param("userAccountVo")UserAccountPOJO userAccountVo,@Param("page")Page page);
}