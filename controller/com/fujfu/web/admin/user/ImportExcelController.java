package com.fujfu.web.admin.user;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fujfu.common.util.ExcelUtil;
import com.fujfu.pojo.apply.RecoverImportExcelPOJO;
import com.fujfu.pojo.invest.InvestImportExcelPOJO;
import com.fujfu.service.invest.LoanInvestmentServ;
import com.fujfu.service.recover.RecoverServ;

@Controller
@RequestMapping("/ImportExcel/")
public class ImportExcelController {
	private static final long serialVersionUID = 1L;
	@Resource
	private LoanInvestmentServ loanInvestmentServ;
	@Resource
	private RecoverServ recoverServ;
	
	@RequestMapping("ImportExcelInvest")
	public void ImportExcelInvest(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String applyId = request.getParameter("id");
		List<InvestImportExcelPOJO> InvestList = loanInvestmentServ.InvestImportExcelList(Integer.parseInt(applyId));
		InputStream stream = null;
		OutputStream os = null;
		response.reset();
		response.setContentType("application/msexcel");
		String sname = "";
		if(InvestList.size()>0){
			sname=InvestList.get(0).getName();
		}		
		String asname =sname+"交易结果.xls";
		String fileName = new String(asname.getBytes("GB2312"), "ISO_8859_1");
		response.setHeader("Content-Disposition", "attachment; filename="+fileName);//***是文件名D://all.xls
		//response.setContentLength(stream.available());
		os = response.getOutputStream();
		LinkedHashMap<String, String> fieldMap =new LinkedHashMap();
		fieldMap.put("investTime","交易时间");
		fieldMap.put("name","项目分期名称");
		fieldMap.put("money","投资金额");
		fieldMap.put("realName","客户姓名");
		fieldMap.put("cardTypeName","证件类型");
		fieldMap.put("cardId","证件号码");
		
		List list1 =new ArrayList();
		
		try {
			ExcelUtil.listToExcel(InvestList, fieldMap, "交易结果.xls", 1000, os);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping("ImportExcelRecover")
	public void ImportExcelRecover(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String applyId = request.getParameter("id");
		String period = request.getParameter("period");
		List<RecoverImportExcelPOJO> recoverList = recoverServ.recoverImportExcelList(Integer.parseInt(applyId), Integer.parseInt(period));
		InputStream stream = null;
		OutputStream os = null;
		response.reset();
		response.setContentType("application/msexcel");
		String ss ="";
		if(recoverList.size()>0){
			ss=recoverList.get(0).getLoanName();
		}
		String as =ss+"兑付结果-" + period+".xls";
		String fileName = new String(as.getBytes("GB2312"), "ISO_8859_1");
		response.setHeader("Content-Disposition", "attachment; filename="+fileName);//***是文件名D://all.xls
		//response.setContentLength(stream.available());
		os = response.getOutputStream();
		LinkedHashMap<String, String> fieldMap =new LinkedHashMap();
		fieldMap.put("repay_done_time","兑付时间");
		//fieldMap.put("listingCode","项目挂牌代码");
		fieldMap.put("recoverPeriod","兑付期数");
		//fieldMap.put("StagingCode","分期代码");
		fieldMap.put("valuedate","本期起息日");
		fieldMap.put("maturitydate","本期结息日");
		fieldMap.put("repay_req_time","应兑日期");
		fieldMap.put("realName","客户姓名");
		fieldMap.put("cardTypeName","证件类型");
		fieldMap.put("cardId","证件号码");
		fieldMap.put("recover_money","兑付总金额");
		fieldMap.put("recover_capital","其中兑付本金");
		fieldMap.put("recover_interest","其中兑付利息");
		fieldMap.put("overdueInterest","其中兑付逾期利息");
		fieldMap.put("serialno1","银行/第三方流水号");
		fieldMap.put("cashingPassage","兑付通道(银行/第三方)");
		fieldMap.put("serialno2","合作方兑付流水号");

		List list1 =new ArrayList();
		
		try {
			ExcelUtil.listToExcel(recoverList, fieldMap, "兑付结果.xls", 1000, os);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
