<%-- 
    Document   : viewCart
    Created on : Mar 10, 2020, 1:55:07 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>View Cart</h1>
        <table border="1" class="table table-striped" style="width: 80%; margin: 50px 0 0 100px">
            <thead>
                <tr>
                    <th scope="col">Car Name</th>
                    <th scope="col">Category</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Total</th>
                </tr>
            </thead>
            <tbody>
            <s:iterator value="%{#session.CART.listCars}">
                <tr>
                <td><s:property value="value.carName" /></td>
                <td><s:property value="value.category" /></td>
                <td><s:property value="value.price" /></td>
                <td><input name="quantity" value="<s:property value="value.quantity" />" /></td>
                <td><s:property value="value.total" /></td>
                </tr>    
            </s:iterator>
        </tbody>
    </table>
        <s:url var="urlRewrting" value="shopping"/>
        <a href="${urlRewrting}">Shopping</a>
</body>
</html>
