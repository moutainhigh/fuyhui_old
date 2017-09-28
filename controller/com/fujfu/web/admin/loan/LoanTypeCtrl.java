package com.fujfu.web.admin.loan;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.PropertyFileUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.loan.LoanTypeVO;
import com.fujfu.service.loan.LoanTypeServ;
import com.fujfu.web.BaseController;
import com.fujfu.web.constant.FeeProperties;
@Controller
@RequestMapping("/loanType/")
public class LoanTypeCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	
	@Resource
	private LoanTypeServ loanTypeServ;

	/**
	 * 进入产品配置首页
	 * @return
	 */
	@RequestMapping("index")
	public String index(Page page,Model model){
		LoanTypeVO loanType = new LoanTypeVO();
		Page loanTypeList = loanTypeServ.findLoanTypeByCondition(loanType, page);
		model.addAttribute("loanTypeList", loanTypeList);
		return "views/admin/loanType/loanTypeList.jsp";
	}
	
	/**
	 * 进入添加产品配置
	 * @return
	 */
	@RequestMapping("enterAdd")
	public String enterAdd(Model model){
		model.addAttribute("categoryList", FeeProperties.LOAN_CATEGORY);
		model.addAttribute("productSourceList", FeeProperties.PRODUCT_SOURCE);
		return "views/admin/loanType/addLoanType.jsp";
	}
	
	/**
	 * 进入修改产品配置
	 * @return
	 */
	@RequestMapping("enterUpdate")
	public String enterUpdate(Model model,String id){
		LoanTypeVO loanType = loanTypeServ.findLoanTypeById(Integer.parseInt(id));
		model.addAttribute("loanType", loanType);
		model.addAttribute("categoryList", FeeProperties.LOAN_CATEGORY);
		model.addAttribute("productSourceList", FeeProperties.PRODUCT_SOURCE);
		return "views/admin/loanType/updateLoanType.jsp";
	}
	
	/**
	 * 添加
	 * @param model
	 * @param loanType
	 * @return
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request,Model model,LoanTypeVO loanType){
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
					String absolutePath = PropertyFileUtil.getProperty("filePath")+File.separator+"productPic";
					// 定义上传路径
					String path = absolutePath + File.separator + file.getOriginalFilename();
					File localFile = new File(path);
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
					loanType.setUrl(File.separator+"productPic"+File.separator+fileNameList.get(i));
				}else{
					loanType.setUrl(loanType.getUrl()+","+File.separator+"productPic"+File.separator+fileNameList.get(i));
				}
			}
		}
		if(fileNameList.size()>0){
			loanType.setCreated(DateUtil.getUnixTime());
			int result = loanTypeServ.addLoanType(loanType);
			if(result>0){
				model.addAttribute("msg","添加产品配置成功");
			}else{
				model.addAttribute("msg","添加产品配置失败");
			}
		}else{
			model.addAttribute("msg","请选择图片！");
		}
		return "redirect:/loanType/index";
	}
	
	/**
	 * 修改
	 * @param model
	 * @param loanType
	 * @return
	 */
	@RequestMapping("update")
	public String update(HttpServletRequest request,Model model,LoanTypeVO loanType){
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
					String absolutePath = PropertyFileUtil.getProperty("filePath")+File.separator+"productPic";
					// 定义上传路径
					String path = absolutePath + File.separator + file.getOriginalFilename();
					File localFile = new File(path);
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
					loanType.setUrl(File.separator+"productPic"+File.separator+fileNameList.get(i));
				}else{
					loanType.setUrl(loanType.getUrl()+","+File.separator+"productPic"+File.separator+fileNameList.get(i));
				}
			}
		}
		if(fileNameList.size()>0){
			int result = loanTypeServ.updateLoanType(loanType);
			if(result>0){
				model.addAttribute("msg","修改产品配置成功");
			}else{
				model.addAttribute("msg","修改产品配置失败");
			}
		}else{
			model.addAttribute("msg","请选择图片！");
		}
		return "redirect:/loanType/index";
	}
	
	/**
	 * 删除
	 * @param model
	 * @param loanType
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(Model model,String id){
		int result = loanTypeServ.delLoanType(Integer.parseInt(id));
		if(result>0){
			model.addAttribute("msg","删除产品配置成功");
		}else{
			model.addAttribute("msg","删除产品配置失败");
		}
		return "redirect:/loanType/index";
	}

	/**
	 * 根据产品类型id查询产品类型信息
	 * @return
	 */
	@RequestMapping("findLoanTypeById")
	@ResponseBody
	public Object findLoanTypeById(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isNotEmpty(id)){
			// 产品类型图片数组
			String url[] = loanTypeServ.findLoanTypeById(Integer.parseInt(id)).getUrl().split(",");
			map.put("flag", "1");
			map.put("content", url);
		}else{
			map.put("flag", "0");
		}
		return map;
	}
}
