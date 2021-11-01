<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form name="guestbookWriteForm" id="guestbookWriteForm" >
	<table border="1" cellspacing="0" cellpadding="5" width="650px">
		<tr>
			<td width="100" align="center">작성자</td>
			<td>
				<input type="text" name="name" id="name" placeholder="작성자 입력">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">이메일</td>
			<td>
				<input type="email" name="email" id="email" size = "30"placeholder="이메일 입력">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">제목</td>
			<td>
				<input type="text" name="guestSubject" id="guestSubject" size = "70" placeholder="제목 입력">
				<div id="guestSubjectDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td width="100" height="150" align="center">내용</td>
			<td>
				<textarea name="guestContent" id="guestContent" rows="14" cols="70" placeholder="내용 입력"></textarea>
				<div id="guestContentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="3" align="center">
				<input type="button" value="글작성" name="guestWriteBtn" id="guestWriteBtn" onclick="">
				<input type="reset" value="다시작성" name="gurestResetBtn" id="gurestResetBtn">
				<input type="button" value="글목록" name="guestListBtn" id="guestListBtn" 
				onclick="">
			</td>
		</tr>
	</table>
</form>	

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#guestWriteBtn').click(function(){
		//초기화 과정
		$('#guestSubjectDiv').empty();
		$('#guestContentDiv').empty();
		
		if($('#guestSubject').val() == '') {
			$('#guestSubjectDiv').html('제목 입력'); 
			$('#guestSubject').focus();
		}
		else if($('#guestContent').val() == ''){
			$('#guestContentDiv').html('내용 입력');
			$('#guestContent').focus();
		}
		else 
			$.ajax({
				url:'/MQBProject/guestbook/guestbookWrite.do',
				type:'post',
				data: $('#guestbookWriteForm').serialize(),
				success:function(){
					alert("작성 완료");
					location.href="/MQBProject/guestbook/guestbookList.do?pg=1"
				},
				error:function(err){
					console.log(err);
				}
			});
	});
});
</script>




