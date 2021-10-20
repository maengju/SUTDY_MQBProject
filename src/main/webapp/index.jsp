<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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



</style>


</head>
<body>

<header>

	<h1>
		<img width="100px" height="70px" alt="선생님..." src="image/선생님.png">MVC 기반의 미니 프로젝트
	</h1>
	
	<jsp:include page="main/menu.jsp"/>
	
</header>


<div id="container">


	<nav>
		<jsp:include page="main/nav.jsp"/>
	</nav>
	
	<section>
		<h1>
			홈페이지를 방문해주셔서 감사합니다.<br>
			Have a nice day<br>
			<img width="200px" height="200px" alt="쭈욱" src="image/쭈욱.png">
		</h1>
	</section>
	
	
	
</div>



<footer >
	<p>비트캠프</p>
</footer>









<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/member.js"></script>


</body>
</html>

