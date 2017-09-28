    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <!DOCTYPE html>
        <html lang="en">
        <head lang="zh-cn">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>平台介绍-关于我们-富元汇</title>
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
        <style type="text/css">
            .intro_img
            {
                width: 340px;
                height: 38px;
                margin: 0 auto 100px auto;
                background: url(../../static/images/aboutUs/intro_img01.png) no-repeat center;
            }
            .intro-con
            {
                font-size: 14px;
                color: #666;
                margin-top: 0 !important;
            }
            .intro_img02
            {
                width: 422px;
                height: 50px;
                margin: 35px auto 35px auto;
                background: url(../../static/images/aboutUs/intro_img02.png) no-repeat center;
            }
            .concen
            {
                height: 1087px !important;
            }
            .comp-img
            {
                width: 978px !important;
                height: 366px !important;
                background: url(../../static/images/aboutUs/intro_img03.jpg) no-repeat center;
                margin-left: -64px;
                border:none !important;
            }
            .aboutUs .containerA
            {
                margin: 38px auto 38px !important;
            }

        </style>
        </head>
        <body class="pro-bg">
        <!-- 公共头部Start -->
        <%@ include file="../layouts/header.jsp"%>
        <!--公司介绍的开始-->
        <div class="content aboutUs">
        <div class="containerA">
        <div class="left-con">
        <p>关于我们
        </p>
        <ul class="about-ul">
        <li class="click-li" style="border-left: 2px solid #00BBFF;">
        <a class="hover-A" href="${pageContext.request.contextPath }/enterCompanyIntroduction">
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
        平台介绍
        </p>
        <div class="concen" style="margin-top:-30px !important;">
        <div class="sma-cen">
            <div class="intro_img"></div>
            
            <!-- <span class="bor-tiao">
            </span>
            <p style="margin-bottom:6px;font-size:14px;">
                富金富金融
            </p> -->
            <p class="intro-con">
                富元汇是由世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，注册资本人民币一亿元，实缴资本5000万元人民币，2017年在中国深圳正式启动运营。
            </p>
            <div class="intro_img02"></div>
            <p class="intro-con">
                富士康科技集团连续十余年跻身《财富》全球500强，2016年更是取得世界排名第25位这一傲人佳绩。在“长期、稳定、发展、科技、国际”的经营理念下，多年来致力于服务世界顶尖科技品牌。凭借前瞻决策、扎根科技和专业制造，富士康迅速发展壮大，全球拥有百余万员工，是全球最大的电子产业科技制造服务商。2015年，富士康探索布局互联网金融领域，积极转型投入商贸科技金融服务业，在以融助商的战略布局上，将积极发展互联网金融业务以助力经济发展。
            </p>
            <p class="intro-con" style="margin-top:30px !important;">
                富元汇作为富士康集团旗下综合金融服务平台，专注于互联网大数据分析和金融科技研发，为用户提供优质的金融资产交易所挂牌资产、保险和基金等金融产品信息技术服务，实现财富增值。携手行业内具备多年资产管理服务和风险控制经验人才，保障用户投资安全，致力于打造个性多元、稳健高效的互联网金融服务平台。
            </p>
            <div class="comp-img">

            </div>
            
        </div>
        </div>
        </div>
        </div>
        </div>
        <!--公司介绍的结束-->
        <!-- 公共底部Start -->
        <%@ include file="../layouts/footer.jsp"%>
        </body>
        </html>







