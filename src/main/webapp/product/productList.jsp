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


<table id="productListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	
	
	<tr>
		<th width="100">번호</th>
		<th width="150">이미지</th>
		<th width="150">상품명</th>
		<th width="100">단가</th>
		<th width="100">개수</th>
		<th width="100">합계</th>
		<th width="100">할인율</th>
		<th width="100">할인액</th>
		<th width="100">가격</th>
	</tr>
		
</table>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:'/MQBProject/product/getProductList.do'
		,type:'post'
		,data:'pg='+$('#pg').val()
		,dataType:'json'
		,success: function(data){
			//console.log(JSON.stringify(data));
			$.each(data.list, function(index,items){
				$('<tr/>')
				.append($('<td>',{
					align:'center',
					text: items.seq
				})).append($('<td>')
				.append(
					$('<img>',{
						href:'#',
						src:'/MQBProject/storage/'+items.img,
						class:'subjectA',
						id: 'img_'+items.seq,
						alt : items.img
					})
				)).append($('<td>')
				.append($('<a>',{
						href:'#',
						align:'center',
						text:items.name,
						class:'subjectA',
						id: 'name'+items.seq
				}))).append($('<td>',{
					align:'center',
					text:items.unit
				})).append($('<td>',{
					align:'center',
					text:items.qty
				})).append($('<td>',{
					align:'center',
					text:items.total
				})).append($('<td>',{
					align:'center',
					text:items.rate+'%'
				})).append($('<td>',{
					align:'center',
					text:items.discount
				})).append($('<td>',{
					align:'center',
					text:items.price
				})).appendTo($('#productListTable'));
				
				$('#img_'+items.seq).click(function(){
					alert("img");
				});
				
				
				$('#name_'+items.seq).click(function(){
					alert("name");
				});
			
			});//each
		}
		,error:function(err){
			console.log(err);
		}
	});
});
</script>
    