package com.fujfu.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.AuthCodeVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.pojo.user.UserPOJO;

public interface UserMapper {
	int deleteByPrimaryKey(UserVO key);

	int insertSelective(UserVO record);

	UserVO selectByPrimaryKey(UserVO key);

	int updateByPrimaryKeySelective(UserVO record);

	int updateByPrimaryKey(UserVO record);

	public void insertSmsCode(AuthCodeVO bean);

	public int checkUsername(String username);

	public int checkMobile(String mobile);

	public UserVO getUserByUserId(@Param(value = "userId") int userId);

	public UserVO userLogin(@Param(value = "username") String username, @Param(value = "password") String password);

	public int checkUserExist(String username);

	public int checkUserMatchMobile(@Param(value = "mobile") String mobile, @Param(value = "username") String username);

	public int updatePassword(UserVO bean);

	/**
	 * 更新用户信息
	 * 
	 * @param record
	 * @return
	 */
	int updateUserByUserIdSelective(UserVO record);

	/**
	 * 分页查询
	 * 
	 * @param page
	 * @return
	 */
	List<UserVO> findUser(@Param("userQueryVo") UserPOJO userQueryVo, @Param("page") Page page);

	/**
	 * 分页查询总记录数
	 * 
	 * @return
	 */
	int countUser(@Param("userQueryVo") UserPOJO userQueryVo, @Param("page") Page page);

	/**
	 * 查询出所有用户id
	 * 
	 * @return
	 */
	List<Integer> findAllUserId();

	/**
	 * 根据用户手机号查询用户信息
	 * 
	 * @param mobile
	 * @return
	 */
	UserVO getUserByMobile(@Param(value = "mobile") String mobile);

	/**
	 * 根据标的id查询用户信息
	 * 
	 * @param applyId
	 * @return
	 */
	List<UserVO> findInvestorByBidId(Long applyId);

	/**
	 * 根据用户类型获取用户
	 * @param userType
	 * @return
	 */
	List<UserVO> findUserByType(@Param("userType")String userType);
	
	int getCountByEmail(@Param("email")String email);
	//根据富友登录号查询用户信息
	List<UserVO>  getUserByjzhLoginId(@Param("jzhloginid")String jzhloginid);
	//开户时校验证件号是否已注册
	public int checkCardIdExist(@Param("cardType")String cardType,@Param("cardId")String cardId);
	//开户时校验企业名称是否已注册
	public int checkUserCorpNameExist(@Param("corpName")String corpName);
	//开户时校验银行卡号是否已注册
	public int checkUserActnoExist(@Param("capAcntNo")String capAcntNo);
}