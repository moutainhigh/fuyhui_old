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
    <div class="website-smacen">
    <p class="p-tit" style="text-align:center;">富元汇互联网金融服务平台正式上线公告 <label class="fr back" onclick="window.history.go(-1);" style="cursor:pointer;">返回></label></p>
  <!--   <p class="p-time">
    2017-03-23
    </p> -->
    <div class="desc-1" style="text-indent:0;margin-top: 30px;">
    尊敬的用户：
    </div>
    <div class="desc-1" style="text-indent:2em;margin-top: 30px;">
        世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台富元汇于2017年6月5日正式上线，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。
    </div>
    <div class="desc-1" style="text-indent:2em;margin-top: 30px;">
        富元汇平台上线初期将推出“金猪系列”、“金桔系列”等多种金融产品，预期产品期限为1-6个月，预期年化收益为6%-10%，且有相应的增信措施以保障用户的资金安全。未来还将为用户提供包括保险和基金等多元化的金融产品互联网交易信息技术服务。         
    </div>
    <div class="desc-1" style="text-indent:2em;margin-top: 30px;">
        团队成员均有深厚的金融和互联网技术背景，曾在银行、担保、小贷、科技和互联网金融等多领域任职，拥有丰富的行业经验。利用先进的互联网技术和严谨的风控机制，为防范信用风险，保障交易安全性方面达到更高的标准，致力打造一个透明、安全的互联网金融服务平台。
    </div>
    <div class="desc-1" style="text-indent:2em;margin-top: 30px;">
        感谢各位用户对富元汇的支持与厚爱，我们将竭诚为您服务。
    </div>
    <div style="text-align:right;margin-top:60px; ">富元汇团队</div>
    <div style="text-align:right;">2017年6月5日</div>

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







