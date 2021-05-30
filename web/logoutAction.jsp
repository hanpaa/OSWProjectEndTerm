<%@ page import="java.io.PrintWriter" %>
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
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(int i=0; i < cookies.length; i++){

				// 쿠키의 유효시간을 0으로 설정하여 만료시킨다
				cookies[i].setMaxAge(0) ;

				// 응답 헤더에 추가한다
				response.addCookie(cookies[i]) ;
			}
			PrintWriter script=response.getWriter();

			script.println("<script>");
			script.println("alert('로그아웃 되었습니다.')");
			script.println("location.href='http://osw8team.kro.kr:8080/'");
			script.println("</script>");

		}


	%>
	<script>
		// location.href="http:/osw8team.kro.kr:8080/";//세션 해제 후 index페이지로 이동
	</script>
</body>
</html>
