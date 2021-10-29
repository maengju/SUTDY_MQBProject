<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3> 글쓰기 </h3> 
<form name="boardWriteForm"  id="boardWriteForm" > 
	<table cellspacing="0" border="1" cellpadding="5">
	<tr>
		<td width="50" align="right">제목</td>
		<td>
			<input type="text" name="subject" id="subject" style="width: 350px;">
			<div id="subjectDiv"></div>
		</td>
	</tr>
	<tr>
		<td width="50" align="right">내용</td>
		<td>
			<textarea name="content" id="content" cols="50" rows="15"></textarea>
			<div id="contentDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" id="boardWriteBtn" value="글쓰기">
			<input type="reset" value="다시작성">
		</td>
	</tr>
</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#boardWriteBtn').click(function(){
		//초기화 과정
		$('#subjectDiv').empty();
		$('#contentDiv').empty();
		
		if($('#subject').val() == '') {
			$('#subjectDiv').html('제목 입력'); 
			$('#subject').focus();
		}
		else if($('#content').val() == ''){
			$('#contentDiv').html('내용 입력');
			$('#content').focus();
		}
		else 
			$.ajax({
				url:'/MQBProject/board/boardWrite.do',
				type:'post',
				data: $('#boardWriteForm').serialize(),
				success:function(){
					alert("작성 완료");
					location.href="/MQBProject/board/boardList.do?pg=1"
				},
				error:function(err){
					console.log(err);
				}
			});
	});
});
</script>






