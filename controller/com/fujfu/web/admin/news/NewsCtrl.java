package com.fujfu.web.admin.news;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import com.fujfu.pojo.news.NewsVO;
import com.fujfu.pojo.news.NewsCategoryPOJO;
import com.fujfu.pojo.news.NewsDTO;
import com.fujfu.pojo.news.NewsPOJO;
import com.fujfu.service.news.NewsCategoryServ;
import com.fujfu.service.news.NewsServ;
import com.fujfu.web.BaseController;

@Controller
@RequestMapping("/news/")
public class NewsCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private NewsServ newsServ;
	@Resource
	private NewsCategoryServ newsCategoryServ;
	
	/**进入列表界面
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request,String title, Page page,String startTime,String endTime, Model model) {
		NewsDTO newsQueryVo = new NewsDTO();
		if (StringUtils.isNotEmpty(startTime)) {
			try {
				newsQueryVo.setStartTime(DateUtil.dateTimeStamp(startTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(endTime)) {
			try {
				newsQueryVo.setEndTime(DateUtil.dateTimeStamp(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (StringUtils.isNotEmpty(title)) {
			newsQueryVo.setTitle(title);
		}
 		Page newsList = newsServ.findNewsByCondition(newsQueryVo, page);
		model.addAttribute("newsList", newsList);
		return "views/admin/news/newsList.jsp";

	}
	
	/**
	 * 进入新增界面
	 */
	@RequestMapping("enterAdd")
	public String enterAdd(Model model){
		List<NewsCategoryPOJO> newsCategoryNameList= newsCategoryServ.listAllNewsCategory();
		model.addAttribute("newsCategoryNameList", newsCategoryNameList);
		return "views/admin/news/addNews.jsp";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("add")
	public String add(HttpServletRequest request,Model model,NewsVO news){
		
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
							String absolutePath = request.getSession().getServletContext().getRealPath("")
									+ File.separator + PropertyFileUtil.getProperty("newsFilePath");
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
							news.setUrl(fileNameList.get(i));
						}else{
							news.setUrl(news.getUrl()+","+fileNameList.get(i));
						}
					}
				}
		news.setCreated(DateUtil.getUnixTime());
		int result  = newsServ.addNews(news);
		if(result>0){
			model.addAttribute("msg","添加新闻成功");
		}else{
			model.addAttribute("msg","添加新闻失败");
		}	
		return "redirect:/news/index";
	}
	
	@RequestMapping("listAllNewsCategory")
	@ResponseBody
	public List<NewsCategoryPOJO> listAllNewsCategory(){
		List<NewsCategoryPOJO> newsCategoryList= newsCategoryServ.listAllNewsCategory();
		return newsCategoryList;
	}
	
	/**
	 * 进入修改界面
	 */
	@RequestMapping("enterUpdate")
	public String enterUpdate(Model model,String id){
		NewsPOJO newsVo = newsServ.findNewsVoById(Integer.parseInt(id));
		model.addAttribute("newsVo",newsVo);
		return "views/admin/news/updateNews.jsp";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("update")
	public String update(Model model,NewsVO news){
		news.setUpdated(DateUtil.getUnixTime());
		int result = newsServ.updateNews(news);
		if(result>0){
			model.addAttribute("msg","修改成功");
		}else{
			model.addAttribute("msg","修改失败");
		}			
		return "redirect:/news/index";
	}
	
	/**
	 * 逻辑删除
	 */
	@RequestMapping("delete")
	public String delete(Model model,String id){
		NewsVO news  = new NewsVO();
		news.setId(Integer.parseInt(id));
		news.setStatus((short)-1);
		int result = newsServ.updateNews(news);
		if(result>0){
			model.addAttribute("msg", "删除成功");
		}else{
			model.addAttribute("msg", "删除失败");
		}
		return "redirect:/news/index";
	}
	
	/**
	 * 审核通过
	 */
	@RequestMapping("changeStatus")
	public String changeStatus(Model model,String id){
		NewsVO news  = new NewsVO();
		news.setId(Integer.parseInt(id));
		news.setStatus((short)1);
		int result = newsServ.updateNews(news);
		if(result>0){
			model.addAttribute("msg", "审核已通过");
		}else{
			model.addAttribute("msg", "审核通过失败");
		}
		return "redirect:/news/index";
	}
	
	/**
	 * 进入预览界面
	 */
	@RequestMapping("enterPreview")
	public String enterPreview(Model model,String id){
		NewsPOJO news = newsServ.findNewsVoById(Integer.parseInt(id));
		model.addAttribute("news", news);
		return "views/admin/news/newsPreview.jsp";
	}
}
