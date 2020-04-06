<%-- 
    Document   : list
    Created on : Mar 27, 2020, 5:43:20 PM
    Author     : Jessie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            table{
                width: 40%;
                table-layout: fixed;
            }
            tr,td,th{
                border: 1px solid black;
            }
        </style>
        <title>List Article</title>
    </head>
    <body>
        <table >
            <tr>
                <th style="width: 35%">Article</th>
                <th style="width: 35%">Authors</th>
                <th style="width: 20%">Published</th>
                <th style="width: 10%">Modify</th>
            </tr>
            <c:forEach items="${requestScope.articles}" var="arti">
                <tr>
                    <td>${arti.title}</td>
                    <td>
                        <c:forEach items="${arti.author}" var="au">
                            ${au.name} <br>
                        </c:forEach>
                    </td>
                    <td>${arti.publishedDate}</td>
                    <td>
                        <a href="edit?id=${arti.id}">Edit</a><br>
                        <a href="delete?id=${arti.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            
        </table>
        <a href="add"><button type="button" value="Add">Add</button></a>
    </body>
</html>
