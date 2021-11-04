<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Image 등록</h3>
<form name="imageboardWriteForm" id="imageboardWriteForm" enctype="multipart/form-data"
			method="post" action="/MQBProject/imageboard/imageboardWrite.do">

	<table id="imageboardWriteFormTable" name="imageboardWriteFormTable" cellspacing="0" border="1" cellpadding="5">
	
		<tr>
			<td width="100" align="center">상품코드</td>
			<td>
				<input type="text" name="imageId" id="imageId" value="img_" style="width: 350px;" >
			</td>
		</tr>
				
		<tr>
			<td  align="center">상품명</td>
			<td>
				<input type="text" name="imageName" id="imageName" style="width: 350px;" placeholder="상품명">
			</td>
		</tr>
		
		<tr>
			<td  align="center">단 가</td>
			<td>
				<input type="text" name="imagePrice" id="imagePrice" style="width: 350px;" placeholder="단가">
			</td>
		</tr>
		
		<tr>
			<td  align="center">개수</td>
			<td>
				<input type="text" name="imageQty" id="imageQty" style="width: 350px;" placeholder="개수">
			</td>
		</tr>
		
		<tr>
			<td  align="center">내용</td>
			<td>
				<textarea name="imageContent" id="imageContent" cols="50" rows="15" placeholder="내용입력"></textarea>
				
			</td>
		</tr>
		
		<tr>
			<td colspan="2" >
				<input type="file" name="image1">
			</td>
			
		</tr>
		
		<tr>
			<td colspan="2" >
				<input type="file" name="image2">
			</td>
			
		</tr>
		
		<tr>
			<td colspan="2" width="80" align="center">
				<input type="button" id="imageboardWriteBtn"value="이미지등록">
				<input type="reset" value="다시작성">
			</td>
		</tr>
		
	</table>


</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" >
	$('#imageboardWriteBtn').click(function(){
		$('#imageboardWriteForm').submit();
	});
	
</script>