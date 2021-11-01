<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">


.subjectA:link { color: black; text-decoration: none; }
.subjectA:visited { color: black; text-decoration: none; }
.subjectA:hover { color: darkgreen; text-decoration: underline; }
.subjectA:active { color: black; text-decoration: none; }

#currentPaging {
	color: red;
	text-decoration: underline;
}
#paging {
	color: black;
	text-decoration: none;
}

</style>


<input type="hidden" id="pg" value="${requestScope.pg }">
<input type="hidden" id="boardId" value="${memId }">

<table id="boardListTable"border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="100">작성자</th>
		<th width="100">조회수</th>
		<th width="100">작성일</th>
	</tr>
	
	
	
</table>
<div style="width: 750px; text-align: center;">
	<c:forEach var="i" begin="1" end="${totalP }">
		<c:if test="${i == pg }">
			[<a id="currentPaging" href="/mvcmember/board/boardList.do?pg=${i }">${i }</a>]
		</c:if>
		<c:if test="${i != pg }">
			[<a id="paging" href="/mvcmember/board/boardList.do?pg=${i }">${i }</a>]
		</c:if>
	</c:forEach>
</div>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/boardList.js"></script>


