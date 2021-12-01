<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="bbs.BbsDAO" %>
<%@ page import="bbs.Bbs" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>MyToDo</title>
  <link rel="stylesheet" href="./css/reset.css">
  <link rel="stylesheet" href="./css/main.css">
  <link rel="stylesheet" href="./css/bootstrap-theme.css">
  <link rel="stylesheet" href="./css/bootstrap.css">
<body>
   <%
		String userID=null;
		if(session.getAttribute("userID")!=null){
			userID=(String)session.getAttribute("userID");
		}
		if(userID==null){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요.')");
			script.println("location.href='login.jsp'");
			script.println("</script>");
		}
		int bbsID=0;
		if(request.getParameter("bbsID")!=null)
			bbsID=Integer.parseInt(request.getParameter("bbsID"));
		if(bbsID==0){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('유효하지 않은 글입니다.')");
			script.println("location.href='bbs.jsp'");
			script.println("</script>");
		}
		Bbs bbs = new BbsDAO().getBbs(bbsID);
		if(!userID.equals(bbs.getUserID())){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('권한이 없습니다.')");
			script.println("location.href='bbs.jsp'");
			script.println("</script>");
		}
	%>

<div id="wrap">
  <%
    if(userID==null){//로그인이 되어 있지 않다면
  %>
  <!--Header-->
  <header class="header">
    <div class="header-area">
      <div class="logo">
          <h1><a href="http://locahost:8080/">MyTodo</a></h1>
      </div>
      <div class="login">
        <a href="login.jsp">Login</a>
        <a href="join.jsp">Sign up</a>
      </div>
    </div>
  </header>
  <%
  } else{//로그인이 되어있다면
  %>
  <!--Header-->
  <header class="header">
    <div class="header-area">
      <div class="logo">
          <h1><a href="http://locahost:8080/">MyTodo</a></h1>
      </div>
      <div class="login">
      	<a href="bbs.jsp" style="padding: 16px; font-size: 1.4rem; color: #b89d0e;">Board</a>
        <a href="logoutAction.jsp">Logout</a>
      </div>
    </div>
  </header>
  <%
    }
  %>

    <div class="container">
        <div class="row">
        <form method="post" action="updateAction.jsp?bbsID=<%=bbsID%>">
            <table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
                <thead>
                    <tr>
                        <th colspan="2" style="background-color:#eeeeee; text-align:top; height:30px; width:600px; font-size:14px; vertical-align:middle;">글 작성</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" class="form-control" placeholder="글 제목"  name="bbsTitle" maxlength="50" value="<%=bbs.getBbsTitle() %>" ></td>
                    </tr>
                    <tr>
                        <td><textarea class="form-control" placeholder="글 내용"  name="bbsContent" maxlength="2048" style="height:400px; font-family: 'NanumSquare', sans-serif;"><%=bbs.getBbsContent() %></textarea></td>
                    </tr>
                </tbody>
            </table>
                <input type="submit"  class="btn btn-primary pull-right" value="글 수정">
            </form>
        </div>
    </div>
</div>
<script>
  // list default
  function init() {
    document.getElementById('listdefault').click();
  }
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="./js/listinclude.js"></script>
<script src="./js/clock.js"></script>
<script src="./js/AddPopup.js"></script>
</body>
</html>



