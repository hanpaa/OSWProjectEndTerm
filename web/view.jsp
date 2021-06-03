<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="bbs.Bbs" %>
<%@ page import="bbs.BbsDAO" %>
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
	%>

   <div id="wrap">
  <%
    if(userID==null){//로그인이 되어 있지 않다면
  %>
  <!--Header-->
  <header class="header">
    <div class="header-area">
      <div class="logo">
          <h1><a href="http://osw8team.kro.kr:8080/">MyTodo</a></h1>
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
          <h1><a href="http://osw8team.kro.kr:8080/">MyTodo</a></h1>
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
        <div class="row" style="font-size: 14px;">
            <table class="table table-striped" style="text-align:center; border:1px solid #dddddd;">
                <thead>
                    <tr>
                        <th colspan="3" style="background-color:#eeeeee; text-align:center;">게시글</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td style="width:20%;">제목</td>
                        <td colspan="2"><%= bbs.getBbsTitle().replaceAll(" ","&nbsp;").replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n","<br>") %></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td colspan="2"><%= bbs.getUserID() %></td>
                    </tr>
                    <tr>
                        <td>작성일자</td>
                        <td colspan="2"><%= bbs.getBbsDate().substring(0,11) + bbs.getBbsDate().substring(11, 13) + "시"
                                + bbs.getBbsDate().substring(14,16) + "분"  %></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td colspan="2" style="min-height:200px; text-align:left;">
                        <%= bbs.getBbsContent().replaceAll(" ","&nbsp;").replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n","<br>") %></td>
                    </tr>
                </tbody>
            </table>
            <a href="bbs.jsp" class="btn btn-success">목록</a>
				<%
					if(userID != null && userID.equals(bbs.getUserID())){
				%>
						<a href="update.jsp?bbsID=<%=bbsID%>" class="btn btn-warning">수정</a>
						<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="deleteAction.jsp?bbsID=<%=bbsID%>" class="btn btn-danger">삭제</a>
				<%
					}
				%>
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
<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>




