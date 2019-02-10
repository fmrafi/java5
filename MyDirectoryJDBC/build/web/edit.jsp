<%-- 
    Document   : edit
    Created on : 22-Jan-2012, 17:38:21
    Author     : Tanvir
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="training.webmvc.mydir.*"%>
<jsp:useBean id="user" class="training.webmvc.mydir.User" scope="session"></jsp:useBean>
<jsp:useBean id="entry" class="training.webmvc.mydir.DirectoryEntry" scope="session"></jsp:useBean>

<c:if test="${user.userId eq null}">
    <c:redirect url="login"/>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyDirectory - Edit</title>
    </head>
    <body>
        <h1>Welcome ${user.salutation}!</h1>
        <h2>Edit ${entry.ID} - ${entry.firstName}</h2>
        <form action="entry" method="post">
            <table>
                <tr>
                    <th>ID</th>
                    <td>${entry.ID}</td>
                <tr>
                </tr>
                    <th>First name</th>
                    <td><input type="text" name="entry.firstName" value="${entry.firstName}"></td>
                <tr>
                </tr>
                    <th>Last name</th>
                    <td><input type="text" name="entry.lastName" value="${entry.lastName}"></td>
                <tr>
                </tr>
                    <th>DOB</th>
                    <td><input type="text" name="entry.dateOfBirth" value="<fmt:formatDate value="${entry.dateOfBirth}" pattern="yyyy-MM-dd"/>"></td>
                <tr>
                </tr>
                    <th>Phone</th>
                    <td><input type="text" name="entry.phoneNumber" value="${entry.phoneNumber}"></td>
                </tr>
            </table>
            <input type="submit" value="Submit"></input>
        </form>
        <h6><a href="list.jsp">Go to list</a></h6>
    </body>
</html>
