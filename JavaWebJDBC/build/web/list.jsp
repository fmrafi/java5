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

<jsp:useBean id="order" class="training.Order" scope="session"></jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Product</th>
                <th>Supplier</th>
                <th>Price type</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <c:forEach var="line" items="${order.lines}">
                <tr>
                    <td>${line.product}</td>
                    <td>${line.supplier}</td>
                    <td>${line.priceType}</td>
                    <td>${line.quantity}</td>
                    <td>${line.price}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
