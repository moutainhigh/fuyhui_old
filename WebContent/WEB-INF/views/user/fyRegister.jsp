<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src='${pageContext.request.contextPath }/static/scripts/common/jquery-1.9.1.js'></script>
    <script src="${pageContext.request.contextPath }/static/scripts/common/common.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
<table>
<tr>
<td ><a class ='jiekouceshi' href="javascript:void(0);">接口测试</a></td>
</tr>		
		
	</table>

<form action="<%=request.getContextPath() %>/fy/getRecommenFriendsShow" method="post">
	<table>
		<tr>
			<td>商户代码</td>
			<td><input type="text" name="mchnt_cd" value="0001200F0040016"></td>
		</tr>		
		<tr>
			<td>交易类型PW11 充值PWTX 提现
			</td>
			<td><input type="text" name="busi_tp" value="PWPC"></td>
		</tr>	
		<tr>
			<td>交易流水</td>
			<td><input type="text" name="txn_ssn" value="20170116154931"></td>
		</tr>		
		<tr>
			<td>用户</td>
			<td><input type="text" name="cust_no" value="18675998514"></td>
		</tr>

		<tr>
			<td>签名数据</td>
			<td><input type="text" name="signature"></td>
		</tr>		
		
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="查询交易明细"></td>
		</tr>		
		
	</table>
</form>
<br/>
<hr/>

<form action="<%=request.getContextPath() %>/fy/reOrWithDetails" method="post">
	<table>
		<tr>
			<td>商户代码</td>
			<td><input type="text" name="mchnt_cd" value="0001200F0040016"></td>
		</tr>		
		<tr>
			<td>交易类型PW11 充值PWTX 提现
			</td>
			<td><input type="text" name="busi_tp" value="PW11"></td>
		</tr>	
		<tr>
			<td>交易流水</td>
			<td><input type="text" name="txn_ssn" value="FYHCS20170116103151"></td>
		</tr>		
		<tr>
			<td>用户</td>
			<td><input type="text" name="cust_no" value="18692003840"></td>
		</tr>

		<tr>
			<td>签名数据</td>
			<td><input type="text" name="signature"></td>
		</tr>		
		
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="查询充值或提现明细"></td>
		</tr>		
		
	</table>
</form>
<br/>
<hr/>

<form action="<%=request.getContextPath() %>/rep/cashRefund" method="post">
	<table>
		<tr>
			<td>商户代码</td>
			<td><input type="text" name="mchnt_cd" value="0001200F0040016"></td>
		</tr>		
		<tr>
			<td>交易日期</td>
			<td><input type="text" name="mchnt_txn_dt" value="20140101"></td>
		</tr>
		<tr>
			<td>流水号</td>
			<td><input type="text" name="mchnt_txn_ssn" value="20170112134146"></td>
		</tr>		
		<tr>
			<td>手机号</td>
			<td><input type="text" name="mobile_no"></td>
		</tr>
		<tr>
			<td>充值金额</td>
			<td><input type="text" name="amt"></td>
		</tr>		
		<tr>
			<td>备注</td>
			<td><input type="text" name="remark"></td>
		</tr>
		<tr>
			<td>签名数据</td>
			<td><input type="text" name="signature"></td>
		</tr>		
		
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="通知"></td>
		</tr>		
		
	</table>
</form>
<br/>
<hr/>

<form action="<%=request.getContextPath() %>/fy/register1" method="post">
	<table>
		<tr>
			<td>姓名</td>
			<td><input type="text" name="cust_nm" value="test01"></td>
		</tr>		
		<tr>
			<td>证件号码</td>
			<td><input type="text" name="certif_id" value="450330199104042223"></td>
		</tr>		
		<tr>
			<td>手机号</td>
			<td><input type="text" name="mobile_no"></td>
		</tr>		
		<tr>
			<td>开户行</td>
			<td><select name="city_id" >
				<option value="5840" selected="selected">深圳</option>
			</select></td>
		</tr>		
		<tr>
			<td></td>
			<td>建设银行<input type="radio" name="parent_bank_id" value="0105">
			招商银行<input type="radio" name="parent_bank_id" value="0308"></td>
		</tr>			
		<tr>
			<td>账号</td>
			<td><input type="text" name="capAcntNo" value="6217007200020565626"></td>
		</tr>		
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="注册"></td>
		</tr>		
		
	</table>
</form>

<br/>
<hr/>

<form action="<%=request.getContextPath() %>/fy/artifregister" method="post">
	<table>
	    <tr>
			<td>客户类型</td>
			<td><input type="text" name="userType" value="1"></td>
		</tr>
	
		<tr>
			<td>企业名称</td>
			<td><input type="text" name="cust_nm" value="test01"></td>
		</tr>
		<tr>
			<td>法人姓名</td>
			<td><input type="text" name="artif_nm" value="test01"></td>
		</tr>			
		<tr>
			<td>身份证号码</td>
			<td><input type="text" name="certif_id" value="450330199104042223"></td>
		</tr>		
		<tr>
			<td>手机号</td>
			<td><input type="text" name="mobile_no"></td>
		</tr>
		<tr>
			<td>邮箱地址</td>
			<td><input type="text" name="email"></td>
		</tr>		
		<tr>
			<td>开户行</td>
			<td><select name="city_id" >
				<option value="5840" selected="selected">深圳</option>
			</select></td>
		</tr>		
		<tr>
			<td></td>
			<td>建设银行<input type="radio" name="parent_bank_id" value="0105">
			招商银行<input type="radio" name="parent_bank_id" value="0308"></td>
		</tr>
		<tr>
			<td>开户行支行名称</td>
			<td><input type="text" name="bank_nm"></td>
		</tr>			
		<tr>
			<td>账号</td>
			<td><input type="text" name="capAcntNo" value="6217007200020565626"></td>
		</tr>
		<tr>
			<td>支付密码</td>
			<td><input type="text" name="password" ></td>
		</tr>
		<tr>
			<td>确认支付密码</td>
			<td><input type="text" name="querenpassword" ></td>
		</tr>		
		<tr>
		
			<td>&nbsp;</td>
			<td><input type="submit" value="注册"></td>
		</tr>		
		
	</table>
