<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="date"%>
<!DOCTYPE html>
<html lang="en">
<head lang="zh-cn">
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>账户设置-账户中心-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/jquery.inputbox.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/securityinfos.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-form.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery.inputbox.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery.ganged.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/provinces.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/personalbasicinfos.js'></script>
	<script type="text/javascript" src='../../static/scripts/user/md5.js'></script>
</head>
<body>
<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			if(confirm("${param.msg}")){
				window.location.href=getContextPaths()+'/myAccount/enterPersonalinfos';
			}else{
				window.location.href=getContextPaths()+'/myAccount/enterPersonalinfos';
			}
		</script>
	</c:if>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<!--  账户中心-->
	<div class="warp_account_center">
		<!-- 资产总览内容区域 -->
		<div class="user_account1000">
			<!-- 引入左边菜单导航栏 -->
			<%@ include file="leftMenu.jsp"%>
			<!-- 右边账户中心内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name" style="height:24px;text-indent:-9999px;">个人基本信息</div>
				<!-- 内容盒子Start -->
				<div class="per_rigBotContent_box">
					<!-- 头像Start -->
					<div class="com_perDiv per_headerBox">
						<div class="fl com_perBgBox"><p class="headerBg"></p></div>
						<p class="com_perTitle">头像</p>
						<p class="com_perTxt">用于平台头像</p>
						<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
							 当状态为‘已设置’时，此处的样式是per_success_tips
						 -->
						<p class="com_perTips psimg per_error_tips"></p>
						<!-- <p class="com_perState headState">未设置</p> -->
						<p class="com_perSite headSite">设置</p>
						<div class="clear"></div>
					</div>

					<!-- 用户名Start -->
					<!-- <div class="com_perDiv per_unameBox">
						<div class="fl com_perBgBox"><p class="unameBg"></p></div>
						<p class="com_perTitle">用户名</p>
						<p class="com_perTxt">${sessionScope.user_inf.username}</p> -->
						<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
							 当状态为‘已设置’时，此处的样式是per_success_tips
						 -->
						<!-- <p class="com_perTips unameimg per_error_tips"></p> -->
						<!-- <p class="com_perState unameState">未设置</p> -->
					<!-- 	<p class="com_perSite umSite unameSite">设置</p>
						<div class="clear"></div>
					</div> -->

					<!-- 登录密码Start -->
					<div class="com_perDiv per_pwdBox">
						<div class="fl com_perBgBox"><p class="pwdBg"></p></div>
						<p class="com_perTitle">登录密码</p>
						<p class="com_perTxt">*******</p>
						<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
							 当状态为‘已设置’时，此处的样式是per_success_tips
						 -->
						<p class="com_perTips lpwdimg per_error_tips"></p>
						<!-- <p class="com_perState pwdState">未设置</p> -->
						<p class="com_perSite pwdSite">设置</p>
						<div class="clear"></div>
					</div>

					<!-- 手机号Start -->
					<form action="${pageContext.request.contextPath }/fy/chgMobile" id="addForms" name="addForm" method="post" >  
						<div class="com_perDiv per_iphoneBox">
							<div class="fl com_perBgBox"><p class="iphoneBg"></p></div>
							<p class="com_perTitle">手机号</p>
							<p class="com_perTxt">${sessionScope.user_inf.mobile}</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips ipeimg per_error_tips"></p>
							<!-- <p class="com_perState iphoneState">未设置</p> -->
							<!-- <p class="com_perSite iphoneSite">修改</p> -->
							<button type="submit" class="com_perSite iphoneSite" style="border:0;background:#fff;margin-left:-19px;outline:none;height:66px;">修改</button>
							<div class="clear"></div>
						</div>
					</form>
					<!-- 邮箱Start -->
					<!-- <div class="com_perDiv per_emailBox">
						<div class="fl com_perBgBox"><p class="emailBg"></p></div>
						<p class="com_perTitle">邮箱</p>
						<p class="com_perTxt emailTxt" etxt=${sessionScope.user_inf.email}>获取最新消息及信息变动通知</p> -->
						<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
							 当状态为‘已设置’时，此处的样式是per_success_tips
						 -->
						<!-- <p class="com_perTips eailimg per_error_tips"></p> -->
						
					<!-- 	<p class="com_perSite emailSite">设置</p>
						<div class="clear"></div>
					</div> -->

					<!-- 真实姓名Start -->
					<div class="com_perDiv per_certificationBox">
						<div class="fl com_perBgBox"><p class="certificationBg"></p></div>
						<p class="com_perTitle rnames" realNames=${sessionScope.user_inf.realname}>真实姓名</p>
						<p class="com_perTxt realNamesTxt">实名认证，账户更安全</p>
						<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
							 当状态为‘已设置’时，此处的样式是per_success_tips
						 -->
						<p class="com_perTips reaNames per_error_tips"></p>
						<!-- <p class="com_perState certificationState">未设置</p> -->
						<p class="com_perSite certificationSite">认证</p>
						<div class="clear"></div>
					</div>

					<!-- 富友账号Start -->
					<!-- <div class="com_perDiv depositBox">
						<div class="fl com_perBgBox"><p class="depositBg"></p></div>
						<p class="com_perTitle">富友账号</p>
						<p class="com_perTxt">资金存管第三方账户</p> -->
						<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
							 当状态为‘已设置’时，此处的样式是per_success_tips
						 -->
					<!-- 	<p class="com_perTips per_error_tips"></p>
						<p class="com_perState depositState">未设置</p> -->
						<!-- <p class="com_perSite depositSite" onclick="window.location.href='/enterEscrowAccount'">开通</p>
						<div class="clear"></div>
					</div>  -->

					<!-- 银行卡号Start -->
					<div class="com_perDiv bankBox">
						<div class="fl com_perBgBox"><p class="bankBg"></p></div>
						<p class="com_perTitle">银行卡号</p>
						<p class="com_perTxt bgTxts" bkNumber=${sessionScope.user_inf.capAcntNo}>用于快捷充值/提现绑定银行卡</p>
						<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
							 当状态为‘已设置’时，此处的样式是per_success_tips
						 -->
						<p class="com_perTips bkimg per_error_tips"></p>
						<p class="com_perSite bankSite">绑定</p>
						<div class="clear"></div>
					</div>

					<!-- 提现密码Start -->
					<form action="${pageContext.request.contextPath }/fy/pwdMgt" id="addForm" name="addForm" method="post" >  
						<div class="com_perDiv tradePwdBox">
							<div class="fl com_perBgBox"><p class="tradePwdBg"></p></div>
							<p class="com_perTitle">提现密码</p>
							<p class="com_perTxt txmaTxt">用于平台交易时的密码</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips tmimg per_error_tips"></p>
							<button type="submit" id="submit_btn" class="com_perSite txSite fl" style="border:0;width:68px;background:#fff;margin-left:-13px;outline:none;font-family:'微软雅黑'">设置</button>
							
							<div class="clear"></div>
						</div>
					</form>

					<!-- 常用地址Start -->
					<!-- <div class="com_perDiv addressBox">
						<div class="fl com_perBgBox"><p class="addressBg"></p></div>
						<p class="com_perTitle">常用地址</p>
						<p class="com_perTxt addressTxt" aresTxt=${sessionScope.user_inf.countryCode1}${sessionScope.user_inf.countryCode2}${sessionScope.user_inf.countryCode3}${sessionScope.user_inf.address}>用于寄送礼品等</p> -->
						<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
							 当状态为‘已设置’时，此处的样式是per_success_tips
						 -->
					<!-- 	<p class="com_perTips arsimg per_error_tips"></p>
						<p class="com_perSite addressSite">设置</p>
						<div class="clear"></div>
					</div> -->

					<!-- 风险测评Start -->
					<div class="com_perDiv riskBox">
						<div class="fl com_perBgBox"><p class="riskBg"></p></div>
						<p class="com_perTitle">风险测评</p>
						<p class="com_perTxt riskTeXt">当前投资风格：<span class='riskgrde'>稳健型</span></p>
						<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
							 当状态为‘已设置’时，此处的样式是per_success_tips
						 -->
						<p class="com_perTips risk_img per_error_tips"></p>
						<p class="com_perSite fl risk_btn" onclick="window.location.href=getContextPaths()+'/enterRiskEvaluation?id=1'">立即测评</p>
						<div class="clear"></div>
					</div>
					<!-- 风险测评end -->

				</div>
				<!-- 内容盒子End -->
			</div>
			<!-- 右边账户中心内容区域End -->
			<div class="clear"></div>
		</div>


		
	</div>

	<!-- 设置头像弹窗Start -->
	<div class="com_window head_window">
		<form  method="post" id="upload_head_form" enctype="multipart/form-data">
			<div class="com_wTitle">
				<p class="fl com_window_title">设置头像</p>
				<p class="fr com_window_close head_wClose"></p>
				<div class="clear"></div>
			</div>
			<div class="uploadBox">
				<div class="head_uploadBox" id="imgdiv">
					<img id="imgShowes" border='0' pavatar='${sessionScope.user_inf.avatar}' src=''>
				</div>
				<input type="file" class='upload_heads' id="up_img" name ="apkFile">
			</div>
			<div class="com_werror uploadError"></div>
			<p class="upload_txts">上传头像</p>
			<p class="upload_infos">说明：1.图片格式支持jpg/png/bmp  2.图片大小不超过1M.</p>
			
			<div class="com_wBtn upload_btns">	
				<button type="submit" id="hdsubmit_btn" class="com_wBtn" style="border:0;outline:none;">保存</button>
			</div>
		</form>
	</div>

	<!-- 设置用户名弹窗Start -->
	<div class="com_window uname_window">
	<form action="${pageContext.request.contextPath }/user/updateUserName" method="post" id="pwd_wform">
		<div class="com_wTitle" style="margin-bottom:30px;">
			<p class="fl com_window_title">设置用户名</p>
			<p class="fr com_window_close head_wClose"></p>
			<div class="clear"></div>
		</div>
		<div class="com_wInput">
			<input type="text" name='username' class="w_inputTxt per_name" id="per_name" placeholder='用户名'>
		</div>
		<div class="com_werror unameError"></div>
		<button class="com_wBtn uname_btns">保存</button>
		
		</form>
	</div>

   <!-- 修改密码弹窗Start -->
	<div class="com_window pwd_window">
		<form action="" method="post" id="pwd_wform">
			<div class="com_wTitle" style="margin-bottom:30px;">
				<p class="fl com_window_title">修改密码</p>
				<p class="fr com_window_close head_wClose"></p>
				<div class="clear"></div>
			</div>
			<input type="hidden" name='per_userid' class="w_inputTxt per_userid" id="per_userid"  value="${sessionScope.user_inf.userId}">
			<div class="com_wInput">
				<input type="password" name='per_old_pwd' class="w_inputTxt per_old_pwd" id="per_old_pwd" placeholder='输入旧密码'>
			</div>
			<div class="com_werror oldcodeError"></div>

			<div class="com_wInput">
				<input type="password" name='per_new_pwd' class="w_inputTxt per_new_pwd" id="per_new_pwd" placeholder='新登录密码' onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\@\.\!\~\#\%\*\&\$]/g,'')">
			</div>
			<div class="com_werror newpwdError"></div>

			<div class="com_wInput">
				<input type="password" name='per_confrim_pwd' class="w_inputTxt per_confrim_pwd" id="per_confrim_pwd" placeholder='确认新登录密码' onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\@\.\!\~\#\%\*\&\$]/g,'')">
			</div>
			<div class="com_werror conpwdError"></div>
			
			<div class="com_wBtn pwds_btns">保存</div>
		</form>
	</div>

	<!-- 手机号弹窗Start -->
	<div class="com_window iphones_window">
		<div class="com_wTitle" style="margin-bottom:36px;">
			<p class="fl com_window_title">修改手机号</p>
			<p class="fr com_window_close iphone_wClose"></p>
			<div class="clear"></div>
		</div>
		<!-- 验证身份start -->
		<div class="site01Box">
			<div class="siteImg site01_bg"></div>
			<p class="siteTxt">
				<span>手机号</span>
				<span class='siteIphones'>${sessionScope.user_inf.mobile}</span>
			</p>
			<div class="com_wInput">
				<input type="text" name='per_iphoneCode' class="w_inputTxt per_iphoneCode" id="per_iphoneCode" placeholder='手机验证码' maxlength="6" onkeyup="this.value=this.value.replace(/[^0-9\.]/g,'')">
				<input type="button" class="phone_codeBtn" id="phone_codeBtn" value="发送验证码">
			</div>
			<div class="com_werror icodeError"></div>
			
			<div class="com_wBtn ip_codebtns">下一步</div>
		</div>

		<!-- 重置手机号start -->
		<div class="site02Box" style="display:none;">
		<form action="${pageContext.request.contextPath }/fy/chgMobile"
			id="addForm" name="addForm" method="post" target="_blank">  
			<div class="siteImg site02_bg"></div>
						
			<p class="siteTxt">
				<span>手机号</span>
				<span class='siteIphones'>${sessionScope.user_inf.mobile}</span>
			</p>
			<div class="com_wInput">
				<input type="hidden" name='per_userids' class="w_inputTxt per_userids" id="per_userids"  value="${sessionScope.user_inf.userId}">	
				<input type="text" name='modify_iphone' class="w_inputTxt modify_iphone" id="modify_iphone" placeholder='新手机号' maxlength="11" onkeyup="this.value=this.value.replace(/[^0-9\.]/g,'')">
			</div>
			<div class="com_werror newcodeError"></div>
			
			<div ><button  class="com_wBtn ip_btns" >下一步</button></div>
			</form>
		</div>

		<!-- 完成start -->
		<div class="site03Box" style="display:none;">
			<div class="siteImg site03_bg"></div>
			<p class="siteInfos">
				恭喜您成功绑定了新的手机号码！
			</p>
		
			<div class="com_wBtn completes_btns">完成</div>
		</div>

	</div>

	<!-- 设置邮箱弹窗Start -->
	<div class="com_window email_window">
		<div class="com_wTitle" style="margin-bottom:30px;">
			<p class="fl com_window_title">设置邮箱</p>
			<p class="fr com_window_close head_wClose"></p>
			<div class="clear"></div>
		</div>
		<div class="com_wInput">
			<input type="text" name='per_emails' class="w_inputTxt per_emails" id="per_emails" placeholder='邮箱地址' onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\@\.\!\~\#\%\*\&\$]/g,'')">
		</div>
		<div class="com_werror eAddresError"></div>
		<div class="com_wInput">
			<input type="text" name='per_emails_code' class="w_inputTxt per_emails_code" id="per_emails_code" placeholder='邮箱验证码' onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\@\.\!\~\#\%\*\&\$]/g,'')">
			<input type="button" class="email_codeBtn" id="email_codeBtn" value="发送验证码">
		</div>
		<div class="com_werror ecodeError"></div>
		<div class="com_wBtn emails_btns">确认</div>
	</div>

	<!-- 设置交易密码弹窗Start -->
	<div class="com_window tradePwd_window">
		<div class="com_wTitle" style="margin-bottom:30px;">
			<p class="fl com_window_title">修改交易密码</p>
			<p class="fr com_window_close head_wClose"></p>
			<div class="clear"></div>
		</div>
		<div class="modeify_site01">
			<p class="modeify_infos">
				<span>手机号</span>
				<span class='t_iphone'>${sessionScope.user_inf.mobile}</span>
			</p>
			<div class="com_wInput">
				<input type="text" name='img_code' class="w_inputTxt img_code" id="img_code" placeholder='图形验证码'>
				<img id="imgCode" class="imgCode" alt="验证码" src="" />
			</div>
			<div class="com_werror timgError"></div>

			<div class="com_wInput">
				<input type="text" name='trade_code' class="w_inputTxt trade_code" id="trade_code" placeholder='手机验证码'>
				<input type="button" class="trade_codeBtn" id="trade_codeBtn" value="发送验证码">
			</div>
			<div class="com_werror tcodeError"></div>
			<div class="com_wBtn trade_btns">下一步</div>
		</div>

		<div class="modeify_site02" style="display:none;">
			<div class="com_wInput">
				<input type="password" name='old_trade_pwd' class="w_inputTxt old_trade_pwd" id="old_trade_pwd" placeholder='旧交易密码'>
			</div>
			<div class="com_werror oldpwdError"></div>

			<div class="com_wInput">
				<input type="password" name='new_trade_pwd' class="w_inputTxt new_trade_pwd" id="new_trade_pwd" placeholder='新交易密码'>
			</div>
			<div class="com_werror newpwdError"></div>

			<div class="com_wInput">
				<input type="password" name='confirm_newPwd' class="w_inputTxt confirm_newPwd" id="confirm_newPwd" placeholder='确认新交易密码'>
			</div>
			<div class="com_werror conpwdError"></div>

			<div class="com_wBtn trade_confirm_btns">保存</div>
		</div>
	</div>

	<!-- 设置常用地址Start -->
	<div class="com_window address_window">
		<div class="com_wTitle" style="margin-bottom:30px;">
			<p class="fl com_window_title">设置常用地址</p>
			<p class="fr com_window_close address_wClose"></p>
			<div class="clear"></div>
		</div>
		<div id="adress_select">
			<input type="hidden" class="province" value="010000"/>
			<input type="hidden" class="city" value="010100"/>
			<input type="hidden" class="area" value="010101"/>
			<div name="province" type="selectbox" style="z-index:2;" class="provincess"><div class="opts"></div></div>
			<div name="city" type="selectbox" style="z-index:2;" class="cityess"><div class="opts"></div></div>
			<div name="area" type="selectbox" style="z-index:2;" class="areaess"><div class="opts"></div></div>
		</div>
		<div class="com_werror"></div>

		<div class="com_wInput adres_input">
			<input type="text" name='adres_names' class="w_inputTxt adres_names" id="adres_names" placeholder='街道名称'>
		</div>
		<div class="com_werror"></div>
		<div class="com_wBtn adress_btns">保存</div>
	</div>

	<!-- 错误提示弹窗 -->
	<div class="one_contxt_window">
		<div class="error_txts"></div>
		<div class="error_btns">确认</div>
	</div>
		
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>




