package com.fujfu.service.fee.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.fee.SiteFeeMapper;
import com.fujfu.dao.fee.SiteFeeTypeMapper;
import com.fujfu.pojo.fee.SiteFeeVO;
import com.fujfu.pojo.fee.SiteFeeTypeVO;
import com.fujfu.pojo.fee.SiteFeeTypePOJO;
import com.fujfu.pojo.fee.SiteFeeDTO;
import com.fujfu.service.fee.SiteFeeServ;
@Service("siteFeeSer")
public class SiteFeeSerImpl implements SiteFeeServ {
	@Resource
	public SiteFeeMapper siteFeeMapper;
	@Resource
	public SiteFeeTypeMapper siteFeeTypeMapper;
	@Override
	public int addSiteFee(SiteFeeVO siteFee) {
		return siteFeeMapper.insertSelective(siteFee);
	}

	@Override
	public int updateSiteFee(SiteFeeVO siteFee) {
		return siteFeeMapper.updateByPrimaryKeySelective(siteFee);
	}

	@Override
	public int delSiteFee(int feeId) {
		return siteFeeMapper.deleteByPrimaryKey(feeId);
	}

	@Override
	public Page listAllSiteFee(Page page) {
		page.setTotalCount(siteFeeMapper.countSiteFee());
		page.setItems(siteFeeMapper.listAllSiteFeeByPage(page));
		return page;
	}

	@Override
	public SiteFeeVO findSiteFeeById(int feeId) {
		return siteFeeMapper.selectByPrimaryKey(feeId);
	}

	@Override
	public Page listAllSiteFeeTypeVo(Page page) {
		page.setTotalCount(siteFeeTypeMapper.countSiteFeeTypeVo());
		page.setItems(siteFeeTypeMapper.listAllSiteFeeTypeVo(page));
		return page;
	}

	@Override
	public List<SiteFeeVO> listAllSiteFee() {
		return siteFeeMapper.listAllSiteFee();
	}

	@Override
	public int addSiteFeeType(SiteFeeTypeVO siteFeeType) {
		return siteFeeTypeMapper.insertSelective(siteFeeType);
	}

	@Override
	public int updateSiteFeeType(SiteFeeTypeVO siteFeeType) {
		return siteFeeTypeMapper.updateByPrimaryKeySelective(siteFeeType);
	}

	@Override
	public int delSiteFeeType(int chargeTypeId) {
		return siteFeeTypeMapper.deleteByPrimaryKey(chargeTypeId);
	}

	@Override
	public SiteFeeTypeVO findSiteFeeTypeById(int chargeTypeId) {
		return siteFeeTypeMapper.selectByPrimaryKey(chargeTypeId);
	}

	@Override
	public List<SiteFeeTypeVO> listAllSiteFeeTypeByVo(SiteFeeDTO siteQueryVo) {
		return siteFeeTypeMapper.listAllSiteFeeTypeByVo(siteQueryVo);
	}

	@Override
	public boolean isContainFeeName(String feeName) {
		if(siteFeeMapper.countSiteFeeByName(feeName)>0){
			return true;
		}
		return false;
	}

	@Override
	public SiteFeeTypePOJO queryChageMode(String chargeItem, String feeName, String userType) {
		return siteFeeTypeMapper.queryChageMode(chargeItem,feeName,userType);
	}

	@Override
	public boolean isContainFeeChargeMode(String chargeItem,int chargeFeeId,String userType) {
		if(siteFeeTypeMapper.isContainFeeChargeMode(chargeItem,chargeFeeId,userType)>0){
			return true;
		}
		return false;
	}

	@Override
	public SiteFeeVO findSiteFeeByFeeName(String feeName) {
		return siteFeeMapper.findSiteFeeByFeeName(feeName);
	}
	

}
