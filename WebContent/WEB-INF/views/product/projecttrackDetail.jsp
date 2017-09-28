    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
        <!DOCTYPE html>
        <html lang="en">
        <head lang="zh-cn">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>富元汇项目追踪详情页面</title>
        <meta name="author" content="深圳市富之富信息技术有限公司"/>
        <meta name="keywords" content="富元汇，P2P理财，P2C理财，P2P网贷，投资理财，P2P投资理财，个人理财，金融理财，互联网理财，理财投资，供应链金融 ">
        <meta name="description" content="世界百强企业鸿海富士康科技集团旗下金融品牌富金富打造的互联网金融服务平台，致力于为用户提供稳健、诚信、高效的金融产品交易等互联网信息技术服务。">
        <!-- <meta name="renderer" content="webkit|ie-stand|ie-comp"> -->
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />  -->

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/common.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/header.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/common/footer.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/styles/product/projecttrack.css">
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
        <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/placeholder.js'></script>
        <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery.twbsPagination.js'></script>
        </head>
        <body class="pro-bg">
        <!-- 公共头部Start -->
        <%@ include file="../layouts/header.jsp"%>

        <%--项目追踪详情页面开始--%>
        <div class="content">
        <div class="container contain-produce">
        <div class="tit-nav">
        <label class="lab">
        富元汇借款项目历程
        </label>
        <input class="lab-in" placeholder="请输入项目代号">
        <span class="tit-btn">
        搜素
        </span>
        </div>
        <div class="head-title" style="">
        借款列表
        <div class="border-title" style=""></div>
        </div>
        <!--<div class="Loantab-head">-->
        <!--<div class="fl title">-->
        <!--项目名称-->
        <!--</div>-->
        <!--<div class="fl title">-->
        <!--项目代号-->
        <!--</div>-->
        <!--<div class="fl title">-->
        <!--募集名称-->
        <!--</div>-->
        <!--</div>-->
        <!--<div class="LoanPOJO-con">-->
        <table class="producttab LoanPOJO-tab">
        <tr class="tab-tr tab-head">
        <th class="">
        项目名称
        </th>
        <th>
        项目代号
        </th>
        <th>
        募集名称
        </th>
        </tr>
        <tr class="tab-tr">
        <td>
        富海公司设备采购01期
        </td>
        <td class="tab-code">
        1MDBU3EaT6Wc6E4rmNJJ9Q3yN41J6poZ4ta
        </td>
        <td>
        500万元
        </td>
        </tr>
        <tr class="tab-tr">
        <td>
        富海公司设备采购01期
        </td>
        <td class="tab-code">
        1MDBU3EaT6Wc6E4rmNJJ9Q3yN41J6poZ4ta
        </td>
        <td>
        500万元
        </td>
        </tr>
        </table>
        <!--</div>-->
        <div class="tab-border" style="">
        </div>
        <div class="head-title" style="">
        项目进程
        <div class="border-title" style=""></div>
        </div>
        <div class="flow-bg">
        <img src="image/flow4.png">
        <ul class="" style="">
        <li class="fl">
        发布时间<br>
        2016-8-9
        </li>
        <li class="fl">
        投资金额<br>
        500万元
        </li>
        <li class="fl">
        放款金额<br>
        500万元
        </li>
        <li class="fl">
        已还金额/期数：300万/4期<br>
        待还金额/期数：200万/2期
        </li>
        <li class="fl">
        结清时间<br>
        2016-8-9
        </li>
        <div style="clear: both;"></div>
        </ul>
        <div class="status-con">
        <label class="sta-img">
        <img src="image/fail.png">
        <span>失败状态</span>
        </label>
        <label class="sta-img">
        <img src="image/success.png">
        <span>成功状态</span>
        </label>
        <label class="sta-img">
        <img src="image/process.png">
        <span>进行状态</span>
        </label>
        </div>
        </div>
        <div class="tab-border" style="">
        </div>
        <div class="head-title" style="">
        投资列表
        <div class="border-title" style=""></div>
        </div>
        <table class="producttab invest-tab">
        <tr class="tab-tr tab-head">
        <th class="">
        投资人姓名代码
        </th>
        <th>
        投资金额
        </th>
        <th>
        投资交易码
        </th>
        </tr>
        <tr class="tab-tr">
        <td>
        9DASsewQEsdfsSQlsd8sD5
        </td>
        <td>
        500万元
        </td>
        <td class="tab-code">
        cdaf192546c4ebf527dbfe193b35956b90917d9980f53d6e5c8b656885da51d
        </td>
        </tr>
        <tr class="tab-tr">
        <td>
        9DASsewQEsdfsSQlsd8sD5
        </td>
        <td>
        500万元
        </td>
        <td class="tab-code">
        cdaf192546c4ebf527dbfe193b35956b90917d9980f53d6e5c8b656885da51d
        </td>
        </tr>
        <tr class="tab-tr">
        <td>
        9DASsewQEsdfsSQlsd8sD5
        </td>
        <td>
        500万元
        </td>
        <td class="tab-code">
        cdaf192546c4ebf527dbfe193b35956b90917d9980f53d6e5c8b656885da51d
        </td>
        </tr>
        <tr class="tab-tr">
        <td>
        9DASsewQEsdfsSQlsd8sD5
        </td>
        <td>
        500万元
        </td>
        <td class="tab-code">
        cdaf192546c4ebf527dbfe193b35956b90917d9980f53d6e5c8b656885da51d
        </td>
        </tr>
        </table>
        <div class="tab-border" style="">
        </div>
        <div class="head-title" style="">
        还款列表
        <div class="border-title" style=""></div>
        </div>

        <table class="producttab repayment-tab">
        <tr class="tab-tr tab-head">
        <th class="">
        退款日期
        </th>
        <th>
        退款金额
        </th>
        <th>
        退款交易码
        </th>
        <th>
        退款状态
        </th>
        </tr>
        <tr class="tab-tr">
        <td>
        9DASsewQEsdfsSQlsd8sD5
        </td>
        <td>
        500万元
        </td>
        <td class="tab-code">
        cdaf192546c4ebf527dbfe193b35956b90917d9980f53d6e5c8b656885da51d
        </td>
        <td>
        退款成功
        </td>
        </tr>
        <tr class="tab-tr">
        <td>
        9DASsewQEsdfsSQlsd8sD5
        </td>
        <td>
        500万元
        </td>
        <td class="tab-code">
        cdaf192546c4ebf527dbfe193b35956b90917d9980f53d6e5c8b656885da51d
        </td>
        <td>
        退款成功
        </td>
        </tr>
        <tr class="tab-tr">
        <td>
        9DASsewQEsdfsSQlsd8sD5
        </td>
        <td>
        500万元
        </td>
        <td class="tab-code">
        cdaf192546c4ebf527dbfe193b35956b90917d9980f53d6e5c8b656885da51d
        </td>
        <td>
        退款成功
        </td>
        </tr>
        <tr class="tab-tr">
        <td>
        9DASsewQEsdfsSQlsd8sD5
        </td>
        <td>
        500万元
        </td>
        <td class="tab-code">
        cdaf192546c4ebf527dbfe193b35956b90917d9980f53d6e5c8b656885da51d
        </td>
        <td>
        退款成功
        </td>
        </tr>
        </table>


        </div>
        </div>
        <%--项目追踪详情页面结束--%>




        <!-- 公共底部Start -->
        <%@ include file="../layouts/footer.jsp"%>
        </body>
        </html>



