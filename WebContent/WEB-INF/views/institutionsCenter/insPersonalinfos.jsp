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
    <title>机构中心——安全信息</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/jquery.inputbox.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/securityinfos.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/institutionsCenter/guarantee.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery.inputbox.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery.ganged.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/provinces.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/personalbasicinfos.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/institutionsCenter/insper.js'></script>
	<script type="text/javascript" src='../../static/scripts/user/md5.js'></script>
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<!--  账户中心-->
	<div class="warp_account_center">
		<!-- 资产总览内容区域 -->
		<div class="user_account1000">
			<!-- 引入左边菜单导航栏 -->
			<%@ include file="instituteMenu.jsp"%>
			<!-- 右边账户中心内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name">安全信息</div>
				<!-- 内容盒子Start -->
				<div class="per_rigBotContent_box" style="position:relative;">
					<div class="insper_title">
						<p class="fl account_title active">账户信息</p>
						<p class="fl enterprise_title">企业信息</p>
						<div class="clear"></div>
					</div>
					<!-- 安全信息内容Start -->
					<div class="accountInfos">
						<!-- 头像Start -->
						<!-- <div class="com_perDiv per_headerBox">
							<div class="fl com_perBgBox"><p class="headerBg"></p></div>
							<p class="com_perTitle">头像</p>
							<p class="com_perTxt">用于平台头像</p> -->
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<!-- <p class="com_perTips per_error_tips"></p> -->
							<!-- <p class="com_perState headState">未设置</p> -->
							<!-- <p class="com_perSite headSite">设置</p>
							<div class="clear"></div> -->
						<!-- </div> -->

						<!-- 用户名Start -->
						<div class="com_perDiv per_unameBox">
							<div class="fl com_perBgBox"><p class="unameBg"></p></div>
							<p class="com_perTitle">用户名</p>
							<p class="com_perTxt">${sessionScope.user_inf.username}</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips unameimg per_error_tips"></p>
							<!-- <p class="com_perState unameState">未设置</p> -->
							<p class="com_perSite umSite unameSite">未设置</p>
							<div class="clear"></div>
						</div>

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
							<p class="com_perSite pwdSite">未设置</p>
							<div class="clear"></div>
						</div>

						<!-- 手机号Start -->
						<div class="com_perDiv per_iphoneBox">
							<div class="fl com_perBgBox"><p class="iphoneBg"></p></div>
							<p class="com_perTitle">手机号</p>
							<p class="com_perTxt">${sessionScope.user_inf.mobile}</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips ipeimg per_error_tips"></p>
							<!-- <p class="com_perState iphoneState">未设置</p> -->
							<p class="com_perSite iphoneSite">修改</p>
							<div class="clear"></div>
						</div>

						<!-- 企业名称Start -->
						<div class="com_perDiv per_enterBox">
							<div class="fl com_perBgBox"><p class="enterBg"></p></div>
							<p class="com_perTitle">企业名称</p>
							<p class="com_perTxt">${sessionScope.user_inf.corpName}</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips enterNameImg per_error_tips"></p>
							<!-- <p class="com_perState unameState">未设置</p> -->
							<p class="com_perSite enterprise_namess">已设置</p>
							<div class="clear"></div>
						</div>

						<!-- 法人姓名Start -->
						<div class="com_perDiv per_farenBox">
							<div class="fl com_perBgBox"><p class="farenBg"></p></div>
							<p class="com_perTitle">法人姓名</p>
							<p class="com_perTxt">${sessionScope.user_inf.realname}</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips farenNameImg per_error_tips"></p>
							<!-- <p class="com_perState unameState">未设置</p> -->
							<p class="com_perSite faren_site">已设置</p>
							<div class="clear"></div>
						</div>

						<!-- 法人身份证号码Start -->
						<div class="com_perDiv per_cerIdBox">
							<div class="fl com_perBgBox"><p class="certificationBg"></p></div>
							<p class="com_perTitle" style="width:106px;margin-right:102px;">法人身份证号码</p>
							<p class="com_perTxt">${sessionScope.user_inf.cardId}</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips farenIdImg per_success_tips"></p>
							<!-- <p class="com_perState unameState">未设置</p> -->
							<p class="com_perSite cerId_site">已认证</p>
							<div class="clear"></div>
						</div>

						<!-- 企业开户省区Start -->
						<div class="com_perDiv kaifusheng">
							<div class="fl com_perBgBox"><p class="addressBg"></p></div>
							<p class="com_perTitle" style="width:106px;margin-right:102px;">企业开户省区</p>
							<p class="com_perTxt addressTxt">广东省深圳市</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips enterAdressImg per_error_tips"></p>
							<!-- <p class="com_perState addressState">未设置</p> -->
							<p class="com_perSite kaitong">已开通</p>
							<div class="clear"></div>
						</div>

						

						<!-- 邮箱Start -->
						<div class="com_perDiv per_emailBox">
							<div class="fl com_perBgBox"><p class="emailBg"></p></div>
							<p class="com_perTitle">邮箱</p>
							<p class="com_perTxt">${sessionScope.user_inf.email}</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips eailimg per_error_tips"></p>
							<!-- <p class="com_perState emailState">未设置</p> -->
							<p class="com_perSite emailSite">未设置</p>
							<div class="clear"></div>
						</div>

						<!-- 真实姓名Start -->
						<div class="com_perDiv per_certificationBox">
							<div class="fl com_perBgBox"><p class="certificationBg"></p></div>
							<p class="com_perTitle">真实姓名</p>
							<p class="com_perTxt">${sessionScope.user_inf.realname}</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips reaNames per_error_tips"></p>
							<!-- <p class="com_perState certificationState">未设置</p> -->
							<p class="com_perSite certificationSite">未认证</p>
							<div class="clear"></div>
						</div>

						<!-- 富友账号Start -->
						<div class="com_perDiv depositBox">
							<div class="fl com_perBgBox"><p class="depositBg"></p></div>
							<p class="com_perTitle">富友账号</p>
							<p class="com_perTxt">资金存管第三方账户</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips fuyouActImg per_error_tips"></p>
							<!-- <p class="com_perState depositState">未设置</p> -->
							<p class="com_perSite depositSite">未开通</p>
							<div class="clear"></div>
						</div>

						<!-- 银行卡号Start -->
						<div class="com_perDiv bankBox">
							<div class="fl com_perBgBox"><p class="bankBg"></p></div>
							<p class="com_perTitle">银行卡号</p>
							<p class="com_perTxt">${sessionScope.user_inf.capAcntNo}</p>
							<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
								 当状态为‘已设置’时，此处的样式是per_success_tips
							 -->
							<p class="com_perTips bkimg per_error_tips"></p>
						<!-- 	<p class="com_perState bankState">未设置</p> -->
							<p class="com_perSite bankSite">未绑定</p>
							<div class="clear"></div>
						</div>

						<!-- 提现密码Start -->
						<form action="${pageContext.request.contextPath }/fy/pwdMgt" id="addForm" name="addForm" method="post" > 
							<div class="com_perDiv tradePwdBox">
								<div class="fl com_perBgBox"><p class="tradePwdBg"></p></div>
								<p class="com_perTitle">提现密码</p>
								<p class="com_perTxt">第三方支付托管平台提现密码</p>
								<!-- 温馨提示：当状态为‘未设置’时，此处的样式是per_error_tips；
									 当状态为‘已设置’时，此处的样式是per_success_tips
								 -->
								<p class="com_perTips tmimg per_error_tips"></p>
								<!-- <p class="com_perState tradePwdState">未设置</p> -->
								<button type="submit" id="submit_btn" class="com_perSite txSite fl" style="border:0;background:#fff;margin-left:-19px;">设置</button>
								<div class="clear"></div>
							</div>
						</form>

					</div>
					<!-- 安全信息内容End -->

					<!-- 企业信息Start -->
					<div class="enterpriseInfos" style="display:none;">
						<!-- 企业信息 -->
						<div class="com_entDiv entInfoBox">
							<div class="fl con_ent_title">
								<p>企业信息</p>
								<div class="ent_hr"></div>
							</div>
							<div class="fl con_ent_contxt">
								<p>
									经分析，而绝大多数的受访者声称他们是设计为中心，我们发现有我们的受访者的一个子集已取得由一个庞大的，专门的设计团队和风险投资成功测量的水平。我们标记这些公司的“设计 - 成熟”和其他人“设计为中心”。
								</p>
								<p>
									一个公司，是设计为中心的优先用户体验和庆祝新的思路。这家公司是不行的单独离开不够好，但总是寻求改善。他们积极培育创造性思维，他们知道，后面的每个数字是一个人。他们不断寻找办法，使这一目标到终端的经验（在所有接触点）为他们的客户提供更好的。
								</p>
							</div>
							<div class="clear"></div>
						</div>

						<!-- 经营情况 -->
						<div class="com_entDiv businessBox">
							<div class="fl con_ent_title">
								<p>经营情况</p>
								<div class="ent_hr"></div>
							</div>
							<div class="fl con_ent_contxt">
								<p>
									每个人都有关的初创企业设计的重要性会谈。然而，有提供了有关角色设计对于数据非常少，没有路线图如何将设计融入公司。400多家企业响应我们的要求，以便了解他们的看法，做法和预测。
								</p>
							</div>
							<div class="clear"></div>
						</div>

						<!-- 涉诉情况 -->
						<div class="com_entDiv shesuBox">
							<div class="fl con_ent_title">
								<p>涉诉情况</p>
								<div class="ent_hr"></div>
							</div>
							<div class="fl con_ent_contxt">
								<p>
									每个人都有关的初创企业设计的重要性会谈。然而，有提供了有关角色设计对于数据非常少，没有路线图如何将设计融入公司。400多家企业响应我们的要求，以便了解他们的看法，做法和预测。
								</p>
							</div>
							<div class="clear"></div>
						</div>

						<!-- 征信情况 -->
						<div class="com_entDiv zhengxinBox">
							<div class="fl con_ent_title">
								<p>征信情况</p>
								<div class="ent_hr"></div>
							</div>
							<div class="fl con_ent_contxt">
								<p>
									每个人都有关的初创企业设计的重要性会谈。然而，有提供了有关角色设计对于数据非常少，没有路线图如何将设计融入公司。400多家企业响应我们的要求，以便了解他们的看法，做法和预测。
								</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<!-- 企业信息End -->


				</div>
				<!-- 内容盒子End -->
			</div>
			<!-- 右边账户中心内容区域End -->
			<div class="clear"></div>
		</div>

		
	</div>

	<!-- 设置头像弹窗Start -->
	<div class="com_window head_window">
		<form action="" method="post" id="upload_head_form">
			<div class="com_wTitle">
				<p class="fl com_window_title">设置头像</p>
				<p class="fr com_window_close head_wClose"></p>
				<div class="clear"></div>
			</div>
			<div class="head_uploadBox">
				<input type="file" class='upload_heads'>
			</div>
			<div class="com_werror uploadError"></div>
			<p class="upload_txts">上传头像</p>
			<p class="upload_infos">说明：1.图片格式支持jpg/png/bmp  2.图片大小不超过1M.</p>
			<div class="com_wBtn upload_btns">保存</div>
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
				<input type="password" name='per_new_pwd' class="w_inputTxt per_new_pwd" id="per_new_pwd" placeholder='新登录密码'>
			</div>
			<div class="com_werror newpwdError"></div>

			<div class="com_wInput">
				<input type="password" name='per_confrim_pwd' class="w_inputTxt per_confrim_pwd" id="per_confrim_pwd" placeholder='确认新登录密码'>
			</div>
			<div class="com_werror conpwdError"></div>
			
			<div class="com_wBtn pwds_btns">保存</div>
		</form>
	</div>

	<!-- 手机号弹窗Start -->
	<div class="com_window iphones_window">
		<div class="com_wTitle" style="margin-bottom:36px;">
			<p class="fl com_window_title">修改手机号</p>
			<p class="fr com_window_close head_wClose"></p>
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
				<input type="text" name='per_iphoneCode' class="w_inputTxt per_iphoneCode" id="per_iphoneCode" placeholder='手机验证码' maxlength="6">
				<input type="button" class="phone_codeBtn" id="phone_codeBtn" value="发送验证码">
			</div>
			<div class="com_werror icodeError"></div>
			
			<div class="com_wBtn ip_codebtns">下一步</div>
		</div>

		<!-- 重置手机号start -->
		<div class="site02Box" style="display:none;">
			<div class="siteImg site02_bg"></div>
			<p class="siteTxt">
				<span>手机号</span>
				<span class='siteIphones'>${sessionScope.user_inf.mobile}</span>
			</p>
			<div class="com_wInput">
				<input type="text" name='modify_iphone' class="w_inputTxt modify_iphone" id="modify_iphone" placeholder='新手机号' maxlength="11">
			</div>
			<div class="com_werror newcodeError"></div>
			
			<div class="com_wBtn ip_btns">下一步</div>
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
			<input type="text" name='per_emails' class="w_inputTxt per_emails" id="per_emails" placeholder='邮箱地址'>
		</div>
		<div class="com_werror eAddresError"></div>
		<div class="com_wInput">
			<input type="text" name='per_emails_code' class="w_inputTxt per_emails_code" id="per_emails_code" placeholder='邮箱验证码'>
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
				<span class='t_iphone'>185****6321</span>
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
			<p class="fr com_window_close head_wClose"></p>
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
		
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>


