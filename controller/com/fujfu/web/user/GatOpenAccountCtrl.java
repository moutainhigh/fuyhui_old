package com.fujfu.web.user;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fujfu.common.util.FileUtil;
import com.fujfu.common.util.PropertyFileUtil;
import com.fujfu.common.util.UploadUtil;
import com.fujfu.pojo.user.UserVO;
import com.fujfu.web.BaseController;
@Controller
public class GatOpenAccountCtrl extends BaseController {

	private static final long serialVersionUID = 1L;
	@ResponseBody
	@RequestMapping(value = "gatOpenAccount",method = RequestMethod.POST)
	public Object gatOpenAccount(final MultipartFile idCard,final MultipartFile idCard2,final MultipartFile bankCard){
		// 返回的json对象
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断是否登录
		UserVO userInf = (UserVO) getSession("user_inf");
		if (userInf == null) {
			return returnMessage(map, "2", "请登录！");
		}
		// 判断是否为空
		if(idCard == null || idCard2 == null || bankCard == null){
			return returnMessage(map, "0", "缺少图片！");
		}
		// 获取上传文件后缀
		String idCardName = FileUtil.getFileExt(idCard.getOriginalFilename());
		String idCard2Name = FileUtil.getFileExt(idCard2.getOriginalFilename());
		String bankCardName = FileUtil.getFileExt(bankCard.getOriginalFilename());
		// 图片校验
		if(!FileUtil.isImageExt(idCardName) || !FileUtil.isImageExt(idCard2Name) || !FileUtil.isImageExt(bankCardName)){
			return returnMessage(map, "0", "图片格式不正确！");
		}
		if(idCard.getSize() > 1024*1024 || idCard2.getSize() > 1024*1024 || bankCard.getSize() > 1024*1024){
			return returnMessage(map, "0", "图片不能大于1M！");
		}
		// 上传图片(/gat/xxx.jpg)
		int userId = userInf.getUserId();
		String absolutePath = PropertyFileUtil.getProperty("filePath")+File.separator+"gat";
		boolean idCardFlag = false;
		boolean idCard2Flag = false;
		boolean bankCardFlag = false;
		// 新文件名
		String idCardNewName = userId+"idCard";
		String idCard2NewName = userId+"idCard2";
		String bankCardNewName = userId+"bankCard";
		try {
			idCardFlag = UploadUtil.uploadFile(absolutePath, idCard.getInputStream(), idCardName, idCardNewName);
			idCard2Flag = UploadUtil.uploadFile(absolutePath, idCard2.getInputStream(), idCard2Name, idCard2NewName);
			bankCardFlag = UploadUtil.uploadFile(absolutePath, bankCard.getInputStream(), bankCardName, bankCardNewName);
		} catch (IOException e) {
			e.printStackTrace();
			return returnMessage(map, "0", "系统异常！");
		}
		if(idCardFlag && idCard2Flag && bankCardFlag){
			map.put("flag", "1");
			map.put("idCardUrl", File.separator+"gat"+File.separator+idCardNewName+idCardName);
			map.put("idCard2Url", File.separator+"gat"+File.separator+idCard2NewName+idCard2Name);
			map.put("bankCardUrl", File.separator+"gat"+File.separator+bankCardNewName+bankCardName);
			return map;
		}else{
			return returnMessage(map, "0", "上传失败！");
		}
	}
	
	/**
	 * 返回的json对象
	 * 
	 * @param flag
	 * @param msg
	 * @return
	 */
	private Map<String, Object> returnMessage(Map<String, Object> map, String flag, String msg) {
		map.put("flag", flag);
		map.put("msg", msg);
		return map;
	}
}
