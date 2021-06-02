<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>

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
//
//  URL url = new URL("http://localhost:8081/api/todos/s85737/todolist/");
//  HttpURLConnection con = (HttpURLConnection) url.openConnection();
//  con.setRequestMethod("GET"); //기본적으로 조회 시 사용되는 GET
//
//  int status = con.getResponseCode();
//  BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//  String inputLine;
//  StringBuffer content = new StringBuffer();
//
//  while((inputLine = in.readLine()) != null)
//    content.append(inputLine);
//
//  in.close();
//  con.disconnect();
//
//  System.out.println("Response status: " + status);
//  System.out.println(content.toString());


%>

<div id="wrap">
  <%
    if(userID==null){//로그인이 되어 있지 않다면
  %>
  <!--Header-->
  <header class="header">
    <div class="header-area">
      <div class="logo">
        <h1><a href="index.jsp">MyTodo</a></h1>                      
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
        <h1><a href="index.jsp">MyTodo</a></h1>
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

  <!--Banner-->
  <div class="banner">
    <div class="banner-area">
      <div class="time js-time">
        <h2>00:00</h2>
        <p>2021년 6월 18일 금요일</p>
      </div>
    </div>
  </div>
    
    <div class="container">
        <div class="row">
        <form method="post" action="writeAction.jsp">
            <table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
                <thead>
                    <tr>
                        <th colspan="2" style="background-color:#eeeeee; text-align:top; height:30px; width:600px; font-size:14px; vertical-align:middle;">글 작성</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td><input type="text" class="form-control" placeholder="글 제목"  name="bbsTitle" maxlength="50" ></td>
                    </tr>
                    <tr>
                    <td><textarea class="form-control" placeholder="글 내용"  name="bbsContent" maxlength="2048" style="height:400px; font-family: 'NanumSquare', sans-serif;"></textarea></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit"  class="btn btn-primary pull-right" value="글 작성">     
            </form>
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
