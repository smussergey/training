<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Car List</title>
</head>
    <body>
        <h2>
            List Cars <br/>
        </h2>

        <%=request.getAttribute("cars")%>
        <br/>
        <a href="servlet">Click here to see servlet</a>
    </body>
</html>
