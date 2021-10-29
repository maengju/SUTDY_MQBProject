<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
div .loginOkId{
	text-align: center;
}
</style>
<div class="loginOkId">${sessionScope.memName }님 로그인</div>
<br><br>
<div class="loginOkId">
	<input type="button" value="로그아웃" id="logoutBtn">
	<input type="button" value="회원정보수정" onclick="location.hreff='/MQBProject/member/modifyForm.do'">	
</div>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	
$('#logoutBtn').click(function(){
	$.ajax({
		url:'/MQBProject/member/logout.do',
		type:'post',
		success:function(){
			alert('logout');	
			location.href="/MQBProject/index.jsp";
		},
		error:function(err){
			console.log(err);
		}
	});
});
</script>



