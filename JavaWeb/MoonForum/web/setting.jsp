<%-- 
    Document   : setting
    Created on : Mar 28, 2020, 1:47:29 PM
    Author     : Jessie
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="moon.png">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.0.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule="" src="https://unpkg.com/ionicons@5.0.0/dist/ionicons/ionicons.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link href="homestyle.css" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

        <title>Settings</title>
        <style>
            td{
                border: none;
                text-align: left;
                background-color: transparent;
                color: black;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
            <a class="navbar-brand" href="home">
                <img src="moon.png" width="38" height="30" class="d-inline-block align-top" alt="">
                Moon Forum
            </a>


            <form class="form-inline my-2 my-lg-0 ml-5 pl-5 flex-grow-1" action="search" method="POST">
                <input class="form-control mr-sm-2"  style="width:70%" type="search" 
                       placeholder="Search" aria-label="Search" name="search">
                <button class="btn btn-create my-sm-0" type="submit">Search</button>
            </form>

            <ul class="navbar-nav">
                <li class="nav-item dropdown ">
                    <a class="nav-link dropdown-toggle" href="" id="navbardrop" data-toggle="dropdown">
                        <ion-icon name="settings-sharp" size="large"></ion-icon>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a class="dropdown-item" href="setting">Settings</a>
                        <a class="dropdown-item" href="logout">Log Out</a>
                    </div>
                </li>
            </ul>    


        </nav>


        <div class="seperator"></div>

        <div class="content-item">
            <div class="row">
                <div class="col-md-8" >
                    <div class="mr-1" style="background-color: #FFE9CA;border-radius: 5px;">
                        <div class="ml-2">
                            <form action="setting" method="POST" >
                                <br>
                                <table>
                                    <tr>
                                        <td style="width:30%">
                                            <label for="displayName" style="display: inline">Your Name: </label>
                                        </td>
                                        <td>
                                            <input type="text" id="displayName" name="displayName" 
                                                   value="${requestScope.user.displayName}" required=""><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="dob" style="display: inline">Your DOB</label>
                                        </td>
                                        <td>
                                            <input type="date" id="dob" name="dob"
                                                   value="${requestScope.user.dob}" required><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="gender" style="display: inline">Gender</label>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${requestScope.user.gender}">
                                                    <input type="radio" id="gender" name="gender" 
                                                           value="1" checked required><h7>Male</h7>
                                                    <input type="radio" id="gender" name="gender" 
                                                           value="0" required><h7>Female</h7><br>
                                                </c:when>
                                                <c:otherwise>
                                                    <input type="radio" id="gender" name="gender" 
                                                           value="1" required><h7>Male</h7>
                                                    <input type="radio" id="gender" name="gender" 
                                                           value="0" checked required><h7>Female</h7><br>
                                                </c:otherwise>
                                            </c:choose>
                                    </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="bio" style="display: inline">Bio Description</label>
                                        </td>
                                        <td>
                                            <input type="text" id="bio" name="bio" 
                                                   value="${requestScope.user.bio}"><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="username"style="display: inline">Your Username</label><br>
                                        </td>
                                        <td>
                                            <input type="text" id="username" name="username" 
                                                   value="${requestScope.user.username}" readonly><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label for="password"style="display: inline">Your Password</label><br>
                                        </td>
                                        <td>
                                            <input type="password" id="password" name="password" 
                                                   value="${requestScope.user.password}" required><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td>
                                            <input class="btn btn-outline" type="submit" value="Save"><br>
                                        </td>
                                    </tr>
                                </table><br>
                            </form>
                        </div>
                    </div><br>
                </div>
                <div class="col-md-4 ">
                    <div class="sticky-top sticky-offset-first" style="background-color: #000000;border-radius: 5px;">
                        <div class="ml-2">
                            <a href="home">
                                <ion-icon name="home-sharp" size="large"></ion-icon><menu>HOME</menu>
                            </a><br>
                            <a href="profile?id=${sessionScope.user.id}">
                                <ion-icon name="person-circle-sharp" size="large"></ion-icon><menu>PROFILE</menu>
                            </a><br>
                            <a href="save">
                                <ion-icon name="layers-outline" size="large"></ion-icon><menu>SAVE</menu>
                            </a><br>
                            <a href="blocklist">
                                <ion-icon name="mail-sharp"size="large"></ion-icon><menu>BLOCK LIST</menu>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
