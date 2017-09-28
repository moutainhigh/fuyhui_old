package com.fujfu.common.util;



import java.io.File;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.fujfu.pojo.apply.ApplyRecoverVO;
import com.fujfu.pojo.invest.LoanInvestmentVO;
import com.fujfu.pojo.loan.LoanApplyVO;
import com.fujfu.pojo.loan.LoanTypeVO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.lender.impl.LenderServImpl;

public class PDFUtil {

	private static Logger log = Logger.getLogger(LenderServImpl.class);

	public static String runCreProductPdf(LoanApplyVO loanApply, HttpServletRequest request, LoanTypeVO loanType,
			UserVO lender, UserVO guaranUser) {
		String dateString = loanApply.getProductUrl();
		String path =PropertyFileUtil.getProperty("filePath") + File.separator
				+ "pdf" + File.separator + dateString;
		System.out.println("存放投资人合同地址" + path);
		log.info("存放投资人合同地址" + path);
		PDFUtil.checkandmkdirFile(path);
		String filename = loanApply.getOrderNumber() + "01" + ".pdf";
		log.info("产品募集书名称" + filename);
		if (!PDFUtil.checkFile1(path + File.separator + filename)) {// 如果文件不存在，则代表未生成合同，继续生成合同

			CreProductPdf creProductPdf = new CreProductPdf();
			try {
				

				creProductPdf.writePdf2(path + File.separator + filename, loanType.getName(), loanApply, lender,
						guaranUser);					
				log.info("生成产品募集书成功" + path + File.separator + filename);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String filename1 = loanApply.getOrderNumber() + "02" + ".pdf";
		if (!PDFUtil.checkFile1(path + File.separator + filename1)) {// 如果文件不存在，则代表未生成合同，继续生成合同
			log.info("合同模板名称" + filename1);
			CreContrPdftemplate creContrPdftemplate = new CreContrPdftemplate();
			try {
				if(loanApply.getLoanType() == 51){
					creContrPdftemplate.writePdf3(path + File.separator + filename1, loanType.getName(), loanApply, lender,guaranUser);
				} else {
					creContrPdftemplate.writePdf2(path + File.separator + filename1, loanType.getName(), loanApply, lender,guaranUser);						
				}
				log.info("生成合同成功" + path + File.separator + filename1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "1";
	}
	public static void main(String[] args) throws Exception {

		CreContrPdftemplate creContrPdf = new CreContrPdftemplate();
		LoanApplyVO loanApply =new LoanApplyVO();
		loanApply.setLoanTime(1462464000);
		loanApply.setAmount(new BigDecimal("10000"));
		loanApply.setApr(10f);
		loanApply.setPaymentOptions(1);
		loanApply.setPeriod(3);
		loanApply.setStartTime(1462464000);
		loanApply.setEndTime(1462464000);
		loanApply.setMtime(1462464000);
		loanApply.setProductManager("阿虎发怒给");
		loanApply.setGuaranteeMode("afsd");
		loanApply.setDescription("很好的公司哦");
		UserVO investuser=new UserVO();
		investuser.setUserId(10000010);
		investuser.setRealname("范坚强");
		investuser.setCardId("4231231451234123123123412");
		UserVO loadApplyUser = new UserVO();
		loadApplyUser.setRealname("金华有限公司");
		LoanInvestmentVO invest=new LoanInvestmentVO();
		invest.setUserId(10000010);
		invest.setMoney(new BigDecimal("10000"));
		UserVO GuaranUser = new UserVO();
		GuaranUser.setUsername("担保公司1");
		ApplyRecoverVO applyRecover =new ApplyRecoverVO();
		List<ApplyRecoverVO> applyRecoverList = new ArrayList<ApplyRecoverVO>();
       creContrPdf.writePdf2("c://all.pdf","安心投",loanApply,loadApplyUser,GuaranUser);
       
       CreProductPdf CreProductPdf = new CreProductPdf();
       CreProductPdf.writePdf2("c://all1.pdf", "安心投", loanApply, loadApplyUser, GuaranUser);
	}
	public static String getContrUrl(LoanApplyVO loanApply, HttpServletRequest request) {
		// 根据标的放款日期生成文件夹
		String dateString = DateUtil.timeMillisToStr(loanApply.getLoanTime(), "yyyyMMdd");
		String path = PropertyFileUtil.getProperty("filePath") + File.separator
				+ "pdf" + File.separator + dateString;
		System.out.println("存放投资人合同地址" + path);
		log.info("存放投资人合同地址" + path);
		PDFUtil.checkandmkdirFile(path);
		return path;

	}

	/*
	 * 判断文件夹是否存在，不存在则新建
	 */
	public static boolean checkandmkdirFile(String path) {
		boolean bb = true;
		if (!checkFile(path)) {
			File file = new File(path);
			bb = file.mkdirs();
		}
		return bb;
	}

	/*
	 * 判断文件夹是否存在
	 */
	public static boolean checkFile(String path) {
		File file = new File(path);
		if (!file.exists() && !file.isDirectory()) {
			return false;
		}
		return true;
	}

	/*
	 * 判断文件是否存在
	 */
	public static boolean checkFile1(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

}