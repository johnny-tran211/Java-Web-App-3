<%-- 
    Document   : shopping
    Created on : Mar 6, 2020, 2:20:09 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <s:if test="%{#session.USER.role != 'admin'}">
            <p>Welcome, <s:property value="%{#session.USER.fullname}" /></p>
            <s:url var="urlRewrting" value="logout"/>
            <a href="${urlRewrting}">Logout</a><br/>
        </s:if>
        <s:else>
            <jsp:forward page="login.jsp" />
        </s:else>
        <h1>Shopping Cart</h1>
            <p style="color: red"><s:property value="errorQuantity"/></p>
        <s:url var="urlRewrting2" value="viewCart"/>
        <a href="${urlRewrting2}">view cart</a><br/>
        <table border="1" class="table table-striped" style="width: 80%; margin: 50px 0 0 100px">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Car Name</th>
                    <th scope="col">Color</th>
                    <th scope="col">Year</th>
                    <th scope="col">Category</th>
                    <th scope="col">Price</th>
                    <th scope="col">All Quantity</th>
                    <th scope="col">Input Quantity</th>
                    <th scope="col">ADD</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="listcars">
                <form action="addToCart" method="POST">
                    <tr>
                        <td><s:property value="id" /></td>
                    <input type="hidden" name="id" value="<s:property value="id" />" />
                    <td><s:property value="carName" /></td>
                    <input type="hidden" name="carName" value="<s:property value="carName" />" />
                    <td><s:property value="color" /></td>
                    <td><s:property value="year" /></td>
                    <td><s:property value="category" /></td>
                    <input type="hidden" name="category" value="<s:property value="category" />" />
                    <td><s:property value="price" /></td>
                    <input type="hidden" name="price" value="<s:property value="price" />" />
                    <td><s:property value="quantity" /></td>
                    <input type="hidden" name="realQuantity" value="<s:property value="quantity" />" />
                    <td><input type="text" name="quantity" value="1" /></td>
                    <td><button type="submit" class="btn btn-primary">Add</button></td>
                    </tr>    
                </form>
            </s:iterator>
        </tbody>
    </table>

</body>
</html>
