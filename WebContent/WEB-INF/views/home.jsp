<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="${pageContext.request.contextPath }/static/back/assets/css/dpl-min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/static/back/assets/css/bui-min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/static/back/assets/css/main-min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/bui-min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/common/main-min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/back/assets/js/config-min.js"></script>
</head>
<body>
	<c:if test="${param.msg ne null}">
		<script type="text/javascript">
			alert("${param.msg}");
		</script>
	</c:if>
	<div class="header">
		<div class="dl-title">
			<img
				src="${pageContext.request.contextPath }/static/back/assets/img/fujbao_logo.png">
		</div>
		<div class="dl-log">
			欢迎您，<span class="dl-log-user">${sessionScope.admin.username}！</span><a
				href="#" title="修改密码" class="dl-log-quit">[修改密码]</a>&nbsp;<a
				href="${pageContext.request.contextPath }/admin/loginOut"
				title="退出系统" class="dl-log-quit">[退出]</a>
		</div>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-user">用户管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-order">业务管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-cost">账务管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-monitor">运营管理</div></li>
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-permission">系统设置</div></li>
			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">

		</ul>
	</div>
	<script>
		BUI
				.use(
						'common/main',
						function() {
							var config = [
									{
										id : '1',
										menu : [
												{
													text : '<i class="icon-tag"></i>&nbsp;投资用户',
													items : [
															{
																id : '11',
																text : '注册信息',
																href : '${pageContext.request.contextPath }/user/index?target=P2P'
															},
															{
																id : '12',
																text : '资金情况',
																href : '${pageContext.request.contextPath }/backAccount/personal/index'
															},
															{
																id : '13',
																text : '投资记录',
																href : '${pageContext.request.contextPath }/admin/user/loanInvestList'
															},
															{
																id : '14',
																text : '港澳台用户审批',
																href : '${pageContext.request.contextPath }/gat/searchGatList?first=1'
															}															
															
															]
												},
												{
													text : '<i class="icon-leaf"></i>&nbsp;借款用户',
													items : [
															{
																id : '21',
																text : '企业用户',
																href : '${pageContext.request.contextPath }/admin/user/index?userType=2'
															},
															{
																id : '22',
																text : '资金情况',
																href : '${pageContext.request.contextPath }/backAccount/corporate/index'
															},
															{
																id : '23',
																text : '借款记录',
																href : '${pageContext.request.contextPath }/admin/user/loanDoApplyList'
															} ]
												},
												{
													text : '<i class="icon-fire"></i>&nbsp;担保机构',
													items : [
															{
																id : '31',
																text : '担保公司',
																href : '${pageContext.request.contextPath }/admin/user/index?userType=3'
															},
															{
																id : '32',
																text : '资金情况',
																href : '${pageContext.request.contextPath }/backAccount/institution/index'
															},
															{
																id : '33',
																text : '担保记录',
																href : '${pageContext.request.contextPath }/admin/user/loanDoGuarantee'
															} ]
												} ]
									},
									{
										id : '2',
										menu : [
												{
													text : '<i class="icon-tag"></i>&nbsp;项目审核',
													items : [
															{
																id : '11',
																text : '项目录入',
																href : '${pageContext.request.contextPath }/loan/loanApply/listDraftLoan'
															},
															{
																id : '12',
																text : '发标初审',
																href : '${pageContext.request.contextPath }/loan/loanApply/listFReview'
															},
															{
																id : '13',
																text : '发标终审',
																href : '${pageContext.request.contextPath }/loan/loanApply/listSReview'
															},
															{
																id : '14',
																text : '放款终审',
																href : '${pageContext.request.contextPath }/lender/fullLenderList'
															} ]
												},
												{
													text : '<i class="icon-fire"></i>&nbsp;合同管理',
													items : [
															{
																id : '21',
																text : '合同签署',
																href : '${pageContext.request.contextPath }/lender/signContractList'
															}, {
																id : '22',
																text : '合同查看',
																href : '#'
															} ]
												},
												{
													text : '<i class="icon-star"></i>&nbsp;还款管理',
													items : [
															{
																id : '31',
																text : '正常还款',
																href : '${pageContext.request.contextPath }/repay/advanceRepay'
															},
															{
																id : '32',
																text : '逾期还款',
																href : ''
															} ]
												},
												{
													text : '<i class="icon-leaf"></i>&nbsp;项目查询',
													items : [
															{
																id : '41',
																text : '项目详情',
																href : '${pageContext.request.contextPath }/loan/loanApply/findLoanByCondition'
															},{
																id : '42',
																text : '还款提醒',
																href : '${pageContext.request.contextPath }/repay/repaymentReminder'
															}]
												} ]
									},
									{
										id : '3',
										menu : [
												{
													text : '<i class="icon-tag"></i>&nbsp;投资人账单',
													items : [
															{
																id : '11',
																text : '提现记录',
																href : '${pageContext.request.contextPath }/admin/withdrawal/index'
															},
															{
																id : '12',
																text : '充值记录',
																href : '${pageContext.request.contextPath }/admin/recharge/index'
															},
															{
																id : '13',
																text : '投资记录',
																href : '${pageContext.request.contextPath }/admin/user/loanInvestList'
															},
															{
																id : '14',
																text : '回款记录',
																href : '${pageContext.request.contextPath }/admin/user/allApplyRecoverList'
															} ]
												},
												/* {
													text : '<i class="icon-leaf"></i>&nbsp;借款人账户',
													items : [
															{
																id : '21',
																text : '借款记录',
																href : '${pageContext.request.contextPath }/admin/user/loanDoApplyList'
															},
															{
																id : '22',
																text : '还款记录',
																href : '${pageContext.request.contextPath }/admin/user/allApplyRepayList'
															} ]
												},
												{
													text : '<i class="icon-fire"></i>&nbsp;平台账单',
													items : [
															{
																id : '31',
																text : '收益记录',
																href : '${pageContext.request.contextPath }/siteAccount/siteAccountIndex'
															}, {
																id : '32',
																text : '运营记录',
																href : '#'
															} ]
												}, */
												{
													text : '<i class="icon-fire"></i>&nbsp;对账管理',
													items : [
// 															{
// 																id : '51',
// 																text : '富友账单',
// 																href : '#'
// 															}, 
                                                            {
																id : '52',
																text : '平台账单',
																href : '${pageContext.request.contextPath }/backAccount/siteBillingList/index'
															} ]
												},
												{
													text : '<i class="icon-star"></i>&nbsp;担保机构',
													items : [ {
														id : '41',
														text : '垫付记录',
														href : '${pageContext.request.contextPath }/user/payfor'
													} ]
												} ]
									},
									{
										id : '4',
										menu : [
												{
													text : '<i class="icon-tag"></i>&nbsp;站点管理',
													items : [
															{
																id : '11',
																text : '首页焦点图',
																href : '${pageContext.request.contextPath }/focus/list'
															},
															{
																id : '12',
																text : '新闻类别',
																href : '${pageContext.request.contextPath }/newsCategory/index'
															},
															{
																id : '13',
																text : '新闻管理',
																href : '${pageContext.request.contextPath }/news/index'
															}, {
																id : '14',
																text : '短信推广',
																href : '#'
															}, {
																id : '15',
																text : '站内信',
																href : '#'
															} ]
												},
												{
													text : '<i class="icon-leaf"></i>&nbsp;运营活动',
													items : [
															{
																id : '21',
																text : '体验金管理',
																href : '#'
															},
															{
																id : '22',
																text : '红包活动管理',
																href : '${pageContext.request.contextPath }/award/awardTypeIndex'
															}
															,
															{
																id : '23',
																text : '红包领取明细',
																href : '${pageContext.request.contextPath }/award/findAwardAccountList'
															}		
															,
															{
																id : '23',
																text : '红包使用明细',
																href : '${pageContext.request.contextPath }/award/findAwardAccountLogList'
															}														
															
															]
												},
												{
													text : '<i class="icon-fire"></i>&nbsp;推荐邀请',
													items : [
															{
																id : '30',
																text : '推荐设置',
																href : '${pageContext.request.contextPath }/recommend/settingQuery'
															}	,													         
													         
															{
																id : '31',
																text : '推荐奖励汇总',
																href : '${pageContext.request.contextPath }/recommend/recommendRewardList'
															},{
																id : '32',
																text : '被推荐用户',
																href : '${pageContext.request.contextPath }/recommend/getRecommendedList'
															}
															]
												} ]
									},
									{
										id : '5',
										menu : [
												{
													text : '<i class="icon-tag"></i>&nbsp;后台用户',
													items : [
															{
																id : '11',
																text : '用户管理',
																href : '${pageContext.request.contextPath }/admin/member/index'
															},
															{
																id : '12',
																text : '角色管理',
																href : '${pageContext.request.contextPath }/admin/role/index'
															},
															{
																id : '13',
																text : '权限管理',
																href : '${pageContext.request.contextPath }/admin/purview/index'
															} ]
												},
												{
													text : '<i class="icon-leaf"></i>&nbsp;产品管理',
													items : [
															{
																id : '21',
																text : '产品配置',
																href : '${pageContext.request.contextPath }/loanType/index'
															},
															{
																id : '22',
																text : '费用列表',
																href : '${pageContext.request.contextPath }/siteFee/siteFeeList'
															},
															{
																id : '23',
																text : '收费管理',
																href : '${pageContext.request.contextPath }/siteFeeType/siteFeeTypeList'
															}, {
																id : '23',
																text : '附件管理',
																href : '#'
															} ]
												},
												{
													text : '<i class="icon-fire"></i>&nbsp;模板管理',
													items : [
															{
																id : '31',
																text : '短信模板',
																href : '${pageContext.request.contextPath }/notifyAuto/index'
															},
															{
																id : '32',
																text : '站内信模板',
																href : '${pageContext.request.contextPath }/message/index'
															} ]
												} ]
									}

							];
							new PageUtil.MainPage({
								modulesConfig : config
							});
						});
	</script>
</body>
</html>