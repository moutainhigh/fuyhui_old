package com.fujfu.service.focus;

import java.util.List;

import com.fujfu.common.util.tag.Page;

import com.fujfu.pojo.focus.FocusPicVO;
/**
 * 
 * 焦点图服务接口类
 * 
 * @author hjz
 *
 */
public interface FocusPicServ {
	
	/**
	 * 添加焦点图
	 * @param focusPic
	 * @return
	 */
	public int add(FocusPicVO focusPic);
	
	/**
	 * 更新焦点图
	 * @param focusPic
	 * @return
	 */
	public int update(FocusPicVO focusPic);
	
	/**
	 * 根据id获取焦点图
	 * @param focusPic
	 * @return
	 */
	public FocusPicVO getFocusPicById(Integer id);
	
	/**
	 * 根据显示设备获取焦点图
	 * @param focusPic
	 * @return
	 */
	public List<FocusPicVO> findBannerByDevice(Integer displayDevice);
	
	/**
	 * 查询焦点图
	 * @return
	 */
	public Page findFocusPicByCondition(FocusPicVO focusPic,Page page);
	
}
