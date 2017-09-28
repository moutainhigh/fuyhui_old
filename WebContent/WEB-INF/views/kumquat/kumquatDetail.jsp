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
    <title>金桔系列详情-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/webox.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/kumquat/kumquatDetail.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/thirdPlugs/jquery-webox.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/kumqt/kumquatDetail.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/kumqt/kumquatWindow.js'></script>
	<style type="text/css">
		.investagreement
		{
			color: #303642;
			font-size: 12px;
			font-weight: bold;
		}
		.hasRead
		{
			font-size: 12px;
			cursor: #000;
		}
		.row_read 
		{
			margin-left: 42px;
			margin-bottom: 10px;
		}
		.inDetail_btn
		{
			outline: none;
		}
	</style>
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	<!-- 标的详情内容区域Start -->
	<div class="inDetail_top_body">
		<div class="inDetail_1000">
			<!-- 左边部分标的详情介绍Start -->
			<div class="fl inDetail_left_box">
				<div class="inDetail_top_title">
					<div class="fl indetail_name" investId=${investment.id}>${investment.loanName }</div>
					<!-- <div class="fl indetail_code">编号：<span class='indetCodeNum'>${investment.orderNumber }</span></div> -->
					<!-- <div class="fr indetImg"></div> -->
					<div class="clear"></div>
				</div>

				<div class="inDetail_content">
					<ul class="indetail_list">
						<li class="indet_item indet_item01">
							<p><span class='indet_rate'>${investment.apr }</span>%</p>
							<div>预期年化收益</div>
						</li>
						<li class="indet_item indet_item02">
							<p><span class='indet_limit_day'>${investment.period }</span>天</p>
							<div>预期产品期限</div>
						</li>
						<li class="indet_item indet_item03">
							<p><span class='indet_invest_amout'><fmt:formatNumber type="number" value="${investment.amount }" maxFractionDigits="0"/></span>元</p>
							<div>产品规模</div>
						</li>
					</ul>
					<div class="clear"></div>
					<div class="inDetail_conBot">
						<!-- <span class='conBot01'>还款方式：
						<c:choose>
						<c:when test="${investment.paymentOptions == 1 }">按月付息，到期一次性还本</c:when>
						<c:when test="${investment.paymentOptions == 2 }">到期一次性还本付息</c:when>
						<c:when test="${investment.paymentOptions == 3 }">等额本息</c:when>
						<c:when test="${investment.paymentOptions == 4 }">等额本金</c:when>
						<c:when test="${investment.paymentOptions == 5 }">按季付息，到期一次性还本</c:when>
						<c:otherwise></c:otherwise>
						</c:choose>
						</span> -->


						<div class='fl conBot_endTime_box'>
							<div class="conBot_endtime">
								认购开始时间：<date:date pattern="yyyy-MM-dd HH:mm" value="${investment.startTime}"></date:date>
							</div>
							<div class="conBot_fangshi">
								回款方式：
								<c:choose>
									<c:when test="${investment.paymentOptions == 1 }">按月付息，到期一次性还本</c:when>
									<c:when test="${investment.paymentOptions == 2 }">到期一次性还本付息</c:when>
									<c:when test="${investment.paymentOptions == 3 }">等额本息</c:when>
									<c:when test="${investment.paymentOptions == 4 }">等额本金</c:when>
									<c:when test="${investment.paymentOptions == 5 }">按季付息，到期一次性还本</c:when>
									<c:otherwise></c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class='fl conBot_endTimees_box'>
							<div class="conBot_endTimees">
								认购截止时间：<date:date pattern="yyyy-MM-dd HH:mm" value="${investment.endTime}"></date:date>
							</div>
							<div class="conBot_zenxinfang">
								增信方：<span>${investment.guaranteeCompany }</span>
							</div>
						</div>
						<!-- <div class='fl conBot_instit'>保障方式：${investment.guaranteeCompany }提供${investment.guaranteeMode }</div> -->
						
						<div class="clear"></div>
					</div>
				</div>
			</div>
			<!-- 右边部分是投标区域 -->
			<div class="fl inDetail_right_box">
			<input name="redid" id="redid" value="" type="hidden">
				<c:choose>
					<c:when test="${investment.status == 2 }">
						<!-- 预热中时 -->
						<div class="inDetail_also">
							<div class="inter_rightTitle">
								<h3 style="margin-left:47px;">预热中</h3>
								<!-- <p class="redFlagImg_also"></p> -->
							</div>
							<div class="rema_avail_money">
								剩余认购金额：<span class='remaMoney'>${investment.amount }</span>元
							</div>
							<div class="amount_avail_money">
								认购完成时间：<span class='fundra_time'>尚未开始认购</span>
							</div>
							<div class="indet_btnBox">
								<div class="fl inDetail_btn" style="margin:40px 0 0 49px !important;background:#c1c1c1;">立即认购</div>
								<!-- <p class="fuyuanhuiImg"></p> -->
							</div>

						</div>
					</c:when>
					<c:when test="${investment.status == 7 }">
						<c:if test="${empty sessionScope.user_inf }">
						<!-- 我要投资未登录时 -->
						<div class="inDetail_noLogin">
							<div class="inter_rightTitle">
								<h3 style="margin-bottom:17px;">请登录</h3>
								<p class="redFlagImg"></p>
							</div>
							<div class="rema_avail_money">
								剩余认购金额：<span class='remaMoney'>
								<c:if test="${empty investment.remainAmount }">${investment.amount }</c:if>
								<c:if test="${not empty investment.remainAmount }">${investment.remainAmount }</c:if></span>元
							</div>
							<div class="amount_avail_money">
								账户可用余额：&nbsp;&nbsp;<a href="javascript:void(0);" style="color:#0bf;" onclick="window.location.href=getContextPaths()+'/enterLogin'">登录后</a>&nbsp;可见
							</div>
							<div class="inter_rightInput">
								<input type="text" name='avail_money'
									class="fuyhui_txt avail_money" id="avail_money"
									placeholder='${investment.investMin }元起，${investment.proAmount }元递增'>
							</div>
							<div class="noinv_errorMsg" style="height:21px;"></div>
							<div class="row_read success">
					            <input checked="checked" name="Ifagreement" id="Ifagreement" value="1" type="checkbox">            
					            <label for="Ifagreement">
					            	<span class="hasRead">我已阅读并同意</span>
					                <a href="javascript:void(0);" class="no_investagreement" style="color:#5e97f6;margin-left:0;">《产品合同》</a>
					            </label>     
            				</div>
							<div class="inDetail_btn" onclick="window.location.href=getContextPaths()+'/enterLogin'" style="margin-top:22px;">登录</div>
						</div>
						</c:if>
						<c:if test="${not empty sessionScope.user_inf }">
						<!-- 我要投资已经登录时 -->
						<div class="inDetail_login">
							<!-- <form action="${pageContext.request.contextPath }/invest?id={investment.id }" id="indetLogin_form" method="post"> -->
								<div class="inter_rightTitle">
									<h3 style="margin-bottom:20px">我要认购</h3>
									<p class="redFlagImg"></p>
								</div>
								<div class="rema_avail_money">
									剩余认购金额：<span class='remaMoney'>
								<c:if test="${empty investment.remainAmount }">${investment.amount }</c:if>
								<c:if test="${not empty investment.remainAmount }">${investment.remainAmount }</c:if></span>元
								</div>
								<div class="amount_avail_money">
									账户可用余额：
									<span style='position:relative;'> 
										<span class='indet_avail_money'>${balance }</span>
										<span class='indet_avail_dis' style='display:none;'>********</span>
										<span style='position:absolute;top:0px;left:86px;color: #0bf; font-size: 16px;'>元</span> 
										<span class='com_indet_eyeImg indet_eyeImg'></span>
										<c:if test="${sessionScope.user_inf.userType=='1'}"><a href="javascript:void(0);" class="amount_href" onclick="window.location.href=getContextPaths()+'/account/enterRecharge'">充值</a></c:if>
										<c:if test="${sessionScope.user_inf.userType=='2'}"><a href="javascript:void(0);" class="amount_href" onclick="window.location.href=getContextPaths()+'/account/enterBorrowRecharge'">充值</a></c:if>
										<c:if test="${sessionScope.user_inf.userType=='3'}"><a href="javascript:void(0);" class="amount_href" onclick="window.location.href=getContextPaths()+'/account/enterInsRecharge'">充值</a></c:if>
										
									</span>
								</div>
								<div class="inter_rightInput">
									<input type="text" name='avail_money'
										class="fuyhui_txt avail_money" id="avail_money"
										placeholder='${investment.investMin }元起，${investment.proAmount }元递增'>
									<div class="indet_expect_box">
										预期收益： <span class='indet_expect_earn'>50.00</span> 元
									</div>
								</div>
								<div class="inv_errorMsg"></div>
								<!-- <div class="row_read success">
						            <input checked="checked" name="Ifagreement" id="Ifagreement" value="1" type="checkbox">            
						            <label for="Ifagreement">
						            	<span class="hasRead">我已阅读并同意</span>
						                <a href="javascript:void(0);" class="investagreement" style="color:#5e97f6;margin-left:0;">《产品合同》</a>
						            </label>     
            					</div> -->
								<div class="indet_btnBox">
									<button type="submit" class="fl inDetail_btn real_ind_btn" style="margin-top:5px;" width='640' hight='510' title='认购确认' conhref='/pdf/${investment.productUrl}/${investment.orderNumber}02.pdf'>立即认购</button>
									<!-- <div class="fl inDetail_awardBox">
										<div class="indet_redpackage">
											<span class="redPackageImg"></span> <span>红包抵扣：</span> <span
												class='redPack_num'>0</span><span>元</span>
										</div>
										<div class="indet_payBox">
											<span class='payImg'></span> <span>实际付款：</span> <span
												class='indet_payNum'>0</span><span>元</span>
										</div>
									</div> -->
								</div>
							<!-- </form> -->
						</div>
						</c:if>
					</c:when>
					<c:when test="${investment.status == 8 && investment.isLoans == 0}">
						<!-- 满标时 -->
						<div class="inDetail_also">
							<div class="inter_rightTitle">
								<h3 style="margin-left:47px;">已售罄</h3>
								<p class="redFlagImg_mambiao"></p>
							</div>
							<div class="rema_avail_money">
								剩余认购金额：<span class='remaMoney'>${investment.remainAmount }</span>元
							</div>
							<div class="amount_avail_money">
								认购完成时间：<span class='fundra_time manbiao'>${investment.completeTime}</span>
							</div>
							<div class="indet_btnBox">
								<div class="fl inDetail_btn" onclick="window.location.href=getContextPaths()+'/enterKumquatList'" style="margin:40px 0 0 48px !important;">认购其它产品</div>
								<!-- <p class="fuyuanhuiImg"></p> -->
							</div>

						</div>
					</c:when>
					<c:when test="${investment.status == 9 || (investment.status == 8 && investment.isLoans != 0)}">
						<!-- 还款中时 -->
						<div class="inDetail_also">
							<div class="inter_rightTitle">
								<h3 style="margin-left:47px;">回款中</h3>
								<p class="redFlagImg_also"></p>
							</div>
							<div class="rema_avail_money">
								剩余认购金额：<span class='remaMoney'>${investment.remainAmount }</span>元
							</div>
							<div class="amount_avail_money">
								认购完成时间：<span class='fundra_time fkduring'>${investment.completeTime}</span>
							</div>
							<div class="indet_btnBox">
								<div class="fl inDetail_btn" onclick="window.location.href=getContextPaths()+'/enterKumquatList'" style="margin:40px 0 0 48px !important;">认购其它产品</div>
								<!-- <p class="fuyuanhuiImg"></p> -->
							</div>

						</div>
					</c:when>
					<c:otherwise>
						<!-- 已结清时 -->
						<div class="inDetail_complete">
							<div class="inter_rightTitle">
								<h3 style="margin-left:47px;">已结束</h3>
								<p class="redFlagImg_complete"></p>
							</div>
							<div class="rema_avail_money">
								剩余认购金额：<span class='remaMoney'>${investment.remainAmount }</span>元
							</div>
							<div class="amount_avail_money">
								认购完成时间：<span class='fundra_time completeTime'>${investment.completeTime}</span>
							</div>
							<div class="indet_btnBox">
								<div class="fl inDetail_btn" style="margin:40px 0 0 48px !important;" onclick="window.location.href=getContextPaths()+'/enterKumquatList'" style="margin:40px 0 0 48px !important;">认购其它产品</div>
								<!-- <p class="fuyuanhuiImg_complete"></p> -->
							</div>

						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!-- 标的详情内容区域End -->
	
	<!-- 下半部分内容Start -->
	<div class="inDetail_bot_body">
		<div class="indet_bot_1000">
			<div class="indet_bot_contentBox">
				<div class="indet_title_box">
					<ul class="indet_title_list">
						<li class="project_info active">产品信息</li>
						<li class="project_plan">回款计划</li>
						<li class="indet_investRecord">认购记录</li>
						<!-- <li class="pro_quersions">常见问题</li> -->
						<!-- <li class="project_process">项目历程</li> -->
					</ul>
					<div class="clear"></div>
				</div>

				<!-- 项目信息Start -->
				<div class="indet_project_infosBox">
					<p class="odd_p progect_names">
						<span class='pro_firstP'>产品名称：</span>
						<span class='com_prosecond projectNam'>${investment.loanName }</span>
					</p>
					<!-- <p class="even_p project_source">
						<span class='pro_firstP'>项目来源：</span>
						<span class='com_prosecond proSource'>${investment.projectSource }</span>
					</p> -->
					<p class="even_p project_source">
						<span class='pro_firstP'>产品规模：</span>
						<span class='com_prosecond proSource'><fmt:formatNumber type="number" value="${investment.amount }" maxFractionDigits="0"/>元</span>
					</p>
				
					<p class="odd_p">
						<span class='pro_firstP'>预期年化收益：</span>
						<span class='com_prosecond pro_rate'>${investment.apr }%</span>
					</p>

					<p class="even_p">
						<span class='pro_firstP'>预期产品期限：</span>
						<span class='com_prosecond pro_limit'>${investment.period }天，实际产品期限以合同为准</span>
					</p>
					<p class="odd_p">
						<span class='pro_firstP'>认购条件：</span>
						<span class='com_prosecond pro_conditions'>购买金额 <span class='qitouyuan'>${investment.investMin }</span> 元起，且为 ${investment.proAmount } 元的整数倍递增</span>
					</p>
					<p class="even_p">
						<span class='pro_firstP'>收益起算日：</span>
						<span class='com_prosecond pro_rengou'>认购全部完成后的一个工作日内</span>
					</p>
					<p class="odd_p">
						<span class='pro_firstP'>到期日期：</span>
						<span class='com_prosecond pro_daoqiday'><date:date pattern="yyyy-MM-dd" value="${investment.dueTime}"></date:date></span>
					</p>
					<!-- <p class="odd_p">
						<span class='pro_firstP'>收益说明：</span>
						<span class='com_prosecond pro_increts'>本项目约定年化收益率为 X%，平台活动加息X%，实际收益以产品到期结算收益为准。</span>
					</p> -->
					<p class="even_p">
						<span class='pro_firstP'>回款方式：</span>
						<span class='com_prosecond pro_rateStyle'>
						<c:choose>
						<c:when test="${investment.paymentOptions == 1 }">按月付息，到期一次性还本</c:when>
						<c:when test="${investment.paymentOptions == 2 }">到期一次性还本付息</c:when>
						<c:when test="${investment.paymentOptions == 3 }">等额本息</c:when>
						<c:when test="${investment.paymentOptions == 4 }">等额本金</c:when>
						<c:when test="${investment.paymentOptions == 5 }">按季付息，到期一次性还本</c:when>
						<c:otherwise></c:otherwise>
						</c:choose>
						</span>
					</p>
					<p class="odd_p">
						<span class='pro_firstP'>收益说明：</span>
						<span class='com_prosecond shouyiincrement'>
						</span>
					</p>
					<p style="margin-left: 29px;font-size: 14px;color: #474e5d;line-height: 28px;">
						本产品认购期间不计算收益，根据认购人持有产品的实际天数计算收益。本产品存在提前还款到期的可能性，若产品提前还款到期，本金和实际产品期限内的收益将提前自动回款至您的托管账户，本产品不可转让。
					</p>
					<p class="odd_p">
						<span class='pro_firstP'>增信方式：</span>
						<span class='com_prosecond pro_baozheng'>${investment.guaranteeCompany }提供${investment.guaranteeMode }</span>
					</p>
					<!-- <p class="odd_p">
						<span class='pro_firstP'>合同及协议：</span> -->
						<!-- 《金融产品认购协议样本》和     等-->
					<!-- 	<a class='com_prosecond pro_agreement' href="javascript:void(0);" style="color:#5e97f6;margin-left:0;">《产品<span style='font-family:"宋体"'>募</span>集说明书》</a>
					</p>  -->
					<p class="even_p">
						<span class='pro_firstP'>产品描述：</span>
					</p>
					<p class="pro_gaishu" style="margin-left:26px;font-size:16px;color:#474e5d;line-height:26px;font-weight:bold;">
						${investment.description }
					</p>
					<p class="odd_p" style="font-weight:bold;height:50px;">
						<span class='pro_firstP'>风险提示：</span>
						<!-- <span class='com_prosecond risk_toops'> </span> -->
					</p>
					<p class="risk_toops" style="margin-left:29px;font-size:14px;color:#474e5d;line-height:28px;">尊敬的会员： 您所购买的金桔系列产品虽然由增信机构提供了增信措施，但您仍有可能面临信用风险以及增信机构能力下降的风险等，您可能面临本金及收益的损失。 富元汇别提示您，请您根据自身的理财规划及风险承受能力进行决策。</p>
					 

				</div>
				<!-- 项目信息End -->

				

				<!-- 还款计划Start -->
				<div class="indet_plan_infoBox" style="display:none;">
					<!-- <div class="indet_refund_box">
						<div class="fl relady_refund">已还金额：<span class='re_refund'>0.00</span>元</div>
						<div class="fl no_refund">待还金额：<span class='dai_refund'>0.00</span>元</div>
						<div class="clear"></div>
					</div> -->
					<div class="refund_titleBox">
						<ul class="refund_list">
							<li class="refund_item01">期数</li>
							<li class="refund_item02">应还日期</li>
							<li class="refund_item03">应还本金</li>
							<li class="refund_item04">应付收益</li>
							<!-- <li class="refund_item05">实还本金</li>
							<li class="refund_item06">实还利息</li>
							<li class="refund_item07">实还日期</li> -->
							<li class="refund_item08">状态</li>
						</ul>
						<div class="clear"></div>
					</div>
					<div class="indet_planContBox">
						<!-- 每一条还款计划信息 -->
						<!-- <div class="refund_infos">
							<div class="fl refund_div refund_date_num">第<span>1</span>期</div>
							<div class="fl refund_div refund_time">2016-10-10</div>
							<div class="fl refund_div refund_beijin"><span>0</span>元</div>
							<div class="fl refund_div refund_rate"><span>30</span>元</div>
							<div class="fl refund_div refund_state">待还</div>
							<div class="clear"></div>
						</div> -->
					</div>

					<!-- 分页 -->
					<div class="page_box investPlanPage">
						<ul id="plan_page" class="plan_page"></ul>
					</div>
					
				</div>
				<!-- 还款计划End -->


				<!-- 购买记录Start -->
				<div class="indet_investRecord_box" style="display:none;">
					<div class="indet_invest_title">
						<ul class="indet_invest_list">
							<li class="indet_inveItem01">会员名</li>
							<li class="indet_inveItem02">认购金额</li>
							<li class="indet_inveItem03">认购时间</li>
						</ul>
						<div class="clear"></div>
					</div>
					<div class="inv_record_wrap"></div>
					
					<!-- 分页 -->
					<div class="page_box investRecordPage">
						<ul id="invest_page" class="invest_page"></ul>
					</div>


				</div>
				<!-- 投资记录End -->

				<!-- 常见问题Start -->
				<div class="question_box_infos" style="display:none;">
					<!-- <div class="big_quetitle">
						<div class="fl que_hr"></div>
						<div class="fl que_title">提现</div>
						<div class="clear"></div>
					</div> -->
					<div class="que_div">
						<p class="que_txtTitle">1、什么是地方金融资产交易所？</p>
						<p class="que_tement">
							地方金融资产交易所是由地方省委省政府批准设立，并由地方政府金融办监管的，为金融产品提供登记、托管、交易和结算等提供场所设施和服务的组织机构。
						</p>
					</div>
					<div class="que_div">
						<p class="que_txtTitle">2、富元汇发布的交易所资产有哪些种类？</p>
						<p class="que_tement">
							富元汇发布的交易所资产主要是理财计划类、直接融资类产品和权益转让类产品。<!--理财计划类产品：指地方金融资产交易所发行的、<span style='font-family:"宋体"'>募<span>集资金投向于金融机构的资管计划或信托计划的金融产品。-->
						</p>
						<p class="que_tement">
							<!--直接融资类产品：指在中国境内依法注册的公司、合伙企业及其他组织形式的商事主体依据法律法规规定在地方金融资产交易所注册（备案）的、以直接融资为目的并约定在一定期限还本付息的产品。权益转让类产品：指在中国境内依法注册的公司、合伙企业及其他组织形式的商事主体依据法律法规规定将其因持有债权性资产而形成的财产类权益在地方金融资产交易所转让予投资人的产品。-->
						</p>
					</div>
					<div class="que_div">
						<p class="que_txtTitle">3、交易所资产有哪些投资要求？</p>
						<p class="que_tement">每个产品的投资人数不能超过200人；</p>
						<p class="que_tement">投资者的年龄必须大于18周岁；</p>
						<p class="que_tement">投资者的风险等级满足产品规定的要求。</p>
					</div>
					<div class="que_div">
						<p class="que_txtTitle">4、如何购买交易所产品？</p>
						<p class="que_tement">
							您只能投资与您的风险等级对应的交易所产品，投资交易所产品需要投资人在相应交易所开户并注册成为其会员，所以投资前您需要对交易所的开户协议进行确认，之后绑定银行卡进行支付。产品<span style='font-family:"宋体"'>募</span>集成功后，交易所将对您的投资份额进行登记。
						</p>
					</div>
					<div class="que_div">
						<p class="que_txtTitle">5、交易所产品在到期前可以提前赎回么？</p>
						<p class="que_tement">
							在<span style='font-family:"宋体"'>募</span>集期内，即产品成立前，您的投资资金将被冻结，不能取消。如果产品<span style='font-family:"宋体"'>募</span>集失败，则申购资金会退回至您的账户内。当产品<span style='font-family:"宋体"'>募</span>集成功后，您不能提前赎回，只能等到产品到期。
						</p>
					</div>
					<div class="que_div">
						<p class="que_txtTitle">6. 交易所产品的安全性如何？</p>
						<p class="que_tement">
							交易所/中心会对基础资产的状况进行审核，必要时会要求发行人提供严谨的增信措施。同时，金融资产交易所/中心不允许产品管理人和发行人设置资金池及期限错配等。投资者认购交易所/中心备案发行的产品，交易所/中心会为投资者进行确权登记，从而与产品形成对应关系。投资者在认购时应认真阅读<span style='font-family:"宋体"'>募</span>集说明书及相关信息披露文件，具备一定的风险承受能力。
						</p>
					</div>
				</div>
				<!-- 常见问题End -->

				<!-- 项目历程Start -->
				<div class="indet_projectCourse_box" style="display:none;">
					<div class="proCourse_increment">
						<a href="javascript:void(0);">追踪详情&nbsp;&gt;</a>
					</div>
					<div class="proCourse_bot_box">
						<div class="fl proCourse_leftImg"></div>
						<div class="fl proCourse_right">
							<div class="com_proCourse">
								<h5>项目上线</h5>
								<div class="proCourse_bot_content">
									<div>上线时间：<span>2016-10-10 12:00:00</span></div>
									<p>项目代号：1MDBU3Eat6Wc6E4rmNJJ9Q3yN41J6poZ4ta</p>
								</div>
							</div>

							<div class="com_proCourse">
								<h5>项目<span style='font-family:"宋体"'>募</span>集</h5>
								<div class="proCourse_bot_content">
									<div>开始时间：<span>2016-10-10 12:00:00</span></div>
									<p>完成时间：<span>2016-10-10 12:00:00</span></p>
								</div>
							</div>

							<div class="com_proCourse">
								<h5>项目放款</h5>
								<div class="proCourse_bot_content">
									<div>放款时间：<span>2016-10-10 12:00:00</span></div>
									<p>放款交易码：1MDBU3Eat6Wc6E4rmNJJ9Q3yN41J6poZ4ta</p>
								</div>
							</div>

							<div class="com_proCourse">
								<h5>项目还款</h5>
								<div class="proCourse_bot_content">
									<div>
										已还款：<span class='relady_repayment'>0.00</span>
										（<span class='relady_limite'>0</span>期）|待还款：
										<span class='no_repayment'>75,581.99</span>
										（<span class='no_limite'>12</span>期）
										
									</div>
								</div>
							</div>

						</div>
						<div class="clear"></div>
					</div>
				</div>
				<!-- 项目历程End -->
			</div>
		</div>
	</div>
	<!-- 下半部分内容End -->
	<!-- 提示弹窗 -->
	<div class="invest_window">
		<div class="fr investClose"></div>
		<div class="clear"></div>
		<p class="investTxt"></p>
	</div>

	<!-- 风险测评弹窗start -->
	<div class="img_window03">
		<p class="r_close"></p>
		<div class="comWimg wAlert"></div>
		<p class="wTxt"></p>
		<p class="wIncrement"></p>
		<div class="comWBtn only_wBtn"></div>
	</div>


	<!-- 投资成功时的弹窗 -->
	<div class="img_window">
		<p class="r_close"></p>
		<div class="comWimg wSuccess"></div>
		<p class="wTxt"></p>
		<p class="wIncrement">邀请好友获取奖励，多邀多得，马上去<span class='wIncrement_a' onclick="window.location.href=getContextPaths()+'/enterIntFriend'">邀请好友</span></p>
		<div class="wBtn_group">
			<p class="comWBtn wBtn01 fl"></p>
			<p class="comWBtn wBtn02 fl"></p>
			<div class="clear"></div>
		</div>
	</div>

	<!-- 投资失败时时的弹窗 -->
	<div class="img_window02">
		<p class="r_close"></p>
		<div class="comWimg wError"></div>
		<p class="wTxt"></p>
		<p class="wIncrement">咨询客服：4009-303-606<br>服务时间：每天9:00 - 20:30</p>
		<div class="wBtn_group">
			<p class="comWBtn wBtn01 fl"></p>
			<p class="comWBtn wBtn02 fl"></p>
			<div class="clear"></div>
		</div>
	</div>



	


	

	<!-- 公共底部Starts -->
	<%@ include file="../layouts/footer.jsp"%>

	<script type="text/javascript">
		
		function openWin() { 
           var url='${pageContext.request.contextPath}/enterInvestAgreement'; //转向网页的地址; 
           var name='';                            //网页名称，可为空; 
           var iWidth=888;                          //弹出窗口的宽度; 
           var iHeight=718;                         //弹出窗口的高度; 
           //获得窗口的垂直位置 
           var iTop = (window.screen.availHeight - 30 - iHeight) / 2; 
           //获得窗口的水平位置 
           var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; 
           window.open(url, name, 'height=' + iHeight + ',,innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no'); 
       }

       $(function(){
			// 调用时间戳转换函数
			$('.completeTime').html(showTime($('.completeTime').html()));
			$('.fkduring').html(showTime($('.fkduring').html()));
			if($('.manbiao').html()==''){
				 //$('.manbiao').html('尚未开始募集');
			}else{
				$('.manbiao').html(showTime($('.manbiao').html()));
			}

			$('.proMoney').html(formatMoney($('.proMoney').html(),2)+'元');

			// 判断产品合同有没有生成
			$('.no_investagreement').click(function(){
				var contractHref ='/pdf/${investment.productUrl}/${investment.orderNumber}02.pdf';
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/user/checkContactPdf',
                    dataType:'json',
                    data:{
                        contactFile:contractHref
                    },
                    success:function(json){
                        if(json.flag == 1){
                           $('.no_investagreement').attr('target','_blank');
                           window.location.href=globalUrl + contractHref;
                        }else{
                            alert('合同不存在');
                        }
                    }
                });
            });


            $('.investagreement').click(function(){
				var contractHref ='/pdf/${investment.productUrl}/${investment.orderNumber}02.pdf';
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/user/checkContactPdf',
                    dataType:'json',
                    data:{
                        contactFile:contractHref
                    },
                    success:function(json){
                        if(json.flag == 1){
                           $('.investagreement').attr('target','_blank');
                           window.location.href=globalUrl+contractHref;
                        }else{
                            alert('合同不存在');
                        }
                    }
                });
            });


            $('.pro_agreement').click(function(){
				var contractHref ='/pdf/${investment.productUrl}/${investment.orderNumber}01.pdf';
                $.ajax({
                    type:'post',
                    url:getContextPaths()+'/user/checkContactPdf',
                    dataType:'json',
                    data:{
                        contactFile:contractHref
                    },
                    success:function(json){
                        if(json.flag == 1){
                           $('.pro_agreement').attr('target','_blank');
                           window.location.href=globalUrl + contractHref;
                        }else{
                            alert('合同不存在');
                        }
                    }
                });
            });
            
            
            
            
            //var contractHref =globalUrl + '/fyh/pdf/${investment.productUrl}/${investment.orderNumber}02.pdf';
			//$('.real_ind_btn').attr('conhref',contractHref);
			


			// cWindowFunction01('您尚未进行风险测评','为了全面了解您的风险承受能力，科学地投资。','立即测评','/enterRiskEvaluation');
       });


		// 为了获取本页面的url
		// function hrefFunction(obj){
			// 需要带过去的合同url
			
		// 	var ivt_id=$('.indetail_name').attr('investId');
		// 	var urls = getContextPaths()+'/enterInvestWindow?id='+ivt_id;
		// 	$(obj).attr('href',urls).attr('conhref',contractHref);
		// }

	

	</script>
	
</body>
</html>










