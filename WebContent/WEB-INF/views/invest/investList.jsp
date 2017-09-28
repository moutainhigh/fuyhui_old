<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head lang="zh-cn">
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>金猪系列列表-富元汇</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/invest/invest.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
	<script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/invest/invest.js'></script>
</head>
<body>
	<!-- 公共头部Start -->
	<%@ include file="../layouts/header.jsp"%>
	
	
	<!-- 投资列表banner区域Start -->
	<div class="borrow_banner">
		<div class="borrow_banner_box">
			<div onclick="window.location.href=getContextPaths()+'/user/register'">马上注册</div>
		</div>
	</div>
	<!-- 投资列表banner区域End -->

	<!-- 标题tab切换Start -->
	<!-- <div class="borrow_tab">
		<div class="borrow_tab_box">
			<a href="javascript:void(0);" class="common_borrowBtn borrow_itemBtn active">投资列表</a>
			<a href="javascript:void(0);" class="common_borrowBtn dbborrow_itemBtn">债权转让</a>
		</div>
	</div> -->
	<!-- 标题tab切换End -->
	<div class="ivstTops">温馨提示：请根据您的理财规划及风险承受能力选择产品</div>

	<!-- 投资列表内容区域Start -->
	<div class="invest_area">
		<div class="invest_content_box">
			<!-- 投资列表Start -->
			<div class="invest_item_box">
				<!-- <div class="invest_titleNav">
					<ul class="invest_navList">
						<li class="invest_li"> -->
							<!-- <select class="invest_select" name="state">
					            <option value ="">全部产品</option>
					            
        					</select> -->
        				<!-- 	<div style="margin-left:-82px;">项目名称</div>
						</li>
						<li class="invest_li rateItem">
							<div class="year_rate" style="left:55px;">预期年化收益</div> -->
							<!-- <div class="year_rateUp"><span class='invest_upImg'></span></div>
							<div class="year_rateDown"><span class='invest_downImg'></span></div> -->
						<!-- </li> -->
						<!-- <li class="invest_li limitItem">
							<div class="borrow_limit">投资期限</div> -->
							<!-- <select class="borrowLimit_select" name="state">
					            <option value ="">借款期限</option>
					            <option value="1">0-3个月</option>
					            <option value="2">3-6个月</option>
					            <option value="3">6-12个月</option>
					            <option value="4">12-24个月</option>
					            <option value="5">24个月以上</option>
        					</select> -->
							<!-- <div class="borrow_limitUp"><span class='invest_upImg'></span></div>
							<div class="borrow_limitDown"><span class='invest_downImg'></span></div> -->
						<!-- </li>
						<li class="invest_li">
							<div style="margin-left:5px;"><span style='font-family:"宋体"'>募</span>集金额</div>
						</li>
						<li class="invest_li">
							<div>项目进度</div>
						</li>
						<li class="invest_li">
							<div>状态</div>
						</li>
					</ul>
					<div class="clear"></div>
				</div> -->

				<div class="invest_item_body">
					<!-- 每一条标的详细内容Start -->
					<!-- <div class="each_item_contents">
						<div class="fl invest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='borrow_litime_moutn'>3</span>个月</div>
						<div class="fl borrow_money com_invest"><span class='borrow_amoutn_num'>20.0</span>万</div>
						<div class="fl invest_progress"><div class="inveset_progress_num"></div></div>
						<div class="fl invest_opear"> -->
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<!-- <div class="invest_btn">立即投资</div>
						</div>
						<div class="clear"></div>
					</div> -->
					<!-- 每一条标的详细内容End -->

					<div class="each_item_contents">
						<div class="each_ivst_title">金桔-QJ-S201700301002</div>
						<div class="fl each_rates_box">
							<div class="each_rates">10.0%</div>
							<div class="each_txts">预期年化收益</div>
						</div>
						<div class="fl each_divs">
							<div class="each_num">365天</div>
							<div class="each_txts">产品期限</div>
						</div>
						<div class="fl each_divs">
							<div class="each_num">20000元</div>
							<div class="each_txts">产品规模</div>
						</div>
						<div class="fl each_divs">
							<div class="each_num">1000元</div>
							<div class="each_txts">认购起点</div>
						</div>
						<div class="fl invest_progress"><div class="inveset_progress_num"><div class="borrow_proNum">90.0%</div></div></div>
						<div class="fl invest_group_btns">
							<!-- 认购中 按钮样式：subscribe_btn，回款中 按钮样式：receivable_btn，已售罄 按钮样式和已结束 按钮样式：hasend_btn，
								，预热中 按钮样式：yuren_btn
							 -->
							 <div class="subscribe_btn">认购中</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>

				<!-- 分页Start -->
				<div class="invest_pages_box">
					<ul id="invest_page01" class="invest_page_ul"></ul>
				</div>
				<!-- 分页End -->

			</div>
			<!-- 投资列表End -->

			<!-- 债权转让Start -->
			<div class="dbborrow_item_box">
				<div class="invest_titleNav">
					<ul class="invest_navList">
						<li class="invest_li">
							<select class="invest_select" name="state">
					            <option value ="0">全部产品</option>
					            <option value ="1" >抵押标</option>
					            <option value ="2" >担保标</option>
        					</select>
						</li>
						<li class="invest_li rateItem">
							<div class="year_rate">年化利率</div>
							<div class="year_rateUp"><span class='invest_upImg'></span></div>
							<div class="year_rateDown"><span class='invest_downImg'></span></div>
						</li>
						<li class="invest_li limitItem">
							<div class="borrow_limit">转让价格</div>
							<div class="borrow_limitUp"><span class='invest_upImg'></span></div>
							<div class="borrow_limitDown"><span class='invest_downImg'></span></div>
						</li>
						<li class="invest_li">
							<div>剩余期限</div>
						</li>
						<li class="invest_li">
							<div>还款方式</div>
						</li>
						<li class="invest_li">
							<div>操作</div>
						</li>
					</ul>
					<div class="clear"></div>
				</div>


				<div class="dbinvest_item_body">
					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="no_dbinvest_btn">已售完</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">一次还本付息</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="no_dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="no_dbinvest_btn">已售完</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>30</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>30</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>2</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>3</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->

					<!-- 每一条标的详细内容Start -->
					<div class="each_item_contents">
						<div class="fl dbinvest_name">富元汇-汇添富理财</div>
						<div class="fl invest_rate com_invest">10.0%</div>
						<div class="fl borrow_limite com_invest"><span class='dbborrow_amoutn_num'>20</span>万</div>
						<div class="fl dbborrow_money com_invest"><span class='dbborrow_litime_moutn'>2</span>个月</div>
						<div class="fl dbinvest_progress"><div class="dbinvest_style">按月付息，到期还本</div></div>
						<div class="fl dbinvest_opear">
							<!-- 立即投资时的按钮样式是：.invest_btn ，还款中时的按钮样式是：.no_invest_btn-->
							<div class="dbinvest_btn">去购买</div>
						</div>
						<div class="clear"></div>
					</div>
					<!-- 每一条标的详细内容End -->
				</div>

				<!-- 分页Start -->
				<div class="invest_pages_box">
					<ul id="dbinvest_page" class="invest_page_ul"></ul>
				</div>
				<!-- 分页End -->


			</div>
			<!-- 债权转让End -->
		</div>
	</div>
	<!-- 投资列表内容区域End -->



	<!-- 公共底部Start -->
	<%@ include file="../layouts/footer.jsp"%>
</body>
</html>



