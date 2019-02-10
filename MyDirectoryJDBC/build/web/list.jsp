<%-- 
    Document   : entry
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
<jsp:useBean id="directory" class="training.webmvc.mydir.Directory" scope="session"></jsp:useBean>

<c:if test="${user.userId eq null}">
    <c:redirect url="login"/>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyDirectory - List</title>
    </head>
    <body>
        <h1>Welcome ${user.salutation}!</h1>
        <h2><%=session.getAttribute("message")%></h2>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>First name</th>
                <th>Last name</th>
                <th>DOB</th>
                <th>Phone</th>
                <th></th>
            </tr>
            <c:forEach var="entry" items="${directory.entries}">
                <tr>
                    <td>${entry.ID}</td>
                    <td>${entry.firstName}</td>
                    <td>${entry.lastName}</td>
                    <td><fmt:formatDate value="${entry.dateOfBirth}" pattern="yyyy-MM-dd"/></td>
                    <td>${entry.phoneNumber}</td>
                    <td><a href="entry?id=${entry.ID}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
        <h6><a href="logout.jsp">Logout</a></h6>
    </body>
</html>
