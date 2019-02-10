<%-- 
    Document   : index
    Created on : 22-Jan-2012, 16:01:56
    Author     : Tanvir
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MyDirectory - Login</title>
    </head>
    <body>
        <h1>Welcome to my directory!</h1>
        <h2>${message}</h2>
        <form action="login" method="post">
            User ID: <input type="text" name="userID" id="userID" value=""></input>
            Password: <input type="password" name="password" id="password" value=""></input>
            <input type="submit" id="submit" value="Log in"></input>
        </form>
    </body>
</html>
