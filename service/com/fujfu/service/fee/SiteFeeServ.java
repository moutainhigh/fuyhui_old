package com.fujfu.service.fee;

import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.fee.SiteFeeVO;
import com.fujfu.pojo.fee.SiteFeeTypeVO;
import com.fujfu.pojo.fee.SiteFeeTypePOJO;
import com.fujfu.pojo.fee.SiteFeeDTO;

public interface SiteFeeServ {
	/**
	 * 添加费用
	 * @param siteFee
	 * @return
	 */
	public int addSiteFee(SiteFeeVO siteFee);
	
	/**
	 * 根据费用名查询费用
	 * @param feeName
	 * @return
	 */
	public SiteFeeVO findSiteFeeByFeeName(String feeName);
	
	/**
	 * 更新费用
	 * @param siteFee
	 * @return
	 */
	public int updateSiteFee(SiteFeeVO siteFee);
	
	/**
	 * 删除费用
	 * @return
	 */
	public int delSiteFee(int feeId);
	
	/**
	 * 分页列出所有费用
	 * @param page
	 * @return
	 */
	public Page listAllSiteFee(Page page);
	
	/**
	 * 列出所有费用
	 * @param page
	 * @return
	 */
	public List<SiteFeeVO> listAllSiteFee();
	/**
	 * 根据id查询费用信息
	 * @param feeId
	 * @return
	 */
	public SiteFeeVO findSiteFeeById(int feeId);
	/**>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	/**
	 * 判断是否已存在该费用
	 * @param feeName
	 * @return
	 */
	public boolean isContainFeeName(String feeName);
	
	/**
	 * 根据产品名、费用名、用户类型返回收费方式及费用
	 * @param productName
	 * @param feeName
	 * @param userType
	 * @return
	 */
	public SiteFeeTypePOJO queryChageMode(String chargeItem,String feeName,String userType);
	
	
	/**
	 * 根据产品名、费用名、用户类型判断是否已存在该收费方式
	 * @param productName
	 * @param feeName
	 * @param userType
	 * @return
	 */
	public boolean isContainFeeChargeMode(String chargeItem,int chargeFeeId,String userType);
	
	/**
	 * 列出所有
	 * @param page
	 * @return
	 */
	public Page listAllSiteFeeTypeVo(Page page);
	/**
	 * 添加收费
	 * @param siteFee
	 * @return
	 */
	public int addSiteFeeType(SiteFeeTypeVO siteFeeType);
	
	/**
	 * 更新收费
	 * @param siteFee
	 * @return
	 */
	public int updateSiteFeeType(SiteFeeTypeVO siteFeeType);
	
	/**
	 * 删除收费
	 * @return
	 */
	public int delSiteFeeType(int chargeTypeId);
	/**
	 * 根据id查询收费信息
	 * @param feeId
	 * @return
	 */
	public SiteFeeTypeVO findSiteFeeTypeById(int chargeTypeId);
	
	public List<SiteFeeTypeVO> listAllSiteFeeTypeByVo(SiteFeeDTO siteQueryVo);

	
	
}
