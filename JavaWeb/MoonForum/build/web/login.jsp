<%-- 
    Document   : login
    Created on : Mar 23, 2020, 4:07:15 PM
    Author     : Jessie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="moon.png">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

        <style>
            body{
                background-image: url("cover.png");
                background-attachment: fixed;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }
            div.container-fluid{
                position: fixed;
                bottom: 150px;
                left: 30px;
            }
            h1{
                color: #FFAA36
            }
            .btn-outline {
                color: #FFAA36;
                background-color: #000000;
                border-color: #FFAA36;
                font-weight: normal;
                border-style: solid;
                border-width: medium;
                border-radius: 5;
            }
            .btn-outline:hover,
            .btn-outline:active,
            .btn-outline:focus,
            .btn-outline.active {
                background: #CC882B;
                color: #000000;
                border-color: #CC882B;

            }
            label{
                font-size: 20px;
                font-weight: 300;
                color: #FFAA36;
            }
            h7{
                color: #CC882B;
            }
            input[type=text] {
                background-color: #FFAA36;
                border-color: #FFAA36;
            }
            input[type=password] {
                background-color: #FFAA36;
                border-color: #FFAA36;
            }
        </style>
        <title>Login</title>
    </head>
    <body>
        <div class="container-fluid">
            <h7>${requestScope.msg}</h7>
            <form action="login" method="POST">
                <label for="username">Username</label><br>
                <input type="text" id="username" name="username" 
                       value="${requestScope.username}"required><br>
                <label for="password">Password</label><br>
                <input type="password" id="password" name="password" required><br><br>
                <input class="btn btn-outline" type="submit" value="Log In">
            </form>
            <label>Do not have an account? <a href="signup">Sign Up Here</a></label>
        </div>
    </body>
</html>
