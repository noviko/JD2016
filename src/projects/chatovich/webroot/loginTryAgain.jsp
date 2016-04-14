<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Старт обработки форм для сервлетов</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/bootsnipp-login.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>

<body>
<form action="login/" method="POST" class="form-horizontal">

    <div class = "container">
        <div class="wrapper">
            <form action="" method="post" name="Login_Form" class="form-signin">
                <h3 class="form-signin-heading1">Non-valid login or password<br>Please try again</h3>
                <hr class="colorgraph"><br>


                <input type="text" class="form-control" name="login" placeholder="Login" required="" autofocus="" />
                <input type="password" class="form-control" name="password" placeholder="Password" required=""/>

                <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>
            </form>
        </div>
    </div>

</form>



</body>
</html>