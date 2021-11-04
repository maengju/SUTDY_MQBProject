$(function(){
	$.ajax({
		url:'/MQBProject/imageboard/getImageboardList.do'
		,type:'post'
		,data:'pg='+$('#pg').val()
		,dataType:'json'
		,success: function(data){
			console.log(JSON.stringify(data));
			$.each(data.list, function(index,items){
				$('<tr/>')
				.append($('<td>',{
					align:'center',
					text: items.seq
				})).append($('<td>')
				.append(
					$('<img>',{
						href:'#',
						src:'/MQBProject/storage/'+items.image1,
						class:'subjectA',
						id: 'image1_'+items.seq,
						alt : items.image1
					})
				)).append($('<td>',{
					align:'center',
					text:items.imageName
				})).append($('<td>',{
					align:'center',
					text:items.imagePrice+'원'
				})).append($('<td>',{
					align:'center',
					text:items.imageQty
				})).append($('<td>',{
					align:'center',
					text:(items.imagePrice)*(items.imageQty)+'원'
				})).appendTo($('#imageboardListTable'));
				
				$('#image1_'+items.seq).click(function(){
					alert("asdf");
				})
			});//each
			
			$('#imageboardPagingDiv').html(data.boardPaging);
		}
		,error(err){
			console.log(err);
		}
	});//ajax
	
});