<%-- 
    Document   : login
    Created on : Mar 6, 2020, 2:00:21 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Login Page</h1>
        <s:if test= "#request.ERROR != null">
            <p style="color: red"><s:property value="#request.ERROR"/></p>
        </s:if> 
        <s:property value="#error" />
        <form action="login" method="POST">
            <input type="text" name="username" value="" /></br>
            <input type="password" name="password" value="" /></br>
            <input type="submit" value="Submit" />
        </form>
        <s:url var="urlRewrting" value="loadIndex"/>
        <a href="${urlRewrting}">Home</a>
    </body>
</html>
