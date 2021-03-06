<%-- 
    Document   : profile
    Created on : Mar 25, 2020, 11:07:25 AM
    Author     : Jessie
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="moon.png">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script type="module" src="https://unpkg.com/ionicons@5.0.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule="" src="https://unpkg.com/ionicons@5.0.0/dist/ionicons/ionicons.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link href="homestyle.css" rel="stylesheet" type="text/css">

        <title>${requestScope.user.displayName}</title>

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
                    <c:if test="${requestScope.user.username == sessionScope.user.username}">
                        <div class="mr-1" style="background-color: #FFE9CA;border-radius: 5px;">
                            <div class="ml-2">
                                <form action="home" method="POST">
                                    <b>Write something</b><br>
                                    <textarea name="content" rows="2" cols="35"></textarea><br>
                                    <input class="btn-create mb-3" type="submit" value="Post">
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <div class="seperator"></div>
                    <c:forEach items="${requestScope.status}" var="s">
                        <div class="mr-1" style="background-color: #FFE9CA;border-radius: 5px;">
                            <div class="ml-2">
                                <b>${requestScope.user.displayName} said</b>
                                <p>${s.content}</p>
                                <p>at ${s.publishDate}</p>
                                <!--A bar to display like and comment view-->
                                <div id="bar" class="container-fluid">

                                    <!--Like button-->
                                    <form id="likeForm${s.id}" method="POST" style="display: inline" >
                                        <c:set var="liked" value="false" />
                                        <c:forEach var="l" items="${s.like}">
                                            <c:if test="${l.username eq sessionScope.user.username}">
                                                <c:set var="liked" value="true" />
                                            </c:if>
                                        </c:forEach>
                                        <c:choose>
                                            <c:when test="${!liked}">
                                                <button class="btn-like" type="submit" id="likeBtn${s.id}">
                                                    <span class="far fa-heart" style="color:black"></span>
                                                </button>
                                            </c:when>
                                            <c:otherwise>
                                                <button class="btn-like" type="submit" id="likeBtn${s.id}">
                                                    <span class="fas fa-heart" style="color:black"></span>
                                                </button>
                                            </c:otherwise>
                                        </c:choose>
                                        <input type="hidden" name="statusid" value="${s.id}">

                                    </form>
                                    <!--Submit form with AJAX-->   
                                    <script>
                                        $('#likeForm${s.id}').submit(function (e) {
                                            e.preventDefault();
                                            $.ajax({
                                                type: 'POST',
                                                url: 'like',
                                                data: $('#likeForm${s.id}').serialize()
                                            });
                                            return false;
                                        });
                                    </script>

                                    <!--Number of like and show list people who like-->
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn-create" data-toggle="modal" 
                                            data-target="#likeModalCenter${s.id}" id="numLike${s.id}">
                                        ${s.like.size()} Likes
                                    </button>

                                    <!--Script to change icon and change number of like-->
                                    <script type="text/javascript">
                                        jQuery(function ($) {
                                            $('#likeBtn${s.id}').on('click', function () {
                                                var $el = $(this);
                                                $el.find('span').toggleClass('fas');
                                                $('#numLike${s.id}').html('${s.like.size()+1} Likes');
                                            });
                                        });
                                    </script>

                                    <!-- Modal -->
                                    <div class="modal fade" id="likeModalCenter${s.id}" tabindex="-1" role="dialog" aria-labelledby="likeModalCenterTitle" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="likeModalLongTitle">Like</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn-create" data-dismiss="modal">Close</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!--JS Query to send data to modal-->
                                    <script type="text/javascript">
                                        $('#likeModalCenter${s.id}').on('show.bs.modal', function (event) {
                                            var modal = $(this);
                                            modal.find('.modal-title').text('Like');
                                        <c:if test="${s.like.size() == 0}">
                                            modal.find('.modal-body ').html('<p>No one like this post</p>');
                                        </c:if>
                                        <c:forEach items="${s.like}" var="li" >
                                            modal.find('.modal-body ').html('<p>${li.displayName}</p><br>');
                                        </c:forEach>
                                        })
                                    </script>


                                    <!--Number of comment and show list comment-->
                                    <button class="btn-create" type="button" data-toggle="collapse" data-target="#showComment${s.id}" 
                                            aria-expanded="false" aria-controls="showComment${s.id}">
                                        ${s.comment.size()} comments
                                    </button>

                                    <!--Save a status-->
                                    <form style="display: inline" action="save" method="POST">
                                        <input type="hidden" name="statusid" value="${s.id}">
                                        <button class="btn-create" type="submit">Save Post</button>
                                    </form>

                                    <br><br>

                                    <!--Collapsed item to show comment-->
                                    <div class="collapse" id="showComment${s.id}">
                                        <c:forEach items="${s.comment}" var="com">
                                            <div class="ml-3 mr-3" style="border-radius: 5px; border: 1px solid black">
                                                <p style="font-weight: bold; display: inline">${com.user.displayName}</p>
                                                <p style="display: inline">${com.content}</p><br>
                                                <p style="font-weight: 100; font-size: 10px; display:inline">${com.time}</p>
                                            </div><br>
                                        </c:forEach><br>
                                    </div>
                                </div>

                                <!--Write a new comment-->
                                <form action="comment" method="POST">
                                    <input type="text" id="comment" name="comment" onfocus="this.value = ''" 
                                           value="Write your comment" >
                                    <input type="hidden" name="statusid" value="${s.id}">
                                    <input class="btn-create" type="submit" value="Comment" style="border-color: black;border-width: thin;">
                                </form><br>
                            </div>
                        </div><br>
                    </c:forEach>
                </div>
                <div class="col-md-4 ">
                    <div class="sticky-top sticky-offset-first" style="background-color: #000000;border-radius: 5px;">
                        <div class="ml-2 mr-1">
                            <h3>${requestScope.user.displayName}</h3>
                            <bio>${requestScope.user.bio}</bio>
                            <br><br>
                            <table>
                                <tr>
                                    <th>Status</th>
                                    <th>Followers</th>
                                    <th>Following</th>
                                </tr>
                                <tr>
                                    <td>${requestScope.status.size()}</td>
                                    <td><!--Show list follower here-->
                                        <!-- Button trigger modal -->
                                        <a id='numFler' href="" data-toggle="modal" data-target="#followerModalCenter"
                                           style="color: #FFAA36">
                                            ${requestScope.follower.size()}
                                        </a>

                                    </td>
                                    <td>
                                        <a id='numFling' href="" data-toggle="modal" 
                                           data-target="#followingModalCenter" style="color: #FFAA36">
                                            ${requestScope.following.size()}
                                        </a>
                                    </td>
                                </tr>
                            </table>
                            <!--Follow or Unfollow-->
                            <form id="follow" method="POST" action="follow" style="display: inline">
                                <input type="hidden" name="followee" value="${requestScope.user.id}">
                                <c:if test="${sessionScope.user.username != requestScope.user.username}">
                                    <button id='btnFl' class="btn-create" type="submit">
                                        <c:set var="contains" value="false" />
                                        <c:forEach var="fl" items="${requestScope.follower}">
                                            <c:if test="${fl.username eq sessionScope.user.username}">
                                                <c:set var="contains" value="true" />
                                            </c:if>
                                        </c:forEach>
                                        <c:choose>
                                            <c:when test="${!contains}">
                                                Follow
                                            </c:when>
                                            <c:otherwise>
                                                Following
                                            </c:otherwise>
                                        </c:choose>
                                    </button>
                                </c:if>
                            </form>
                            <!--Submit form with AJAX-->   
                            <script>

                                $('#follow').submit(function (e) {

                                    e.preventDefault();
                                <c:if test="${!contains}">
                                    $.ajax({
                                        type: 'POST',
                                        url: 'follow',
                                        data: $('#follow').serialize()
                                    });
                                    $('#btnFl').html('Following');
                                    $('#numFler').html(${requestScope.follower.size() +1})
                                    return false;
                                </c:if>
                                });

                            </script>
                            <!--Block or unblock-->
                            <form id="block" method="POST" action="block" style="display: inline">
                                <input type="hidden" name="blockid" value="${requestScope.user.id}">
                                <c:if test="${sessionScope.user.username != requestScope.user.username}">
                                    <button id='btnBl' class="btn-create" type="submit">Block</button>
                                </c:if><br>
                            </form>
                            <!--Submit form with AJAX-->   
                            <script>

                                $('#block').submit(function (e) {
                                    e.preventDefault();
                                    $.ajax({
                                        type: 'POST',
                                        url: 'block',
                                        data: $('#block').serialize()
                                    });
                                    $('#btnBl').html('Blocked');
                                    return false;
                                });
                            </script>
                        </div><br>    
                    </div>
                    <div class="sticky-top sticky-offset-second" style="background-color: #000000;border-radius: 5px;">
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

        <!-- Modal to display followers-->
        <div class="modal fade" id="followerModalCenter" tabindex="-1" role="dialog" aria-labelledby="followerModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="followerModalLongTitle">Followers</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn-create" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal to display following-->
        <div class="modal fade" id="followingModalCenter" tabindex="-1" role="dialog" aria-labelledby="followingModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="followingModalLongTitle">Following</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn-create" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <!--JS Query to send data to modal-->
        <script type="text/javascript">
            //send data to  foller modal
            $('#followerModalCenter').on('show.bs.modal', function (event) {
                var modal = $(this);
                modal.find('.modal-title').text('Follower');
            <c:choose>
                <c:when test="${requestScope.follower.size() == 0}">
                modal.find('.modal-body ').html('<p>No one follow this account</p>');
                </c:when>
                <c:otherwise>
                modal.find('.modal-body ').html('<p>${requestScope.following.size()} People </p>');
                    <c:forEach items="${requestScope.follower}" var="fl" >
                modal.find('.modal-body ').append(`<a href="profile?id=${fl.id}">${fl.displayName}</a><br>`);
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            })

            //send data to following modal
            $('#followingModalCenter').on('show.bs.modal', function (event) {
                var modal = $(this);
                modal.find('.modal-title').text('Following');
            <c:choose>
                <c:when test="${requestScope.following.size() == 0}">
                modal.find('.modal-body ').html('<p>This account do not follow anyone</p>');
                </c:when>
                <c:otherwise>
                modal.find('.modal-body ').html('<p>${requestScope.following.size()} People </p>');
                    <c:forEach items="${requestScope.following}" var="fl" >
                modal.find('.modal-body ').append(`<a href="profile?id=${fl.id}">${fl.displayName}</a><br>`);
                    </c:forEach>
                </c:otherwise>
            </c:choose>

            })
        </script>
    </body>
</html>