</form>

<br/>
<hr/>

<form action="<%=request.getContextPath() %>/fy/queryInfo" method="post">
	用户id：<input type="text" name="user_ids"/>
	<input type="submit" value="查询用户信息">
</form>
<br/>
<hr/>
<form action="<%=request.getContextPath() %>/account/fastRecharge" method="post">
	用户id：<input type="text" name="login_id"/>
	充值金额：<input type="text" name="amt"/>
	<input type="submit" value="快捷充值">
</form>
<br/>
<hr/>
<form action="<%=request.getContextPath() %>/account/webRecharge" method="post">
	用户id：<input type="text" name="login_id"/>
	充值金额：<input type="text" name="amt"/>
	<input type="submit" value="网银充值">
</form>
<br/>
<hr/>
<form action="<%=request.getContextPath() %>/account/withdrawal" method="post">
	用户id：<input type="text" name="login_id"/>
	提现金额: <input type="text" name="amt"/>
	<input type="submit" value="提现">
</form>
<br/>
<hr/>
<form action="<%=request.getContextPath() %>/fy/balance1" method="post">
	用户id：<input type="text" name="cust_no"/>
	<input type="submit" value="余额查询">
</form>
<br/>
<hr/>
<form action="<%=request.getContextPath() %>/fy/freeze" method="post">
	用户id：<input type="text" name="cust_no"/>
	冻结金额：<input type="text" name="amt"/>
	<input type="submit" value="冻结">
</form>
<br/>
<hr/>
<form action="<%=request.getContextPath() %>/fy/unfreeze" method="post">
	用户id：<input type="text" name="cust_no"/>
	解冻金额：<input type="text" name="amt"/>
	<input type="submit" value="解冻">
</form>
<br/>
<hr/>
划拨(个人与个人之间)
<form action="<%=request.getContextPath() %>/fy/transBu" method="post">
	付款账户：<input type="text" name="out_cust_no"/>
	收款账户：<input type="text" name="in_cust_no"/><br/>
	金额：<input type="text" name="amt"/>
	<input type="submit" value="划拨">
</form>
<br/>
<hr/>
转账(商户与个人之间)
<form action="<%=request.getContextPath() %>/fy/transBmu" method="post">
	付款账户：<input type="text" name="out_cust_no"/>
	收款账户：<input type="text" name="in_cust_no"/><br/>
	金额：<input type="text" name="amt"/>
	<input type="submit" value="划拨">
</form>
<br/>
<hr/>
修改手机号
<form action="<%=request.getContextPath() %>/fy/chgMobile" method="post">
	登录id：<input type="text" name="login_id"/>
	<input type="submit" value="提交">
</form>
<br/>
<hr/>
密码管理
<form action="<%=request.getContextPath() %>/fy/pwdMgt" method="post">
	登录id：<input type="text" name="login_id"/>
	<input type="radio" name="busi_tp" value="1"/>1:重置登录密码
	<input type="radio" name="busi_tp" value="2"/>2:修改登录密码
	<input type="radio" name="busi_tp" value="3"/>3:支付密码重置
	<input type="submit" value="提交">
</form>
<br/>
<hr/>
修改银行卡
<form action="<%=request.getContextPath() %>/fy/chgCard" method="post">
	登录id：<input type="text" name="login_id"/>
	<input type="submit" value="提交">
</form>
<br/>
<hr/>
查询修改银行卡
<form action="<%=request.getContextPath() %>/fy/queryChgCard" method="post">
	登录id：<input type="text" name="login_id"/>
	<input type="submit" value="提交">
</form>
<br/>
<hr/>
投资
<form action="<%=request.getContextPath() %>/invest" method="post">
	登录id：<input type="text" name="login_id"/>
	金额：<input type="text" name="money"/>
	<input type="submit" value="提交">
</form>
冻结到冻结
<form action="<%=request.getContextPath() %>/fy/freeze2f" method="post">
	付款登录账户：<input type="text" name="out_cust_no"/>
	收款登录账户：<input type="text" name="in_cust_no"/>
	金额：<input type="text" name="amt"/>
	<input type="submit" value="提交">
</form>

<form action="<%=request.getContextPath() %>/account/rechargetest" method="post">
	付款登录账户：<input type="text" name="out_cust_no"/>
	收款登录账户：<input type="text" name="in_cust_no"/>
	金额：<input type="text" name="amt"/>
	<input type="submit" value="提交1">
</form>
<br/>
<br/>

<script type="text/javascript">
 $(function(){
	 $('.jiekouceshi').click(function(){
			
         $.ajax({
             type:'post',
             url:getContextPaths()+'/user/getRecommenFriendsListByUserid',
             dataType:'json',
             data:{
                 
             },
             success:function(json){
                 
                	 alert(json.aWardYesterday);
                 
             }
         });
     });
 });
 </script>
</body>
</html>
