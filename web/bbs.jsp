<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="bbs.BbsDAO" %>
<%@ page import="bbs.Bbs" %>
​<%@ page import="java.util.ArrayList" %>
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
</head>
<body>
<%
  String userID=null;
  if(session.getAttribute("userID")!=null){
    userID=(String)session.getAttribute("userID");
  }
  int pageNumber = 1;
  if (request.getParameter("pageNumber") != null){
	  pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
  }
%>

<div id="wrap">
  <%
    if(userID==null){//로그인이 되어 있지 않다면
  %>
  <!--Header-->
  <header class="header">
    <div class="header-area">
      <div class="logo" >
      	<h1><a href="http:osw8team.kro.kr:8080/">MyTodo</a></h1>
      </div>
      <div class="login">
       <a href="bbs.jsp" style="padding: 16px; font-size: 1.4rem; color: #b89d0e;">Board</a>
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
          <h1><a href="http:osw8team.kro.kr:8080/">MyTodo</a></h1>
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
            <table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
                <thead>
                    <tr>
                        <th style="background-color:#eeeeee; text-align:center;">번호</th>
                        <th style="background-color:#eeeeee; text-align:center;">제목</th>
                        <th style="background-color:#eeeeee; text-align:center;">작성자</th>
                        <th style="background-color:#eeeeee; text-align:center;">작성일자</th>
                    </tr>
                </thead>
                <tbody>
					<%
						BbsDAO bbsDAO = new BbsDAO();
						ArrayList<Bbs> list = bbsDAO.getList(pageNumber);
						for(int i=0;i<list.size();i++){
					%>
					<tr>
						<td><%= list.get(i).getBbsID() %></td><%--현재 게시글에 대한 정보 --%>
						<td><a href="view.jsp?bbsID=<%= list.get(i).getBbsID() %>"><%= list.get(i).getBbsTitle() %></a></td>
						<td><%= list.get(i).getUserID() %></td>
						<td><%= list.get(i).getBbsDate().substring(0,11)+list.get(i).getBbsDate().substring(11,13)+"시"+list.get(i).getBbsDate().substring(14,16)+"분" %></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<%
				if(pageNumber!=1){
			%>
				<a href="bbs.jsp?pageNumber=<%=pageNumber - 1 %>" class="btn btn-primary btn-arrow-left">이전</a>
			<%
				} if(bbsDAO.nextPage(pageNumber+1)){
			%>
				<a href="bbs.jsp?pageNumber=<%=pageNumber + 1 %>" class="btn btn-primary btn-arrow-left">다음</a>
			<%
				}%>
            <a href="write.jsp" class="btn btn-primary pull-right">글쓰기</a>
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
