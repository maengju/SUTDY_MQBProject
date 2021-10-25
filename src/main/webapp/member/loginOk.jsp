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
	<input type="button" value="로그아웃" onclick="location.href='/MQBProject/member/logout.do'">
	<input type="button" value="회원정보수정" onclick="location.hreff='/MQBProject/member/modifyForm.do'">
</div>


