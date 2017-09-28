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
    <p class="p-tit" style="text-align:center;">富元汇新手专享注册送红包 <label class="fr back" onclick="window.history.go(-1);" style="cursor:pointer;">返回></label></p>
   <!--  <p class="p-time">
    2017-03-23
    </p> -->
    <div class="desc-1" style="text-indent:0;margin-top:30px;">
    亲爱的用户：
    </div>
    <div class="desc-1" style="margin-top:20px;">
    富元汇平台正式上线，新手专享福利抢先知。红包送不停，新手用户成功注册平台账户即可获得五个新手红包，累计最多可获得650元，红包可用于抵扣认购金额，认购金额越多，优惠越多。
    </div>
    <div class="desc-1" style="text-indent:0;margin-top:30px;">
    活动规则：
    </div>
    <p style="color:#323232;">1、新手注册成功后，即可获得28元、58元、88元、188元和288元5个新手红包。</p>
    <p style="margin-top:10px;color:#323232;">2、新手红包有效期为2个月，只能在有效期内使用，过期无效。</p>
    <p style="margin-top:10px;color:#323232;">3、新手红包不可单独投资、不可直接提现，只能在认购产品时用于抵扣。</p>
    <p style="margin-top:10px;color:#323232;">4、用户每次认购产品只能使用1个红包。</p>
    <p style="margin-top:10px;color:#323232;">5、每个新手红包只能抵扣1次，且需1次抵扣完。</p>
    <p style="margin-top:10px;color:#323232;">6、新手红包抵扣产品回款成功后，即可用于提现或者认购新的产品。</p>
    <div class="desc-1" style="text-indent:0;margin-top:30px;color:#323232;">
    本次活动最终解释权归富元汇所有，如有疑问请拨打客服热线：4009-303-606
    </div>
    <p style="margin-top:10px;color:#323232;">感谢您对富元汇的支持，我们将为您做到最好。</p>
    
    <div style="margin-top:60px;text-align:right;color:#323232;">富元汇团队</div>
    <div style="text-align:right;color:#323232;"> 2017年6月5日</div>
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







