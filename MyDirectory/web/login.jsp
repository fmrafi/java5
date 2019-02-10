<%-- 
    Document   : index
    Created on : 22-Jan-2012, 16:01:56
    Author     : Tanvir
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="training.web.mydir.*"%>
<jsp:useBean id="user" class="training.web.mydir.User" scope="session"></jsp:useBean>

<%
String message = "Please log in...";
if (user.getUserId() != null) {
    // user already logged in, go to list
    //pageContext.forward("list.jsp");
    response.sendRedirect("list.jsp");
    return;
}

String userID = request.getParameter("userID");
String password = request.getParameter("password");
if (userID != null) {
    // check credentials
    if (userID.equals(application.getInitParameter("userid")) && 
            password.equals(application.getInitParameter("password"))) {
        user.setUserId(userID);
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
        <h2><%=message%></h2>
        <form action="login.jsp" method="post">
            User ID: <input type="text" name="userID" id="userID" value=""></input>
            Password: <input type="password" name="password" id="password" value=""></input>
            <input type="submit" id="submit" value="Log in"></input>
        </form>
    </body>
</html>
