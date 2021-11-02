<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<form id = "boardViewForm">
	<input type="hidden" id="seq" name="seq" value="${seq }">
	<input type="hidden" id="pg" name="pg" value="${pg }">
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
	
	<span id="boardViewSpan">
	<input type="button" value="글수정" onclick="mode(1)">
	<input type="button" value="글삭제" onclick="mode(2)">
	</span>
	<input type="button" value="답글">

</form>


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
			if(data.memId==data.id){
				$('#boardViewSpan').show();
			}else{
				$('#boardViewSpan').hide();
			}
		},
		error:function(err){
			console.log(err);
		}
		
	});
});
</script>



<script type="text/javascript">
function mode(num){
	if(num==1){
		document.getElementById('boardViewForm').method = 'post';
		document.getElementById('boardViewForm').action = '/MQBProject/board/boardModifyForm.do';
		document.getElementById('boardViewForm').submit();
		
	}else if(num==2){
		
	}
}
</script>



















