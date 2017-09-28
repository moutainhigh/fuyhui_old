package com.fujfu.web.common;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujfu.common.util.DateUtil;
import com.fujfu.common.util.StringUtil;
import com.fujfu.common.util.tag.Page;
import com.fujfu.pojo.common.MessageVO;
import com.fujfu.pojo.common.MessagePOJO;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.service.common.MessageServ;
import com.fujfu.service.user.UserServ;
import com.fujfu.web.BaseController;


@Controller
@RequestMapping("/message/")
public class MessageCtrl extends BaseController {
	private static final long serialVersionUID = 1L;
	@Resource
	private MessageServ messageServ;
	@Autowired
	private UserServ userServ;
	
	/**
	 * 站内信首页
	 * @param request
	 * @param page
	 * @param title
	 * @param content
	 * @param startTime
	 * @param endTime
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, Page page,String title,String content,String type,String startTime,String endTime, Model model) {
		MessagePOJO messageQueryVo = new MessagePOJO();
		if(!StringUtil.isEmpty(startTime)){
			try {
				messageQueryVo.setStartTime(DateUtil.dateTimeStamp(startTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(!StringUtil.isEmpty(endTime)){
			try {
				messageQueryVo.setEndTime(DateUtil.dateTimeStamp(endTime));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(!StringUtil.isEmpty(type)){
			messageQueryVo.setType(Integer.parseInt(type));
		}else{
			messageQueryVo.setType(0);
		}
		messageQueryVo.setTitle(title);
		messageQueryVo.setContent(content);
		Page messageList = messageServ.findMessageByCondition(messageQueryVo, page);
		model.addAttribute("messageList", messageList);
		return "/views/admin/message/messageList.jsp";
	}
	//前台用户查询站内信
	@RequestMapping("userMsgList")
	@ResponseBody
	public Object userMsgList(HttpSession session, String userId,String pageNum ,String pageSize) {
		UserVO user = (UserVO) session.getAttribute("user_inf");
		//user =userServ.getUserByUserId(1000000113);
		MessagePOJO messageQueryVo = new MessagePOJO();
		// 定义返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
		if(StringUtil.isEmpty(pageNum)){
			pageNum="1";
		}
		if(StringUtil.isEmpty(pageSize)){
			pageSize="6";
		}
		if(!StringUtil.isEmpty(userId)){
			messageQueryVo.setUserId(Integer.parseInt(userId));
		}
		messageQueryVo.setDeleted(0);
		messageQueryVo.setType(1);
		Page page =new Page();
		page.setPageNum(Integer.parseInt(pageNum));
		page.setPageSize(Integer.parseInt(pageSize));
		page = messageServ.findMessageByCondition(messageQueryVo, page);
		ArrayList<MessageVO> MessageList = (ArrayList<MessageVO>) page.getItems();
		int totalNum=(int)page.getTotalCount();
		int totalPage = totalNum % Integer.parseInt(pageSize) == 0 ? totalNum / Integer.parseInt(pageSize) : totalNum / Integer.parseInt(pageSize) + 1;
		map.put("flag", "1");
		map.put("content", MessageList);
		map.put("totalPage",totalPage);
		return map;
		} else {
			map.put("flag", "0");
			map.put("msg", "登录后可查看");
			return map;
		}
	}
	
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("enterAdd")
	public String enterAdd(){
		return "views/admin/message/addMessage.jsp";
	}
	
	/**
	 * 添加
	 * @param model
	 * @param message
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model,String title,String content){
		int result = messageServ.batchInsert(title,content);
		if(result>0){
			model.addAttribute("msg","新增站内信成功");
		}else{
			model.addAttribute("msg","新增站内信失败");
		}	
		return "redirect:/message/index";
	}
	
	/**
	 * 移动端获取站内信
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getMessage",method = RequestMethod.POST)
	public Object getMessage(HttpServletRequest request){
		MessagePOJO messageVo = new MessagePOJO();
		int userId;
		int pageSize = 10;
		int pageNum = 1;
		Map<String,Object> map = new HashMap<String,Object>();
		if(StringUtils.isNotEmpty(request.getParameter("userId"))){
			userId = Integer.parseInt(request.getParameter("userId"));
			if(StringUtils.isNotEmpty(request.getParameter("pageSize"))){
				pageSize = Integer.parseInt(request.getParameter("pageSize"));
			}
			if(StringUtils.isNotEmpty(request.getParameter("pageNum"))){
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			}
			Page page = new Page();
			page.setPageSize(pageSize);
			page.setPageNum(pageNum);
			messageVo.setUserId(userId);
			//messageVo.setSendStatus(true);
			messageVo.setDeleted(0);
			Page messageList = messageServ.findMessageByCondition(messageVo, page);
			map.put("flag", "1");
			map.put("msg", "获取站内信成功!");
			map.put("message", messageList);
			return map;
		}else{
			map.put("flag","0");
			map.put("msg", "参数userId不能为空!");
			map.put("message", null);
			return map;
		}
	} 
	
	/**
	 * 修改站内信阅读状态
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="updateStatu",method = RequestMethod.POST)
	public Object updateStatu(HttpServletRequest request){
		MessageVO message = new MessageVO();
		Map<String,Object> map = new HashMap<String,Object>();
		String ids =request.getParameter("ids");
		if(!StringUtils.isEmpty(ids)){
            String [] stringArr= ids.split(",");			
			int result = messageServ.updateMeSta(stringArr);
			if(result>0){
				map.put("flag", "1");
				map.put("msg", "修改成功!");
				return map;
			}else{
				map.put("flag", "0");
				map.put("msg", "修改失败!");
				return map;
			}
		}else{
			map.put("flag", "0");
			map.put("msg", "参数id不能为空");
			return map;
		}
	}
	
	/**
	 * 删除站内信
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="deleteMessage",method = RequestMethod.POST)
	public Object deleteMessage(HttpServletRequest request){
		Map<String,Object> map = new HashMap<String,Object>();
		String ids =request.getParameter("ids");
		if(!StringUtils.isEmpty(ids)){
			String [] stringArr= ids.split(",");
			
			int result = messageServ.updateMeDel(stringArr);
			if(result>0){
				map.put("flag", "1");
				map.put("msg", "删除成功!");
				return map;
			}else{
				map.put("flag", "0");
				map.put("msg", "删除失败!");
				return map;
			}
		}else{
			map.put("flag", "0");
			map.put("msg", "参数id不能为空");
			return map;
		}
	}
}

