$(function(){
	
	$.ajax({
		url :'/MQBProject/guestbook/getGuestbookList.do',
		type:'post',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success:function(data){
			//alert(JSON.stringify(data));
			$.each(data.list, function(index,items){
				$('#listname').text(items.name);
				$('#listdate').text(items.logtime);
				$('#listemail').text(items.email);
				$('#listsubject').text(items.guestSubject);
				$('#listcontent').text(items.guestContent);
			});
				
			
		},
		error :function(err) {
			console.log(err);
		}
		
	});
	
	
	
	
	
});