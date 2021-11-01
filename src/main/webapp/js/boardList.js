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
						class:'subjectA',
						id:'subject_'+items.seq,
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
				
				//로그인 여부 확인
				$('#subject_'+items.seq).click(function(){
					if(data.memId ==null){
						alert('로그인 후 이용가능합니다.');
					}else{
						location.href='/MQBProject/board/boardView.do?seq='+items.seq+'&pg='+$('#pg').val();
					}
				});
				
			});//each
		},
		error: function(err) {
			console.log(err);
		}
	});
	
	/*$(document).on("click","#subjectA",function(){
		console.log($('#boardId').val());
		
		if($('#boardId').val()==''){
			alert("로그인 후 이용해주세요");
		}else{
			alert("안녕하세요");
			location.href='/MQBProject/board/boardView.do?seq='+item.seq+'&pg='+$('#pg').val();
		}
	});*/
	
	
});