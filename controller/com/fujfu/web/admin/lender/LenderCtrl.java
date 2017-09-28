package com.fujfu.web.admin.lender;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.fee.FixedLoanInrestSubVo;
import com.fujfu.common.fee.FixedLoanInrestUtil;
import com.fujfu.common.fee.FixedLoanInrestVo;
import com.fujfu.common.payment.fuyou.CapitalMgt;
import com.fujfu.common.payment.fuyou.pojo.CapitalUnFreezeBean;
import com.fujfu.common.payment.fuyou.pojo.TransBmuBean;
import com.fujfu.common.payment.fuyou.pojo.TransBuFreeze2FreezeBean;
import com.fujfu.common.payment.fuyou.pojo.response.CapitalUnFreezeResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBmuResp;
import com.fujfu.common.payment.fuyou.pojo.response.TransBuFreeze2FreezeResp;
import com.fujfu.common.payment.fuyou.util.FyUtil;
import com.fujfu.common.util.CreContrPdf;
import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.PDFUtil;
import com.fujfu.common.util.SmsTypeUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.dao.loan.LoanApplyMapper;
import com.fujfu.pojo.account.SiteAccountLogVO;
import com.fujfu.pojo.account.SiteAccountVO;
import com.fujfu.pojo.account.UserAccountLogVO;
import com.fujfu.pojo.account.UserAccountVO;
import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.apply.ApplyRepayVO;
import com.fujfu.pojo.invest.LoanInvestmentVO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.loan.LoanTypeVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.account.SiteAccountLogServ;
import com.fujfu.service.account.SiteAccountServ;
import com.fujfu.service.account.SiteBillingServ;
import com.fujfu.service.account.UserAccountLogServ;
import com.fujfu.service.account.UserAccountServ;
import com.fujfu.service.common.CommonServ;
import com.fujfu.service.fee.SiteFeeServ;
import com.fujfu.service.invest.LoanInvestmentServ;
import com.fujfu.service.lender.LenderServ;
import com.fujfu.service.lender.impl.LenderServImpl;
import com.fujfu.service.loan.LoanApplyServ;
import com.fujfu.service.loan.LoanTypeServ;
import com.fujfu.service.recommend.RecommendSer;
import com.fujfu.service.recover.RecoverServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;
import com.fujfu.web.constant.FeeProperties;

@Controller
@RequestMapping("/lender/")
public class LenderCtrl extends BaseController {
	private static final long serialVersionUID = 1L;

	@Resource
	private LenderServ lenderServ;
	@Resource
	private LoanApplyServ loanApplyServ;
	@Resource
	private UserServ userServ;
	@Resource
	private LoanInvestmentServ loanInvestmentServ;
	@Resource
	private UserAccountServ userAccountServ;
	@Resource
	private SiteFeeServ siteFeeServ;
	@Resource
	private UserAccountLogServ userAccountLogServ;
	@Resource
	private SiteAccountLogServ siteAccountLogServ;
	@Resource
	private SiteAccountServ siteAccountServ;
	@Resource
	private CommonServ commonServ;
	@Resource
	private RecoverServ recoverServ;
	@Resource
	private LoanTypeServ loanTypeServ;
	@Resource
	private RecommendSer recommendSer;
	@Resource
	private SiteBillingServ siteBillingServ;
	@Resource
	private LoanApplyMapper loanApplyMapper;
	private static Logger log = Logger.getLogger(LenderServImpl.class);

	/**
	 * 列出满标且审核通过的标的
	 * 
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping("fullLenderList")
	public String fullLenderList(Page page,Model model) {
		LoanPOJO loan = new LoanPOJO();
		loan.setStatus("8");
		Page fullLenderList = loanApplyServ.findLoanByCondition(loan, page);
		model.addAttribute("fullLenderList", fullLenderList);
		return "views/admin/loan/loanApplyFull.jsp";
	}
	
	/**
	 * 列出已放款的标（用来签署合同）
	 * 
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping("signContractList")
	public String signContractList(Page page,Model model) {
		LoanPOJO loan = new LoanPOJO();
		loan.setStatus("A");
		loan.setIsCreatctra("0");
		Page signContractList = loanApplyServ.findLoanByCondition(loan, page);
		model.addAttribute("signContractList", signContractList);
		return "views/admin/loan/loanApplyCtract.jsp";
	}
	/**
	 * 签署合同
	 * 
	 * @param model
	 * @return
	 * 
	 */
	@RequestMapping("signContract")
	public String signContract(Model model, String applyId,HttpServletRequest request) {
		//标的编号
		Integer iid = Integer.parseInt(applyId);
		//根据标的编号查出标的信息
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(iid);		
		// 根据用户id查询出用户信息
		UserVO lender = userServ.getUserByUserId(loanApply.getUserId());
		//根据标的放款日期生成文件夹
		String path=PDFUtil.getContrUrl(loanApply, request);
		// 根据标的id查出该标的的每个用户的所有投资情况
		List<LoanInvestmentVO> investList = loanInvestmentServ.findInvestGroupByUserid(iid);
		int i =0;
		for(LoanInvestmentVO invest : investList){		
		  UserVO investuser =userServ.getUserByUserId(invest.getUserId());//投资人
		  String filename =loanApply.getOrderNumber()+investuser.getUserId().toString()+".pdf";//生成PDF文件名
		  if(!PDFUtil.checkFile1(path+File.separator+filename)){//如果文件不存在，则代表未生成合同，继续生成合同
			  //生成PDF文件
			  //查询出回款计划（合并相同用户同期数据）
			  List<ApplyRecoverVO> ApplyRecoverList = recoverServ.findRecoverGroupByUserid(iid, investuser.getUserId());
			  //查询产品类
			  LoanTypeVO loanType=loanTypeServ.findLoanTypeById(loanApply.getLoanType());
			  CreContrPdf creContrPdf = new CreContrPdf();
			  try {
				  
				  if(loanApply.getLoanType() == 51){
					  creContrPdf.writePdf3(path+File.separator+filename,loanType.getName(),loanApply,investuser,lender,invest,ApplyRecoverList);	
				  } else {
					  creContrPdf.writePdf2(path+File.separator+filename,loanType.getName(),loanApply,investuser,lender,invest,ApplyRecoverList);	
				  }
			  } catch (Exception e) {
				// TODO Auto-generated catch block
				 e.printStackTrace();
			  }
			  i++;
		  }else{
			  i++;
			  System.out.println("投资人已生成合同"+loanApply.getOrderNumber()+investuser.getUserId().toString());
			  log.info("投资人已生成合同"+loanApply.getOrderNumber()+investuser.getUserId().toString());
			  
		  }
		  
		}
		//更新合同状态字段
		if(i==investList.size()){
			LoanApplyVO loanApply1= new LoanApplyVO();
			loanApply1.setId(loanApply.getId());
			loanApply1.setIsCreatctra("1");
			loanApplyServ.updateLoanApply(loanApply1);
		}
		return "redirect:/lender/signContractList";
		
		
	}

