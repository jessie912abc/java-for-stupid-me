<%-- 
    Document   : edit
    Created on : Mar 27, 2020, 6:12:15 PM
    Author     : Jessie
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Article</title>
    <style>
            div{
                border: 1px solid black;
                max-width: 300px;
                margin: 5px;
                text-indent: 3px;
            }
        </style>
        <script type="text/javascript">
            
            function addMoreRow(){
                const div = document.createElement('div');
                div.className ='row';
                div.innerHTML = `
                    <label for="author">Author Name</label>
                    <input type="text" id="author" name="author">
                    <button type="button" value="Add" onclick="removeRow(this)">Remove</button>`;
                document.getElementById('parent_div').appendChild(div);
            }
            function removeRow(input) {
                if(document.getElementById('parent_div').childElementCount < 5){
                    alert("You cannot remove all author");
                }else{
                    document.getElementById('parent_div').removeChild(input.parentNode);
                }
            }
        </script>
    </head>
    <body>
        <form id="form" ation="edit" method="POST">
            <div id="parent_div">
                <h3>Article Info</h3>
                <div >
                    <label for="arid">Article ID</label>
                    <input type="text" id="arid" name="arid" value="${requestScope.article.id}" readonly><br>
                    <label for="title">Title</label>
                    <input type="text" id="title" name="title" value="${requestScope.article.title}"><br>
                    <label for="date">Published Date </label>
                    <input type="date" id="date" name="date" value="${requestScope.article.publishedDate}"><br>
                </div>
                <h3>Author Info</h3>
                <c:forEach items="${requestScope.article.author}" var="ar">
                    <div class="row">
                        <label for="author">Author Name</label>
                        <input type="text" id="author" name="author" value="${ar.name}">
                        <button type="button" value="Add" onclick="removeRow(this)">Remove</button>
                    </div>
                </c:forEach>
            </div>
        </form>
        <button type="button" value="Add" onclick="addMoreRow()">Add</button>
        <button type="submit" form="form" value="Save">Save</button>

    </body>
</html>
