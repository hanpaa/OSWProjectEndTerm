<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyToDo</title>
</head>
<body>
	<%
		session.invalidate();//현재 이 페이지에 접속한 회원이 세션을 빼앗기도록
	%>
	<script>
		location.href="index.jsp";//세션 해제 후 index페이지로 이동
	</script>
</body>
</html>