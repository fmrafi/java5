<%-- 
    Document   : index
    Created on : 22-Jan-2012, 16:01:56
    Author     : Tanvir
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${param['lang'] != null}">
    <fmt:setLocale value="${param['lang']}" scope="session" />
</c:if>
<fmt:setBundle basename="messages" scope="session" var="messages"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyDirectory - Login</title>
    </head>
    <body>
        <h1><fmt:message bundle="${messages}" key="welcome"/></h1>
        <h2><%=session.getAttribute("message")%></h2>
        <form action="login" method="post">
            <fmt:message bundle="${messages}" key="userid"/>: <input type="text" name="login.userID" id="login.userID" value=""></input>
            Password: <input type="password" name="login.password" id="login.password" value=""></input>
            <input type="submit" id="login.submit" value="Log in"></input>
        </form>
        <h6>
            <a href="?lang=en">English</a>&nbsp;
            <a href="?lang=bn">Bangla</a>
            <a href="?lang=zh">Chinese</a>
        </h6>
    </body>
</html>
