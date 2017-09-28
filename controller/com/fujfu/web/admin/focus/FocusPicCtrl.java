package com.fujfu.web.admin.focus;

import java.io.File;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.PropertyFileUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.UploadUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.focus.FocusPicVO;
import com.fujfu.service.focus.FocusPicServ;
import com.fujfu.web.BaseController;

@Controller
@RequestMapping("/focus/*")
public class FocusPicCtrl extends BaseController {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log =Logger.getLogger(FocusPicCtrl.class);
	
	@Resource
	private FocusPicServ focusPicServ;
	

	/**
	 * @return
	 */
	@RequestMapping("list")
	public String list(Page page, Model model) {
		FocusPicVO focusPic = new FocusPicVO();
		Page focusPicList = focusPicServ.findFocusPicByCondition(focusPic, page);
		model.addAttribute("focusPicList", focusPicList);
		return "views/admin/focus/focusPicList.jsp";
	}


	@RequestMapping(value = "enterAdd")
	public Object enterAdd() {
		return "views/admin/focus/addPic.jsp";
	}

	
	/**
	 * 添加banner图
	 * @return
	 */
	@RequestMapping(value = "add")
	public Object add(final MultipartFile picFile, HttpServletRequest request, HttpServletResponse response,
			Model model, FocusPicVO focusPic) throws Exception {

		if(!StringUtils.isNumeric(focusPic.getPosition().toString())) {
			model.addAttribute("msg", "图片位置必须是数字");
			return "views/admin/focus/addPic.jsp";
		}
		String path = request.getSession().getServletContext().getRealPath("") + File.separator;
		// 文件夹名称
		String dirName = DateUtil.getCurrentDate("yyyy-MM-dd");
		// 相对路径
		String imgurl = PropertyFileUtil.getProperty("bannerFilePath") + "/" + dirName;
		
		// 绝对路径
		String absolutePath = path + imgurl;
		log.info("Absolute Path = " + absolutePath);
		
		File file = new File(absolutePath);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		// 原文件名
		String originalName = picFile.getOriginalFilename();
		// 文件类型
		String type = originalName.substring(originalName.lastIndexOf(".") + 1, originalName.length());
		// 新文件名称
		String filename = DateUtil.getCurrentDate("yyMMddHHmmssSSS");
		// 文件大小
		Integer size = (int) picFile.getSize();

		String imgUrlStr = imgurl+"\\"+filename + "." + type;
		imgUrlStr = imgUrlStr.replaceAll("\\\\", "/");
		
		boolean flag = UploadUtil.uploadFile(absolutePath, picFile.getInputStream(), originalName, filename);
		focusPic.setOriginalName(originalName);
		focusPic.setFilename(filename + "." + type);
		focusPic.setImgurl(imgUrlStr);
		focusPic.setSize(size);
		focusPic.setMime(type);
		focusPic.setCreated(DateUtil.getUnixTime());
		focusPic.setUpdated(DateUtil.getUnixTime());

		int result = focusPicServ.add(focusPic);
		if (result > 0 && flag) {
			model.addAttribute("msg", "图片上传成功");
		} else {
			model.addAttribute("msg", "服务器忙");
		}
		return "views/admin/focus/addPic.jsp";

	}
	
	/**
	 * 删除banner图，逻辑删除，只改变状态
	 * @return
	 */
	@RequestMapping(value = "delete")
	public Object delete(Model model, String id) throws Exception {
		
		if(StringUtil.isEmpty(id) || !StringUtils.isNumeric(id)) {
			model.addAttribute("msg", "服务器忙");
		}else{
			FocusPicVO focusPic = new FocusPicVO();
			focusPic.setId(Integer.valueOf(id));
			focusPic.setStatus(2);
			focusPic.setUpdated(DateUtil.getUnixTime());
			int result = focusPicServ.update(focusPic);
			if (result > 0) {
				model.addAttribute("msg", "删除成功");
			} else {
				model.addAttribute("msg", "删除失败,服务器忙");
			}
		}
		return "views/admin/focus/addPic.jsp";
	}
	
	/**
	 * 编辑
	 * @return
	 */
	@RequestMapping(value = "edit")
	public Object edit(Model model, String id) throws Exception {
		
		if(StringUtil.isEmpty(id) || !StringUtils.isNumeric(id)) {
			model.addAttribute("msg", "服务器忙");
		}else{
			FocusPicVO focusPic = focusPicServ.getFocusPicById(Integer.valueOf(id));
			if (focusPic != null) {
				model.addAttribute("focusPic", focusPic);
			} else {
				model.addAttribute("msg", "服务器忙");
			}
		}
		return "views/admin/focus/editPic.jsp";
	}
	
	/**
	 * 确认编辑
	 * @return
	 */
	@RequestMapping(value = "confirmEdit")
	public String confirmEdit(Model model, FocusPicVO focusPic) throws Exception {
		
		focusPic.setUpdated(DateUtil.getUnixTime());
		int result = focusPicServ.update(focusPic);
		if (result > 0) {
			model.addAttribute("msg", "保存成功");
		} else {
			model.addAttribute("msg", "服务器忙");
		}
		return "redirect:/focus/list";
	}

}
