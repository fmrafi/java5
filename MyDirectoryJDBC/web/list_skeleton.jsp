<%-- 
    Document   : entry
    Created on : 22-Jan-2012, 17:38:21
    Author     : Tanvir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="training.webmvc.mydir.*"%>
<jsp:useBean id="user" class="training.webmvc.mydir.User" scope="session"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyDirectory - List</title>
    </head>
    <body>
        <h1>Welcome <jsp:getProperty name="user" property="salutation"></jsp:getProperty>!</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>First name</th>
                <th>Last name</th>
                <th>DOB</th>
                <th>Phone</th>
            </tr>
        </table>
        <h6><a href="logout.jsp">Logout</a>
    </body>
</html>