	/**
	 * 放款
	 * 
	 * @param model
	 * @param applyId
	 */
	@RequestMapping("lending")
	public String lending(Model model, String applyId) {
		// applyId转int型
		Integer iid = Integer.parseInt(applyId);
		// 根据标的id查询出该标的的信息
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(iid);
		// 从标的信息中取出借款人id
		int lenderId = loanApply.getUserId();
		// 根据用户id查询出用户信息
		UserVO lender = userServ.getUserByUserId(lenderId);
		// 从用户信息中取出借款人金账户账号
		String ljzhId = lender.getJzhloginid();
		// 根据标的id查出该标的的每笔投资情况
		List<LoanInvestmentVO> investList = loanInvestmentServ.findInvestByApplyId(iid);
		
		
		if(DateUtil.getUnixTime() >= loanApply.getDueTime()) {
			model.addAttribute("msg", "到期不起不可小于等于放款日！");
			return "redirect:/lender/fullLenderList";			
		}
		
		boolean gloanFlg = true;
		// 对投资集合进行循环
		for (LoanInvestmentVO invest : investList) {
			// 对投资记录中未放款的记录进行放款
			if (invest.getIsLoans() == 0) {
				// 从每笔投资信息中取出投资人用户id
				int investmentUserId = invest.getUserId();
				// 根据用户id查询投资人用户信息
				UserVO user = userServ.getUserByUserId(investmentUserId);
				// 从投资人用户信息中取出投资人金账户账号
				String jzhId = user.getJzhloginid();
				// 从每笔投资信息中取出投资金额
				BigDecimal money = invest.getMoney();
				// 转账金额,已分为单位(首先取小数点后面两位，然后再乘100，再转为整型)
				int transferAmt = (money.setScale(2, BigDecimal.ROUND_HALF_UP)).multiply(new BigDecimal(100))
						.intValue();
				TransBuFreeze2FreezeBean reqData = new TransBuFreeze2FreezeBean();
				// 付款登录账户
				reqData.setOut_cust_no(jzhId);
				// 收款登录账户
				reqData.setIn_cust_no(ljzhId);
				// 转账金额
				reqData.setAmt(String.valueOf(transferAmt));
				// 进行转账操作,调用冻结到冻结接口
				TransBuFreeze2FreezeResp transBuFreeze2FreezeResp = null;
				try {
					transBuFreeze2FreezeResp = CapitalMgt.freeze2freeze(reqData, user, lender, "放款冻结到冻结", loanApply.getOrderNumber());
				} catch (Exception e) {
					log.info("系统异常！流水号：" + reqData.getMchnt_txn_ssn() + ",投资编号：" + invest.getId());
					e.printStackTrace();
				}
				if (transBuFreeze2FreezeResp != null) {
					// 若转账成功
					if (FyUtil.SUCCESS.equals(transBuFreeze2FreezeResp.getResponse().getResp_code())) {
						//冻结到冻结操作成功修改 对账表信息
						siteBillingServ.updateBusiStatus(0, transBuFreeze2FreezeResp.getResponse().getMchnt_txn_ssn());
						log.info("冻结到冻结转账成功！流水号：" + reqData.getMchnt_txn_ssn() + ",投资编号：" + invest.getId());
						// 更新用户账户
						updateUserAccount(user);
						log.info("更新投资人" + user.getUserId() + "账户信息成功");
						// 更新投资记录表该条投资记录已放款
						invest.setIsLoans(1);
						loanInvestmentServ.updateInvest(invest);
						log.info("更改投资记录" + invest.getId() + "为已放款");
						// 记录投资人投资成功记录
						UserAccountVO userAccount = userAccountServ.selectByUserId(user.getUserId());// 查询本地账户信息
						UserAccountLogVO userAccountLog = new UserAccountLogVO();
						userAccountLog.setUserId(user.getUserId());
						userAccountLog.setType(4202);
						userAccountLog.setMoney(money.setScale(2, BigDecimal.ROUND_HALF_UP));
						userAccountLog.setTotal(userAccount.getTotal());
						userAccountLog.setFrost(userAccount.getFrost());
						userAccountLog.setCash(userAccount.getCash());
						userAccountLog.setAddTime(DateUtil.getUnixTime());
						userAccountLog.setApplyId(iid);
						userAccountLog.setBusiNumber(iid.toString());
						// userAccountLog.setFrom();
						// userAccountLog.setTo();
						userAccountLog.setMemo(loanApply.getName());
						userAccountLogServ.insertSelective(userAccountLog);
						commonServ.sendall(user.getMobile(), SmsTypeUtil.P2P_PUTOUT_SUC_INV, DateUtil.timeMillisToStr(invest.getInvestTime(),"yyyy-MM-dd"), loanApply.getName(),"","");
						log.info("添加投资成功记录" + userAccountLog);
					}else{
						// 冻结到冻结操作失败修改 对账表信息
						siteBillingServ.updateBusiStatus(1, transBuFreeze2FreezeResp.getResponse().getMchnt_txn_ssn());
						log.info("冻结到冻结操作失败！流水号：" + reqData.getMchnt_txn_ssn() + ",投资编号：" + invest.getId());
						gloanFlg = false;
						continue;
						
					}
				} else {
					log.info("接口请求失败！流水号：" + reqData.getMchnt_txn_ssn() + ",投资编号：" + invest.getId());
					gloanFlg = false;
					continue;
				}
			}
		}
		// 更新借款人用户账户表
		updateUserAccount(lender);
		loanApply.setLoanTime(DateUtil.getUnixTime());
		
		//生成回款还款计划
		if(gloanFlg){
			this.generatePayAndRecoverPlan(loanApply);
			//更新实际投资期限	
		}

		if (loanInvestmentServ.isLoansByApplyId(iid)) {
			int period =  DateUtil.getTimeDifference(loanApply.getLoanTime(), loanApply.getDueTime());	
			loanApply.setPeriod(period);	
			loanApply.setActPeriod(period);
			loanApply.setIsLoans((byte) 1);
			loanApplyServ.updateLoanApply(loanApply);
			
			//放款成功发送站内信
			commonServ.sendall(lender.getMobile(), SmsTypeUtil.P2P_PUTOUT_SUC_LOAN, DateUtil.timeMillisToStr(loanApply.getCreated(),"yyyy-MM-dd"), loanApply.getName(),"","");

			model.addAttribute("msg", "放款成功！");
		} else {
			model.addAttribute("msg", "有部分款未放成功,请联系技术进行核实！");
		}
		
		return "redirect:/lender/fullLenderList";
	}

