package com.fujfu.service.gat.impl;



import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fujfu.common.payment.fuyou.pojo.UserRegBean;
import com.fujfu.common.payment.fuyou.pojo.response.UserRegResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.FyReturnCode;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.dao.gat.GatApproveMapper;
import com.fujfu.pojo.gat.GatApproveVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.gat.GatApproveSer;
import com.fujfu.service.user.UserFyMgtServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.service.util.MD5Utils;


/**author haungfeng 20170329*/
@Service("gatApproveSer")
public class GatApproveSerImpl implements GatApproveSer {
	
	private static Logger log = Logger.getLogger(GatApproveSerImpl.class);
	@Resource
	public GatApproveMapper gatApproveMapper;
	@Autowired
	private UserFyMgtServ fyMgtServ;	
	@Autowired
	private UserServ userServ;	
	
	

	@Override
	public int addGatApprove(GatApproveVO gatApprove) {
		// TODO Auto-generated method stub
		return gatApproveMapper.insertSelective(gatApprove);
	}
	/**
	 * 审批通过
	 * 1-成功。0，-1失败
	 * */
	@Override
	public String approvePass(String id) {
		// TODO Auto-generated method stub
		
		GatApproveVO gatApprove  = gatApproveMapper.selectByPrimaryKey(Integer.valueOf(id));
		if(gatApprove == null){
			return "审批记录不存在";
		}		
		UserVO user = userServ.getUserByMobile(gatApprove.getMobile());
		if(user == null){
			log.info("用户不存在");
			return "用户不存在";			
		}
		

		/**查询富有是否已存在该手机号*/
		/*QueryUserInfoBean queryUserInfoBean = new QueryUserInfoBean();
		QueryUserInfoResp queryUserInfoResp = new QueryUserInfoResp();
		queryUserInfoBean.setUser_ids(gatApprove.getMobile());
		queryUserInfoResp = fyMgtServ.queryUserInfo(queryUserInfoBean);
		String queryUserInfoRespCode = queryUserInfoResp.getResponse().getResp_code();
		queryUserInfoResp = queryUserInfoResp.getResponse().getRespList().get(0);
		if (!"0000".equals(queryUserInfoRespCode)){
			log.info("查询失败");
			return "查询富友信息失败";
		}
		
		
		if(!"".equals(queryUserInfoResp.getMobile_no())){
			log.info("港澳台注册开户,用户在富友已开户");
			return "港澳台注册开户,用户在富友已开户";
		}
		
		if(queryUserInfoResp.getMobile_no() == null){
			log.info("港澳台注册开户,用户在富友已开户");
			return "港澳台注册开户,用户在富友已开户";
		}*/
		
		//调用富有开户
		UserRegBean reqData = new UserRegBean();
		UserRegResp respData = null;
		String dateStr = DateUtil.getCurrentDate("yyyyMMddHHmmss") + UserAccountUtil.getManyNumber(4);
		
		reqData.setMchnt_txn_ssn(dateStr);		
		
		reqData.setMchnt_txn_ssn(dateStr);// 根据表单提交的user组装reqData
		reqData.setMchnt_cd(FyUtil.MCHNT_CD);// 商户代码
		reqData.setCust_nm(gatApprove.getRealname());// 客户名称
		if ("1".equals(gatApprove.getCardId())) {
			reqData.setCertif_tp("0");// 证件类型
		} else {
			reqData.setCertif_tp("7");// 证件类型
		}
		reqData.setCertif_id(gatApprove.getCardId());// 身份证号码
		reqData.setMobile_no(gatApprove.getMobile());// 证件号码
		// reqData.setEmail(user.getEmail());//邮箱
		reqData.setCity_id(String.valueOf(gatApprove.getCity()));// 开户行地区代码
		reqData.setParent_bank_id(gatApprove.getBank());// 开户行行别
		// reqData.setBank_nm("");//开户行支行名称
		reqData.setCapAcntNo(gatApprove.getCardNumber());// 帐号
		reqData.setPassword(MD5Utils.MD5Encrypt(gatApprove.getCashPassword()));

		// reqData.setPassword("123456");//提现密码，不填默认为手机号后6位
		// reqData.setLpassword("123456");//登录密码，不填默认为手机号后6位
		reqData.setRem("");// 备注
		// 富友注册
		try {
			respData = fyMgtServ.userRegister(reqData);
		} catch (Exception e) {
			log.info("港澳台注册开户 异常"+e.toString());
			return "港澳台注册开户 异常";
		}
		String respCode = respData.getResponse().getResp_code();
		log.info("港澳台注册开户resp code = " + respCode);// response code = 0000表示成功
		
		if (!"0000".equals(respCode)){
			log.info("港澳台注册开户失败resp code = " + respCode);// response code = 0000表示成功
			return  FyReturnCode.codeType.get(respCode);
		}
		
		/*更新审批表*/
		//审批状态
		gatApprove.setApproveStatus("2");
		//修改时间
		gatApprove.setUpdated(DateUtil.getUnixTime());
		gatApproveMapper.updateByPrimaryKeySelective(gatApprove);		
		
		
		//证件类型
		user.setCardType(gatApprove.getCardType());
        //证件号码
		user.setCardId(gatApprove.getCardId());
		//真实姓名
		user.setRealname(gatApprove.getRealname());
	    //保存金账户ID
		// 金账户的登录id 此时是手机号码
		user.setJzhloginid(gatApprove.getMobile());	
		//省份
		user.setCountry_id(String.valueOf(gatApprove.getProvince()));
		
		//城市
		user.setCity_id(String.valueOf(gatApprove.getCity()));
		//银行卡号
		user.setCapAcntNo(gatApprove.getCardNumber());
		//银行编码
		user.setParent_bank_id(gatApprove.getBank());
		user.setBankCardPic(gatApprove.getBankCardPic());
		user.setCardPic(gatApprove.getCardIdPic());
		user.setIsInside(0);
		//会员状态？？？
		userServ.updateUser(user);
		
		
		return "1";
	}

	@Override
	/**
	 * 审批失败
	 * 1-成功。0，-1失败
	 * */
	public String approveFail(String id) {

		GatApproveVO gatApprove  = gatApproveMapper.selectByPrimaryKey(Integer.valueOf(id));
		
		if(gatApprove == null){
			return "记录不存在";
		}
		
		//审批状态
		gatApprove.setApproveStatus("3");
		//修改时间
		gatApprove.setUpdated(DateUtil.getUnixTime());
		int i =gatApproveMapper.updateByPrimaryKeySelective(gatApprove);
		if(i==1){
			return "1";
		}
		return "0";
	}
	@Override
	public int countGatApproveByStatus(GatApproveVO gatApprove) {
		// TODO Auto-generated method stub
		return gatApproveMapper.countGatApproveByStatus(gatApprove);
	}
	@Override
	public int countGatApproveByUserId(String userID) {
		// TODO Auto-generated method stub
		return gatApproveMapper.countGatApproveByUserId(userID);
	}
	
	
	
}