<script type="text/javascript">
	$(function(){
		$.ajax({
        type:'post',
        url:getContextPaths()+'/user/getPersonStatus',
        dataType:'json',
        success:function(json){
        	
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
            // 判断企业名称是否设置 1设置 0未设置 
            if(json.CropNameFlag=='1'){
                $('.enterNameImg').removeClass('per_error_tips').addClass('per_success_tips');
            }else{
                $('.enterNameImg').removeClass('per_error_tips').addClass('per_success_tips');
            }
            // 判断法人姓名是否设置 1设置 0未设置 
            if(json.RealNameFlag=='1'){
                $('.farenNameImg').removeClass('per_error_tips').addClass('per_success_tips');
            }else{
                $('.farenNameImg').removeClass('per_error_tips').addClass('per_success_tips');
            }
            // 判断法人身份证号码是否设置 1设置 0未设置 
            // if(json.CropNameFlag=='1'){
            //     $('.farenNameImg').removeClass('per_error_tips').addClass('per_success_tips');
            // }else{
            //     $('.farenNameImg').removeClass('per_error_tips').addClass('per_success_tips');
            // }
            // 判断企业开户省区是否设置 1设置 0未设置 
            if(json.provinceFlag=='1'){
                $('.enterAdressImg').removeClass('per_error_tips').addClass('per_success_tips');
            }else{
                $('.enterAdressImg').removeClass('per_error_tips').addClass('per_success_tips');
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

            // 判断真实姓名是否设置 1设置 0未设置 
            if(json.cardFlag=='1'){
                $('.reaNames').removeClass('per_error_tips').addClass('per_success_tips');
                $('.certificationSite').html('已认证');
            }else{
                $('.reaNames').removeClass('per_success_tips').addClass('per_error_tips');
                $('.certificationSite').html('未认证');
                $('.certificationSite').click(function(){
                	window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount';
                });
            }
            // 判断富友账号是否设置 1设置 0未设置 
            if(json.fuyouFlag=='1'){
                $('.fuyouActImg').removeClass('per_error_tips').addClass('per_success_tips');
                $('.depositSite').html('已开通');
            }else{
                $('.fuyouActImg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.depositSite').html('未开通');
                $('.depositSite').click(function(){
                	window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount';
                });
            }

            // 判断银行卡号是否设置 1设置 0未设置 
            if(json.acntNoFlag=='1'){
                $('.bkimg').removeClass('per_error_tips').addClass('per_success_tips');
                $('.bankSite').html('已绑定');
            }else{
                $('.bkimg').removeClass('per_success_tips').addClass('per_error_tips');
                $('.bankSite').html('未绑定');
                $('.bankSite').click(function(){
                	window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount';
                });
            }

            // 判断提现密码是否设置 1设置 0未设置 
            if(json.tixPassWordFlag=='1'){
                $('.tmimg').removeClass('per_error_tips').addClass('per_success_tips');
                // $('.tradePwdSite').html('修改');
            }else{
                $('.tmimg').removeClass('per_success_tips').addClass('per_error_tips');
                // $('.tradePwdSite').html('设置');
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





        }
    });














	// 用户名设置前的非空判断
	$('.uname_btns').click(function(){
		var flag = $('#per_name').val();
		if(flag==''){
			$('.unameError').html('用户名不能设置为空。');
			setTimeout(function(){
				$('.unameError').html('');
			},2000);
			return false;
		}else{
			return true;
		}
	});

















	});














</script>



