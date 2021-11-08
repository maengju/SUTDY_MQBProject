$(function(){
	$.ajax({
		url:'/MQBProject/imageboard/getImageboardList.do'
		,type:'post'
		,data:'pg='+$('#pg').val() //{'pg':$('#pg').val()} jsonType
		,dataType:'json'
		,success: function(data){
			console.log(JSON.stringify(data));
			$.each(data.list, function(index,items){
				$('<tr/>')
				.append($('<td>',{
					align:'center',
					text: items.seq
				}).prepend($('<input/>',{
					type:'checkbox',
					class:'check',
					name:'check',
					value:items.seq
				}))).append($('<td>')
				.append(
					$('<img>',{
						href:'#',
						src:'/MQBProject/storage/'+items.image1,
						class:'subjectA',
						id: 'image1_'+items.seq,
						alt : items.image1
					})
				)).append($('<td>')
				.append($('<a>',{
						href:'#',
						align:'center',
						text:items.imageName,
						class:'subjectA',
						id: 'imageName_'+items.seq
				}))).append($('<td>',{
					align:'center',
					text:items.imagePrice.toLocaleString()+'원'
				})).append($('<td>',{
					align:'center',
					text:items.imageQty
				})).append($('<td>',{
					align:'center',
					text:((items.imagePrice)*(items.imageQty)).toLocaleString()+'원'
				})).appendTo($('#imageboardListTable'));
				
				
				
				$('#img_'+items.seq).click(function(){
					alert("img");
				});
				
				
				$('#name_'+items.seq).click(function(){
					alert("name");
				});
				
			});//each
			
			
			$('#imageboardPagingDiv').html(data.imageboardPaging);
		}
		,error:function(err){
			console.log(err);
		}
	});//ajax
	
	
	
	
	
	
});