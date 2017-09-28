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
    <title>充值-账户中心-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富之富，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/witrecharge.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/witrecharge.js'></script>
	<style type="text/css">
		.rech_rigBotContent_box, .wit_rigBotContent_box
		{
			padding: 1px 0 122px 0 !important;
		}
		.eBank_box
		{
			margin-top: -46px;
		}
		#quick_content, #eb_content
		{
			height: 640px !important;
		}
		.bankBox_wrap
		{
			margin-top: 60px;
		}
		.enter_titles
		{
			margin-bottom: 30px;
		}
		.bankBox_title
		{
			font-size: 18px;
			color: #0bf;
			margin-right: 12px;
		}
		.bankBox_last
		{
			font-size: 12px;
			color: #ff5353;
		}
		.bankBox_ul li
		{
			float: left;
			margin-bottom: 15px;
			width: 283px;
		}
		.bankBoxImg 
		{
			width: 50px;
			height: 50px;
		}
		.bank_top
		{
			margin-top: -16px;
		}
		.bankBox_list
		{
			width: 852px;
		}
		.bankBoxTxt
		{
			font-size: 16px;
		    color: #323232;
		    margin-left: 6px;
		    margin-top:-4px;
		}
		.bankBox_radio
		{
			cursor: pointer;
		}
		.wangying_titleBox
		{
			height: 50px;
		    line-height: 50px;
		    font-size: 18px;
		    color: #474e5d;
		    border-bottom: 2px solid #0bf;
		}
		.wangying_titleBox p {
		    width: 138px;
		    height: 100%;
		    text-align: center;
		    cursor: pointer;
		}
		.wangying_titleBox p.active {
		    background: #0bf;
		    color: #fff;
		}
	</style>
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<!--  账户中心-->
	<div class="warp_account_center">
		<!-- 资产总览内容区域 -->
		<div class="user_account1000">
			<!-- 引入左边菜单导航栏 -->
			<%@ include file="borrowerMenu.jsp"%>
			<!-- 右边账户中心内容区域Start -->
			<div class="fl account_rightContent_box">
				<div class="acc_rigContent_name" style="height:26px;text-indent:-9999px;">充值</div>
				<!-- 内容盒子Start -->
				<div class="rech_rigBotContent_box">
					<div class="wangying_titleBox"> 
						<p class="fl enter_wangying active">企业网银</p> 
						<p class="fl person_wangying">个人网银</p>
						<div class="clear"></div>
					</div> 

					<div class="tup_up_area">

						<!-- 网银充值Start -->
						<div class="eBank_box">
						<!-- 未绑定银行卡时显示此部分内容 -->
								<c:if test="${empty userAccountInfo.capAcntNo}">
								<div class="ee_bank_box">
									<p class="bind_card" onclick="window.location.href=getContextPaths()+'/myAccount/enterEscrowAccount'">+&nbsp;&nbsp;开通托管账户</p>
								</div>
                                </c:if>
						<c:if test="${not empty userAccountInfo.capAcntNo}">
						<form action="<%=request.getContextPath() %>/account/webRecharge1" method="post">
							<div id="eb_content">
								<div class="eb_balance">
									<span>可用余额</span>
									<span class='eb_balance_amount'>${userAccountamt }</span>
									<span style='color:#ff5353;'>元</span>
								</div>

								<div class="ebank_middle">
									<p class="fl">充值金额</p>
									<input type="text" name='amt' class="fl ebtop_up_amount" id="ebtop_up_amount" placeholder='请输入100元以上的金额' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,''">
									<input type="hidden" class="fl order_pay_type" value="B2B" name="order_pay_type"  >
									
									<!-- 企业网银手续费 -->
									<div class="fl ebbot_infos entriseBox">
										<span class='ebhand_fee' ebformulaType =${formulaType} >手续费</span>
										<span class='ebhand_cost wangyingebhand' ebinterestRate=${interestRate}>0</span>
										<span class='ebfees' style='color:#ff5353;' ebfee=${fee}>元</span>
										
									</div>
									<!-- 个人网银手续费 -->
									<div class="fl ebbot_infos personesBox" style="display:none;">
										<span class='ebhand_fee02' ebformulaType1 =${formulaType1} >手续费</span>
										<span class='ebhand_cost ebhand_cost02' ebinterestRate1=${interestRate1}>0</span>
										<span class='ebfees1' style='color:#ff5353;' ebfee1=${fee1}>元</span>
										
									</div>

									<div class="clear"></div>
								</div>
								<div class="eb_error"></div>
                                <input type="submit"  class="eb_top_upBtn" value="确认充值">

								<div class="bankBox_wrap">
									<!-- 企业网银充值start -->
									<div class="enterprise_bankBox">
										<div class="enter_titles">
											<span class='bankBox_title'>选择企业网银充值</span>
											<span class='bankBox_last'>（企业网银充值手续费<span class='enter_sxf'>10</span>/笔）</span>
										</div>
										<div class="bankBox_list">
											<ul class="bankBox_ul">
												<!-- 中国工商银行-->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0801020000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_gh bank_top"></div>
													<div class="fl bankBoxTxt">中国工商银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国农业银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0801030000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_nh bank_top"></div>
													<div class="fl bankBoxTxt">中国农业银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国建设银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0801050000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_jh bank_top"></div>
													<div class="fl bankBoxTxt">中国建设银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国民生银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803050000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_ms bank_top"></div>
													<div class="fl bankBoxTxt">中国民生银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国邮政 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0801000000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_yz bank_top"></div>
													<div class="fl bankBoxTxt">中国邮政</div>
													<div class="clear"></div>
												</li>
												<!-- 上海农村商业银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0865012900" name="iss_ins_cd">
													<div class="fl bankBoxImg shny bank_top"></div>
													<div class="fl bankBoxTxt">上海农村商业银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国光大银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803030000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_gd bank_top"></div>
													<div class="fl bankBoxTxt">中国光大银行</div>
													<div class="clear"></div>
												</li>
												<!-- 华夏银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803040000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_hx bank_top"></div>
													<div class="fl bankBoxTxt">华夏银行</div>
													<div class="clear"></div>
												</li>
												<!-- 招商银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803080000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_zs bank_top"></div>
													<div class="fl bankBoxTxt">招商银行</div>
													<div class="clear"></div>
												</li>
												<!-- 洛阳市商业银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0804184930" name="iss_ins_cd">
													<div class="fl bankBoxImg nuoyangsy_img bank_top"></div>
													<div class="fl bankBoxTxt">洛阳市商业银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0801040000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_zh bank_top"></div>
													<div class="fl bankBoxTxt">中国银行</div>
													<div class="clear"></div>
												</li>
												<!-- 交通银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803010000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_jt bank_top"></div>
													<div class="fl bankBoxTxt">交通银行</div>
													<div class="clear"></div>
												</li>
												<!-- 上海浦东发展银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803100000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_pf bank_top"></div>
													<div class="fl bankBoxTxt">上海浦东发展银行</div>
													<div class="clear"></div>
												</li>
												<!-- 兴业银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803090000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_xy bank_top"></div>
													<div class="fl bankBoxTxt">兴业银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中信银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803020000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_zx bank_top"></div>
													<div class="fl bankBoxTxt">中信银行</div>
													<div class="clear"></div>
												</li>
												<!-- 北京银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0804031000" name="iss_ins_cd">
													<div class="fl bankBoxImg beijing_img bank_top"></div>
													<div class="fl bankBoxTxt">北京银行</div>
													<div class="clear"></div>
												</li>
												<!-- 广东发展银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803060000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_gf bank_top"></div>
													<div class="fl bankBoxTxt">广东发展银行</div>
													<div class="clear"></div>
												</li>
												<!-- 平安银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0804105840" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_pa bank_top"></div>
													<div class="fl bankBoxTxt">平安银行</div>
													<div class="clear"></div>
												</li>
						




											</ul>
										</div>
									</div>




									<!-- 个人网银充值start -->
									<div class="person_bankBox" style="display:none">
										
									
										<div class="enter_titles">
											<span class='bankBox_title'>选择个人网银充值</span>
											<span class='bankBox_last'>（个人网银充值手续费<span class='pson_sxf'>0.0%</span>/笔，适用于小额充值。）</span>
										</div>
										<div class="bankBox_list">
											<ul class="bankBox_ul">
												<!-- 中国工商银行-->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0801020000" name="iss_ins_cd">												
													<div class="fl bankBoxImg bakn_gh bank_top"></div>
													<div class="fl bankBoxTxt">中国工商银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国农业银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0801030000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_nh bank_top"></div>
													<div class="fl bankBoxTxt">中国农业银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国建设银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0801050000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_jh bank_top"></div>
													<div class="fl bankBoxTxt">中国建设银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国民生银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803050000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_ms bank_top"></div>
													<div class="fl bankBoxTxt">中国民生银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国光大银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803030000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_gd bank_top"></div>
													<div class="fl bankBoxTxt">中国光大银行</div>
													<div class="clear"></div>
												</li>
												<!-- 华夏银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803040000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_hx bank_top"></div>
													<div class="fl bankBoxTxt">华夏银行</div>
													<div class="clear"></div>
												</li>
												<!-- 招商银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803080000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_zs bank_top"></div>
													<div class="fl bankBoxTxt">招商银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中国银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0801040000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_zh bank_top"></div>
													<div class="fl bankBoxTxt">中国银行</div>
													<div class="clear"></div>
												</li>
												<!-- 交通银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803010000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_jt bank_top"></div>
													<div class="fl bankBoxTxt">交通银行</div>
													<div class="clear"></div>
												</li>
												<!-- 上海浦东发展银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803100000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_pf bank_top"></div>
													<div class="fl bankBoxTxt">上海浦东发展银行</div>
													<div class="clear"></div>
												</li>
												<!-- 兴业银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803090000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_xy bank_top"></div>
													<div class="fl bankBoxTxt">兴业银行</div>
													<div class="clear"></div>
												</li>
												<!-- 中信银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803020000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_zx bank_top"></div>
													<div class="fl bankBoxTxt">中信银行</div>
													<div class="clear"></div>
												</li>
												<!-- 北京银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0804031000" name="iss_ins_cd">
													<div class="fl bankBoxImg beijing_img bank_top"></div>
													<div class="fl bankBoxTxt">北京银行</div>
													<div class="clear"></div>
												</li>
												<!-- 广东发展银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0803060000" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_gf bank_top"></div>
													<div class="fl bankBoxTxt">广东发展银行</div>
													<div class="clear"></div>
												</li>
												<!-- 平安银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0804105840" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_pa bank_top"></div>
													<div class="fl bankBoxTxt">平安银行</div>
													<div class="clear"></div>
												</li>
												<!-- 徽商银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0804403600" name="iss_ins_cd">
													<div class="fl bankBoxImg bakn_ws bank_top"></div>
													<div class="fl bankBoxTxt">徽商银行</div>
													<div class="clear"></div>
												</li>
												<!-- 宁波银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0864083300" name="iss_ins_cd">
													<div class="fl bankBoxImg nbobank bank_top"></div>
													<div class="fl bankBoxTxt">宁波银行</div>
													<div class="clear"></div>
												</li>
												
												
												
												<!-- 天津银行 -->
												<li>
													<input type="radio" class="fl bankBox_radio" value="0804341101" name="iss_ins_cd">
													<div class="fl bankBoxImg tianjing bank_top"></div>
													<div class="fl bankBoxTxt">天津银行</div>
													<div class="clear"></div>
												</li>
												
												
												
												
												
												
												
						




											</ul>
										</div>
									</div>
								</div>







								
							</div>
                          </form>
                          </c:if>
							<!-- 温馨提示内容 -->
							<div class="bank_comment_box">
								<h3>温馨提示</h3>
								<div class="bank_txtes">
									<p class="bank_txt_item">
										1、为了您的账户安全，请在充值前进行身份认证，绑定手机、银行卡，开通托管账户。 
									</p>
									<p class="bank_txt_item">
										2、用户充值时请检查银行卡信息是否填写正确、是否开通网上银行，有足够余额能正常使用。 
									</p>
									<p class="bank_txt_item">
										3、企业网银充值限额单笔最高6000万，单日无限额。企业网银支付额度由企业自行设置。如有问题，详询发卡行。 
									</p>
									<p class="bank_txt_item">
										4、严禁利用充值功能洗钱、信用卡套现、虚假交易，一经发现，终止该账户的使用。 
									</p>
									<p class="bank_txt_item">
										5、如遇充值后银行已扣款，网站个人账户可用余额未增加，请及时联系客服：4009-303-606。 
									</p>
								</div>
							</div>

						</div>
						<!-- 网银充值End -->
					</div>
				</div>
				<!-- 内容盒子End -->
			</div>
			<!-- 右边账户中心内容区域End -->
			<div class="clear"></div>
		</div>


		
	</div>


	<!-- 充值信息弹窗 -->
	<div class="recharge_window">
		<div class="rec_titles">
			<h3 class="fl">信息</h3>
			<p class="fr rec_closes"></p>
			<div class="clear"></div>
		</div>
		<div class="rec_content">
			<div class="fl alertImg"></div>
			<div class="fl alertTxt">
				请您在新打开的网上银行页面进行支付，支付完成前请不要关闭窗口。
			</div>
			<div class="clear"></div>
		</div>
		<div class="rec_btns">
			<div class="fl rec_success">充值成功</div>
			<div class="fl rec_question">遇到问题</div>
			<div class="clear"></div>
		</div>
	</div>
		
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>