<script type="text/javascript">
	$(function(){

	// 头像上传js调用
	new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShowes" });
	
	$.ajax({
        type:'post',
        url:getContextPaths()+'/user/getPersonStatus',
        dataType:'json',
        success:function(json){
        	// 判断平台头像是否设置 1设置 0未设置
            if(json.avatarFlag=='1'){
                $('.psimg').removeClass('per_error_tips').addClass('per_success_tips');
                $('.headSite').html('修改');
            }else{
                $('.psimg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.headSite').html('设置');
            }

            // 判断用户名是否设置 1设置 0未设置 
            if(json.userNameFlag=='1'){
                $('.unameimg').removeClass('per_error_tips').addClass('per_success_tips');
                $('.umSite').html('已设置').removeClass('unameSite').removeClass('com_perSite').css({
                	'width':'66px',
                	'height':'100%',
                	'font-size':'14px',
                	'color':'#0bf',
                	'cursor':'pointer'
                });
                $('.umSite').unbind('click');
            }else{
                $('.unameimg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.umSite').html('设置').addClass('unameSite').addClass('com_perSite');
            }

            // 判断登录密码是否设置 1设置 0未设置 
            if(json.loginpasswordFlag=='1'){
                $('.lpwdimg').removeClass('per_error_tips').addClass('per_success_tips');
                $('.pwdSite').html('修改');
            }else{
                $('.lpwdimg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.pwdSite').html('设置');
            }

            // 判断手机号码是否设置 1设置 0未设置 
            if(json.MobilFlag=='1'){
                $('.ipeimg').removeClass('per_error_tips').addClass('per_success_tips');
            }else{
                $('.ipeimg').removeClass('per_success_tips').addClass('per_error_tips');
            }

            // 判断邮箱是否设置 1设置 0未设置 
            if(json.emailFlag=='1'){
                $('.eailimg').removeClass('per_error_tips').addClass('per_success_tips');
                $('.emailSite').html('修改');
                var emailTxt = $('.emailTxt').attr('etxt');
                $('.emailTxt').html(emailTxt);
            }else{
                $('.eailimg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.emailSite').html('设置');
                $('.emailTxt').html('获取最新消息及信息变动通知');
            }

            // 判断真实姓名是否设置 1设置 0未设置  2审批中 3审批拒绝
            if(json.cardFlag=='1'){
                $('.reaNames').removeClass('per_error_tips').addClass('per_success_tips');
                $('.certificationSite').html('已认证');
                $('.realNamesTxt').html($('.rnames').attr('realNames'));
            }else if(json.cardFlag==0){
                $('.reaNames').removeClass('per_success_tips').addClass('per_error_tips');
                $('.certificationSite').html('未认证');
                $('.realNamesTxt').html('实名认证，账户更安全');
                $('.certificationSite').click(function(){
                	window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount';
                });
            }else if(json.cardFlag==2){
            	$('.reaNames').removeClass('per_success_tips').addClass('per_error_tips');
                $('.certificationSite').html('审核中');
                $('.realNamesTxt').html('实名认证，账户更安全');
                $('.certificationSite').click(function(){
                	errorWindow('您开通的托管账户正在审核中......');
                });
            }else if(json.cardFlag==3){
                $('.reaNames').removeClass('per_success_tips').addClass('per_error_tips');
                $('.certificationSite').html('重新认证');
                $('.realNamesTxt').html('审核不通过');
                $('.certificationSite').click(function(){
                	window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount';
                });
            }

            // 判断银行卡号是否设置 1设置 0未设置 2审批中 3审批拒绝
            if(json.acntNoFlag=='1'){
                $('.bkimg').removeClass('per_error_tips').addClass('per_success_tips');
                $('.bankSite').html('已绑定');
                $('.bgTxts').html($('.bgTxts').attr('bkNumber'));
            }else if(json.acntNoFlag==0){
                $('.bkimg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.bankSite').html('未绑定');
                $('.bgTxts').html('用于快捷充值/提现绑定银行卡');
                $('.bankSite').click(function(){
                	window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount';
                });
            }else if(json.acntNoFlag==2){
            	$('.bkimg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.bankSite').html('未绑定');
                $('.bgTxts').html('用于快捷充值/提现绑定银行卡');
                $('.bankSite').html('审核中');
                $('.bankSite').click(function(){
                	errorWindow('您开通的托管账户正在审核中......');
                });
            }else if(json.acntNoFlag==3){
				$('.bkimg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.bankSite').html('重新绑定');
                $('.bgTxts').html('审核不通过');
                $('.bankSite').click(function(){
                	window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount';
                });
            }

            // 判断提现密码是否设置 1设置 0未设置  2审批中 3审批拒绝
            if(json.tixPassWordFlag=='1'){
                $('.tmimg').removeClass('per_error_tips').addClass('per_success_tips');
                // $('.tradePwdSite').html('修改');
                $('.txmaTxt').html('******');
                $('.txSite').css('width','68px');
            }else if(json.tixPassWordFlag==0){
                $('.tmimg').removeClass('per_success_tips').addClass('per_error_tips');
                // $('.tradePwdSite').html('设置');
                $('.txmaTxt').html('用于平台交易时的密码');
                $('.txSite').css('width','68px');
                $('.txSite').click(function(){
					if($('.certificationSite').text() == '已认证'){
						return true;
					}else{
						alert('真实姓名未认证，不能进行提现密码设置。');
						return false;
					}
				});
            }else if(json.tixPassWordFlag==2){
            	$('.txSite').html('审核中').css('width','68px');
            	$('.tmimg').removeClass('per_success_tips').addClass('per_error_tips');
            	$('.txSite').click(function(){
            		errorWindow('您开通的托管账户正在审核中......');
            		return false;
            	});
            }else if(json.tixPassWordFlag==3){
            	$('.txSite').html('重新提交').css('width','80px');
            	$('.txmaTxt').html('审核不通过');
            	$('.tmimg').removeClass('per_success_tips').addClass('per_error_tips');
            	$('.txSite').click(function(){
            		window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount';
            		return false;
            	});
            }

            // 判断常用地址是否设置 1设置 0未设置 
            if(json.ArdessFlag=='1'){
                $('.arsimg').removeClass('per_error_tips').addClass('per_success_tips');
                $('.addressSite').html('修改');
                var aresTxt = $('.addressTxt').attr('aresTxt');
                $('.addressTxt').html(aresTxt);
            }else{
                $('.arsimg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.addressSite').html('设置');
                $('.addressTxt').html('用于寄送礼品等');
            }

            //判断风险测评是否设置 0未设置 其它情况直接显示风险等级
            if(json.assessmentResult!='0'){
                $('.risk_img').removeClass('per_error_tips').addClass('per_success_tips');
            	var rtxts = '当前投资风格：'+'<span class="riskgrde">'+json.assessmentResult+'</span>';
            	$('.riskTeXt').html(rtxts);
                $('.risk_btn').html('重新测评');
            }else{
                $('.risk_img').removeClass('per_success_tips').addClass('per_error_tips');
                $('.risk_btn').html('立即测评');
                $('.riskTeXt').html('尚未测评');
            }
            // alert(json.assessmentResult);



        }
    });


	// 如果真实姓名没认证就不能调到富友那边进行提现密码设置
	// $('.txSite').click(function(){
	// 	if($('.certificationSite').text() == '已认证'){
	// 		return true;
	// 	}else{
	// 		alert('真实姓名未认证，不能进行提现密码设置。');
	// 		return false;
	// 	}
	// });


	// 用户名设置前的非空判断
	$('.uname_btns').click(function(){
		var flag = $('#per_name').val();
		var name_reg = /^[0-9a-zA-Z\u4e00-\u9fa5_]{3,}$/;
		if(flag==''){
			$('.unameError').html('用户名不能设置为空。');
			setTimeout(function(){
				$('.unameError').html('');
			},2000);
			return false;
		}else if(!name_reg.test(flag)){
			$('.unameError').html('用户名格式不正确。');
			setTimeout(function(){
				$('.unameError').html('');
			},2000);
			return false;
		}else if(flag.length>17){
			$('.unameError').html('用户名长度不允许超过16个字符。');
			setTimeout(function(){
				$('.unameError').html('');
			},2000);
			return false;
		}else{
			return true;
		}
	});

	// 如果用户未上传头像则显示默认头像否则显示用户上传的头像
	var uimgs = $('#imgShowes').attr('pavatar');
	var imgurls = globalUrl+uimgs
	if(uimgs==''){
		$('#imgShowes').attr('src','${pageContext.request.contextPath }/static/images/userAccount/per_morenImg.png');
	}else{
		$('#imgShowes').attr('src',imgurls);
	}
	
	// $('#hdsubmit_btn').click(function(){
	// 	if($('#up_img').val()=='' && uimgs == ''){	 
	// 		alert('默认头像不能上传，请重新选择要上传的头像。');
	// 		return false; 
	// 	}
	// 	if($('#up_img').val()==''){
			 
	// 		alert('请不要重复上传同一张图片。');
	// 		return false; 
			
	// 	}
	// 	var f = document.getElementById('up_img');
 //        var fv = '';
 //        if(f.files && f.files[0]){
 //            fv = (f.files[0].size/1024/1024).toFixed(1);
 //        }
 //        if(fv>1){
 //            alert('图片不能大于1M，请重新选择');
 //            return false;
 //        }
	// 	$("#upload_head_form").ajaxSubmit({
	// 		type : "post",//提交类型  
	// 		dataType : "json",//返回结果格式  
	// 		url : getContextPaths() + "/user/updateAvatar1",//请求地址  
	// 		//请求数据  
	// 		success : function(json){//请求成功后的函数  
	// 			if(json.flag==1){
	// 				alert('恭喜您，图片上传成功');
	// 			}else{
	// 				alert(json.msg);
	// 				// console.log(json.msg);
	// 			}
	// 		}
	// 	});
	// });



	var t_imgFlag = false;//判断图片是否有选择的标识
	$('#up_img').change(function(){
        var f = document.getElementById('up_img');
        var fv = '';
        if(f.files && f.files[0]){
            fv = (f.files[0].size/1024/1024).toFixed(1);
        }
        if($('#up_img').val()=='' && uimgs == ''){
            t_imgFlag = false;
            alert('默认头像不能上传，请重新选择要上传的头像。');
        }else if($('#up_img').val()==''){
        	t_imgFlag = false;
            alert('请不要重复上传同一张图片。');
        }else if(fv>1){
        	t_imgFlag = false;
            alert('图片不能大于1M，请重新选择');
        }else{
            t_imgFlag = true;
        }
    });

	var formFlag = true;//防表单重复提交的标识
	$('#hdsubmit_btn').click(function(){
		if(t_imgFlag){
			if(formFlag){
				$("#upload_head_form").ajaxSubmit({
					type : "post",//提交类型  
					dataType : "json",//返回结果格式  
					url : getContextPaths() + "/user/updateAvatar1",//请求地址 
					beforeSend:function(){
						formFlag = false;
						$('#hdsubmit_btn').html('上传中...');
					}, 
					async: false,
					//请求数据  
					success : function(json){//请求成功后的函数  
						if(json.flag==1){
							alert('恭喜您，图片上传成功');
							$('#hdsubmit_btn').html('保存');
						}else{
							alert(json.msg);
							formFlag = true;
							$('#hdsubmit_btn').html('保存');
						}
					}
					// error:function(){
					// 	alert('图片上传失败');
					// 	formFlag = true;
					// 	$('#hdsubmit_btn').html('保存');
					// }
				});
			}
		}else{
			t_imgFlag=false;
			$('#up_img').trigger('change');
		}
	});





































	//点击错误弹窗里的'确认按钮'时刷新当前页面
	$('.error_btns').click(function(){
		window.location.reload(true);
	});
	
	


		
	
	$('.iphoneSite').click(function(){
		if($('.certificationSite').text() == '已认证'){
			return true;
		}else{
			alert('您还没开通托管账户，暂时不能进行手机号码修改。');
			return false;
		}
	});









	
});





