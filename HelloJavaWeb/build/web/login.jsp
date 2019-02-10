<%-- 
    Document   : login
    Created on : 18-Oct-2012, 17:59:01
    Author     : Tanvir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.util.Locale" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.TimeZone" %>
<%@page import="java.text.DateFormat" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>Please log in</h2>
        <h3>userid: ${param["userid"]}</h3>
        <h3>password: ${param["password"]}</h3>
        <%
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        if (userid != null && password != null) {
            if (userid.equals("tanvir") && password.equals("secret")) {
                // say yes
                %>
                <font color="green">Yes</font>
                <%
                response.sendRedirect("home.jsp");
                return;
            } else {
                // say no
                %>
                <font color="red">No</font>
                <%
            }
        }
        %>
        <form action="login.jsp" method="post">
            User id: <input type="text" name="userid"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Submit">
        </form>
        <%
        Locale en_US = new Locale("en", "US");
        Calendar c = Calendar.getInstance();
        DateFormat df_en_US = DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG, en_US);
        df_en_US.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        %>
        <h6><font color="red"><i>Date</i>: <%=df_en_US.format(c.getTime())%></font></h6>
    </body>
</html>
