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
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/witrecharge.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/witrecharge.js'></script>
</head>
<body>
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
				<div class="acc_rigContent_name" style="height:24px;text-indent:-9999px;">充值</div>
				<!-- 内容盒子Start -->
				<div class="rech_rigBotContent_box">
					<div class="rech_tab_title" cardType = "${sessionScope.user_inf.cardType}">
						<p class="fl quick_top_up active">快捷充值</p>
						<p class="fl ebank_top_up">网银充值</p>
						<div class="clear"></div>
					</div>

					<div class="tup_up_area">
						<!-- 快捷充值Start -->
						<div class="quick_box">
							<div id="quick_content">
							
								<!-- 未绑定银行卡时显示此部分内容 -->
								<c:if test="${empty userAccountInfo.capAcntNo}">
								<div class="nobind_bank_box">
									<p class="bind_card">+&nbsp;&nbsp;开通托管账户</p>
								</div>
                                </c:if>	
								<!-- 已经绑定了银行卡时显示此部分内容 -->
								<c:if test="${not empty userAccountInfo.capAcntNo}">
								<form action="${pageContext.request.contextPath }/account/fastRecharge" method="post" id="queck_form">
								<div class="relbind_bank_box">
									<div class="relbind_bank_top">
										<div class="fl com_bank_icon"></div>
										<div class="fl bank_title" bandcode = ${userAccountInfo.parent_bank_id}>${bankName }</div>
										<div class="fl bank_hr"></div>
										<div class="fl bank_infose">
											<p class="bank_ids">${userAccountInfo.capAcntNo }</p>
											<p class="bank_id_name">${userAccountInfo.realname }</p>
										</div>
										<div class="fl bank_right"></div>
										<div class="clear"></div>
									</div>

									<div class="relbind_bank_middle">
										<span>可用余额</span>
										<span class='bank_balance'>${userAccountamt }</span>
										<span style='color:#ff5353;'>元</span>
									</div>

									<div class="relbind_bank_bot">
										<p class="fl">充值金额</p>
										<input type="text" name='amt' class="fl top_up_amount" id="top_up_amount" placeholder='请输入100元以上的金额' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,''">
										<div class="fl bot_infos">
											<span class='hand_fee' formulaType =${formulaType}>手续费</span>
											<span class='hand_cost' interestRate=${interestRate}>0</span>
											<span class='feees' style='color:#ff5353;'  fee=${fee}>元</span>
										</div>
										<div class="clear"></div>
									</div>
									<div class="re_error"></div>

									<div class="confirm_top_up" ><input class='kuaijie_btn' type="submit" value="确认充值"></div>

								</div>
								</form>
								</c:if>
							</div>

							<!-- 温馨提示内容 -->
							<div class="bank_comment_box">
								<h3>温馨提示</h3>
								<div class="bank_txtes">
									<p class="bank_txt_item">
										1、为了您的账户安全，请在充值前进行身份认证、手机绑定以及提现密码设置。
									</p>
									<p class="bank_txt_item">
										2、您的账户资金将由第三方托管平台管理。
									</p>
									<p class="bank_txt_item">
										3、请注意您的银行卡充值限制，以免造成不便。以下支持快捷充值银行限额，仅供参考：
									</p>
									<table class="tab">
										<tr>
											<th class="t_width">银行</th>
											<th>额度</th>
											<th class="t_width">银行</th>
											<th>额度</th>
										</tr>
										<tr>
											<td class="t_width">工行</td>
											<td>5万/笔，5万/日，20万/月</td>
											<td class="t_width">平安</td>
											<td>5万/笔，20万/月</td>
										</tr>
										<tr>
											<td class="t_width">农行</td>
											<td>5万/笔，10万/日，20万/月</td>
											<td class="t_width">中信</td>
											<td>1万/笔，1万/日,2万/月</td>
										</tr>
										<tr>
											<td class="t_width">建行</td>
											<td>5万/笔，10万/日，20万/月</td>
											<td class="t_width">华夏</td>
											<td>5万/笔，20万/月</td>
										</tr>
										<tr>
											<td class="t_width">中行</td>
											<td>5万/笔，10万/日，20万/月</td>
											<td class="t_width">光大</td>
											<td>5万/笔，20万/月</td>
										</tr>
										<tr>
											<td class="t_width">邮储</td>
											<td>5万/笔，20万/月</td>
											<td class="t_width">浦发</td>
											<td>2万元/笔，5万/日，20万/月</td>
										</tr>
										<tr>
											<td class="t_width">招行</td>
											<td>5万元/笔，5万/日，20万/月</td>
											<td class="t_width">民生</td>
											<td>5万/笔，20万/月</td>
										</tr>
										<tr>
											<td class="t_width">兴业</td>
											<td>5万/笔，5万/日，20万/月</td>
											<td class="t_width">交行</td>
											<td>5万/笔，10万/日，20万/月</td>
										</tr>
										<tr>
											<td class="t_width">广发</td>
											<td>5万/笔，20万/月</td>
											<td class="t_width"></td>
											<td></td>
										</tr>
									</table>
									<p class="bank_txt_item">
										4、禁止洗钱、信用卡套现、虚假交易等行为，一经发现并确认，将终止该账户的使用。
									</p>
									<p class="bank_txt_item">
										5、如果充值金额没有及时到账，请联系客服：4009-303-606
									</p>
								</div>
							</div>
						</div>
						<!-- 快捷充值End -->

						<!-- 网银充值Start -->
						<div class="eBank_box" style="display:none;">
						<!-- 未绑定银行卡时显示此部分内容 -->
								<c:if test="${empty userAccountInfo.capAcntNo}">
								<div class="ee_bank_box">
									<p class="bind_card">+&nbsp;&nbsp;开通托管账户</p>
								</div>
                                </c:if>
						<c:if test="${not empty userAccountInfo.capAcntNo}">
						<form action="<%=request.getContextPath() %>/account/webRecharge" method="post">
							<div id="eb_content">
								<div class="eb_balance">
									<span>可用余额</span>
									<span class='eb_balance_amount'>${userAccountamt }</span>
									<span style='color:#ff5353;'>元</span>
								</div>

								<div class="ebank_middle">
									<p class="fl">充值金额</p>
									<input type="text" name='amt' class="fl ebtop_up_amount" id="ebtop_up_amount" placeholder='请输入100元以上的金额' onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,''">
									<div class="fl ebbot_infos">
										<span class='ebhand_fee' ebformulaType =${formulaType1}>手续费</span>
										<span class='ebhand_cost' ebinterestRate=${interestRate1}>0</span>
										<span class='ebfees' style='color:#ff5353;' ebfee=${fee1}>元</span>
									</div>
									<div class="clear"></div>
								</div>
								<div class="eb_error"></div>
                                <input type="submit"  class="eb_top_upBtn" value="确认充值">
								
							</div>
                          </form>
                          </c:if>
							<!-- 温馨提示内容 -->
							<div class="bank_comment_box">
								<h3>温馨提示</h3>
								<div class="bank_txtes">
									<p class="bank_txt_item">
										1.为了您的账户安全，请在充值前进行身份认证，绑定手机、银行卡，开通托管账户。
									</p>
									<p class="bank_txt_item">
										2.用户充值时请检查银行卡信息是否填写正确、是否开通网上银行，有足够余额能正常使用。
									</p>
									<p class="bank_txt_item">
										3.请注意您的银行卡充值限制，以免造成不便。以下个人网银充值限额，仅供参考：
									</p>
									<table class="w_tab">
										<tr>
											<th rowspan="2">银行名称</th>
											<th colspan="2">静态存量密码</th>
											<th colspan="2">口令卡</th>
											<th colspan="2">电子密码器/数字证书</th>
											<th colspan="2">一代ukey</th>
											<th colspan="2">二代UKEY</th>
											<th colspan="2">短信</th>
										</tr>
										<tr>
											<th>单笔</th>
											<th>单日</th>
											<th>单笔</th>
											<th>单日</th>
											<th>单笔</th>
											<th>单日</th>
											<th>单笔</th>
											<th>单日</th>
											<th>单笔</th>
											<th>单日</th>
											<th>单笔</th>
											<th>单日</th>
										</tr>
										<tr>
											<td>工行</td>
											<td>300</td>
											<td>300</td>
											<td>500</td>
											<td>1000</td>
											<td>5万</td>
											<td>5万</td>
											<td>50万</td>
											<td>100万</td>
											<td>100万</td>
											<td>500万</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>中行</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
											<td>5万</td>
										</tr>
										<tr>
											<td>建行</td>
											<td>500</td>
											<td>500</td>
											<td>5000</td>
											<td>5000</td>
											<td>-</td>
											<td>-</td>
											<td>5万</td>
											<td>10万</td>
											<td>50万</td>
											<td>50万</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>交行</td>
											<td>-</td>
											<td>-</td>
											<td>5000</td>
											<td>5000</td>
											<td>-</td>
											<td>-</td>
											<td>100万</td>
											<td>100万</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>农行</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>50万</td>
											<td>100万</td>
											<td>100万</td>
											<td>500万</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>邮储</td>
											<td>-</td>
											<td>-</td>
											<td>20万</td>
											<td>20万</td>
											<td>-</td>
											<td>-</td>
											<td>200万</td>
											<td>200万</td>
											<td>-</td>
											<td>-</td>
											<td>2万</td>
											<td>2万</td>
										</tr>
										<tr>
											<td>招行</td>
											<td>5000</td>
											<td>5000</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>无限额</td>
											<td>无限额</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>中信</td>
											<td>-</td>
											<td>-</td>
											<td>1000</td>
											<td>5000</td>
											<td>-</td>
											<td>-</td>
											<td>无限额</td>
											<td>无限额</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>浦发</td>
											<td>-</td>
											<td>-</td>
											<td>1万</td>
											<td>20万</td>
											<td>-</td>
											<td>-</td>
											<td>无限额</td>
											<td>无限额</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>兴业</td>
											<td>-</td>
											<td>-</td>
											<td>5000</td>
											<td>5000</td>
											<td>-</td>
											<td>-</td>
											<td>100万</td>
											<td>100万</td>
											<td>100万</td>
											<td>100万</td>
											<td>5000</td>
											<td>5000</td>
										</tr>
										<tr>
											<td>民生</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>50万</td>
											<td>50万</td>
											<td>-</td>
											<td>-</td>
											<td>5000</td>
											<td>5000</td>
										</tr>
										<tr>
											<td>光大</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>50万</td>
											<td>100万</td>
											<td>50万</td>
											<td>50万</td>
											<td>-</td>
											<td>-</td>
											<td>2万</td>
											<td>2万</td>
										</tr>
										<tr>
											<td>平安</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>5万</td>
											<td>5万</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>上海</td>
											<td>-</td>
											<td>-</td>
											<td>6000</td>
											<td>1万</td>
											<td>-</td>
											<td>-</td>
											<td>50万</td>
											<td>100万</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>华夏</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>50万</td>
											<td>50万</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>北京</td>
											<td>-</td>
											<td>-</td>
											<td>1000</td>
											<td>5000</td>
											<td>-</td>
											<td>-</td>
											<td>100万</td>
											<td>100万</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>广发</td>
											<td>-</td>
											<td>-</td>
											<td>5万</td>
											<td>5万</td>
											<td>-</td>
											<td>-</td>
											<td>100万</td>
											<td>100万</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
											<td>-</td>
										</tr>
										<tr>
											<td>浙商</td>
											<td>200</td>
											<td>1000</td>
											<td>用户自设</td>
											<td>用户自设</td>
											<td>用户自设</td>
											<td>用户自设</td>
											<td>用户自设</td>
											<td>用户自设</td>
											<td>用户自设</td>
											<td>用户自设</td>
											<td>用户自设</td>
											<td>用户自设</td>
										</tr>
									</table>
									<p class="bank_txt_item">
										4.严禁利用充值功能洗钱、信用卡套现、虚假交易，一经发现，终止该账户的使用。
									</p>
									<p class="bank_txt_item">
										5.如遇充值后银行已扣款，网站个人账户可用余额未增加，请及时联系客服：4009-303-606。
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

	    $('.bank_balance').html(formatMoney($('.bank_balance').text(),2));

	    $('.eb_balance_amount').html(formatMoney($('.eb_balance_amount').text(),2));



	    //查询港澳台开户是否正在审批中
	    $.ajax({
	    	type:'post',
	    	url:getContextPaths()+'/user/getCountGatApprove',
	    	dataType:'json',
	    	success:function(json){
	    		if(json.flag==1){
	    			if(json.countFlag==1){
	    				errorWindow('您开通的托管账户正在审核中......');
	    				$('.bind_card').click(function(){
	    					errorWindow('您开通的托管账户正在审核中......');
	    				});
	    			}else{
	    				$('.bind_card').click(function(){
	    					window.location.href = getContextPaths() + '/myAccount/enterEscrowAccount';
	    				});
	    			}
	    		}
	    	}
	    });




		// 判断是否是台胞证和港澳回乡证开户
		var card_type = $('.rech_tab_title').attr('cardType');
	    if(card_type != 1){
	    	$('.quick_top_up').hide();
	    	$('.ebank_top_up').unbind('click').addClass('active');
	    	$('.quick_box').hide();
	    	$('.eBank_box').show();
	    }



	});
</script>



