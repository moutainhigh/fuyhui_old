package com.fujfu.service.user;

import java.util.List;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.pojo.user.UserPOJO;

public interface UserServ {
	/**
	 * 条件查询注册用户
	 * 
	 * @return
	 */
	public Page findUserByCondition(UserPOJO userQueryVo, Page page);

	/**
	 * 根据用户id查询用户信息
	 * 
	 * @return
	 */
	public UserVO getUserByUserId(int userId);

	/**
	 * 根据用户手机号查询用户信息
	 * 
	 * @param mobile
	 * @return
	 */
	public UserVO getUserByMobile(String mobile);

	/**
	 * 修改用户信息
	 * 
	 * @param userBean
	 * @return
	 */
	public int updateUser(UserVO userBean);
	
	/**
	 * 根据用户类型查询用户信息
	 * @param userType
	 * @return
	 */
	public List<UserVO> findUserByType(String userType);
	
	public int insertUser(UserVO userBean) ;
	
	public int getCountByEmail(String email);
	
	/** 检查用户名是否存在 */
	public int checkUsername(String username);
	
	//根据富友登录号查询用户信息
	List<UserVO>  getUserByjzhLoginId(String jzhloginid);
	//开户时校验证件号是否已注册
	public int checkCardIdExist(String cardType,String cardId);
	//开户时校验证件号是否已注册
	public int checkUserCorpNameExist(String corpName);
	//开户时校验银行卡号是否已注册
	public int checkUserActnoExist(String capAcntNo);
}
