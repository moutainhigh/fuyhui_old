    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <!DOCTYPE html>
        <html lang="en">
        <head lang="zh-cn">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>网站公告-关于我们-富元汇</title>
        <meta name="author" content="深圳市富之富信息技术有限公司"/>
        <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
        <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
        <!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/about/aboutUs.css">
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
        <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/product/projecttrack.js'></script>
        </head>
        <body class="pro-bg">
        <!-- 公共头部Start -->
        <%@ include file="../layouts/header.jsp"%>
        <%--网站公告的开始--%>
        <div class="content aboutUs">
        <div class="containerA">
        <div class="left-con">
        <p>关于我们
        </p>
        <ul class="about-ul">
        <li>
        <a href="${pageContext.request.contextPath }/enterCompanyIntroduction">
        平台介绍
        </a>
        </li>
        <%--<li>--%>
        <%--<a  href="${pageContext.request.contextPath }/enterTeamIntroduction">--%>
        <%--团队介绍--%>
        <%--</a>--%>
        <%--</li>--%>
        <li class="click-li" style="border-left: 2px solid #00BBFF;">
        <a  class="hover-A" href="${pageContext.request.contextPath }/enterWebsiteAnnouncement">
        网站公告
        </a>
        </li>
        <li>
        <a href="${pageContext.request.contextPath }/enterMediaCoverage">
        媒体报道
        </a>
        </li>
        <li>
        <a href="${pageContext.request.contextPath }/enterContactUs">
        联系我们
        </a>
        </li>
        <%--<li>--%>
        <%--<a href="${pageContext.request.contextPath }/enterPerformanceReport">--%>
        <%--业绩报告--%>
        <%--</a>--%>
        <%--</li>--%>
        </ul>
        </div>
        <div class="right-con">
        <p style="text-indent:-9999px;">
        网站公告
        </p>
        <div class="concen concenA" style="margin-top:-30px;height:680px !important;">
        <ul class="site-ul">
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=11'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 富元汇2017年国庆节假日工作安排
        </label>
        <label class="time-annmou fr">
        2017-09-28
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=10'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 金桔系列-优质小额债权资产上线公告
        </label>
        <label class="time-annmou fr">
        2017-08-16
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=9'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 系统升级&产品暂停发布公告
        </label>
        <label class="time-annmou fr">
        2017-07-17
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=8'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 金猪002号产品发布公告（更新）
        </label>
        <label class="time-annmou fr">
        2017-06-28
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=7'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 金猪002号产品暂停发布公告
        </label>
        <label class="time-annmou fr">
        2017-06-27
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=6'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 金猪002号产品发布公告
        </label>
        <label class="time-annmou fr">
        2017-06-23
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=5'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 618破千万礼赞活动获奖名单公告
        </label>
        <label class="time-annmou fr">
        2017-06-21
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=4'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 金猪001号产品发布公告
        </label>
        <label class="time-annmou fr">
        2017-06-05
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=1'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 富元汇互联网金融服务平台正式上线公告
        </label>
        <label class="time-annmou fr">
        2017-06-05
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=2'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 富元汇新手专享注册送红包
        </label>
        <label class="time-annmou fr">
        2017-06-05
        </label>
        </li>
        <li class="webLI" onclick="window.location.href=getContextPaths()+'/enterWebsiteAnnoundetails?id=3'">
        <label class="tit-annmou fl">
        <span class="circle"></span> 富元汇邀请好友拿现金奖励
        </label>
        <label class="time-annmou fr">
        2017-06-05
        </label>
        </li> 
        </ul>
        </div>
        </div>
        </div>
        </div>

        <%--网站公告的结束--%>
        <!-- 公共底部Start -->
        <%@ include file="../layouts/footer.jsp"%>
        </body>
        </html>







