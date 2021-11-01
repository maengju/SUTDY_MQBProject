<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">


#currentPagingA{
	color: red;
	text-decoration: underline;
}

#pagingA{
	color:black;
	text-decoration: none;
}
</style>


<input type="hidden" id="pg" value="${requestScope.pg }">





<table id = "guestbookListTable" name = "guestbookListTable" border="1" width="450px">
	<tr id = "guestbookList1">
		<td width="70" align="center" >작성자</td>
		<td width="100" align="center" id="listname">
		<td width="70" align="center">작성일</td>
		<td align="center" id="listdate">
	</tr>

	<tr>
		<td width="70" align="center">이메일</td>
		<td colspan="3" align="center" id="listemail">
	</tr>

	<tr>
		<td width="70" align="center">제목</td>
		<td colspan="3" align="center" id="listsubject"></td>

	</tr>

	<tr>

		<td colspan="4" height="200px" align="center"><pre id="listcontent"></pre></td>

	</tr>

</table>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/guestbook.js"></script>