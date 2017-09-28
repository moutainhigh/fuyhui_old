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
    <title>金桔系列-账户中心-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/index.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/userAccount/financialcenter.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/userAccount/mycreditor.js'></script>
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
				<div class="acc_rigContent_name" style="height:24px;text-indent:-9999px;">申请中的</div>
				<!-- 内容盒子Start -->
				<div class="acc_rigBotContent_box">
					<div class="tab_nav_box">
						<div class="fl aply_liubiao_nav aNav active">回款中</div>
						<div class="fl aply_invet_nav aNav">认购中</div>
						<div class="fl aply_repay_nav aNav">已结束</div>
						<div class="clear"></div>
					</div>
					<div class="comtab">
						<!-- 申请中Start -->
						<div class="apy_invest_during" apid =${sessionScope.user_inf.userId} style="display:none;">
							<div class="table_title">
								<div class="fl apy_borrow_title">产品名称</div>
								<div class="fl apy_invest_title">认购金额</div>
								<div class="fl apy_year_title">预期年化收益</div>
								<div class="fl apy_qishu_title">预期产品期限</div>
								<!-- <div class="fl apy_interest_title">预计利息</div> -->
								<div class="fl apy_investDate_title">认购日期</div>
								<div class="fl apy_project_title">认购进度</div>
								<div class="clear"></div>
							</div>
							
							<!-- 内容体 -->
							<div class="tab_tr_box touzizhong">
								<!-- <div class="each_tab_tr">
									<p class="apy_number">JJS20170306001</p>
									<p class="apy_investAmount">4000元</p>
									<p class="apy_yearRate">10%</p>
									<p class="apy_qishu">171天</p>
									<p class="apy_investTime">2017-03-06 11:47:15</p>
									<p class="apy_proProgress">100%</p>
									<div class="clear"></div>
								</div> -->
							</div>
							<!-- 分页Start -->
							<div class="page_box page_box01">
								<ul id="apyduring" class="mycredit"></ul>
							</div>
							<!-- 分页End -->
						</div>
						<!-- 申请中End -->


						<!-- 还款中Start -->
						<div class="apy_liu_biao">
							<div class="table_title repayUId" apid =${sessionScope.user_inf.userId}>
								<div class="fl cre_num_title" style="padding-left:0">产品名称</div>
								<div class="fl cre_invest_title com_cre" style="padding-left:0">认购金额</div>
								<div class="fl cre_dai_title com_cre" style="padding-left:0">待收金额</div>
								<div class="fl cre_qishu_title com_cre" style="padding-left:0">已回/总期数</div>
								<div class="fl cre_reimbu_title com_cre" style="padding-left:0">下个回款日</div>
								<div class="fl cre_oper_title com_cre" style="padding-left:0">操作</div>
								<div class="clear"></div>
							</div>

							<div class="tab_tr_box repay_durBox">
								<!-- <div class="each_tab_tr">
									<p class="credit_number">JJS20170303007004</p>
									<p class="cre_investAmount">20000元</p>
									<p class="cre_rate">20018.33元</p>
									<p class="cre_qishu">0/1</p>
									<p class="cre_reimbuDate">2017-03-17 </p>
									<p class="cre_contract" style="cursor:pointer"><a style="color:#474e5d" target="_blank" href="http://10.128.199.233/fyh/pdf/20170306/JJS201703030071000000113.pdf">查看合同</a></p>
									<div class="clear"></div>
								</div> -->
								
							</div>

							<!-- 分页Start -->
							<div class="page_box page_box02">
								<ul id="invt_pages" class="invt_pages"></ul>
							</div>
							<!-- 分页End -->
						</div>
						<!-- 还款中End -->


						<!-- 已还款Start -->
						<div class="real_pay" style="display:none;">
							<div class="table_title realReyUid" apid =${sessionScope.user_inf.userId}>
								<div class="fl cre_num_title" style="padding-left:0;width:195px;">产品名称</div>
								<div class="fl cre_invest_title com_cre" style="padding-left:0;width:195px;">认购金额</div>
								<div class="fl cre_dai_title com_cre" style="padding-left:0;width:195px;">待收金额</div>
								<div class="fl cre_qishu_title com_cre" style="padding-left:0;width:195px;">已回/总期数</div>
								<!-- <div class="fl cre_reimbu_title com_cre" style="padding-left:0">下个还款日</div> -->
								<div class="fl cre_oper_title com_cre" style="padding-left:0;width:195px;">操作</div>
								<div class="clear"></div>
							</div>

							<div class="tab_tr_box repay_cptBox">
								<!-- <div class="each_tab_tr">
									<p class="credit_number">JJS20170303007004</p>
									<p class="cre_investAmount">20000元</p>
									<p class="cre_rate">20018.33元</p>
									<p class="cre_qishu">0/1</p>
									<p class="cre_reimbuDate">2017-03-17 </p>
									<p class="cre_contract" style="cursor:pointer"><a style="color:#474e5d" target="_blank" href="http://10.128.199.233/fyh/pdf/20170306/JJS201703030071000000113.pdf">查看合同</a></p>
									<div class="clear"></div>
								</div>

								<div class="each_tab_tr">
									<p class="credit_number">JJS20170303007004</p>
									<p class="cre_investAmount">20000元</p>
									<p class="cre_rate">20018.33元</p>
									<p class="cre_qishu">0/1</p>
									<p class="cre_reimbuDate">2017-03-17 </p>
									<p class="cre_contract" style="cursor:pointer"><a style="color:#474e5d" target="_blank" href="http://10.128.199.233/fyh/pdf/20170306/JJS201703030071000000113.pdf">查看合同</a></p>
									<div class="clear"></div>
								</div> -->
								
							</div>

							<!-- 分页Start -->
							<div class="page_box page_box03">
								<ul id="repay_during" class="repay_during"></ul>
							</div>
							<!-- 分页End -->
						</div>
						<!-- 已还款End -->

						
					</div>	
					
				</div>
				<!-- 内容盒子End -->
			</div>
			<!-- 右边账户中心内容区域End -->
			<div class="clear"></div>
		</div>


		
	</div>
		
	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>



