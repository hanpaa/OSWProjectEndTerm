<%--
  Created by IntelliJ IDEA.
  User: s85737
  Date: 21. 5. 8.
  Time: 오후 4:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>MyToDo</title>
  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div id="wrap">
  <!--Header-->
  <header class="header">
    <div class="header-area">
      <div class="logo">
        <h1><a href="#">MyTodo</a></h1>
      </div>
      <div class="login">
        <a href="#">Login</a>
        <a href="#">Sign up</a>
      </div>
    </div>
  </header>
  <!--Banner-->
  <div class="banner">
    <div class="banner-area">
      <div class="time js-time">
        <h2>00:00</h2>
        <p>2020년 3월 10일 화요일</p>
      </div>
    </div>
  </div>
  <!--Contents-->
  <article class="list">
    <div class="list-area">
      <div class="todo-list-sort">
        <div class="sort-method">
          <a href="#" onclick="list('list/list-todo.html')" id="listdefault">할일</a>
          <a href="#" onclick="list('list/list-end.html')">했당</a>
        </div>
      </div>
      <!----------------------리스트 들어가는 곳---------------------->
      <div class="todo-list" id="listinclude">
      </div>
      <!------------------------------------------------------------>
    </div>
  </article>
  <!--bottom nav-->
  <footer class="nav" id="nav">
    <div class="nav-area">
      <div class="nav-area-plus">
        <button type="button" onclick="openPopUp()">
          <svg width="16" height="16" viewBox="0 0 16 16" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M16 6.85714H9.14286V0H6.85714V6.85714H0V9.14286H6.85714V16H9.14286V9.14286H16V6.85714Z" fill="#D20BBE"/>
          </svg>
        </button>
      </div>
    </div>
  </footer>

  <div class="popup">
    <div class="add-todo">
      <div class="head">
        <h3>Name</h3>
        <a href="#" onclick="closePopUp()"><svg width="13" height="13" viewBox="0 0 13 13" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path d="M11.5 1L1 11.5" stroke="#979797" stroke-width="2"/>
          <path d="M1 1L11.5 11.5" stroke="#979797" stroke-width="2"/>
        </svg>
        </a>
      </div>
      <form>
        <textarea name="text" rows="1" cols="10" wrap="soft" placeholder="언제까지 할꺼야"></textarea>
        <textarea name="text" rows="5" cols="10" wrap="soft" placeholder="메모"></textarea>
        <button type="submit">확인</button>
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
<script src="js/listinclude.js"></script>
<script src="../todofrontend/src/assets/clock.js"></script>
<script src="js/AddPopup.js"></script>
</body>
</html>
