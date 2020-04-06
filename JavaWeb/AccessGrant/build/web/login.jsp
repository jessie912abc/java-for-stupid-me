<%-- 
    Document   : login
    Created on : Mar 24, 2020, 2:37:58 PM
    Author     : Jessie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" id="username" name="username"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" id="password" name="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
