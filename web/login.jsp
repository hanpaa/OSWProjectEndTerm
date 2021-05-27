<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href=./css/reset.css">
	<link rel="stylesheet" href="./css/main.css">
 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<title>MyToDo</title>
</head>
<body>
 	<!--Header-->
	<header class="header">
		<div class ="header-area">
			<h1><a class="logo" href="http://localhost:8080">MyToDo</a></h1>
		</div>
	</header>
	<!--info-->
	<div class="sign">
			<h1 style="text-align:center;">Login</h1>
				<form method="post" action="loginAction.jsp">
					<div class = "form-group">
						<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인">
				</form>
	</div>

	<footer class="copyright">
        <p>Copyright 2020. TEAM 8. All right reserved </p>
    </footer>

	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>

	<script src="js/AddPopup.js"></script> <!-- 원래 js파일 -->
</body>
</html>
