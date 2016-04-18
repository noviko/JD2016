<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="ru">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Базовый шаблон для JSP</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>
<body>

<div class="container">

      <div class="navbar navbar-default" role="navigation" >
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Главная</a>
          </div>
          <div class="navbar-collapse collapse">

            <ul class="nav navbar-nav">
              <li><a href=".">Мой кабинет</a></li>
              <li><a href="createad.jsp">Добавить авто</a></li>
              <li><a href="readUsers">Добавить заказ</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
              <li><a href="signup.jsp">Зарегистрироваться</a></li>
              <li><a href="signin.jsp">Вход</a></li>
              <li><a href="signout.jsp">Выход</a></li>
            </ul>

          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </div>