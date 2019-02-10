<%-- 
    Document   : index
    Created on : 14-Jun-2012, 18:46:30
    Author     : Tanvir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="hello">Say hello</a>
        <h2>Message from the session: ${message}</h2>
        <form action="hello" method="post">
            Enter a message: <input type="text" name="message"/>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
