<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<style type="text/css">

body{
	margin: 0;
	padding: 0;
	height: 100%;
	width: auto;
	
}

header{
	width: 1700px;
	height: 10%;
	text-align: center;
}

#container{
	margin: auto;
	width: 1700px;
	height: 500px;
}

#container:after {
	content: '';
	display: block;
	clear: both;
	float: none;
	
}

nav{
	margin-left: 10px;
	width: 25%;
	height: 100%;
	float: left;
	
}

section{
	width: 70%;
	height: 100%;
	float: left;
}

footer{
	width: 1700px;
	height: 10%;
}

div#idDiv, div#pwdDiv ,div#repwdDiv 
,div#nameDiv , div#subjectDiv
, div#contentDiv, div#guestContentDiv, div#guestSubjectDiv
, div#boardModifyForm {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}

th {
	font-size: 16px;
}

td {
	font-size: 13px;
}

</style>


</head>
<body>

<header>

	<h1>
		<img width="100px" height="70px" alt="선생님..." 
		
		src="/MQBProject/image/선생님.png" onclick="location.href='/MQBProject/index.jsp'"
		style="cursor: pointer"
		>MVC 기반의 미니 프로젝트
		<img width="100px" height="70px" alt="선생님..." 
		
		src="/MQBProject/image/선생님.png" onclick="location.href='/MQBProject/index.jsp'"
		style="cursor: pointer"
		>
	</h1>
	
	<jsp:include page="main/menu.jsp"/>
	
</header>


<div id="container">


	<nav>
		<jsp:include page="main/nav.jsp"/>
	</nav>
	
	<section>
	<c:if test="${empty display }">
		<jsp:include page="main/body.jsp"></jsp:include>
	</c:if>
	<c:if test="${not empty display }">
		<jsp:include page="${display }"></jsp:include>
	</c:if>
		
	</section>
	
	
	
	
</div>



<footer >
	<p>비트캠프 02 888 8888</p>
</footer>









<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/member.js"></script>


</body>
</html>

