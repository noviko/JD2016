<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="z-top-menu.jsp" %>

<form class="form-horizontal" action="j_security_check" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Авторизация пользователя</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Логин</label>
            <div class="col-md-4">
                <input id="login" name="j_username" type="text" value="tomcat" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-4">
                <input id="password" name="j_password" type="password" value="tomcat" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите пароль</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Войти</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="zz-bottom.jsp" %>
