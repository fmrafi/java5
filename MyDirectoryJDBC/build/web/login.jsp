<%-- 
    Document   : index
    Created on : 22-Jan-2012, 16:01:56
    Author     : Tanvir
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="training.webmvc.mydir.*"%>
<jsp:useBean id="user" class="training.webmvc.mydir.User" scope="session"></jsp:useBean>

<%
String message = "Please log in";
if (user.getUserId() != null) {
    // user already logged in, go to list
    //pageContext.forward("list.jsp");
    response.sendRedirect("list.jsp");
}

if (request.getParameter("login.userID") != null) {
    // check credentials
    if (request.getParameter("login.userID").equals(application.getInitParameter("userid")) && 
            request.getParameter("login.password").equals(application.getInitParameter("password"))) {
        user.setUserId(request.getParameter("login.userID"));
        user.setSalutation(application.getInitParameter("salutation"));
        // success, go to list
        //pageContext.forward("list.jsp");
        response.sendRedirect("list.jsp");
    } else {
        // failed, show error
        //out.write("invalid user");
        message = "Invalid credentials, please try again";
    }
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyDirectory - Login</title>
    </head>
    <body>
        <h1>Welcome to my directory!</h1>
        <h2><jsp:expression>message</jsp:expression></h2>
        <form action="login.jsp" method="post">
            User ID: <input type="text" name="login.userID" id="login.userID" value=""></input>
            Password: <input type="password" name="login.password" id="login.password" value=""></input>
            <input type="submit" id="login.submit" value="Log in"></input>
        </form>
    </body>
</html>
