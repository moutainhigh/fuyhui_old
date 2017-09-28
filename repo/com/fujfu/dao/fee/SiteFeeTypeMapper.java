package com.fujfu.dao.fee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.fee.SiteFeeTypeVO;
import com.fujfu.pojo.fee.SiteFeeTypePOJO;
import com.fujfu.pojo.fee.SiteFeeDTO;

public interface SiteFeeTypeMapper {
    int deleteByPrimaryKey(Integer chargeTypeId);

    int insertSelective(SiteFeeTypeVO record);

    SiteFeeTypeVO selectByPrimaryKey(Integer chargeTypeId);

    int updateByPrimaryKeySelective(SiteFeeTypeVO record);

    /**
     * 总记录数
     * @return
     */
	int countSiteFeeTypeVo();

	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
    List<SiteFeeTypePOJO> listAllSiteFeeTypeVo(@Param("page")Page page);
    
    List<SiteFeeTypeVO> listAllSiteFeeTypeByVo(@Param("siteQueryVo")SiteFeeDTO siteQueryVo);

    /**
     * 根据产品名、费用名、用户类型返回收费方式及费用
     * @param productName
     * @param feeName
     * @param userType
     * @return
     */
	SiteFeeTypePOJO queryChageMode(@Param("chargeItem")String chargeItem, @Param("feeName")String feeName, @Param("userType")String userType);
	
	/**
	 * 根据产品名、费用名、用户类型判断是否已存在该收费方式
	 * @param productName
	 * @param feeName
	 * @param userType
	 * @return
	 */
	int isContainFeeChargeMode(@Param("chargeItem")String chargeItem, @Param("chargeFeeId")int chargeFeeId, @Param("userType")String userType);
}