<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



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

img.subjectA{
 	display : block;
    margin : auto;
	width: 70px;
	height: 70px;
	cursor: pointer;
}

</style>



<input type="hidden" id="pg" value="${requestScope.pg }">
<input type="hidden" id="imageboardId" value="${memId }">

<table id="imageboardListTable"border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	
	
	<tr>
		<th width="100">글번호</th>
		<th width="150">이미지</th>
		<th width="150">상품명</th>
		<th width="100">단가</th>
		<th width="100">개수</th>
		<th width="100">합계</th>
	</tr>
		
</table>
<div style="width: 750px; text-align: center; cursor: pointer;" id = "imageboardPagingDiv">???</div>



<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/imageboardList.js"></script>
<script type="text/javascript">
function boardPaging(param_pg){
	location.href='/MQBProject/imageboard/imageboardList.do?pg='+param_pg;
} 
</script>