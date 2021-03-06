<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="org.academiadecodigo.loginmvc.controller.RegisterController" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tomás Amaro Super Login</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Flat Sign Up Form Responsive Widget Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- Meta tag Keywords -->
    <!-- css files -->
    <link href="resources/style.css" rel="stylesheet" type="text/css" media="all">
    <!-- //css files -->
    <!-- online-fonts -->
    <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic'
          rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Raleway+Dots' rel='stylesheet' type='text/css'>
</head>
<body>
<!--header-->
<div class="header-w3l">
    <h1>Cadet Helper</h1>
</div>
<!--//header-->
<!--main-->
<div class="main-agileits">
    <h2 class="sub-head">Register</h2>
    <div class="sub-main">
        <form:form action="#" modelAttribute="userReg" method="post">
            <form:input path="name" placeholder="Name" name="registerName" class="name" type="text" required=""/>
            <form:input path="email" placeholder="Email" name="registerEmail" class="name" type="text" required=""/>
            <form:errors path="email" cssStyle="font-size: 10px;color: yellow;"/>
           <div class="select-style">
            <form:select path="role" placeholder="Role" name="registerRole">
                <form:option value="mastercoder">Master Coder</form:option>
                <form:option value="padawan">Padawan Master Coder</form:option>
                <form:option value="cadet">Code Cadet</form:option>
                <form:option value="padawancadet">Padawan Code Cadet</form:option>
                </form:select>
           </div>
            <form:input path="password" placeholder="Password" name="registerPassword" class="name2" type="password" required=""/>
            <form:errors path="password" cssStyle="font-size: 10px;color: yellow;"/>
            <form:input path="password2" placeholder="Confirm Password" name="registerPassword2" class="name2" type="password" required=""/>
            <input type="submit" value="Register">
        </form:form>
    </div>
    <div class="clear"></div>
</div>
<!--//main-->

<!--footer-->
<div class="subhead">
    <h3><a href="/">REGISTER</a></h3>
</div>
<br>
<div class="footer-w3">
    <p>&copy; Academia de Código</p>
    </br>
</div>
<!--//footer-->

</body>
</html>