//头像上传js封装
var uploadPreview = function(setting) {
    /*
    *work:this(当前对象)
    */
    var _self = this;
    /*
    *work:判断为null或者空值
    */
    _self.IsNull = function(value) {
        if (typeof (value) == "function") { return false; }
        if (value == undefined || value == null || value == "" || value.length == 0) {
            return true;
        }
        return false;
    }
    /*
    *work:默认配置
    */
    _self.DefautlSetting = {
        UpBtn: "",
        DivShow: "",
        ImgShow: "",
        Width: 144,
        Height: 144,
        ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
        ErrMsg: "选择文件错误,图片类型必须是(gif,jpeg,jpg,bmp,png)中的一种",
        callback: function() { }
    };
    /*
    *work:读取配置
    */
    _self.Setting = {
        UpBtn: _self.IsNull(setting.UpBtn) ? _self.DefautlSetting.UpBtn : setting.UpBtn,
        DivShow: _self.IsNull(setting.DivShow) ? _self.DefautlSetting.DivShow : setting.DivShow,
        ImgShow: _self.IsNull(setting.ImgShow) ? _self.DefautlSetting.ImgShow : setting.ImgShow,
        Width: _self.IsNull(setting.Width) ? _self.DefautlSetting.Width : setting.Width,
        Height: _self.IsNull(setting.Height) ? _self.DefautlSetting.Height : setting.Height,
        ImgType: _self.IsNull(setting.ImgType) ? _self.DefautlSetting.ImgType : setting.ImgType,
        ErrMsg: _self.IsNull(setting.ErrMsg) ? _self.DefautlSetting.ErrMsg : setting.ErrMsg,
        callback: _self.IsNull(setting.callback) ? _self.DefautlSetting.callback : setting.callback
    };
    /*
    *work:获取文本控件URL
    */
    _self.getObjectURL = function(file) {
        var url = null;
        if (window.createObjectURL != undefined) {
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
    /*
    *work:绑定事件
    */
    _self.Bind = function() {
        document.getElementById(_self.Setting.UpBtn).onchange = function() {
            if (this.value) {
                if (!RegExp("\.(" + _self.Setting.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                    alert(_self.Setting.ErrMsg);
                    this.value = "";
                    return false;
                }
                if (navigator.userAgent.indexOf("MSIE") > -1) {
                    try {
                        document.getElementById(_self.Setting.ImgShow).src = _self.getObjectURL(this.files[0]);
                    } catch (e) {
                        var div = document.getElementById(_self.Setting.DivShow);
                        this.select();
                        top.parent.document.body.focus();
                        var src = document.selection.createRange().text;
                        document.selection.empty();
                        document.getElementById(_self.Setting.ImgShow).style.display = "none";
                        div.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                        div.style.width = _self.Setting.Width + "px";
                        div.style.height = _self.Setting.Height + "px";
                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src;
                    }
                } else {
                    document.getElementById(_self.Setting.ImgShow).src = _self.getObjectURL(this.files[0]);
                }
                _self.Setting.callback();
            }
        }
    }
    /*
    *work:执行绑定事件
    */
    _self.Bind();
}
</script>
