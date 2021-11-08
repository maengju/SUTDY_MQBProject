<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name="productWriteForm" id="productWriteForm" enctype="multipart/form-data"
			method="post" action="/MQBProject/product/productWrite.do">

	<table id="productWriteFormTable" name="productWriteFormTable" cellspacing="0" border="0" cellpadding="5"
			style="height: 400px;">
	
	
		<tr>
			<td  width="100" align="center">
				상품
			</td>
			<td >
				<input type="file" name="img">
			</td>
			
		</tr>
		
		<tr>
			<td  align="center">상품명</td>
			<td>
				<input type="text" name="name" id="name" style="width: 200px;" >
			</td>
		</tr>
		
		<tr>
			<td  align="center">단 가</td>
			<td>
				<input type="text" name="unit" id="unit" style="width: 200px;" >
			</td>
		</tr>
		
		<tr>
			<td  align="center">개수</td>
			<td>
				<input type="text" name="qty" id="qty" style="width: 200px;" >
			</td>
		</tr>
		
		<tr>
			<td  align="center">할인율</td>
			<td>
				<input type="text" name="rate" id="rate" style="width: 200px;" >
			</td>
		</tr>
		
		
		
		<tr>
			<td colspan="2" width="80" align="center">
				<input type="button" id="productWriteFormBtn"value="계산">
				<input type="reset" value="취소">
			</td>
		</tr>
		
	</table>


</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" >
	$('#productWriteFormBtn').click(function(){
		$('#productWriteForm').submit();
	});
	
</script>