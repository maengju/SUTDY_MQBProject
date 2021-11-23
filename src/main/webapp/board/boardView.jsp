<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





<form id = "boardViewForm">
	<input type="hidden" id="seq" name="seq" value="${seq }">
	<input type="hidden" id="pg" name="pg" value="${pg }">
	<table border="1" width="600"  cellspacing="0" cellpadding="5" frame="hsides" rules="rows">

		<tr>
			<td colspan="3"><h3><span id = "subjectSpan"></span></h3></td>
		</tr>
		
		<tr>
			<td width="150">글번호 : <span id = "seqSpan"></span></td>
			<td width="150">작성자 : <span id = "idSpan"></span></td>
			<td width="150">조회수 : <span id = "hitSpan"></span></td>
		</tr>
		
		<!-- 
		
		엔터를 안치고 글을 옆으로 길게쓴 경우
		
		 -->
		
		
		<tr>
			<td colspan="3" height="200" valign="top">
				<pre style= " white-space: pre-line; work-break: break-all;">
				<span id = "contentSpan"></span></pre>
			</td>
		</tr>
	</table>
	
	<div class="tr_hashTag_area">
    <p><strong>해시태그 구현</strong></p>
           <div class="form-group">
                <input type="hidden" value="" name="tag" id="rdTag" />
            </div>
        
             <ul id="tag-list"></ul>
                        
            <div class="form-group">
            	<input type="text" id="tag" size="7" placeholder="엔터로 해시태그를 등록해주세요." style="width: 300px;"/>
           </div>
	</div>
	
	<input type="button" id="boardListBtn" value="목록" onclick="location.href='/MQBProject/board/boardList.do?pg=${pg}'">
	
	<span id="boardViewSpan">
	<input type="button" value="글수정" onclick="mode(1)">
	<input type="button" value="글삭제" onclick="mode(2)">
	</span>
	<input type="button" value="답글" onclick="mode(3)">

</form>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url:'/MQBProject/board/getBoardView.do',
		type: 'post',
		data: {'seq': $('#seq').val()},
		dataType: 'json',
		success: function(data) {
			console.log(JSON.stringify(data));
			$('#subjectSpan').text(data.subject);
			$('#seqSpan').text(data.seq);
			$('#idSpan').text(data.id);
			$('#hitSpan').text(data.hit);
			$('#contentSpan').text(data.content);
			
			//작성한 사람만 글수정, 글삭제가 보이게 만들기
			if(data.memId==data.id){
				$('#boardViewSpan').show();
			}else{
				$('#boardViewSpan').hide();
			}
		},
		error:function(err){
			console.log(err);
		}
		
	});
	
	
	
	
});
</script>



<script type="text/javascript">
function mode(num){
	if(num==1){
		document.getElementById('boardViewForm').method = 'post';
		document.getElementById('boardViewForm').action = '/MQBProject/board/boardModifyForm.do';
		document.getElementById('boardViewForm').submit();
		
	}else if(num==2){
		document.getElementById('boardViewForm').method = 'post';
		document.getElementById('boardViewForm').action = '/MQBProject/board/boardDelete.do';
		document.getElementById('boardViewForm').submit();
	}else if(num==3){
		document.getElementById('boardViewForm').method = 'post';
		document.getElementById('boardViewForm').action = '/MQBProject/board/boardReplyForm.do';
		document.getElementById('boardViewForm').submit();
	}
}
</script>

<script>
    $(document).ready(function () {
        var tag = {};
        var counter = 0;

        // 입력한 값을 태그로 생성한다.
        function addTag (value) {
            tag[counter] = value;
            counter++; // del-btn 의 고유 id 가 된다.
        }

        // tag 안에 있는 값을 array type 으로 만들어서 넘긴다.
        function marginTag () {
            return Object.values(tag).filter(function (word) {
                return word !== "";
            });
        }
    
        // 서버에 제공
        $("#tag-form").on("submit", function (e) {
            var value = marginTag(); // return array
            $("#rdTag").val(value); 

            $(this).submit();
        });

        $("#tag").on("keypress", function (e) {
            var self = $(this);

            //엔터나 스페이스바 눌렀을때 실행
            if (e.key === "Enter" || e.keyCode == 32) {

                var tagValue = self.val(); // 값 가져오기

                // 해시태그 값 없으면 실행X
                if (tagValue !== "") {

                    // 같은 태그가 있는지 검사한다. 있다면 해당값이 array 로 return 된다.
                    var result = Object.values(tag).filter(function (word) {
                        return word === tagValue;
                    })
                
                    // 해시태그가 중복되었는지 확인
                    if (result.length == 0) { 
                        $("#tag-list").append("<li class='tag-item'>"+tagValue+"<span class='del-btn' idx='"+counter+"'>x</span></li>");
                        addTag(tagValue);
                        self.val("");
                    } else {
                        alert("태그값이 중복됩니다.");
                    }
                }
                e.preventDefault(); // SpaceBar 시 빈공간이 생기지 않도록 방지
            }
        });

        // 삭제 버튼 
        // 인덱스 검사 후 삭제
        $(document).on("click", ".del-btn", function (e) {
            var index = $(this).attr("idx");
            tag[index] = "";
            $(this).parent().remove();
        });
})
</script>



















