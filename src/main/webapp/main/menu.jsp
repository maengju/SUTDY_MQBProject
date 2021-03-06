<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.mainnav{
	background-color: #00BFFF;
	list-style: none;
	
}

.mainnav li{
	display: inline-block;
	justify-content: space-between; /* 여백 */
	
}

.mainnav li a{
	display: block;
	color: #ffffff;
	padding: 0 13px;
	background-color: #00BFFF;
	font: bold 16px/40px 'nanum Gthic', sans-serif;
	
	text-transform: uppercase; 
	text-decoration: none;
}

.mainnav li a:hover{
	color: #FDF5E6;
	background-color: #1E90FF;
	
}

</style>    
    
    
<ul class="mainnav">
	<c:if test="${memId!= null}">
		<li>
		<a href="/MQBProject/board/boardWriteForm.do">글쓰기</a>
		</li>
		<li>
		<a href="/MQBProject/imageboard/imageboardWriteForm.do">이미지 등록</a>
		</li>
		
		<li>
		<a href="/MQBProject/product/productWriteForm.do">상품 등록</a>
		</li>
	</c:if>
	
	
	<li><a href="/MQBProject/board/boardList.do?pg=1">글 목록</a></li>
	<li><a href="/MQBProject/imageboard/imageboardList.do?pg=1">이미지 목록</a></li>
	<li><a href="/MQBProject/product/productList.do?pg=1">상품 목록</a></li>
	
	<c:if test="${memId!= null}">
		<li>
		<a href="/MQBProject/guestbook/guestbookWriteForm.do">방명록 작성</a>
		</li>
	</c:if>
	<li><a href="/MQBProject/guestbook/guestbookList.do?pg=1">방명록 보기</a></li>
	
	
</ul>
