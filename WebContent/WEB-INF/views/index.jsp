<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html lang="en">
<head lang="zh-cn">
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>富元汇官网-富士康科技集团旗下互联网金融服务平台</title>
    <meta name="author" content="深圳市富之富信息技术有限公司"/>
    <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
    <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
	<!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->
 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/site/index.css">
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/site/jquery.flexslider-min.js"></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
    <script src="${pageContext.request.contextPath }/static/scripts/site/site.js"></script>
    <script>
		//百度统计
		//	為了更好地統計我司富金富官網的流量數據，煩請幫忙添加百度監測代碼，以方便後期統計pv、uv二次跳轉等多方面數據，具體如下
		//	百度統計地址：http://tongji.baidu.com/
		//	基礎監測代碼：
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?17dc2518cd5f660a0bdaef25654a3f8e";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</head>
<body>
	<!-- 头部Start -->
	<%@ include file="layouts/header.jsp"%>

	<!-- 头部End -->
	<!-- 轮播器Start -->
	<div class="pics_wrap" id="site_slide">
      <div class="site_slide_box flexslider">
        <ul class="slides">
        <!-- <li style="background:url(${pageContext.request.contextPath }/static/images/activities/banner.png) no-repeat center" onclick="window.location.href=getContextPaths()+'/enterCelebrate'"></li> -->
        <!-- <li style="background:url(${pageContext.request.contextPath }/static/images/site/sote03.png) no-repeat center" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=1'"></li> -->
		<li style="background:url(${pageContext.request.contextPath }/static/images/site/raise.png) no-repeat center" onclick="window.location.href=getContextPaths()+'/enterRaiseInterest'"></li>
          <li style="background:url(${pageContext.request.contextPath }/static/images/site/newWelfare.jpg) no-repeat center" onclick="window.location.href=getContextPaths()+'/enterNewWelfare'"></li>
          <li style="background:url(${pageContext.request.contextPath }/static/images/site/contacts.jpg) no-repeat center" onclick="window.location.href=getContextPaths()+'/enterContacts'"></li>
          <!-- <li style="background:url(${pageContext.request.contextPath }/static/images/site/jinju.jpg) no-repeat center" onclick="window.location.href=getContextPaths()+'/enterKumquatList'"></li> -->
        </ul>
      </div>
		<!-- 快捷注册按钮 -->
		<!-- <div class="site_register_box">
			<div class="site_register" onclick="window.location.href='/user/register'">立即注册</div>
		</div> -->

    </div>
	<!-- 轮播器End -->

	<!-- 员工专享区Start -->
	<!-- <div class="shared_area">
		<div class="shared_area_box">
		  <div class="left_btn" id="left_btn"></div>
	      <div class="share_list">
	          <div class="share_left">
		          <p class="share_item_img"><img src="${pageContext.request.contextPath }/static/images/site/left_img02.png" alt="左边图片"></p>
		          <p class="recommend">新手推荐</p>
		          <h2>富元汇集团专享月月发</h2>
		          <div class="share_money_box">
	          		<span>筹款金<span class='share_money'>20</span>万</span>
	          		<span>&nbsp;/&nbsp;</span>
	          		<span>起投金额<span class='share_money'>100</span>元</span>
	          	  </div>
		          <div class="shared_content_box"> -->
		          	<!-- <div class="least_earnings">预计最低收益（元）</div>
			        <div class="least_number">1000.00</div> -->
			        <!-- <div class="rate_box">
			            <div class="fl rate_box_left">
			             	<span>年化收益率</span>
			             	<div class="com_font">15.00%</div>
			            </div>
			            <div class="fr rate_box_right">
			            	<span>投资期限</span>
			            	<div class="com_font">180天</div>
			            </div>
			            <div class="clear"></div>
			        </div>
		          </div>
		          <div class="share_btn">立即购买</div>
	          </div>
	          <div class="share_middle">
	          	<p class="share_item_img"><img src="${pageContext.request.contextPath }/static/images/site/middle_img02.png" alt="中间图片"></p>
	          	<p class="recommend">新手推荐</p>
	          	<h2>富元汇集团专享月月发</h2>
	          	<div class="share_money_box">
	          		<span>筹款金<span class='share_money'>20</span>万</span>
	          		<span>&nbsp;/&nbsp;</span>
	          		<span>起投金额<span class='share_money'>100</span>元</span>
	          	</div>
	          	<div class="shared_content_box"> -->
		          	<!-- <div class="least_earnings">预计最低收益（元）</div>
		          	<div class="least_number">1000.00</div> -->
		          <!-- 	<div class="rate_box">
			            <div class="fl rate_box_left">
			             	<span>年化收益率</span>
			             	<div class="com_font">15.00%</div>
			            </div>
			            <div class="fr rate_box_right">
			            	<span>投资期限</span>
			            	<div class="com_font">180天</div>
			            </div>
			            <div class="clear"></div>
			          </div>
		        </div>
		        <div class="share_btn">立即购买</div>
	          </div>
	          <div class="share_right">
	          	<p class="share_item_img"><img src="${pageContext.request.contextPath }/static/images/site/right_img02.png" alt="右边图片"></p>
	          	<p class="recommend">新手推荐</p>
	          	<h2>富元汇集团专享月月发</h2>
	          	<div class="share_money_box">
	          		<span>筹款金<span class='share_money'>20</span>万</span>
	          		<span>&nbsp;/&nbsp;</span>
	          		<span>起投金额<span class='share_money'>100</span>元</span>
	          	</div>
	          	<div class="shared_content_box"> -->
		          	<!-- <div class="least_earnings">预计最低收益（元）</div>
		          	<div class="least_number">1000.00</div> -->
		          	<!-- <div class="rate_box">
			            <div class="fl rate_box_left">
			             	<span>年化收益率</span>
			             	<div class="com_font">15.00%</div>
			            </div>
			            <div class="fr rate_box_right">
			            	<span>投资期限</span>
			            	<div class="com_font">180天</div>
			            </div>
			            <div class="clear"></div>
			          </div>
		        </div>
		        <div class="share_btn">立即购买</div>
	          </div>
	      </div>
          <div class="right_btn" id="right_btn"></div>
		</div>
	</div> -->
	<!-- 员工专享区End -->

	<!-- 平台数据显示Start -->
	<!-- <div class="plat_data_area">
		<div class="plat_data_box">
			<ul class="plat_data_list">
				<li class="com_data_item plat_total_invest">
					<div>1,203,005<span>元</span></div>
					<p>平台累计总投资额</p>
				</li>
				<li class="data_bg"></li>
				<li class="com_data_item user_rate">
					<div>203,005<span>元</span></div>
					<p>用户收益总金额</p>
				</li>
				<li class="data_bg"></li>
				<li class="com_data_item register_total_user">
					<div>100,000<span>人</span></div>
					<p>注册用户总数</p>
				</li>
				<li class="data_bg"></li>
				<li class="com_data_item plat_days">
					<div>200<span>天</span></div>
					<p>平台运行</p>
				</li>
				<div class="clear"></div>
			</ul>
		</div>
	</div> -->
	<!-- 平台数据显示End -->


	<!-- 平台介绍区Start -->
	<div class="plat_increBox">
		<div class="plat_1170">
			<ul class="plat_list">
				<li class="plat_item01">
					<div class="pt_img01 fl"></div>
					<div class="fl">
						<p class="pt_title">品牌实力</p>
						<p class="pt-txt">世界百强企业金融品牌</p>
					</div>
					<div class="clear"></div>
				</li>
				<li class="plat_item02"></li>
				<li class="plat_item03">
					<div class="pt_img02 fl"></div>
					<div class="fl">
						<p class="pt_title">资金安全</p>
						<p class="pt-txt">第三方资金托管</p>
					</div>
					<div class="clear"></div>
				</li>
				<li class="plat_item04"></li>
				<li class="plat_item05">
					<div class="pt_img03 fl"></div>
					<div class="fl">
						<p class="pt_title">财富增值</p>
						<p class="pt-txt">稳健收益 投资增值</p>
					</div>
					<div class="clear"></div>
				</li>
			</ul>
			<div class="clear"></div>
		</div>
	</div>

	<!-- 平台介绍区End -->




	<!-- 产品专区Start -->
	<div class="site_product_area">
		<div class="product_box">
			<h3>产品专区</h3>
			<!-- 金猪系列产品Start -->
			<div class="top_product_box">
				<div class="fl pro_top_ltImg" onclick="window.location.href=getContextPaths()+'/enterInvest'">
					<!-- <img src="${pageContext.request.contextPath }/static/images/site/dingqi_final.png" alt="智能理财" width="159px" height="168px"> -->
					<div class="pro_lt_txt">温馨提示</div>
					<div class="pro_lt_btm">请根据您的理财规划及<br>风险承受能力选择产品</div>
				</div>
				<ul class="top_pro_list fl">
					<!-- <li class="top_item01">
						<img src="${pageContext.request.contextPath }/static/images/site/top_pro.png" alt="智能理财">
						<div>
							1年起投，零手续费<br>
							2年后无退保手续费<br>
							2年后无退保手续费
						</div>
						<p>年化收益约&nbsp;&nbsp;&nbsp;<span>10.30%</span></p>
						<a href="javascript:void(0);">查看更多&gt;</a>
					</li> -->
					
				</ul>
				<div class="clear"></div>
			</div>
			<!-- 金猪系列产品end -->


			<!-- 金桔系列产品Start -->
			<div class="bot_product_box">
				<div class="fl pro_bot_ltImg" onclick="window.location.href=getContextPaths()+'/enterKumquatList'">
					<!-- <img src="${pageContext.request.contextPath }/static/images/site/dingqi_final.png" alt="智能理财" width="159px" height="168px"> -->
					<div class="pro_lt_txt">温馨提示</div>
					<div class="pro_lt_btm">请根据您的理财规划及<br>风险承受能力选择产品</div>
				</div>
				<ul class="bot_pro_list fl">
					<!-- <li class="top_item01">
						<img src="${pageContext.request.contextPath }/static/images/site/top_pro.png" alt="智能理财">
						<div>
							1年起投，零手续费<br>
							2年后无退保手续费<br>
							2年后无退保手续费
						</div>
						<p>年化收益约&nbsp;&nbsp;&nbsp;<span>10.30%</span></p>
						<a href="javascript:void(0);">查看更多&gt;</a>
					</li> -->
					
				</ul>
				<div class="clear"></div>
			</div>

			<!-- 金桔系列产品End -->




			
		</div>
	</div>
	<!-- 产品专区End -->

	<!-- 申请借款流程Start -->
	<!-- <div class="borrow_process_area">
		<div class="borrow_process_box">
			<h2>投资步骤</h2>
			<p class="borrow_txt_line"></p>
			<ul class="borrow_process_list">
				
				<li class="borrow_pro_item01">
					<img class='pro_item_img01' src="${pageContext.request.contextPath }/static/images/site/invt_setp01.png" alt="免费注册" width="196" height="54">
				</li>
				<li class="borrow_pro_item02">
					<img class='pro_item_img01' src="${pageContext.request.contextPath }/static/images/site/invt_setp02.png" alt="实名认证" width="200" height="54">
				</li>
				<li class="borrow_pro_item03">
					<img class='pro_item_img01' src="${pageContext.request.contextPath }/static/images/site/invt_setp03.png" alt="免费注册" width="201" height="54">
				</li>
				<li class="borrow_pro_item04">
					<img class='pro_item_img01' src="${pageContext.request.contextPath }/static/images/site/invt_setp04.png" alt="免费注册" width="200" height="54">
				</li>
				<li class="borrow_pro_item05">
					<img class='pro_item_img01' src="${pageContext.request.contextPath }/static/images/site/invt_setp05.png" alt="免费注册" width="199" height="54">
				</li>
			</ul>
			<div class="clear"></div>
			
		</div>
	</div> -->
	
	<!-- 申请借款流程Start -->
	<!-- <div class="borrow_bg_area">
		<div class="borrow_info_box">
			<ul class="borrow_info_list">
				<li class="info_item01">
					<img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/common_icon.png" alt="01">
					<div class="info_title">快速放款</div>
					<div class="info_txt">
						成为贷款人，<br>
						通过发行标进行贷款，<br>
						最快2小时可获得资金。
					</div>
				</li>
				<li class="borrow_info_line"></li>
				<li class="info_item02">
					<img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/common_icon.png" alt="01">
					<div class="info_title">灵活门槛</div>
					<div class="info_txt">
						成为贷款人，<br>
						通过发行标进行贷款，<br>
						最快2小时可获得资金。
					</div>
				</li>
				<li class="borrow_info_line"></li>
				<li class="info_item03">
					<img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/common_icon.png" alt="01">
					<div class="info_title">赚钱更轻松</div>
					<div class="info_txt">
						成为贷款人，<br>
						通过发行标进行贷款，<br>
						最快2小时可获得资金。
					</div>
				</li>
				<li class="borrow_info_line"></li>
				<li class="info_item04">
					<img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/common_icon.png" alt="01">
					<div class="info_title">安全有保障</div>
					<div class="info_txt">
						成为贷款人，<br>
						通过发行标进行贷款，<br>
						最快2小时可获得资金。
					</div>
				</li>
			</ul>
			<div class="clear"></div>
		</div>
	</div> -->
	<!-- 申请借款流程End -->

	<!-- 媒体报道Start -->
	<div class="media_reports_area">
		<div class="media_report_box">
			<div class="fl media_left_box">
				<div class="media_left_title">
					<h2 class="fl media_titles">媒体报道</h2>
					<a class='fr media_more' onclick="window.location.href=getContextPaths()+'/enterMediaCoverage'">更多</a>
					<div class="clear"></div>
				</div>
				<div class="media_content_item">
					<div class="fl content_img01"></div>
					<div class="fr contents_box" onclick="window.location.href=getContextPaths()+'/enterMediaCovedetail?id=2'">
						<div class="media_title_content">
							<a href="javascript:void(0);" class="fl">富士康旗下互联网金融服务平台富元汇正式上线</a>
							<span class='fr media_left_time'>2017-06-05</span>
							<div class="clear"></div>
						</div>
						<div class="media_contents" style="text-align: justify;">
							<a href="javascript:void(0);">
								世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台富元汇(http://www.fuyhui.com/)于2017年6月正式上线，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。
							</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<!-- <div class="media_content_item">
					<div class="fl content_img02"></div>
					<div class="fr contents_box" onclick="window.location.href=getContextPaths()+'/enterMediaCovedetail?id=2'">
						<div class="media_title_content">
							<a href="javascript:void(0);" class="fl">正式跨足互联网金融 富士康借贷平台 富金富上线</a>
							<span class='fr media_left_time'>2017-03-23</span>
							<div class="clear"></div>
						</div>
						<div class="media_contents">
							<a href="javascript:void(0);">
								富士康在互联网金融的布局再传进展。中国经营报报导，富士康旗下锁定蓝领阶层的小额贷款平台「富金富」已经上线，目前先以富士康内部员工为主，待经营上轨道后，将全面对外开放。
							</a>
						</div>
					</div>
					<div class="clear"></div>
				</div> -->
				<!-- <div class="media_content_item">
					<div class="fl content_img03"></div>
					<div class="fr contents_box">
						<div class="media_title_content">
							<a href="javascript:void(0);" class="fl">【新浪网】富士康进军互联网金融！</a>
							<span class='fr media_left_time'>2016-8-29</span>
							<div class="clear"></div>
						</div>
						<div class="media_contents">
							<a href="javascript:void(0);">
								自不知庐山真面目，只缘身在此山中；要知投资真面目，必须从投资中跳出。自不知庐山真面目，只缘身在此山中；要知投资真面目，必须从投资中跳出。
							</a>
						</div>
					</div>
					<div class="clear"></div>
				</div> -->
			</div>
			<div class="fr media_right_box">
				<div class="media_right_title">
					<h2 class="fl media_titles">网站公告</h2>
					<a class='fr media_more' onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnouncement'">更多</a>
					<div class="clear"></div>
				</div>
				<div class="media_right_content">
					<div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=11'">
						<a href="javascript:void(0);" class="fl front" style='color:red'>富元汇2017年国庆节假日工作安排</a>
						<span class='fr' style='color:red'>2017-09-28</span>
						<div class="clear"></div>
					</div>
					<div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=10'">
						<a href="javascript:void(0);" class="fl front">金桔系列-优质小额债权资产上线公告</a>
						<span class='fr'>2017-08-16</span>
						<div class="clear"></div>
					</div>
					<div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=9'">
						<a href="javascript:void(0);" class="fl front">系统升级&产品暂停发布公告</a>
						<span class='fr'>2017-07-17</span>
						<div class="clear"></div>
					</div>
					<div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=8'">
						<a href="javascript:void(0);" class="fl front">金猪002号产品发布公告（更新）</a>
						<span class='fr'>2017-06-28</span>
						<div class="clear"></div>
					</div>
					<!-- <div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=7'">
						<a href="javascript:void(0);" class="fl front">金猪002号产品暂停发布公告</a>
						<span class='fr'>2017-06-27</span>
						<div class="clear"></div>
					</div> -->
					<!-- <div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=6'">
						<a href="javascript:void(0);" class="fl front">金猪002号产品发布公告</a>
						<span class='fr'>2017-06-23</span>
						<div class="clear"></div>
					</div> -->
					<div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=5'">
						<a href="javascript:void(0);" class="fl front">618破千万礼赞活动获奖名单公告</a>
						<span class='fr'>2017-06-21</span>
						<div class="clear"></div>
					</div>
					<!-- <div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=4'">
						<a href="javascript:void(0);" class="fl front">金猪001号产品发布公告</a>
						<span class='fr'>2017-06-05</span>
						<div class="clear"></div>
					</div> -->
					<!-- <div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=1'">
						<a href="javascript:void(0);" class="fl front">富元汇互联网金融服务平台正式上线</a>
						<span class='fr'>2017-06-05</span>
						<div class="clear"></div>
					</div> -->
					<!-- <div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=2'">
						<a href="javascript:void(0);" class="fl front">富元汇新手专享注册送红包</a>
						<span class='fr'>2017-06-05</span>
						<div class="clear"></div>
					</div> -->
					<!-- <div class="right_content_item" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=3'">
						<a href="javascript:void(0);" class="fl front">富元汇邀请好友拿现金奖励</a>
						<span class='fr'>2017-06-05</span>
						<div class="clear"></div>
					</div> -->
					<!-- <div class="right_content_item">
						<a href="javascript:void(0);" class="fl">彩票销售收入暴涨20倍秒杀BAT三大互联网巨头</a>
						<span class='fr'>2016-8-29</span>
						<div class="clear"></div>
					</div> -->
					<!-- <div class="right_content_item">
						<a href="javascript:void(0);" class="fl">个人认购大额存单门槛降至20万，吸引力不足</a>
						<span class='fr'>2016-8-29</span>
						<div class="clear"></div>
					</div> -->
					<!-- <div class="right_content_item">
						<a href="javascript:void(0);" class="fl">校园网贷风险多发 致一些学生背负巨额债务</a>
						<span class='fr'>2016-8-29</span>
						<div class="clear"></div>
					</div> -->
					<!-- <div class="right_content_item">
						<a href="javascript:void(0);" class="fl">北京首家民营银行预计年内获批</a>
						<span class='fr'>2016-8-29</span>
						<div class="clear"></div>
					</div> -->
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<!-- 媒体报道End -->

	<!-- 合作伙伴Start -->
	<div class="coperate_partner_area">
		<div class="coperate_partner_box">
			<p>合作伙伴</p>
			<div class="cooperate_img_list">
				<img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/fuyoujituan.png" alt="富友集团">
				<img class='borrow_info_img02' src="${pageContext.request.contextPath }/static/images/site/cper02.png" alt="青岛国富金融资产交易中心">
				<img class='borrow_info_img03' src="${pageContext.request.contextPath }/static/images/site/cper03.png" alt="广东银华律师事务所">
				<img class='borrow_info_img04' src="${pageContext.request.contextPath }/static/images/site/cper04.png" alt="贤方律师事务所">
				<!-- <img class='borrow_info_img05' src="${pageContext.request.contextPath }/static/images/site/cper05.png" alt="金融网站律师事务所"> -->
				<!-- <img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/ibm.png" alt="IBM">
				<img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/dell.png" alt="DELL">
				<img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/cisco.png" alt="CISCO">
				<img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/baidu.png" alt="百度">
				<img class='borrow_info_img01' src="${pageContext.request.contextPath }/static/images/site/alibaba.png" alt="阿里巴巴" style='margin-right:5px;margin-right:3px \9'> -->
			</div>
		</div>
	</div>
	<!-- 合作伙伴End -->


	<!-- 底部Start -->
	<%@ include file="layouts/footer.jsp"%>
</body>
<!-- JS区域 -->
<script type="text/javascript">
$(function(){
		// 轮播器调用
		$('.flexslider').flexslider({
	      directionNav: true,
	      pauseOnAction: false,
	      slideshowSpeed: 5000
    	});
    	$('.share_list').children().eq(0).append('<div id="share_fade"></div>');
    	$('.share_list').children().eq(2).append('<div id="share_fade"></div>');
    	$('.share_list').children().eq(1).find('.share_money_box').show();
		$('.share_list').children().eq(1).css('background','url(${pageContext.request.contextPath }/static/images/site/middle_bg02.png)');
		$('.share_list').children().eq(1).css({
			'z-index': 12,
		    'opacity':1,
		    'box-shadow':'none',
		    'left':'355px',
		    'top':'-187px',
		    'width':'400px',
		    'height':'827px',
		    'padding':'10px 20px 22px',
		    'border-bottom':'0px'
		});
		$('.share_list').children().eq(1).find('h2').css({
	        'margin':'15px 0',
	        'font-size':'32px'
   		});
	   $('.share_list').children().eq(1).find('.share_money_box').fadeIn(2500);
	   $('.share_list').children().eq(1).find('p img').css({
	        'width':'400px',
	        'height':'452px'
	   });
	   $('.share_list').children().eq(1).find('.rate_box').css({
	        'margin':'28px 0\0'
	   });
	   $('.share_list').children().eq(1).find('.rate_box').css({
	        'margin':'34px 0'
	   });
	   $('.share_list').children().eq(1).find('.com_font').css({
	        'font-size':'30px'
	   });
		// 当点击左边"员工新手专享"时触发
		$('.left_btn').click(function(){
            leftFunction();
        });
		// 当点击右边"员工新手专享"时触发
		$('.right_btn').click(function(){
            rightFunction();
        });

        $('.left_btn').hover(function(){
        	$('.share_list').children().eq(0).css('transform','translateY(-3px)');
        },function(){
        	$('.share_list').children().eq(0).css('transform','translateY(0)');
        });

        $('.right_btn').hover(function(){
        	$('.share_list').children().eq(2).css('transform','translateY(-3px)');
        },function(){
        	$('.share_list').children().eq(2).css('transform','translateY(0)');
        });


	});

// 第一种同步动画
function leftFunction(){
  $('.share_list').children().eq(0).css('z-index',12).css('opacity',1);
    $('.share_list').children().eq(1).find('.share_money_box').hide();
  $('.share_list').children().eq(1).css({
     'z-index':1
  });
  //$('.share_list').children().eq(0).append('<div id="share_fade"></div>');
  //$('.share_list').children().eq(2).append('<div id="share_fade"></div>');
  $('.share_list').children().eq(0).css('background','url(${pageContext.request.contextPath }/static/images/site/middle_bg02.png)');
  $('.share_list').children().eq(0).css('box-shadow','none');
  $('.share_list').children().eq(0).find('p img').css({
        'width':'400px',
        'height':'452px'
   });
   $('.share_list').children().eq(0).find('.rate_box').css({
        'margin':'28px 0\0'
   });
   $('.share_list').children().eq(0).find('.rate_box').css({
        'margin':'34px 0'
   });
   $('.share_list').children().eq(0).find('.com_font').css({
        'font-size':'30px'
   });
  $('.share_list').children().eq(0).animate({
      'left':355,
      'top':-187,
      'width':400,
      'height':827,
      'padding':'10px 20px 22px 20px',
      'border-bottom':0
  },500);
  $('.share_list').children().eq(0).find('#share_fade').remove();
  $('.share_list').children().eq(1).append('<div id="share_fade"></div>');
  $('.share_list').children().eq(0).find('h2').css({
        'margin':'15px 0',
        'font-size':'32px'
   });
  $('.share_list').children().eq(0).find('.share_money_box').fadeIn(2500);

  	$('.share_list').children().eq(1).animate({
  		'left':764,
        'top':-115,
        'background':0,
        'width':360,
        'height':608,
        'z-index':1,
        'padding':0
  	},600);
  	$('.share_list').children().eq(1).find('p img').css({
        'width':'360px',
        'height':'340px'
      });
      $('.share_list').children().eq(1).find('h2').css({
        'margin':'10px 0',
        'font-size':'28px'
      });
      $('.share_list').children().eq(1).find('.rate_box').css({
        'margin':'20px 0'
   	  });
	  $('.share_list').children().eq(1).find('.com_font').css({
	       'font-size':'24px'
	  });
      $('.share_list').children().eq(2).animate({
             'left':25,
       },700);

      $('.share_list').children().eq(1).css({
      	  	'background':'#fff',
      	  	'box-shadow':'0px 11px 40px -2px #bbb',
      	  	'border-bottom':'7px solid #dfa782'
      	  });
      $('.share_list').children().eq(0).before($('.share_list').children().eq(2));

}
function rightFunction(){
  $('.share_list').children().eq(2).css({
     "z-index":12,
     "opacity":1
  });
  $('.share_list').children().eq(1).css({
     'z-index':1
  });
  //$('.share_list').children().eq(0).append('<div id="share_fade"></div>');
  //$('.share_list').children().eq(2).append('<div id="share_fade"></div>');
  $('.share_list').children().eq(1).find('.share_money_box').hide();
  $('.share_list').children().eq(2).css('background','url(${pageContext.request.contextPath }/static/images/site/middle_bg02.png)');
  $('.share_list').children().eq(2).css('box-shadow','none');
  $('.share_list').children().eq(2).find('p img').css({
        'width':'400px',
        'height':'452px'
   });
   $('.share_list').children().eq(2).find('.rate_box').css({
        'margin':'28px 0\0'
   });
   $('.share_list').children().eq(2).find('.rate_box').css({
       'margin':'34px 0'
   });
   $('.share_list').children().eq(2).find('.com_font').css({
        'font-size':'30px'
   });
  $('.share_list').children().eq(2).animate({
      'left':355,
      'top':-187,
      'height':827,
      'width':400,
      'padding':'10px 20px 22px 20px',
      'border-bottom':0
  },500);
  $('.share_list').children().eq(2).find('h2').css({
        'margin':'15px 0',
        'font-size':'32px'
   });
  $('.share_list').children().eq(2).find('#share_fade').remove();
  $('.share_list').children().eq(1).append('<div id="share_fade"></div>');
  $('.share_list').children().eq(2).find('.share_money_box').fadeIn(2500);


	$('.share_list').children().eq(1).find('p img').css({
        'width':'360px',
        'height':'340px'
      });
      $('.share_list').children().eq(1).find('h2').css({
        'margin':'10px 0',
        'font-size':'28px'
      });
      $('.share_list').children().eq(1).find('.rate_box').css({
         'margin':'20px 0'
   	  });
   	  $('.share_list').children().eq(1).find('.com_font').css({
        'font-size':'24px'
   	  });
	$('.share_list').children().eq(1).animate({
		'left':25,
         'top':-115,
         'width':360,
         'height':608,
         'z-index':1,
         'padding':0,
         'background':0
	},600);

	$('.share_list').children().eq(0).animate({
		'left':764
	},700);
	$('.share_list').children().eq(1).css({
  	  	'background':'#fff',
  	  	'box-shadow':'0px 11px 40px -2px #bbb',
  	  	'border-bottom':'7px solid #dfa782'
    });
	$('.share_list').children().eq(0).before($('.share_list').children().eq(1));
    $('.share_list').children().eq(1).before($('.share_list').children().eq(2));

}
</script>
</html>
