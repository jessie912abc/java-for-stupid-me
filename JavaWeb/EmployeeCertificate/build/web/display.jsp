<%-- 
    Document   : display
    Created on : Mar 5, 2020, 8:41:52 PM
    Author     : Jessie
--%>

<%@page import="model.Certificate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.temporal.ChronoUnit;"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.LocalDate"%>
<%@page import="model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Employee Certificate</title>
    </head>
    <body>

        <%
            ArrayList<Employee> listEmp = (ArrayList<Employee>) request.getAttribute("listEmp");
            LocalDate date = LocalDate.now();
            int dayOfWeek = date.getDayOfWeek().getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        %>
        <h2>Current Date: <%=formatter.format(date).toString()%></h2>

        <style>
            table,th,td{
                border: 1px solid black;
            }
            table {
                width: 70%;
            }

            th,td {
                height: 50px;
                text-align: center;
            }
            .red {
                background: red; 
            } 
            .blue {
                background: blue;
            }
        </style>
        <table>
            <tr>
                <%
                    
                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM");
                    LocalDate monday = date.minusDays(dayOfWeek - 1);
                %>
                <th>Employee</th>
                <th <%if (formatter1.format(monday).equals(date))%>
                      class =" blue"  >
                    <%= formatter1.format(monday)%></th>
                <th <%if (formatter1.format(monday.plusDays(1)).equals(date))%>
                      class =" blue"  >
                    <%= formatter1.format(monday.plusDays(1))%></th>
                <th <%if (formatter1.format(monday.plusDays(2)).equals(date))%>
                      class =" blue" >
                    <%= formatter1.format(monday.plusDays(2))%></th>
                <th <%if (formatter1.format(monday.plusDays(3)).equals(date))%>
                      class =" blue" >
                    <%= formatter1.format(monday.plusDays(3))%></th>
                <th <%if (formatter1.format(monday.plusDays(4)).equals(date))%>
                      class =" blue" > 
                    <%= formatter1.format(monday.plusDays(4))%></th>
                <th <%if (formatter1.format(monday.plusDays(5)).equals(date))%>
                      class =" blue" >
                    <%= formatter1.format(monday.plusDays(5))%></th>
                <th <%if (formatter1.format(monday.plusDays(6)).equals(date))%>
                      class =" blue" >
                    <%= formatter1.format(monday.plusDays(6))%></th>
            </tr>
            <%
                for (Employee e : listEmp) {%>
            <tr>
                <td><%= e.getName()%></td>   
                <%
                    ArrayList<Certificate> listCert = e.getCert();                    
                %>
                 <td
                    <% 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday);
                            if(minus ==0){%> class = "red">
                    <%=c.getTitle()+"<br>"%>
                    <%}}%>
                </td> 
                 <td
                    <% 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(1));
                            if(minus ==0){%> class = "red">
                    <%=c.getTitle()+"<br>"%>
                    <%}}%>
                </td> 
                 <td
                    <% 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(2));
                            if(minus ==0){%> class = "red">
                    <%=c.getTitle()+"<br>"%>
                    <%}}%>
                </td> 
                <td
                    <% 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(3));
                            if(minus ==0){%> class = "red">
                    <%=c.getTitle()+"<br>"%>
                    <%}}%>
                </td> 
                 <td
                    <% 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(4));
                            if(minus ==0){%> class = "red">
                    <%=c.getTitle()+ "<br>"%>
                    <%}}%>
                </td>  
                 <td
                    <% 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(5));
                            if(minus ==0){%> class = "red">
                    <%=c.getTitle()+"<br>"%>
                    <%}}%>
                </td> 
                 <td
                    <% 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(6));
                            if(minus ==0){%> class = "red">
                    <%=c.getTitle()+"<br>"%>
                    <%}}%>
                </td> 
            </tr>
            <%}%>
        </table>

    </body>
</html>
