<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="z-top-menu.jsp" %>

<form class="form-horizontal" action="createUser" method="post">
    <fieldset>

        <!-- Form Name -->
        <legend>Регистрация нового пользователя</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="id">id пользователя</label>
            <div class="col-md-4">
                <input id="id" name="ID" value="0" type="text"
                placeholder="" class="form-control input-md" required="">
                <span class="help-block">Это поле будет скрыто</span>
            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
                    <label class="col-md-4 control-label" for="Name">Имя</label>
                    <div class="col-md-4">
                        <input id="name" name="Name" type="text" placeholder="" class="form-control input-md" required="">
                        <span class="help-block">Введите Ваше имя</span>
                    </div>
                </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Логин</label>
            <div class="col-md-4">
                <input id="login" name="Login" type="text" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите Ваш логин</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="password">Пароль</label>
            <div class="col-md-4">
                <input id="password" name="Password" type="password" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Введите пароль не менее 8 символов</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="email">E-mail</label>
            <div class="col-md-4">
                <input id="email" name="Email" type="text" placeholder="" class="form-control input-md" required="">
                <span class="help-block">Укажите E-mail</span>
            </div>
        </div>
        <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="phone">Телефон</label>
                    <div class="col-md-4">
                        <input id="phone" name="Phone" type="text" placeholder="" class="form-control input-md" required="">
                        <span class="help-block">Укажите номер телефона</span>
                    </div>
                </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="role">Роль пользователя</label>
            <div class="col-md-4">
                <select id="role" name="FK_role" class="form-control">
                    <option value="2">User</option>
                    <option value="1">Administrator</option>
                </select>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Зарегистрировать</button>
            </div>
        </div>
    </fieldset>
</form>

<%@ include file="zz-bottom.jsp" %>
