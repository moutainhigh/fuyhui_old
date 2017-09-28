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
    <style>
        /*邀请奖励表格*/
        .invite_role_h1{
            font-size: 16px;
            margin-bottom: 10px;
            color: #2a2a2a !important;
        }
        .invite_table
        {
            margin:0 auto;
            width: 350px;
            font-size: 16px;
        }
        .inv_tab01
        {
            width: 174.5px;
            height: 33.5px;
            line-height: 33.5px;
            text-align: center;
            margin-right: 1px;
            color: #fff;
            background: #95cfff;
        }
        .inv_tab02
        {
            width: 174.5px;
            height: 33.5px;
            line-height: 33.5px;
            text-align: center;
            color: #fff;
            background: #95cfff;
        }
        .left_inv_tab
        {
            width: 173px;
            height: 32.5px;
            line-height: 32.5px;
            text-align: center;
            border:1px solid #76c1ff;
            border-top:none;
            color: #396ea2;
        }
        .right_inv_tab
        {
            width: 174px;
            height: 32.5px;
            line-height: 32.5px;
            text-align: center;
            border-right: 1px solid #76c1ff;
            border-bottom:1px solid #76c1ff;
            color: #396ea2;
        }
        .det04_title
        {
            font-size: 18px;
            font-weight: bold;
            color: #323232;
            margin-top: 30px !important;
            text-indent: 0 !important;
        }
        .det04_txt_box p
        {
            font-size: 16px;
            color: #323232;
            line-height: 25px;
            text-indent: 33px;
        }
        .det04_last
        {
            margin-top: 30px;
            text-indent: 33px;
        }
    </style>
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
    <div class="concen concenA" style="margin-top:-30px;height:650px !important;">
    <div class="website-smacen">
    <p class="p-tit" style="text-align:center;">系统升级&产品暂停发布公告 <label class="fr back" onclick="window.history.go(-1);" style="cursor:pointer;">返回></label></p>
     <div class="desc-1 det04_title">
        尊敬的用户：
    </div>
    <div class="det04_txt_box">
        <p>     您好！为了给用户提供更好的投资体验，富元汇将对系统进行升级，升级期间将暂停发布新产品，但您仍可进行浏览、充值和提现等操作。</p>
        <p>
             我们将尽快完成系统升级，并为您提供优质产品，您可通过富元汇官网的网站公告和微信公众号进行关注。
        </p>
    </div>
    <div style="text-align:right;margin-top:60px;">富元汇团队</div>
    <div style="text-align:right;">2017年7月17日</div>

 <!--    <div style="text-align:right;margin-top:60px;">富元汇团队</div>
    <div style="text-align:right;">2017年6月23日</div> -->

    <!-- 分页start -->
    <!-- <div class="page-cen">
        <span class="prev page-btn">
            下一篇
        </span>
        <span class="next page-btn">
            上一篇
        </span>
    </div> -->
    <!-- 分页end -->

    </div>
    </div>
    </div>
    </div>
</div>

<%--网站公告的结束--%>
<!-- 公共底部Start -->
<%@ include file="../layouts/footer.jsp"%>
</body>
</html>







