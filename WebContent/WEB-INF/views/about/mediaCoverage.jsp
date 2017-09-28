    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <!DOCTYPE html>
        <html lang="en">
        <head lang="zh-cn">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>媒体介绍-关于我们-富元汇</title>
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
        <%--媒体介绍的开始--%>
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
        <li class="click-li" style="border-left: 2px solid #00BBFF;">
        <a class="hover-A" href="${pageContext.request.contextPath }/enterMediaCoverage">
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
        媒体报道
        </p>
        <div class="concen concenA" style="margin-top:-30px;height:680px !important;">
        <div class="media-sma">
        <!-- <div class="media-con" onclick="window.location.href=getContextPaths()+'/enterMediaCovedetail?id=1'">
            <div class="img-con fl">
                <img src="${pageContext.request.contextPath }/static/images/aboutUs/Newsphoto1.png">
            </div>
            <div class="media-desc">
                <p>
                    我来贷联合富士康进军蓝领普惠金融 挑战千亿规模
                    <label class="fr">2017-06-05</label>
                </p>
                <p class="col-font">
                    在传统金融体系中，蓝领群体因普遍缺乏传统信用记录而难以享受服务，这即将得以改变。
                </p>
            </div>
        </div> -->
        <div class="media-con" onclick="window.location.href=getContextPaths()+'/enterMediaCovedetail?id=2'">
            <div class="img-con fl">
                <img src="${pageContext.request.contextPath }/static/images/aboutUs/Newsphoto2.png">
            </div>
            <div class="media-desc">
                <p>
                    富士康旗下互联网金融服务平台富元汇正式上线
                    <label class="fr">2017-06-05</label>
                </p>
                <p class="col-font" style="text-align:justify;">
                    世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台富元汇(http://www.fuyhui.com/)于2017年6月正式上线，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。
                </p>
            </div>
        </div>
        
        
        
        
        
        </div>
        </div>
        </div>
        </div>
        </div>


        <%--媒体介绍的结束--%>
        <!-- 公共底部Start -->
        <%@ include file="../layouts/footer.jsp"%>
        </body>
        </html>







