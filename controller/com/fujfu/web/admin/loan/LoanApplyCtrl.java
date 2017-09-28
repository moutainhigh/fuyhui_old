package com.fujfu.web.admin.loan;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.PingYinUtil;
import com.fujfu.common.util.PropertyFileUtil;
import com.fujfu.common.util.UserAccountUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.admin.AdminVO;
import com.fujfu.pojo.admin.LoanInvestPOJO;
import com.fujfu.pojo.loan.AuditRecordVO;
import com.fujfu.pojo.loan.LoanPOJO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.loan.LoanTypeVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.invest.LoanInvestmentServ;
import com.fujfu.service.lender.impl.LenderServImpl;
import com.fujfu.service.loan.AuditRecordServ;
import com.fujfu.service.loan.LoanApplyServ;
import com.fujfu.service.loan.LoanTypeServ;
import com.fujfu.service.repay.RepayServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;
import com.fujfu.web.constant.FeeProperties;
@Controller
@RequestMapping("/loan/")
public class LoanApplyCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private LoanInvestmentServ investServ;
	@Resource
	private UserServ userServ;
	@Resource
	private LoanApplyServ loanApplyServ;
	@Resource
	private LoanTypeServ loanTypeServ;
	@Resource
	private RepayServ repayServ;
	@Resource
	private AuditRecordServ auditRecordServ;
	
	private static Logger log = Logger.getLogger(LenderServImpl.class);
	
	/**
	 * 进入放款确认页面
	 * @return
	 */
	@RequestMapping("loanApply/enterRepayConfirm")
	public String enterRepayConfirm(Model model,String id){
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(Integer.parseInt(id));
		List<AuditRecordVO> auditRecordList = auditRecordServ.findAuditRecordByApplyId(Integer.parseInt(id));
		if(loanApply.getStartTime()!=null){
			model.addAttribute("startTime", DateUtil.timeMillisToStr(loanApply.getStartTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getEndTime()!=null){
			model.addAttribute("endTime", DateUtil.timeMillisToStr(loanApply.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getDueTime()!=null){
			model.addAttribute("dueTime", DateUtil.timeMillisToStr(loanApply.getDueTime(),"yyyy-MM-dd"));
		}
		if(loanApply.getLineloanDate()!=null){
			model.addAttribute("lDate", DateUtil.timeMillisToStr(loanApply.getLineloanDate(),"yyyy-MM-dd"));
		}
		model.addAttribute("loanApply", loanApply);
		model.addAttribute("auditRecordList", auditRecordList);
		model.addAttribute("borrower", userServ.getUserByUserId(loanApply.getUserId()).getCorpName());
		model.addAttribute("loanType", loanTypeServ.findLoanTypeById(loanApply.getLoanType()).getName());
		model.addAttribute("guaranteeCompany", userServ.getUserByUserId(loanApply.getGuaranteeCompanyId()).getCorpName());
		model.addAttribute("repayment", FeeProperties.REPAYMENT_METHOD.get(loanApply.getPaymentOptions()));
		model.addAttribute("repaymentMethod", FeeProperties.REPAYMENT_METHOD);
		
		
		return "views/admin/loan/repayConfirm.jsp";
	}
	
	/**
	 * 进入标的详情页面
	 * @return
	 */
	@RequestMapping("loanApply/enterLoanConfirm")
	public String enterLoanConfirm(Model model,String id){
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(Integer.parseInt(id));
		List<AuditRecordVO> auditRecordList = auditRecordServ.findAuditRecordByApplyId(Integer.parseInt(id));
		if(loanApply.getStartTime()!=null){
			model.addAttribute("startTime", DateUtil.timeMillisToStr(loanApply.getStartTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getEndTime()!=null){
			model.addAttribute("endTime", DateUtil.timeMillisToStr(loanApply.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getDueTime()!=null){
			model.addAttribute("dueTime", DateUtil.timeMillisToStr(loanApply.getDueTime(),"yyyy-MM-dd"));
		}
		if(loanApply.getLineloanDate()!=null){
			model.addAttribute("lDate", DateUtil.timeMillisToStr(loanApply.getLineloanDate(),"yyyy-MM-dd"));
		}
		model.addAttribute("loanApply", loanApply);
		model.addAttribute("auditRecordList", auditRecordList);
		model.addAttribute("borrower", userServ.getUserByUserId(loanApply.getUserId()).getCorpName());
		model.addAttribute("loanType", loanTypeServ.findLoanTypeById(loanApply.getLoanType()).getName());
		model.addAttribute("guaranteeCompany", userServ.getUserByUserId(loanApply.getGuaranteeCompanyId()).getCorpName());
		model.addAttribute("repayment", FeeProperties.REPAYMENT_METHOD.get(loanApply.getPaymentOptions()));
		model.addAttribute("repaymentMethod", FeeProperties.REPAYMENT_METHOD);
		
		
		return "views/admin/loan/loanConfirm.jsp";
	}
	
	/**
	 * @return
	 */
	@RequestMapping("loanApply/enterLoanConfirm2")
	public String enterLoanConfirm2(Model model,String id){
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(Integer.parseInt(id));
		List<AuditRecordVO> auditRecordList = auditRecordServ.findAuditRecordByApplyId(Integer.parseInt(id));
		if(loanApply.getStartTime()!=null){
			model.addAttribute("startTime", DateUtil.timeMillisToStr(loanApply.getStartTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getEndTime()!=null){
			model.addAttribute("endTime", DateUtil.timeMillisToStr(loanApply.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getDueTime()!=null){
			model.addAttribute("dueTime", DateUtil.timeMillisToStr(loanApply.getDueTime(),"yyyy-MM-dd"));
		}
		if(loanApply.getLineloanDate()!=null){
			model.addAttribute("lDate", DateUtil.timeMillisToStr(loanApply.getLineloanDate(),"yyyy-MM-dd"));
		}
		LoanInvestPOJO loanInvestQueryVo =new LoanInvestPOJO();
		if (StringUtils.isNotEmpty(id)) {
		    loanInvestQueryVo.setApply_id(Integer.parseInt(id));
		}
		Page page = new Page();
		Page applyRepayList = repayServ.findAllApplyRepayListByCondition(loanInvestQueryVo, page);
		model.addAttribute("applyRepayList", applyRepayList);
		model.addAttribute("auditRecordList", auditRecordList);
		model.addAttribute("loanApply", loanApply);
		model.addAttribute("borrower", userServ.getUserByUserId(loanApply.getUserId()).getCorpName());
		model.addAttribute("loanType", loanTypeServ.findLoanTypeById(loanApply.getLoanType()).getName());
		model.addAttribute("guaranteeCompany", userServ.getUserByUserId(loanApply.getGuaranteeCompanyId()).getCorpName());
		model.addAttribute("repayment", FeeProperties.REPAYMENT_METHOD.get(loanApply.getPaymentOptions()));
		model.addAttribute("repaymentMethod", FeeProperties.REPAYMENT_METHOD);
		
		
		return "views/admin/loan/loanConfirm2.jsp";
	}
	
	
	/**
	 * 列出草稿标的
	 * @param model
	 * @return
	 */
	@RequestMapping("loanApply/listDraftLoan")
	public String listDraftLoan(Page page,Model model,String status) {
		LoanPOJO loan = new LoanPOJO();
		System.out.println(status);
		if(StringUtils.isNotEmpty(status)){
			loan.setStatus(status);
		}else{
		loan.setStatus("-1");
		}
		Page loanApplyList = loanApplyServ.findLoanByCondition(loan, page);
		model.addAttribute("draftLoanList", loanApplyList);
		if("0".equals(loan.getStatus())){
			model.addAttribute("loanApplyReviewList", loanApplyList);
		return "views/admin/loan/loanApplyFReview.jsp";
		}else{
			return "views/admin/loan/draftLoanList.jsp";	
		}
	}
	
	/**
	 * 进入发标界面
	 * @return
	 */
	@RequestMapping("loanApply/enterAdd")
	public String enterAdd(Model model){
		List<LoanTypeVO> loanTypeList = loanTypeServ.listAllLoanType();
		List<UserVO> guaranteeCompanyList = userServ.findUserByType("3");
		List<UserVO> borrowerList = userServ.findUserByType("2");
		model.addAttribute("borrowerList", borrowerList);
		model.addAttribute("loanTypeList", loanTypeList);
		model.addAttribute("guaranteeCompanyList", guaranteeCompanyList);
		model.addAttribute("repaymentMethod", FeeProperties.REPAYMENT_METHOD);
		return "views/admin/loan/addLoanApply.jsp";
	}
	
	/**
	 * 进入标的信息修改页面
	 * @return
	 */
	@RequestMapping("loanApply/enterLoanApplyUpdate")
	public String enterLoanApplyUpdate(Model model,String id){
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(Integer.parseInt(id));
		List<LoanTypeVO> loanTypeList = loanTypeServ.listAllLoanType();
		List<UserVO> guaranteeCompanyList = userServ.findUserByType("3");
		List<UserVO> borrowerList = userServ.findUserByType("2");
		List<AuditRecordVO> auditRecordList = auditRecordServ.findAuditRecordByApplyId(Integer.parseInt(id)); 
		if(loanApply.getStartTime()!=null){
			model.addAttribute("startTime", DateUtil.timeMillisToStr(loanApply.getStartTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getEndTime()!=null){
			model.addAttribute("endTime", DateUtil.timeMillisToStr(loanApply.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getDueTime()!=null){
			model.addAttribute("dueTime", DateUtil.timeMillisToStr(loanApply.getDueTime(),"yyyy-MM-dd"));
		}
		if(loanApply.getLineloanDate()!=null){
			model.addAttribute("lDate", DateUtil.timeMillisToStr(loanApply.getLineloanDate(),"yyyy-MM-dd"));
		}
		model.addAttribute("loanApply", loanApply);
		model.addAttribute("borrower", userServ.getUserByUserId(loanApply.getUserId()).getCorpName());
		model.addAttribute("borrowerList", borrowerList);
		model.addAttribute("auditRecordList", auditRecordList);
		model.addAttribute("loanType", loanTypeServ.findLoanTypeById(loanApply.getLoanType()).getName());
		model.addAttribute("loanTypeList", loanTypeList);
		model.addAttribute("guaranteeCompany", userServ.getUserByUserId(loanApply.getGuaranteeCompanyId()).getCorpName());
		model.addAttribute("guaranteeCompanyList", guaranteeCompanyList);
		model.addAttribute("repayment", FeeProperties.REPAYMENT_METHOD.get(loanApply.getPaymentOptions()));
		model.addAttribute("repaymentMethod", FeeProperties.REPAYMENT_METHOD);
		return "views/admin/loan/loanApplyDetail.jsp";
	}
	
	/**
	 * 列出为未审核的
	 * @param model
	 * @return
	 */
	@RequestMapping("loanApply/listFReview")
	public String listFReview(Page page, Model model){
		LoanPOJO loan = new LoanPOJO();
		loan.setStatus("0");
		Page loanApplyList = loanApplyServ.findLoanByCondition(loan, page);
		model.addAttribute("loanApplyReviewList", loanApplyList);
		return "views/admin/loan/loanApplyFReview.jsp";
	}
	
	/**
	 * 列出为初审通过的
	 * @param model
	 * @return
	 */
	@RequestMapping("loanApply/listSReview")
	public String listSReview(Page page,Model model){
		LoanPOJO loan = new LoanPOJO();
		loan.setStatus("1");
		Page loanApplyList = loanApplyServ.findLoanByCondition(loan, page);
		model.addAttribute("loanApplySReviewList", loanApplyList);
		return "views/admin/loan/loanApplySReview.jsp";
	}
	
	/**
	 * 列出终审通过的
	 * @param model
	 * @return
	 */
	@RequestMapping("loanApply/list")
	public String list(Page page,Model model){
		LoanPOJO loan = new LoanPOJO();
		loan.setStatus("2");
		Page loanApplyList = loanApplyServ.findLoanByCondition(loan, page);
		model.addAttribute("loanApplyList", loanApplyList);
		return "views/admin/loan/loanApplyList.jsp";
	}
	
	/**
	 * 进入初审标的详情页面
	 * @return
	 */
	@RequestMapping("loanApply/enterLoanReviewDetail")
	public String enterLoanReviewDetail(Model model,String id){
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(Integer.parseInt(id));
		List<AuditRecordVO> auditRecordList = auditRecordServ.findAuditRecordByApplyId(Integer.parseInt(id));
		if(loanApply.getStartTime()!=null){
			model.addAttribute("startTime", DateUtil.timeMillisToStr(loanApply.getStartTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getEndTime()!=null){
			model.addAttribute("endTime", DateUtil.timeMillisToStr(loanApply.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getDueTime()!=null){
			model.addAttribute("dueTime", DateUtil.timeMillisToStr(loanApply.getDueTime(),"yyyy-MM-dd"));
		}
		if(loanApply.getLineloanDate()!=null){
			model.addAttribute("lDate", DateUtil.timeMillisToStr(loanApply.getLineloanDate(),"yyyy-MM-dd"));
		}
		
		model.addAttribute("loanApply", loanApply);
		model.addAttribute("borrower", userServ.getUserByUserId(loanApply.getUserId()).getCorpName());
		model.addAttribute("auditRecordList", auditRecordList);
		model.addAttribute("loanType", loanTypeServ.findLoanTypeById(loanApply.getLoanType()).getName());
		model.addAttribute("guaranteeCompany", userServ.getUserByUserId(loanApply.getGuaranteeCompanyId()).getCorpName());
		model.addAttribute("repayment", FeeProperties.REPAYMENT_METHOD.get(loanApply.getPaymentOptions()));
		model.addAttribute("repaymentMethod", FeeProperties.REPAYMENT_METHOD);
		return "views/admin/loan/loanReviewDetail.jsp";
	}
	
	/**
	 * 进入复审标的详情页面
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("loanApply/enterLoanFinalReviewDetail")
	public String enterLoanFinalReviewDetail(Model model,String id){
		LoanApplyVO loanApply = loanApplyServ.selectByPrimaryKey(Integer.parseInt(id));
		List<AuditRecordVO> auditRecordList = auditRecordServ.findAuditRecordByApplyId(Integer.parseInt(id));
		if(loanApply.getStartTime()!=null){
			model.addAttribute("startTime", DateUtil.timeMillisToStr(loanApply.getStartTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getEndTime()!=null){
			model.addAttribute("endTime", DateUtil.timeMillisToStr(loanApply.getEndTime(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(loanApply.getDueTime()!=null){
			model.addAttribute("dueTime", DateUtil.timeMillisToStr(loanApply.getDueTime(),"yyyy-MM-dd"));
		}
		if(loanApply.getLineloanDate()!=null){
			model.addAttribute("lDate", DateUtil.timeMillisToStr(loanApply.getLineloanDate(),"yyyy-MM-dd"));
		}
		model.addAttribute("loanApply", loanApply);
		model.addAttribute("borrower", userServ.getUserByUserId(loanApply.getUserId()).getCorpName());
		model.addAttribute("auditRecordList", auditRecordList);
		model.addAttribute("loanType", loanTypeServ.findLoanTypeById(loanApply.getLoanType()).getName());
		model.addAttribute("guaranteeCompany", userServ.getUserByUserId(loanApply.getGuaranteeCompanyId()).getCorpName());
		model.addAttribute("repayment", FeeProperties.REPAYMENT_METHOD.get(loanApply.getPaymentOptions()));
		model.addAttribute("repaymentMethod", FeeProperties.REPAYMENT_METHOD);
		return "views/admin/loan/loanFinalReviewDetail.jsp";
	}
	
	
	/**
	 * 修改
	 */
	@RequestMapping("loanApply/update")
	public String update(HttpServletRequest request,Model model,LoanApplyVO loanApply,String sTime, String eTime,String dTime,String isUpdate,String lDate){
		AuditRecordVO auditRecord = new AuditRecordVO();
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
								request.getSession().getServletContext());
				// 文件名数组
				List<String> fileNameList = new ArrayList<String>();
				// 判断 request 是否有文件上传,即多部分请求
				if (multipartResolver.isMultipart(request)) {
					// 转换成多部分request
					MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
					// 取得request中的所有文件名
					Iterator<String> iter = multiRequest.getFileNames();
					while (iter.hasNext()) {
						// 取得上传文件
						MultipartFile file = multiRequest.getFile(iter.next());
						if (file != null) {
							// 绝对路径
							String absolutePath = PropertyFileUtil.getProperty("filePath")+File.separator+"contract";
							// 定义上传路径
							String path = absolutePath + File.separator + file.getOriginalFilename();
							File localFile = new File(path);
							if (localFile.isFile() && localFile.exists()) {
								localFile.delete();
							}
							if (!localFile.exists()) {
								localFile.mkdirs();
							}
							try {
								file.transferTo(localFile);
							} catch (Exception e) {
								e.printStackTrace();
							}
							fileNameList.add(file.getOriginalFilename());
						}
					}
					for (int i = 0; i < fileNameList.size(); i++) {
						if(i == 0){
							loanApply.setContract(File.separator+"contract"+File.separator+fileNameList.get(i));
						}else{
							loanApply.setContract(loanApply.getContract()+","+File.separator+"contract"+File.separator+fileNameList.get(i));
						}
					}
		}
		
		if (StringUtils.isNotEmpty(sTime)) {
			try {
				loanApply.setStartTime(DateUtil.dateTimeStamp(sTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(eTime)) {
			try {
				loanApply.setEndTime(DateUtil.dateTimeStamp(eTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(dTime)) {
			try {
				loanApply.setDueTime(DateUtil.dateTimeStamp(dTime+" 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(StringUtils.isNotEmpty(lDate)){
			try {
				loanApply.setLineloanDate(DateUtil.dateTimeStamp(lDate+" 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		AdminVO admin = (AdminVO) request.getSession().getAttribute("admin");
		if(admin == null){
			model.addAttribute("msg","登录状态过期，请重新登录！");
			return "redirect:/loan/loanApply/listDraftLoan";
		}
		int result = loanApplyServ.updateLoanApply(loanApply);
		if(result>0){
			if(loanApply.getStatus() == -2){
				model.addAttribute("msg","取消项目成功");
				return "redirect:/loan/loanApply/listDraftLoan";
			}
			else if(loanApply.getStatus() == -1){
				model.addAttribute("msg","保存项目成功");
				return "redirect:/loan/loanApply/listDraftLoan";
			}
			else if(loanApply.getStatus() == 0){
				if(StringUtils.isNotEmpty(isUpdate) && isUpdate.equals("0")){
					model.addAttribute("msg","保存项目成功");
				}else{
					model.addAttribute("msg","录入项目成功");
				}
				return "redirect:/loan/loanApply/listDraftLoan?status=0";
			}
			else if(loanApply.getStatus() == 1){
				auditRecord.setApplyId(loanApply.getId());
				auditRecord.setAuditTime(DateUtil.getUnixTime());
				auditRecord.setAuditPerson(admin.getUsername());
				auditRecord.setAuditResult((byte)1);
				auditRecord.setAuditAdvice(loanApply.getFristAdvice());
				auditRecord.setAuditLink("发标初审");
				auditRecordServ.addAuditRecord(auditRecord);
				model.addAttribute("msg","初审通过");
				return "redirect:/loan/loanApply/listFReview";
			}else if(loanApply.getStatus() == 2){
				if(loanApply.getEndTime() <= DateUtil.getUnixTime()){
					loanApply.setStatus((byte)1);
					model.addAttribute("msg","竞价结束时间不能小于当前时间");
					return "redirect:/loan/loanApply/listSReview";
				}else{
					auditRecord.setApplyId(loanApply.getId());
					auditRecord.setAuditTime(DateUtil.getUnixTime());
					auditRecord.setAuditPerson(admin.getUsername());
					auditRecord.setAuditResult((byte)1);
					auditRecord.setAuditAdvice(loanApply.getLastAdvice());
					auditRecord.setAuditLink("发标终审");
					auditRecordServ.addAuditRecord(auditRecord);
					model.addAttribute("msg","终审通过");
					return "redirect:/loan/loanApply/listSReview";
				}
			}
			else if(loanApply.getStatus() == 3){
				loanApply.setStatus((byte)-1);
				loanApplyServ.updateLoanApply(loanApply);
				auditRecord.setApplyId(loanApply.getId());
				auditRecord.setAuditTime(DateUtil.getUnixTime());
				auditRecord.setAuditPerson(admin.getUsername());
				auditRecord.setAuditResult((byte)0);
				auditRecord.setAuditAdvice(loanApply.getFristAdvice());
				auditRecord.setAuditLink("发标初审");
				auditRecordServ.addAuditRecord(auditRecord);
				loanApply.setFristAdvice("");
				loanApplyServ.updateLoanApply(loanApply);
				model.addAttribute("msg","初审退回成功");
				return "redirect:/loan/loanApply/listFReview";
			}
			else if(loanApply.getStatus() == 4){
				loanApply.setStatus((byte)1);
				loanApplyServ.updateLoanApply(loanApply);
				model.addAttribute("msg","保存成功");
				return "redirect:/loan/loanApply/listSReview";
			}
			else{
				loanApply.setStatus((byte)0);
				loanApplyServ.updateLoanApply(loanApply);
				auditRecord.setApplyId(loanApply.getId());
				auditRecord.setAuditTime(DateUtil.getUnixTime());
				auditRecord.setAuditPerson(admin.getUsername());
				auditRecord.setAuditResult((byte)0);
				auditRecord.setAuditAdvice(loanApply.getLastAdvice());
				auditRecord.setAuditLink("发标终审");
				auditRecordServ.addAuditRecord(auditRecord);
				loanApply.setFristAdvice("");
				loanApply.setLastAdvice("");
				loanApplyServ.updateLoanApply(loanApply);
				model.addAttribute("msg","终审退回成功");
				return "redirect:/loan/loanApply/listSReview";
			}
		}else{
			model.addAttribute("msg","操作失败");
			return "redirect:/loan/loanApply/listDraftLoan";
		}
	}
	
	/**
	 * 录入标的
	 * @throws IOException 
	 */
	@RequestMapping("loanApply/add")
	public String add(HttpServletRequest request,Model model,LoanApplyVO loanApply,String dTime,String lDate) throws IOException{
		if (StringUtils.isNotEmpty(dTime)) {
			try {
				loanApply.setDueTime(DateUtil.dateTimeStamp(dTime+" 00:00:00"));
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(lDate!=null){
			try {
				loanApply.setLineloanDate(DateUtil.dateTimeStamp(lDate+" 00:00:00"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
						request.getSession().getServletContext());
		// 文件名数组
		List<String> fileNameList = new ArrayList<String>();
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 绝对路径
					String absolutePath = PropertyFileUtil.getProperty("filePath")+File.separator+"contract";
					// 定义上传路径
					String path = absolutePath + File.separator + file.getOriginalFilename();
					File localFile = new File(path);
					if (localFile.isFile() && localFile.exists()) {
						localFile.delete();
					}
					if (!localFile.exists()) {
						localFile.mkdirs();
					}
					try {
						file.transferTo(localFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
					fileNameList.add(file.getOriginalFilename());
				}
			}
			for (int i = 0; i < fileNameList.size(); i++) {
				if(i == 0){
					loanApply.setContract(File.separator+"contract"+File.separator+fileNameList.get(i));
				}else{
					loanApply.setContract(loanApply.getContract()+","+File.separator+"contract"+File.separator+fileNameList.get(i));
				}
			}
		}
		//获取投资编号orderNumber
		String orderNumber ="";
		try {
		LoanTypeVO loanType = loanTypeServ.findLoanTypeById(loanApply.getLoanType());
		String oldMaxorderNumber =loanApplyServ.findMaxApplyOrderNumber(PingYinUtil.getFirstSpell(loanType.getName())+DateUtil.getCurrentDate("yyyyMMdd"));
		log.info("oldMaxorderNumber=="+oldMaxorderNumber);
		
		if(StringUtils.isEmpty(oldMaxorderNumber)){
			 orderNumber = PingYinUtil.getFirstSpell(loanType.getName())+DateUtil.getCurrentDate("yyyyMMdd")+"001";
		}else{
			orderNumber=UserAccountUtil.getApplyOrderNumber(oldMaxorderNumber,loanType.getName());
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("orderNumber=="+orderNumber);
		loanApply.setProductUrl(DateUtil.getCurrentDate("yyyyMMdd"));//用于保存productUrl
		loanApply.setOrderNumber(orderNumber);
		loanApply.setCreated(DateUtil.getUnixTime());
		int result = loanApplyServ.addLoanApply(loanApply);
		if(result>0){
			if(loanApply.getStatus() == -1){
				model.addAttribute("msg","保存项目成功");
			}else{
				model.addAttribute("msg","录入项目成功");
			}
		}else{
			model.addAttribute("msg","操作失败");
		}	
		return "redirect:/loan/loanApply/listDraftLoan";
	}
	
	/**
	 * 条件查询
	 * @param model
	 * @return
	 */
	@RequestMapping("loanApply/findLoanByCondition")
	public String findLoanByCondition(Page page,Model model,String status) {
		LoanPOJO loan = new LoanPOJO();
		if(StringUtils.isNotEmpty(status)){
			loan.setStatus(status);
		}else{
			loan.setStatus(null);
		}
		Page loanApplyList = loanApplyServ.findLoanByCondition(loan, page);
		model.addAttribute("loanApplyList", loanApplyList);
		return "views/admin/loan/loanApplyList.jsp";
	}
	
	/**
	 * 项目逻辑删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("loanApply/del")
	public String delLoanApply(Model model,String id){
		LoanApplyVO loanApply = new LoanApplyVO();
		loanApply.setId(Integer.parseInt(id));
		loanApply.setStatus((byte)-2);
		int result = loanApplyServ.updateLoanApply(loanApply);
		if(result > 0){
			model.addAttribute("msg", "删除项目成功");
		}else{
			model.addAttribute("msg", "删除项目失败");
		}
		return "redirect:/loan/loanApply/listDraftLoan";
	}
}