	/**
	 * 解冻
	 * 
	 * @param model
	 * @param applyId
	 */
	@RequestMapping("freezing")
	public String freezing(Model model, String applyId) {
		// applyId转int型
		Integer iid = Integer.parseInt(applyId);
		// 根据标的id查询出该标的的信息
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(iid);
		//判断是否已经生成合同，未生产合同则不许解冻
		if("0".equals(loanApply.getIsCreatctra())){
			model.addAttribute("msg", "未生成合同！请先生成合同再进行解冻");
			return "redirect:/lender/fullLenderList";
		}
		// 从标的信息中取出借款金额
		BigDecimal amount = loanApply.getAmount();
		// 从标的信息中取出借款人id
		int lenderId = loanApply.getUserId();
		// 根据用户id查出用户信息，从用户信息中取出借款人账户
		UserVO lender = userServ.getUserByUserId(lenderId);
		String jzhId = lender.getJzhloginid();
		// 服务费计算
		/*SiteFeeTypePOJO siteFeeTypeVo = siteFeeServ.queryChageMode(loanApply.getLoanType() + "", "融资服务费",
				lender.getUserType());*/
		// 融资服务费
		BigDecimal successFee = new BigDecimal(0);
		BigDecimal serviceCharge = new BigDecimal(0);
		boolean isServiceCharge = false;
		/*if (siteFeeTypeVo != null && siteFeeTypeVo.getFormulaType() == 1) {
			isServiceCharge = true;
			// 比例
			successFee = siteFeeTypeVo.getInterestRate().divide(new BigDecimal(100),4,BigDecimal.ROUND_HALF_UP);
			serviceCharge = amount.multiply(successFee).setScale(2, BigDecimal.ROUND_HALF_UP);
		}*/
		if(loanApply.getFinanceServiceFee()!=null){
			isServiceCharge = true;
			// 费率/100/365
			successFee = new BigDecimal(loanApply.getFinanceServiceFee()).divide(new BigDecimal(36500),8,BigDecimal.ROUND_HALF_UP);
			// 融资服务费*实际借款天数
			serviceCharge = amount.multiply(successFee).multiply(new BigDecimal(loanApply.getActPeriod())).setScale(2, BigDecimal.ROUND_HALF_UP);
		}else{
			model.addAttribute("msg", "未配置融资服务费比例！请先进行配置！");
			return "redirect:/lender/fullLenderList";
		}
		
		// isLoans状态为1时进行解冻
		if (loanApply.getIsLoans() == 1) {
			// 解冻
			CapitalUnFreezeBean capitalUnFreezeBean = new CapitalUnFreezeBean();
			capitalUnFreezeBean.setRem("00解冻00");
			// 解冻目标登录账户
			capitalUnFreezeBean.setCust_no(jzhId);
			// 解冻金额
			capitalUnFreezeBean.setAmt(String
					.valueOf(amount.setScale(2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).intValue()));
			CapitalUnFreezeResp capitalUnFreezeResp = null;
			try {
				capitalUnFreezeResp = CapitalMgt.capitalUnFreeze(capitalUnFreezeBean, null, lender, "放款解冻", loanApply.getOrderNumber());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (capitalUnFreezeResp != null) {
				if (FyUtil.SUCCESS.equals(capitalUnFreezeResp.getResponse().getResp_code())) {
					// 转账成功修改 对账表信息
					siteBillingServ.updateBusiStatus(0, capitalUnFreezeResp.getResponse().getMchnt_txn_ssn());
					log.info("解冻成功");
					loanApply.setIsLoans((byte) 2);
					loanApplyServ.updateLoanApply(loanApply);
					
					// 更新借款人用户账户表
					updateUserAccount(lender);
					// 记录借款成功
					UserAccountVO userAccount = userAccountServ.selectByUserId(lenderId);// 查询本地账户信息
					// 借款成功记录
					UserAccountLogVO userAccountLog = new UserAccountLogVO();
					userAccountLog.setUserId(lenderId);
					userAccountLog.setType(4301);
					userAccountLog.setMoney(loanApply.getAmount());
					userAccountLog.setTotal(userAccount.getTotal());
					userAccountLog.setFrost(userAccount.getFrost());
					userAccountLog.setCash(userAccount.getCash());
					userAccountLog.setAddTime(DateUtil.getUnixTime());
					userAccountLog.setApplyId(loanApply.getId());
					// userAccountLog.setFrom();
					userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
					userAccountLog.setMemo(loanApply.getName());
					userAccountLog.setBusiNumber(loanApply.getOrderNumber());
					userAccountLogServ.insertSelective(userAccountLog);
					
				} else {
					// 转账失败修改 对账表信息
					siteBillingServ.updateBusiStatus(1, capitalUnFreezeResp.getResponse().getMchnt_txn_ssn());
					model.addAttribute("msg", "解冻失败，请联系技术进行核实！");
					return "redirect:/lender/fullLenderList";
				}

			} else {
				model.addAttribute("msg", "解冻接口请求失败，请重新解冻！");
				return "redirect:/lender/fullLenderList";
			}
			
			// 收取融资服务费
			if (isServiceCharge && serviceCharge.compareTo(BigDecimal.ZERO)>0) {
				loanApply = loanApplyServ.selectByPrimaryKey(iid);
				if (loanApply.getIsLoans() == 2) {
					int result = getSerFee(loanApply, serviceCharge,lenderId);
					if (result == 0) {
						model.addAttribute("msg", "转账接口请求失败，请联系技术进行核实！");
						return "redirect:/lender/fullLenderList";
					}
					if (result == 1) {
						model.addAttribute("msg", "融资服务费扣取失败，请联系技术进行核实！");
						return "redirect:/lender/fullLenderList";
					}
					if (result == 2) {
						model.addAttribute("msg", "解冻成功");
						return "redirect:/lender/fullLenderList";
					}
				}
			} else {
				// 将标的状态改为已放款,将借款时间改为当前时间
				LoanApplyVO loan = new LoanApplyVO();
				int currentTime = DateUtil.getUnixTime();
				loan.setId(loanApply.getId());
				loan.setIsLoans((byte) 3);
				loan.setLoanTime(currentTime);
				loan.setStatus((byte) 9);
				int loanResult = loanApplyServ.updateLoanApply(loan);
				if (loanResult > 0) {
					log.info("更改标的状态成功");
				}
			}
		}
		// 解冻成功，但转账未成功时候进行处理
		if (loanApply.getIsLoans() == 2 && serviceCharge.compareTo(BigDecimal.ZERO)>0) {
			int result = getSerFee(loanApply, serviceCharge,lenderId);
			if (result == 0) {
				model.addAttribute("msg", "转账接口请求失败，请联系技术进行核实！");
				return "redirect:/lender/fullLenderList";
			}
			if (result == 1) {
				model.addAttribute("msg", "融资服务费扣取失败，请联系技术进行核实！");
				return "redirect:/lender/fullLenderList";
			}
			if (result == 2) {
				model.addAttribute("msg", "解冻成功");
				return "redirect:/lender/fullLenderList";
			}
		}
		
		model.addAttribute("msg", "解冻成功");
		return "redirect:/lender/fullLenderList";
	}

	/**
	 * 0 请求转账接口失败 1 转账失败 2 转账成功
	 * 
	 * @param loanApply
	 * @param serviceCharge
	 * @return
	 */
	private int getSerFee(LoanApplyVO loanApply, BigDecimal serviceCharge,int lenderId) {
		// 根据借款人id查出借款人信息
		UserVO lender = userServ.getUserByUserId(lenderId);
		String jzhId = lender.getJzhloginid();

		// 解冻成功之后进行划款操作
		// 投资人投资的钱全部转到借款人账户之后，收取服务费到平台账户
		TransBmuBean reqData = new TransBmuBean();
		// 付款登录账户
		reqData.setOut_cust_no(jzhId);
		// 平台账户
		reqData.setIn_cust_no(FyUtil.MCHNT_USER_ID);
		// 转账金额(即服务费)
		reqData.setAmt(String.valueOf(serviceCharge.multiply(new BigDecimal(100)).intValue()));
		// 进行转账操作,调用冻结到冻结接口
		TransBmuResp transBmuResp = null;
		try {
			transBmuResp = CapitalMgt.transferBmu(reqData, lender, null, "融资服务费", loanApply.getOrderNumber());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (transBmuResp != null) {
			// 若转账成功
			if (FyUtil.SUCCESS.equals(transBmuResp.getResponse().getResp_code())) {
				
				log.info("划款成功");
				// 转账成功修改 对账表信息
				siteBillingServ.updateBusiStatus(0, transBmuResp.getResponse().getMchnt_txn_ssn());
				loanApply.setIsLoans((byte) 3);
				loanApplyServ.updateLoanApply(loanApply);
				// 将标的状态改为已放款,将借款时间改为当前时间
				LoanApplyVO loan = new LoanApplyVO();
				int currentTime = DateUtil.getUnixTime();
				loan.setId(loanApply.getId());
				loan.setLoanTime(currentTime);
				loan.setStatus((byte) 9);
				int loanResult = loanApplyServ.updateLoanApply(loan);
				if (loanResult > 0) {
					log.info("更改标的状态成功");
				}
				// 更新借款人用户账户表
				updateUserAccount(lender);

				// 融资服务费记录
				UserAccountVO userAccount = userAccountServ.selectByUserId(lenderId);// 查询本地账户信息
				UserAccountLogVO userAccountLog = new UserAccountLogVO();
				userAccountLog.setUserId(lenderId);
				userAccountLog.setType(4302);
				userAccountLog.setMoney(serviceCharge);
				userAccountLog.setTotal(userAccount.getTotal());
				userAccountLog.setFrost(userAccount.getFrost());
				userAccountLog.setCash(userAccount.getCash());
				userAccountLog.setAddTime(DateUtil.getUnixTime());
				userAccountLog.setApplyId(loanApply.getId());
				// userAccountLog.setFrom();			
				//生成投资服务费编号						
				String oldMaxBusiNumber = userAccountLogServ.findMaxBusiNumber("RZF" + DateUtil.getCurrentDate("yyyyMMdd"));
				log.info("oldMaxBusiNumber==" + oldMaxBusiNumber);
				String	busiNumber = UserAccountUtil.getBusiNumber(oldMaxBusiNumber,"RZF");						
				log.info("busiNumber==" + busiNumber	);
				userAccountLog.setBusiNumber(busiNumber);
				userAccountLog.setTo(FyUtil.MCHNT_USER_ID);
				userAccountLog.setMemo(loanApply.getName());
				userAccountLogServ.insertSelective(userAccountLog);
				
				// 平台收益记录
				SiteAccountLogVO siteAccountLog = new SiteAccountLogVO();
				siteAccountLog.setFeeId(siteFeeServ.queryChageMode(null,"融资服务费",null).getChargeFeeId());
				siteAccountLog.setUserId(lenderId);
				siteAccountLog.setMoney(serviceCharge);
				siteAccountLog.setCreated(DateUtil.getUnixTime());
				siteAccountLogServ.addSiteAccountLog(siteAccountLog);
				// 总收益更新
				SiteAccountVO siteAccount = siteAccountServ.findSiteAccountByFeeName("融资服务费");
				siteAccount.setIncome(siteAccount.getIncome().add(serviceCharge));
				siteAccountServ.updateSiteAccount(siteAccount);
			} else {
				// 转账失败修改 对账表信息
				siteBillingServ.updateBusiStatus(1, transBmuResp.getResponse().getMchnt_txn_ssn());
				return 1;
			}
		} else {
			return 0;
		}
		return 2;
	}
	
	
//	@RequestMapping("recoverTest")
//	public void recoverRepayAndRecoverPlan() {
//		List<LoanApplyVO> loanApplyList = loanApplyMapper.findErrorApply();
//		for(LoanApplyVO loanApply : loanApplyList) {
//			generatePayAndRecoverPlan(loanApply);
//		}
//	}
	
	
	
	/**
	 * 生成回款计划
	 * 
	 * 
	 */		

	public void generatePayAndRecoverPlan(LoanApplyVO loanApply){
		// 从标的信息中取出借款金额
		BigDecimal amount = loanApply.getAmount();
		// 还款方式
		int paymentOptions = loanApply.getPaymentOptions();
		// 年利率
		Double apr = Double.parseDouble(String.valueOf(loanApply.getApr()));
		// 还款计划
		ApplyRepayVO applyRepay = new ApplyRepayVO();
		// 回款计划
		ApplyRecoverVO applyRecover = new ApplyRecoverVO();
		// 根据标的id查出该标的的每笔投资情况
		List<LoanInvestmentVO> investList = loanInvestmentServ.findInvestSumByApplyId(loanApply.getId());
		// 生成还款计划表
		// 还款用户id和标的id每条还款计划记录都一样
		// 借款人用户id
		applyRepay.setUserId(loanApply.getUserId());
		// 还款标的id
		applyRepay.setApplyId(loanApply.getId());
		applyRecover.setApplyId(loanApply.getId());
//		   put(1,"按月结息，到期还本");
//		   put(2,"一次性还本息");
//		   put(3,"等额本息");
//		   put(4,"等额本金");
		if (paymentOptions == 1 || paymentOptions == 2 || paymentOptions == 5){//一次性还本息，按月结息到期还本，按季结息到期还本
			// 生成还款计划表
			FixedLoanInrestVo fixedLoanInrestVo  = new FixedLoanInrestVo();
			//起始日期（yyyyMMdd）
			String startDate = DateUtil.timeMillisToStr(loanApply.getLoanTime(), "yyyyMMdd");
			fixedLoanInrestVo.setStartDate(startDate);
			// 结束日期（yyyyMMdd）
			//结束日期
			String endDate = DateUtil.timeMillisToStr(loanApply.getDueTime(), "yyyyMMdd");
			fixedLoanInrestVo.setEndDate(endDate);
			//总的本金金额
			fixedLoanInrestVo.setTotalCaptital(amount);
			//利息周期方式（1-按月，3-按季，0-一次性还本息）
			if (paymentOptions == 1){
				fixedLoanInrestVo.setPerIntrestDuration(1);
			} else if (paymentOptions == 2){
				fixedLoanInrestVo.setPerIntrestDuration(0);
			} else if (paymentOptions == 5){
				fixedLoanInrestVo.setPerIntrestDuration(3);
			}
			//年利率
			fixedLoanInrestVo.setRate(new BigDecimal(apr));
			
			//分期还款日
			fixedLoanInrestVo.setPayDay(loanApply.getInstallmentDate());
			//线下放款日
			//线下放款日
			if(loanApply.getLineloanDate() != null ){
			fixedLoanInrestVo.setOffLineLoanDate(DateUtil.timeMillisToStr(loanApply.getLineloanDate(), "yyyyMMdd"));		
			}
			//lineloanDate
			//计算还款计划
			fixedLoanInrestVo = FixedLoanInrestUtil.calulate(fixedLoanInrestVo);
			//利息计划明细
			ArrayList<FixedLoanInrestSubVo> periodDetail = fixedLoanInrestVo.getPeriodDetail();
			
			for(FixedLoanInrestSubVo fixedLoanInrestSubVo:periodDetail){
				//还款总额？？？
				applyRepay.setRepayTotal(fixedLoanInrestVo.getTotalRepayment());
				// 还款方式
				applyRepay.setRepayType(FeeProperties.REPAYMENT_METHOD.get(paymentOptions));	
				
				// 还款金额
				applyRepay.setRepayMoney(fixedLoanInrestSubVo.getPerSum());
				
				//还款本金
				applyRepay.setRepayCapital(fixedLoanInrestSubVo.getPerCapital());
				
				// 还款利息
				applyRepay.setRepayInterest(fixedLoanInrestSubVo.getPerIntrest());
				// 当前还款期数
				applyRepay.setRepayPeriod((byte) fixedLoanInrestSubVo.getPeriod());
				
				
				try {
					//开始时间
					applyRepay.setValueDate(DateUtil.dateTimeStampyyyyMMdd(fixedLoanInrestSubVo.getStartDate()));
					// 应还时间
					applyRepay.setRepayReqTime(DateUtil.dateTimeStampyyyyMMdd(fixedLoanInrestSubVo.getEndDate())+86399);
					// 结息日
					applyRepay.setMaturityDate(DateUtil.dateTimeStampyyyyMMdd(fixedLoanInrestSubVo.getEndDate())+86399);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				// 借款人所剩还款
				applyRepay.setRepayRemain(fixedLoanInrestSubVo.getRemainSum());
						
				// 添加还款计划
				int applyRepayResult = lenderServ.addPaymentRecord(applyRepay);
				if (applyRepayResult > 0) {
					log.info("添加还款计划成功");
				}						
				
			}
			
			/***************************************************************************/
			// 生成回款计划表
			for (LoanInvestmentVO inv : investList) {
				// 从每笔投资信息中取出投资人用户id
				int investmentUserId = inv.getUserId();
				//总的投资金额
				BigDecimal lend = inv.getMoney();
				// 投资id
				applyRecover.setInvestId(inv.getId());
				applyRecover.setUserId(investmentUserId);
				
				//总的本金金额
				fixedLoanInrestVo.setTotalCaptital(lend);				
				//计算回款计划
				fixedLoanInrestVo = FixedLoanInrestUtil.calulate(fixedLoanInrestVo);	
				
				//利息计划明细
				periodDetail = fixedLoanInrestVo.getPeriodDetail();				
				
				for(FixedLoanInrestSubVo fixedLoanInrestSubVo:periodDetail){
					//回款总金额
					applyRecover.setRecoverTotal(fixedLoanInrestVo.getTotalRepayment());		
					// 投资人收款金额
					applyRecover.setRecoverMoney(fixedLoanInrestSubVo.getPerSum());
					// 收款本金
					applyRecover.setRecoverCapital(fixedLoanInrestSubVo.getPerCapital());
					// 收款利息
					applyRecover.setRecoverInterest(fixedLoanInrestSubVo.getPerIntrest());
					// 当前收款期数
					applyRecover.setRecoverPeriod(fixedLoanInrestSubVo.getPeriod());				
					
					try {
						//本期开始时间
						applyRecover.setValueDate(DateUtil.dateTimeStampyyyyMMdd(fixedLoanInrestSubVo.getStartDate()));
						// 应收时间
						applyRecover.setRecoverReqTime(DateUtil.dateTimeStampyyyyMMdd(fixedLoanInrestSubVo.getEndDate())+86399);
						applyRecover.setMaturityDate(DateUtil.dateTimeStampyyyyMMdd(fixedLoanInrestSubVo.getEndDate())+86399);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					// 投资人剩余收款
					applyRecover.setRecoverRemain(fixedLoanInrestSubVo.getRemainSum());
					// 添加回款计划
					int recoverRecoverResult = lenderServ.addRecoverRecord(applyRecover);
					if (recoverRecoverResult > 0) {
						log.info("添加回款计划成功");
					}					
				}
				
				
				/*推荐列表更新，准备给推荐人奖励*/
//				recommendSer.LoanRecommend(investmentUserId, loanApply.getId(), loanApply.getName(), lend, DateUtil.getUnixTime());
			}
		}  else if (paymentOptions == 3) {
//			// 等额本息
//			// 生成还款计划表
//			// 还款总额
//			BigDecimal repayTotal = new BigDecimal(
//					AverageCapitalPlusInterestUtils.getPrincipalInterestCount(lendAmount, apr, period));
//			// 每期还款金额
//			BigDecimal repayMoney = new BigDecimal(
//					AverageCapitalPlusInterestUtils.getPerMonthPrincipalInterest(lendAmount, apr, period));
//			applyRepay.setRepayTotal(repayTotal);
//			applyRepay.setRepayMoney(repayMoney);
//			// 还款方式
//			applyRepay.setRepayType(FeeProperties.REPAYMENT_METHOD.get(3));
//			// 还需还款金额(repay_remain)
//			BigDecimal repayRemain = repayTotal;
//			for (int i = 1; i <= period; i++) {
//				BigDecimal repayInterest = AverageCapitalPlusInterestUtils
//						.getPerMonthInterest(lendAmount, apr, period).get(i);
//				BigDecimal repayCapital = AverageCapitalPlusInterestUtils
//						.getPerMonthPrincipal(lendAmount, apr, period).get(i);
//				// 还款利息
//				applyRepay.setRepayInterest(repayInterest);
//				// 还款本金
//				applyRepay.setRepayCapital(repayCapital);
//				// 当前还款期数
//				applyRepay.setRepayPeriod((byte) i);
//				try {
//					Integer time = DateUtil.getMonthBefore(currentTime, i);
//					// 应还时间
//					applyRepay.setRepayReqTime(time);
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				repayRemain = repayRemain.subtract(repayMoney);
//				// 剩余还款
//				applyRepay.setRepayRemain(repayRemain);
//				// 添加还款计划
//				int applyRepayResult = lenderServ.addPaymentRecord(applyRepay);
//				if (applyRepayResult > 0) {
//					log.info("添加还款计划成功");
//				}
//			}
//			/***************************************************************************/
//			// 生成回款计划表
//			for (LoanInvestmentVO inv : investList) {
//				// 从每笔投资信息中取出投资人用户id
//				int investmentUserId = inv.getUserId();
//				BigDecimal lend = inv.getMoney();
//				// 投资id
//				applyRecover.setInvestId(inv.getId());
//				applyRecover.setUserId(investmentUserId);
//				// 所占投资比
//				BigDecimal ratio = lend.divide(amount,4,BigDecimal.ROUND_HALF_UP);
//				// 还需收款金额
//				BigDecimal recoverRemain = repayTotal.multiply(ratio);
//				applyRecover.setRecoverTotal(repayTotal.multiply(ratio));
//				for (int i = 1; i <= period; i++) {
//					BigDecimal repayInterest = AverageCapitalPlusInterestUtils
//							.getPerMonthInterest(lendAmount, apr, period).get(i);
//					BigDecimal repayCapital = AverageCapitalPlusInterestUtils
//							.getPerMonthPrincipal(lendAmount, apr, period).get(i);
//					// 收款金额
//					applyRecover.setRecoverMoney(repayMoney.multiply(ratio));
//					// 收款利息
//					applyRecover.setRecoverInterest(repayInterest.multiply(ratio));
//					// 收款本金
//					applyRecover.setRecoverCapital(repayCapital.multiply(ratio));
//					// 当前收款期数
//					applyRecover.setRecoverPeriod(i);
//					try {
//						Integer time = DateUtil.getMonthBefore(currentTime, i);
//						// 应收时间
//						applyRecover.setRecoverReqTime(time);
//					} catch (ParseException e) {
//						e.printStackTrace();
//					}
//					recoverRemain = recoverRemain.subtract(repayMoney.multiply(ratio));
//					// 剩余收款
//					applyRecover.setRecoverRemain(recoverRemain);
//					// 添加回款计划
//					int recoverRecoverResult = lenderServ.addRecoverRecord(applyRecover);
//					if (recoverRecoverResult > 0) {
//						log.info("添加回款计划成功");
//					}
//				}
//			}
		} else if (paymentOptions == 4) {
//			// 等额本金
//			// 生成还款计划表
//			// 还款总额
//			BigDecimal repayTotal = new BigDecimal(
//					AverageCapitalUtils.getPrincipalInterestCount1(lendAmount, apr, period)).setScale(2, BigDecimal.ROUND_HALF_UP);
//			
//			BigDecimal repayIntrestTotal = repayTotal.subtract(new BigDecimal(lendAmount));
//			
//			BigDecimal repayCapital = new BigDecimal(
//					AverageCapitalUtils.getPerMonthPrincipal(lendAmount, period)).setScale(2, BigDecimal.ROUND_HALF_UP);;
//			applyRepay.setRepayTotal(repayTotal);
//			
//			//四舍五入后的总还款本金总额
//			BigDecimal mTotalCapital = repayCapital.multiply(new BigDecimal(period));					
//			// 还款方式
//			applyRepay.setRepayType(FeeProperties.REPAYMENT_METHOD.get(4));
//			// 还款本金
//			applyRepay.setRepayCapital(repayCapital);
//			// 还需还款金额(repay_remain)
//			BigDecimal repayRemain = repayTotal;	
//			//调整本金金额
//			BigDecimal adjustCapital = mTotalCapital.subtract(new BigDecimal(lendAmount));		
//			
//			for (int i = 1; i <= period; i++) {
//				BigDecimal repayMoney = new BigDecimal(
//						AverageCapitalUtils.getPerMonthPrincipalInterest(lendAmount, apr, period).get(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
//				BigDecimal repayInterest = new BigDecimal(
//						AverageCapitalUtils.getPerMonthInterest(lendAmount, apr, period).get(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
//
//				try {
//					Integer time = DateUtil.getMonthBefore(currentTime, i);
//					// 应还时间
//					applyRepay.setRepayReqTime(time);
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//				repayRemain = repayRemain.subtract(repayMoney);
//				
//				//最后一期调整
//				if(i == period){
//					//本金尾差调整
//					repayMoney = repayMoney.subtract(adjustCapital);
//					repayCapital = repayCapital.subtract(adjustCapital);
//
//					// 还款本金
//					applyRepay.setRepayCapital(repayCapital);		
//					
//					repayRemain = new BigDecimal(0.00);
//				}
//
//				
//				// 还款金额
//				applyRepay.setRepayMoney(repayMoney);
//				// 还款利息
//				applyRepay.setRepayInterest(repayInterest);
//				// 当前还款期数
//				applyRepay.setRepayPeriod((byte) i);						
//				// 剩余还款
//				applyRepay.setRepayRemain(repayRemain);
//				
//				System.out.println("还款计划还款总额 ， 第" +i+ "期，金额" + applyRepay.getRepayMoney());
//				System.out.println("还款计划还款本金 ， 第" +i+ "期，金额" + applyRepay.getRepayCapital());
//				System.out.println("还款计划还款利息 ， 第" +i+ "期，金额" + applyRepay.getRepayInterest());
//				System.out.println("还款计划剩余还款金额 ， 第" +i+ "期，金额" + applyRepay.getRepayRemain());	
//				System.out.println("-------------------------------------------------------------------");						
//				// 添加还款计划
//				int applyRepayResult = lenderServ.addPaymentRecord(applyRepay);
//				if (applyRepayResult > 0) {
//					log.info("添加还款计划成功");
//				}
//			}
//			/***************************************************************************/
//
//			// 生成回款计划表
//			for (LoanInvestmentVO inv : investList) {
//				BigDecimal lend = inv.getMoney();
//				// 回款还款总额
//				BigDecimal recoverTotal = new BigDecimal(
//						AverageCapitalUtils.getPrincipalInterestCount1(lend.doubleValue(), apr, period)).setScale(2, BigDecimal.ROUND_HALF_UP);
//				//回款还款本金
//				BigDecimal recvorCapital = new BigDecimal(
//						AverageCapitalUtils.getPerMonthPrincipal(lend.doubleValue(), period)).setScale(2, BigDecimal.ROUND_HALF_UP);
//				
//				//四舍五入后的总还款本金总额
//				BigDecimal mrecvorTotalCapital = recvorCapital.multiply(new BigDecimal(period));
//				BigDecimal recoverRemain = recoverTotal;
//				
//				
//				BigDecimal adjustCoverCapital = mrecvorTotalCapital.subtract(lend);							
//				
//				// 收款本金
//				applyRecover.setRecoverCapital(recvorCapital);
//				for (int i = 1; i <= period; i++) {
//				
//					// 从每笔投资信息中取出投资人用户id
//					int investmentUserId = inv.getUserId();
//
//					// 投资id
//					applyRecover.setInvestId(inv.getId());
//					applyRecover.setUserId(investmentUserId);						
//					
//					BigDecimal recoverRepayMoney = 
//							new BigDecimal(AverageCapitalUtils.getPerMonthPrincipalInterest(lend.doubleValue(), apr, period).get(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
//					BigDecimal recoveRrepayInterest = 
//							new BigDecimal(AverageCapitalUtils.getPerMonthInterest(lend.doubleValue(), apr, period).get(i)).setScale(2, BigDecimal.ROUND_HALF_UP);
//
//					try {
//						Integer time = DateUtil.getMonthBefore(currentTime, i);
//						// 应收时间
//						applyRecover.setRecoverReqTime(time);
//					} catch (ParseException e) {
//						e.printStackTrace();
//					}
//					recoverRemain = recoverRemain.subtract(recoverRepayMoney);
//					
//					//最后一期调整
//					if(i == period){
//						
//						
//						//最后一期调整
//						if(i == period){
//							//本金尾差调整
//							recoverRepayMoney = recoverRepayMoney.subtract(adjustCoverCapital);
//							recvorCapital = recvorCapital.subtract(adjustCoverCapital);
//
//							// 还款本金
//							applyRecover.setRecoverCapital(recvorCapital);		
//							
//							recoverRemain = new BigDecimal(0.00);
//						}
//						
//				
//					}
//					
//					// 收款金额
//					applyRecover.setRecoverMoney(recoverRepayMoney);
//					// 收款利息
//					applyRecover.setRecoverInterest(recoveRrepayInterest);
//
//					// 当前收款期数
//					applyRecover.setRecoverPeriod(i);							
//					// 剩余收款
//					applyRecover.setRecoverRemain(recoverRemain);
//					// 添加回款计划
//					int recoverRecoverResult = lenderServ.addRecoverRecord(applyRecover);
//					if (recoverRecoverResult > 0) {
//						log.info("添加回款计划成功");
//					}
//					
//					System.out.println("回款款计划还款总额 ， 第" +i+ "期，金额" + applyRecover.getRecoverMoney());
//					System.out.println("回款计划还款本金 ， 第" +i+ "期，金额" + applyRecover.getRecoverCapital());
//					System.out.println("回款计划还款利息 ， 第" +i+ "期，金额" + applyRecover.getRecoverInterest());
//					System.out.println("回款计划剩余还款金额 ， 第" +i+ "期，金额" + applyRecover.getRecoverRemain());
//					System.out.println("-------------------------------------------------------------------");								
//					
//				}
//			}	
//			
		}
			
	}
	
	
}
