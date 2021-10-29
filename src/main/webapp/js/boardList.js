$(function(){
	$.ajax({
		url:'/MQBProject/board/getBoardList.do',
		type: 'post',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success: function(data) {
			//alert(JSON.stringify(data))
			
			$.each(data.list, function(index,items){
				$('<tr/>')
				.append($('<td>',{
					align:'center',
					text: items.seq
				})).append($('<td>')
				.append(
					$('<a>',{
						href:'#',
						id:'subjectA',
						text:items.subject
					})
				)).append($('<td>',{
					align:'center',
					text:items.id
				})).append($('<td>',{
					align:'center',
					text:items.hit
				})).append($('<td>',{
					align:'center',
					text:items.logtime
				})).appendTo($('#boardListTable'));
				
				
			});
		},
		error: function(err) {
			console.log(err);
		}
	});
	
	$(document).on("click","#subjectA",function(){
		console.log($('#boardId').val());
		
		if($('#boardId').val()==''){
			alert("로그인 후 이용해주세요");
		}else{
			alert("안녕하세요");
			location.href='/MQBProject/board/boardView.do?seq='+item.seq+'&pg='+$('#pg').val();
		}
	})
});