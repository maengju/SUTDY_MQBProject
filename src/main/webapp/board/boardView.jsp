<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input type="hidden" id="seq" value="${seq }">
<input type="hidden" id="pg" value="${pg }">
<input type="hidden" id="memId" value="${memid }">

<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<td colspan="3"><h3><span id = "subjectSpan"></span></h3></td>
	</tr>
	
	<tr>
		<td width="150">글번호 : <span id = "seqSpan"></span></td>
		<td width="150">작성자 : <span id = "idSpan"></span></td>
		<td width="150">조회수 : <span id = "hitSpan"></span></td>
	</tr>
	
	<tr>
		<td colspan="3" height="200" valign="top">
			<pre><span id = "contentSpan"></span></pre>
		</td>
	</tr>
</table>

<input type="button" id="boardListBtn" value="목록" onclick="location.href='/MQBProject/board/boardList.do?pg=${pg}'">

<input type="hidden" id = "updateBtn" value="글 수정">
<input type="hidden" id = "deleteBtn" value="글 삭제">
<input type="button" value="답글">



<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:'/MQBProject/board/getBoardView.do',
		type: 'post',
		data: {'seq': $('#seq').val()},
		dataType: 'json',
		success: function(data) {
			console.log(JSON.stringify(data));
			$('#subjectSpan').text(data.subject);
			$('#seqSpan').text(data.seq);
			$('#hitjectSpan').text(data.hit);
			$('#contentSpan').text(data.content);
			
			//작성한 사람만 글수정, 글삭제가 보이게 만들기
			if($('#memId').val()==data.id){
				$('#updateBtn').prop("type","button");
				$('#deleteBtn').prop("type","button");
			}else{
				$('#updateBtn').prop("type","hidden");
				$('#deleteBtn').prop("type","hidden");
			}
		},
		error:function(err){
			console.log(err);
		}
		
	});
});
</script>





















