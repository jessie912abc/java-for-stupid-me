<%-- 
    Document   : signup
    Created on : Mar 23, 2020, 4:37:14 PM
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
                bottom: 50px;
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
                color:#FFAA36;
                font-weight: 300;
            }
            input[type=text],input[type=password], input[type=date], input[type=radio]{
                background-color: #FFAA36;
                border-color: #FFAA36;
            }
        </style>
        <title>Sign Up </title>
    </head>
    <body>
        <div class="container-fluid">
            <form action="signup" method="POST">
                <label for="username">Your Username</label><br>
                <input type="text" id="username" name="username" required><br>
                <label for="password">Your Password</label><br>
                <input type="password" id="password" name="password" required><br>
                <label for="displayName">What should we call you? </label><br>
                <input type="text" id="displayName" name="displayName" required><br>
                <label for="dob">Your DOB</label><br>
                <input type="date" id="dob" name="dob" required><br>
                <label for="gender">Gender</label><br>
                <input type="radio" id="gender" name="gender" value="1" required><h7>Male</h7>
                <input type="radio" id="gender" name="gender" value="0" required><h7>Female</h7><br>
                <label for="bio">Describe Yourself</label><br>
                <input type="text" id="bio" name="bio"><br><br>
                <input class="btn btn-outline" type="submit" value="Sign Up">
            </form>
            <label>Already have an account? <a href="login">Log In Here</a></label>
        </div>
       
    </body>
</html>
