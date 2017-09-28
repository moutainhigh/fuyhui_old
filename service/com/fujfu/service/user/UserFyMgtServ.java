package com.fujfu.service.user;

import com.fujfu.common.payment.fuyou.pojo.ChangeCardBean;
import com.fujfu.common.payment.fuyou.pojo.ChangeMobileBean;
import com.fujfu.common.payment.fuyou.pojo.PasswordMgtBean;
import com.fujfu.common.payment.fuyou.pojo.QueryChgCardBean;
import com.fujfu.common.payment.fuyou.pojo.QueryUserInfoBean;
import com.fujfu.common.payment.fuyou.pojo.UserArtifRegBean;
import com.fujfu.common.payment.fuyou.pojo.UserRegBean;
import com.fujfu.common.payment.fuyou.pojo.response.QueryChgCardResp;
import com.fujfu.common.payment.fuyou.pojo.response.QueryUserInfoResp;
import com.fujfu.common.payment.fuyou.pojo.response.UserRegResp;

/** 
 * 用户富友服务接口类
 * @author huangjizhong
 * 
 */

public interface UserFyMgtServ {

	/** 用户注册2.0 
	 * @throws Exception */
	public UserRegResp userRegister(UserRegBean bean) throws Exception;
	
	/** 法人用户注册2.0 */
	public UserRegResp userArtifRegister(UserArtifRegBean reqData);
	
	/** 用户信息查询  */
	public QueryUserInfoResp queryUserInfo(QueryUserInfoBean reqData);
	
	/** 用户修改手机号  */
	public ChangeMobileBean changeMobile(ChangeMobileBean reqData);
	
	/** 用户密码管理  */
	public PasswordMgtBean passwordMgt(PasswordMgtBean reqData);
	
	/** 更换银行卡  */
	public ChangeCardBean changeCard(ChangeCardBean reqData);
	
	/** 查询更换银行卡  */
	public QueryChgCardResp queryChgCard(QueryChgCardBean reqData);


	
}
	
	
	
		