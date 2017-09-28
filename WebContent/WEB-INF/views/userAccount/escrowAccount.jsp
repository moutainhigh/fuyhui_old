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
    <title>开通富友托管账户-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="富元汇，专注于供应链金融的P2C平台，年化收益高达10%~13%，拥有第三方资金托管的正规理财平台。提供百元起投的稳健理财产品，产品对接上市企业供应链项目，本息安全保障，随时稳定赎回。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/escrowAccount.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-form.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/escrowAccount.js'></script>
</head>

<body style="background:#f5f5f5;">
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	
	<div class="escro_body">
		<h3>开通富友托管账户</h3>
		<div class="escro_contentBox">
			<!-- 手机号码 -->
			<div class="escro_grounp">
				<label class="fl escro_label">手机号码</label>
				<input type="text" name='mobile' class="fl esc_input escro_iphone" id="escro_iphone" readonly="readonly" value="${user.mobile}">
				<div class="clear"></div>
				<div class="escro_error"></div>
			</div>
			<!-- 证件类型 -->
			<div class="escro_grounp">
				<label class="fl escro_label">证件类型</label>
				<select name="cardType" id="escro_certificate" class="fl esc_select escro_certificate">
					<option value="0" selected="">身份证</option>
					<option value="1">台胞证</option>
					<option value="2">港澳回乡证</option>
					<option value="2">护照</option>
				</select>
				<div class="clear"></div>
				<div class="escro_error"></div>
			</div>
			<!-- 真实姓名 -->
			<div class="escro_grounp chinaBoxName">
				<label class="fl escro_label">真实姓名</label>
				<input type="text" name='realname' class="fl esc_input escro_name" id="escro_name1" placeholder='请使用简体填写中文姓名'>
				<div class="fl escro_tsp">与银行卡户名一致</div>
				<div class="clear"></div>
				<div class="escro_error name_error"></div>
			</div>
			<!-- 外国人真实姓名 -->
			<div class="escro_grounp forginBoxName" style="display:none;">
				<label class="fl escro_label">真实姓名</label>
				<input type="text" name='realname' class="fl esc_input escro_name" id="escro_name2" placeholder='请输入姓名'>
				<div class="fl escro_tsp">与银行卡户名一致</div>
				<div class="clear"></div>
				<div class="escro_error forign_name_error"></div>
			</div>
			<!-- 温馨提示：
				 当证件类型为身份证时显示此div里的信息
			 -->
			<!-- 身份证号码 -->
			<div class="escro_grounp id_card">
				<label class="fl escro_label">证件号码</label>
				<input type="text" name='cardId' class="fl esc_input escro_idCard" id="escro_idCard" placeholder='16或18位身份证号码'>
				<div class="fl escro_tsp">请填写真实的证件号</div>
				<div class="clear"></div>
				<div class="escro_error idCard_error"></div>
			</div>

			<!-- 温馨提示：
				 当证件类型为台胞证证时显示此div里的信息
			 -->
			<!-- 台胞证号码 -->
			<form id="gatForm" method='post' enctype='multipart/form-data'>
			<div class="taiwan_infos" style="display:none;">
				<div class="escro_grounp taiwan_id_card">
					<label class="fl escro_label">证件号码</label>
					<input type="text" name='taiwancardId' class="fl esc_input escro_taiwan_idCard" id="escro_taiwan_idCard" placeholder='8位号码'>
					<div class="clear"></div>
					<div class="escro_error taiId_error"></div>
				</div>
				<!-- 台胞证照片 -->
				<div class="escro_grounp taiwan_id_cardImg" style="height:30px;line-height:30px;margin-bottom:10px;">
					<label class="fl escro_label" style="margin-top:0;">上传证件照</label>
					<div class="fl file_tips">支持jpg、jpeg等常见图片格式及小于1M的图片</div>	
					<div class="clear"></div>
				</div>
				<!-- 台胞证正面 -->
				<div class="taiwan_id_cardImg">
					<input type="file" id="taiwan_idCard" name='idCard' class="fl taiwan_img1">
					<div class="fl taiwan_files1">手持证件正面照</div>
					<div class="fl t_zmsg"></div>
					<div class="clear"></div>
					<div class="escro_error t_zmsg1" style="margin-top:25px;line-height:75px \9;" ></div>
				</div>

				<!-- 台胞证反面 -->
				<div class="taiwan_id_cardImg">
					<input type="file" id="taiwan_idCard2" name='idCard2' class="fl taiwan_img2">
					<div class="fl taiwan_files2">手持证件反面照</div>
					<div class="fl t_fmsg"></div>
					<div class="clear"></div>
					<div class="escro_error t_fmsg2" style="margin-top:25px;line-height:75px \9;" ></div>
				</div>

				<!-- 台胞证银行卡 -->
				<div class="taiwan_id_cardImg">
					<input type="file" id="taiwan_bankCard" name='bankCard' class="fl b_img">
					<div class="fl taiwan_files3">银行卡正面照</div>
					<div class="fl tb_zmsg"></div>
					<div class="clear"></div>
					<div class="escro_error t_bmsg" style="margin-top:25px;line-height:75px \9;" ></div>
				</div>





			</div>
			</form>
			<!-- 温馨提示：
				 当证件类型为港澳通行证时显示此div里的信息
			 -->
			<!-- 港澳通行证 -->
			<form id="hkForm" method='post' enctype='multipart/form-data'>
			<div class="hk_infos" style="display:none;">
				<div class="escro_grounp hk_id_card">
					<label class="fl escro_label">证件号码</label>
					<input type="text" name='hkcardId' class="fl esc_input escro_hk_idCard" id="escro_hk_idCard" placeholder='11位号码'>
					<div class="clear"></div>
					<div class="escro_error hk_error"></div>
				</div>
				<!-- 港澳回乡证 -->
				<div class="escro_grounp hk_id_cardImg" style="height:30px;line-height:30px;margin-bottom:10px;">
					<label class="fl escro_label" style="margin-top:0;">上传证件照</label>
					<div class="fl file_tips">支持jpg、jpeg等常见图片格式及小于1M的图片</div>	
					<div class="clear"></div>
				</div>
				<!-- 港澳回乡证正面 -->
				<div class="hk_id_cardImg">
					<input type="file" id="hk_idCard" name='idCard' class="fl hk_img1">
					<div class="fl hk_files1">手持证件正面照</div>
					<div class="fl hk_zmsg"></div>
					<div class="clear"></div>
					<div class="escro_error hk_zmsg1" style="margin-top:25px;line-height:75px \9;" ></div>
				</div>

				<!-- 港澳回乡证反面 -->
				<div class="hk_id_cardImg">
					<input type="file" id="hk_idCard2" name='idCard2' class="fl hk_img2">
					<div class="fl hk_files2">手持证件反面照</div>
					<div class="fl hk_fmsg"></div>
					<div class="clear"></div>
					<div class="escro_error hk_fmsg2" style="margin-top:25px;line-height:75px \9;" ></div>
				</div>

				<!-- 港澳回乡证银行卡 -->
				<div class="hk_id_cardImg">
					<input type="file" id="hk_bankCard" name='bankCard' class="fl b_img">
					<div class="fl hk_files3">银行卡正面照</div>
					<div class="fl hkb_zmsg"></div>
					<div class="clear"></div>
					<div class="escro_error hk_bmsg" style="margin-top:25px;line-height:75px \9;" ></div>
				</div>

			</div>
			</form>

			<!-- 温馨提示：
				 当证件类型为护照时显示此div里的信息
			 -->
			<!-- 护照 -->
			<form id="passportForm" method='post' enctype='multipart/form-data'>
			<div class="pt_infos" style="display:none;">
				<div class="escro_grounp pt_id_card">
					<label class="fl escro_label">证件号码</label>
					<input type="text" name='ptcardId' class="fl esc_input escro_pt_idCard" id="escro_pt_idCard" placeholder='请输入证件号码'>
					<div class="clear"></div>
					<div class="escro_error pt_error"></div>
				</div>
				<!-- 护照 -->
				<div class="escro_grounp pt_id_cardImg" style="height:30px;line-height:30px;margin-bottom:10px;">
					<label class="fl escro_label" style="margin-top:0;">上传证件照</label>
					<div class="fl file_tips">支持jpg、jpeg等常见图片格式及小于1M的图片</div>	
					<div class="clear"></div>
				</div>
				<!-- 护照个人信息页图片 -->
				<div class="pt_id_cardImg">
					<input type="file" id="pt_idCard" name='idCard' class="fl pt_img1" style="width:146px;">
					<div class="fl pt_files1" style="width:146px;">手持护照个人信息页照</div>
					<div class="fl pt_zmsg"></div>
					<div class="clear"></div>
					<div class="escro_error pt_zmsg1" style="margin-top:25px;line-height:75px \9;line-height:20px;" ></div>
				</div>

				<!-- 手持护照签名页 -->
				<div class="pt_id_cardImg">
					<input type="file" id="pt_idCard2" name='idCard2' class="fl pt_img2" style="width:146px;">
					<div class="fl pt_files2" style="width:146px;">手持护照签名页照</div>
					<div class="fl pt_fmsg"></div>
					<div class="clear"></div>
					<div class="escro_error pt_fmsg2" style="margin-top:25px;line-height:75px \9;line-height:20px;" ></div>
				</div>

				<!-- 银行卡正面 -->
				<div class="pt_id_cardImg">
					<input type="file" id="pt_bankCard" name='bankCard' class="fl ptb_img" style="width:146px;">
					<div class="fl pt_files3" style="width:146px;">银行卡正面照</div>
					<div class="fl ptb_zmsg"></div>
					<div class="clear"></div>
					<div class="escro_error pt_bmsg" style="margin-top:25px;line-height:75px \9;line-height:20px;" ></div>
				</div>

			</div>
			</form>

			<!-- 银行卡号 -->
			<div class="escro_grounp">
				<label class="fl escro_label">银行卡号</label>
				<input type="text" name='capAcntNo' class="fl esc_input bank_card" id="bank_card" placeholder=' 限用中国大陆银行卡'>
				<div class="fl escro_tsp" style="margin:5px 0 0 14px;width:372px;">此银行卡为提现银行卡，请填写本人正确的银行卡号；如填写错误或他人银行卡或信用卡，导致无法提现等问题，所有后果应由用户自行承担</div>
				<div class="clear"></div>
				<div class="escro_error band_error"></div>
			</div>

			<!-- 开户行所在地 -->
			<div class="escro_grounp">
				<label class="fl escro_label">开户行所在地</label>
				<select name="country_id" id="esc_account_province" class="fl esc_select esc_account_province" >
					 <option>省份</option>
				</select>
				<select name="city_id" id="esc_account_city" class="fl esc_select esc_account_city">
					<option>县</option>
				</select>
				<div class="clear"></div>
				<div class="escro_error adres_error"></div>
			</div>
			
			<!-- 开户银行 -->
			<div class="escro_grounp">
				<label class="fl escro_label">开户银行</label>
				<select name="parent_bank_id" id="esc_act_bank" class="fl esc_select esc_act_province">
					<option>请选择银行</option>
				</select>
				<div class="clear"></div>
				<div class="escro_error bankName_error"></div>
			</div>
			
			<!-- 提现密码 -->
			<div class="escro_grounp">
				<label class="fl escro_label">提现密码</label>
				<input type="password" name='password' class="fl esc_input wit_pwd" id="wit_pwd" placeholder=' 6-16位字符' onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\@\.\!\~\#\%\*\&\$]/g,'')" oncopy="return false" onpaste="return false"  ondragstart="return false" onselectstart="return false">
				<!-- <div class="fl escro_tsp">不设置默认手机号后6位</div> -->
				<div class="clear"></div>
				<div class="esc_wit_error" style="margin-left:-17px;">该密码用于将托管账户资金提现至个人银行卡时使用</div>
			</div>

			<!-- 确认提现密码 -->
			<div class="escro_grounp">
				<label class="fl escro_label">确认提现密码</label>
				<input type="password" name='confirm_witPwd' class="fl esc_input confirm_witPwd" id="confirm_witPwd" placeholder=' 6-16位字符' onkeyup="value=value.replace(/[^\a-\z\A-\Z0-9\@\.\!\~\#\%\*\&\$]/g,'')" oncopy="return false" onpaste="return false"  ondragstart="return false" onselectstart="return false">
				<div class="clear"></div>
				<div class="escro_error conwit_error"></div>
			</div>

			<div class="esc_btn_box">
				<!-- 提交按钮 -->
				<div class="fl escro_sumbit btn-primary tj_btn">提交</div>
				<!-- 跳过 -->
				<div class="fl jumb_href" onclick="window.location.href='/myAccount/enterUserAccount'">跳过&gt;</div>
				<div class="clear"></div>
			</div>



		</div>
		
	
	</div>


	<%--页面加载时候的弹出框--%>
	<div class="alert-Con hide-ale">
		<span class="esc-accClose" style="float:right;font-size: 24px;color: #333;display: inline-block;margin-top: 10px;">
			
		</span>
		<div class="alertText" style='margin-top: 114px;text-align: center;font-size: 24px;color:#f60;'></div>
		<p class="btn-sure esc-accClose" style='width: 100px;height: 40px;line-height: 40px;background: #0bf;border-radius: 6px;font-size: 16px;color: #fff;text-align: center;left:170px;bottom:42px;'>
			确认
		</p>
	</div>
	<%--页面加载时候的弹出框--%>


	<!-- 照片错误提示弹窗 -->
	<div class="one_contxt_window">
		<div class="error_txts"></div>
		<div class="error_btns">确认</div>
	</div>

	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>



