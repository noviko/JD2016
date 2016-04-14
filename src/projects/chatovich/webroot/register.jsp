<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta http-equiv="Cache-Control" content="no-cache">
    <title>Старт обработки форм для сервлетов</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/bootsnip-grey-menu.css" rel="stylesheet" />
    <link href="css/bootsnipp-login.css" rel="stylesheet" />
    <script src="js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</head>

<script type="text/javascript">
    function validate (form){
    var n = form.name.value;
    var s = form.name.value;
    if(! (/^[a-zA-Zа-яА-ЯёЁ]+$/.test(form.name.value))){
    <!--document.getElementById('name').innerHTML = 'имя должно состоять только из букв!';-->
    alert('имя должно состоять только из букв!');
return false;
    }
    if(! (/^[a-zA-Zа-яА-ЯёЁ]+$/.test(form.surname.value))){
    <!--document.getElementById('surname').innerHTML = 'фамилия должна состоять только из букв!';-->
    alert('фамилия должна состоять только из букв!');
return false;
}
return true;
}


</script>

<body>
<form name = "register" action="register/" method="POST" class="form-horizontal" onSubmit="return validate(this)">

<div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar navbar-fixed-top">
            <div class="container">
            <div id="navbar" class="navbar-collapse collapse">
                                <ul class="nav navbar-nav">
                                    <li><a href="login.html" class="">Log in</a></li>
                                    <li><a href="register.jsp">Register</a></li>
                                    <li><a href="search.html" class="">Search</a></li>
                                </ul>
            </div>
            </div>
        </nav>
    </div>
</div>


<div class = "container">
        <div class="wrapper">
            <form action="" method="post" name="Login_Form" class="form-signin">
                <h3 class="form-signin-heading">Fill the registration form</h3>
                <hr class="colorgraph"><br>


                <input type="text" class="form-control" name="name" placeholder="First name" required="" autofocus="" />
                <input type="text" class="form-control" name="surname" placeholder="Last name" required=""/>
                <input type="text" class="form-control" name="login" placeholder="Login" required=""/>
                <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
                <input type="date" class="form-control" name="birthdate" placeholder="Birthdate" required=""/>
                <input type="text" class="form-control" name="city" placeholder="City" required=""/>
                <input type="email" class="form-control" name="email" placeholder="Email" required=""/>
                <input type="text" class="form-control" name="describtion" placeholder="Describe yourself and the place where you live"/>

                <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Register" type="Submit">Register</button>
            </form>
        </div>
    </div>








</form>


</body>
</html>