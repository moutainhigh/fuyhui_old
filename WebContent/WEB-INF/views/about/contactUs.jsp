    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <!DOCTYPE html>
        <html lang="en">
        <head lang="zh-cn">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>联系我们-关于我们-富元汇</title>
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
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/about/map.js'></script>
        <script type="text/javascript" src="https://api.map.baidu.com/api?key=&v=1.1&services=true"></script>
        <style type="text/css">
            .code-con
            {
                width: 80px;
                height: 80px;
                background: url(../../static/images/footer/foot_wx_right.png) no-repeat center;
                margin: 90px auto 50px auto;
            }
        </style>
        </head>
        <body class="pro-bg">
        <!-- 公共头部Start -->
        <%@ include file="../layouts/header.jsp"%>
        <%--联系我们的开始--%>
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
        <li>
        <a href="${pageContext.request.contextPath }/enterWebsiteAnnouncement">
        网站公告
        </a>
        </li>
        <li>
        <a href="${pageContext.request.contextPath }/enterMediaCoverage">
        媒体报道
        </a>
        </li>
        <li class="click-li" style="border-left: 2px solid #00BBFF;">
        <a class="hover-A" href="${pageContext.request.contextPath }/enterContactUs">
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
        联系我们
        </p>
        <div class="concen concenA concenUs" style="margin-top:-30px;">
        <div class="conus-cen">
        <div class="bor-con">
        </div>
        <div class="con-desc">
        <p class="p-info">联系电话：4009 - 303 - 606</p>
        <p class="p-info">公共邮箱：service@fujfu.com</p>
        <p class="p-info">服务时间：每天 9:00 - 20:30</p>
        <p class="p-info">公司地址：深圳市龙华新区东环二路2号富士康集团C12栋5楼</p>
        </div>
        <div class="code-con"></div>
        </div>
        <div class="mapcon">
        <div class="map-on mapimg" id="dituContents">
        </div>
        <div class="map-off mapimg mapoffimg">
        </div>
        </div>
        </div>
        </div>
        </div>
        </div>




        <%--联系我们的结束--%>
        <!-- 公共底部Start -->
        <%@ include file="../layouts/footer.jsp"%>
        </body>
        </html>







