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
				
				//답글
				for(var i=0; i<items.lev; i++){
					$('#subject_'+items.seq).before('&emsp;');
				}
				
				if(items.lev != 0){
					$('#subject_'+items.seq).before($('<img>',{
						src:'../image/reply.gif',
						alt:'답글 이미지'
					}));
				}
				
				
				//로그인 여부 확인
				$('#subject_'+items.seq).click(function(){
					if(data.memId ==null){
						alert('로그인 후 이용가능합니다.');
					}else{
						location.href='/MQBProject/board/boardView.do?seq='+items.seq+'&pg='+$('#pg').val();
					}
				});
				
				
				
			});//each
			
			//페이징 처리
			$('#boardPagingDiv').html(data.boardPaging);
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