<script type="text/javascript">
	$(function(){
		// 充值页面的银行code
	    var recharge_code = parseFloat($('.bank_title').attr('bandcode')); 
	    // 根据不同的银行显示不同的icon图片
	    if(recharge_code == 102){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/gongshang.png) no-repeat center'
	        });
	    }else if(recharge_code == 103){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/nonghang.png) no-repeat center'
	        });
	    }else if(recharge_code == 104){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/zhonghang.png) no-repeat center'
	        });
	    }else if(recharge_code == 105){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/jianhang.png) no-repeat center'
	        });
	    }else if(recharge_code == 301){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/jiaohang.png) no-repeat center'
	        });
	    }else if(recharge_code == 302){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/zhongxin.png) no-repeat center'
	        });
	    }else if(recharge_code == 303){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/guangda.png) no-repeat center'
	        });
	    }else if(recharge_code == 304){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/huaxia.png) no-repeat center'
	        });
	    }else if(recharge_code == 305){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/mingsheng.png) no-repeat center'
	        });
	    }else if(recharge_code == 306){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/guangfa.png) no-repeat center'
	        });
	    }else if(recharge_code == 307){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/pingan.png) no-repeat center'
	        });
	    }else if(recharge_code == 308){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/zhaohang.png) no-repeat center'
	        });
	    }else if(recharge_code == 309){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/xingye.png) no-repeat center'
	        });
	    }else if(recharge_code == 310){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/pufa.png) no-repeat center'
	        });
	    }else if(recharge_code == 319){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/weishang.png) no-repeat center'
	        });
	    }else if(recharge_code == 313){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/otherhang.png) no-repeat center'
	        });
	    }else if(recharge_code == 314){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/otherhang.png) no-repeat center'
	        });
	    }else if(recharge_code == 315){
	        $('.com_bank_icon').css({
	            'background': 'url(${pageContext.request.contextPath }/static/images/bank/henghang.png) no-repeat center'
	        });
	    }


	    // 兼容ie8 placeholder
	    $('#ebtop_up_amount').next('span').css({
	        'padding-left':'20px',
	        'top':'10px'
	    });

	    // 标题tab切换
	    $('.enter_wangying').click(function(){
    		$(this).addClass('active');
    		$(this).siblings().removeClass('active');
    		$('.enterprise_bankBox').show();
	    	$('.person_bankBox').hide();
	    	$('.entriseBox').show();
	    	$('.personesBox').hide();
	    	$('.order_pay_type').val('B2B');
	    	$('#ebtop_up_amount').val('');
	    	$('.wangyingebhand').text('0');
	    	$('#ebtop_up_amount').html('0');
	    	$('.eb_error').html('');
	    	
	    });


	    $('.person_wangying').click(function(){
	    	$(this).addClass('active');
    		$(this).siblings().removeClass('active');
    		$('.enterprise_bankBox').hide();
	    	$('.person_bankBox').show();
	    	$('#ebtop_up_amount').val('');
	    	$('.wangyingebhand').text('0');
	    	$('.entriseBox').hide();
	    	$('.personesBox').show();
	    	$('.order_pay_type').val('B2C');
	    	$('.ebhand_cost02').text('0');
	    	$('.eb_error').html('');
	    });


	    // 判断网银充值里的充值金额
	    var ebank_num = false;
	    $('#ebtop_up_amount').blur(function(){
	        // var e_reg =  /^([1-9][\d]{0,7}|0)(\.[\d]{1,2})?$/;
	        var e_reg = /^d+$/;
	        $('.eb_error').html('');
	        if (this.value==""){
	            $('.eb_error').html('充值金额不能为空！');
	            ebank_num = false;
	        }else if(this.value<=99){
	            $('.eb_error').html('充值金额不能少于100！');
	            ebank_num = false;
	        }else{
	            ebank_num = true;
	        }
	    });
	    // 判断用户有没有选择网银充值银行
	    var wyingFlag = false;
	    $('.bankBox_radio').each(function(){
	    	$(this).click(function(){
	    		if($(this).is(':checked')){
	    			wyingFlag = true;
	    		}else{
	    			wyingFlag = false;
	    		}
	    	});
	    });
	    // 当点击快捷充值里的“确认充值”时触发
	    $('.eb_top_upBtn').click(function(){
	        if(ebank_num){
	        	if(wyingFlag){
	    			return true;
			    }else{
			    	$('.eb_error').html('请选择网银充值银行！');
			    	setTimeout(function(){
			    		$('.eb_error').html('');
			    	},2000);
			    	return false;
			    }
	        }else{
	            $("#ebtop_up_amount").trigger("blur");
	            return false;
	        }
	    });



	    // 企业网银充值
	    // 获取收费类型
	    var ebfee_type = $('.ebhand_fee').attr('ebformulatype');
	    // 固定的手续费
	    var ebfees = $('.ebfees').attr('ebfee');
	    // 手续费的比例
	    var ebhand_rate = $('.ebhand_cost').attr('ebinterestrate');

	    if(ebfee_type==1){
	        $('#ebtop_up_amount').keyup(function(){
	        	if($(this).val()){
	        		var money = $(this).val()*ebhand_rate;
	        		$('.ebhand_cost').html(round2(money,2));
	        	}else{
	        		$('.ebhand_cost').html('0');
	        	}
	            
	        });
	        var ii = ebhand_rate * 100 + '%';
	        $('.enter_sxf').html(ii);
	    }else if(ebfee_type==2){
	        $('#ebtop_up_amount').keyup(function(){
	            $('.ebhand_cost').html(ebfees);
	            if($(this).val()==''){
	            	$('.ebhand_cost').html('0');
	            }
	        });
	        $('.enter_sxf').html(ebfees+'元');
	    }

	    // 个人网银充值
	    // 获取收费类型
	    var ebfee_type1 = $('.ebhand_fee02').attr('ebformulatype1');
	    // 固定的手续费
	    var ebfees1 = $('.ebfees1').attr('ebfee1');
	    // 手续费的比例
	    var ebhand_rate1 = $('.ebhand_cost02').attr('ebinterestrate1');
	    if(ebfee_type1==1){
	        $('#ebtop_up_amount').keyup(function(){
	        	if($(this).val()){
	        		var money = $(this).val()*ebhand_rate1;
	        		$('.ebhand_cost02').html(round2(money,2));
	        	}else{
	        		$('.ebhand_cost02').html('0');
	        	}
	            
	        });
	        var t = ebhand_rate1 * 100 +'%';
	        $('.pson_sxf').html(t);
	    }else if(ebfee_type1==2){
	        $('#ebtop_up_amount').keyup(function(){
	            $('.ebhand_cost02').html(ebfees1);
	            if($(this).val()==''){
	            	$('.ebhand_cost02').html('0');
	            }
	        });
	        $('.pson_sxf').html(ebfees1+'元');
	    }

	// <div class="fl ebbot_infos personesBox" style="display:none;">
	// 	<span class='ebhand_fee ebhand_fee02' ebformulaType1 =${formulaType1} >手续费</span>
	// 	<span class='ebhand_cost ebhand_cost02' ebinterestRate1=${interestRate1}>0</span>
	// 	<span class='ebfees1' style='color:#ff5353;' ebfee1=${fee1}>元</span>
	// </div> formatMoney

	$('.eb_balance_amount').html(formatMoney($('.eb_balance_amount').text(),2));
	    




	});
</script>



