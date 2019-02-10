<%-- 
    Document   : index
    Created on : 22-Jan-2012, 16:01:56
    Author     : Tanvir
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="training.webmvc.mydir.*"%>
<jsp:useBean id="user" class="training.webmvc.mydir.User" scope="session"></jsp:useBean>

<c:set var="message" value="Please log in"></c:set>
<c:if test="${user.userId ne null}">
    <c:set var="message" value="'${user.salutation}' already logged in"></c:set>
    <c:redirect url="list.jsp"/>
</c:if>
<c:if test="${param['login.userID'] ne null}">
    <c:choose>
        <c:when test="${param['login.userID'] eq initParam.userid
                      && param['login.password'] eq initParam.password }">
            <c:set var="message" value="Success"></c:set>
            <jsp:setProperty name="user" property="userId" value="${param['login.userID']}"></jsp:setProperty>
            <jsp:setProperty name="user" property="salutation" value="${initParam.salutation}"></jsp:setProperty>
            <c:redirect url="list.jsp"/>
        </c:when>
        <c:otherwise>
            <c:set var="message" value="Invalid credentials, please try again"></c:set>
        </c:otherwise>
    </c:choose>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyDirectory - Login</title>
    </head>
    <body>
        <h1>Welcome to my directory!</h1>
        <h2><jsp:text>${message}</jsp:text></h2>
        <form action="login_jstl.jsp" method="post">
            User ID: <input type="text" name="login.userID" id="login.userID" value=""></input>
            Password: <input type="password" name="login.password" id="login.password" value=""></input>
            <input type="submit" id="login.submit" value="Log in"></input>
        </form>
    </body>
</html>
