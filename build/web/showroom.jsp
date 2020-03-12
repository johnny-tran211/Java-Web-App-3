<%-- 
    Document   : showroom
    Created on : Mar 6, 2020, 10:39:23 PM
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
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <!--        <link rel="stylesheet" href="/resources/demos/style.css">-->
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
            $(function () {
                $("#datepicker2").datepicker();
            });
        </script>
    </head>
    <body>

        <h1>Showroom</h1>
        <s:if test="%{#session.USER != null}">
            <p>Welcome, <s:property value="%{#session.USER.fullname}" /></p>
            <s:url var="urlRewrting3" value="logout"/>
            <a href="${urlRewrting3}">Logout</a><br/>
        </s:if>
        <s:else>
            <a href="login.jsp">Login</a></br>
        </s:else>
        <s:url var="urlRewrting" value="loadIndex"/>
        <a href="${urlRewrting}">Reload</a>
        <s:url var="urlRewrting2" value="shopping"/>
        <a href="${urlRewrting2}">Shopping</a>


        <form action="searchIndex">
            <select name="serchType">
                <option>Car Name</option>
                <option>Car Category</option>
            </select>
            <input type="text" name="searchValue" value="${param.searchValue}" /></br>
            Rental Date: <input type="text" id="datepicker" name="rentalDate" value="${param.rentalDate}"></br>
            Return Date: <input type="text" id="datepicker2" name="returnDate" value="${param.returnDate}"></br>
            Amount of Car: <input type="text" name="total" value="${param.total}" /></br>
            <input type="submit" value="Search" />
        </form><br/>
        <s:if test="listcars == null">
            <p style="color: red">No record !!!</p>
        </s:if>
        <s:else>
            <table border="1" class="table table-striped" style="width: 80%; margin: 50px 0 0 100px">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Car Name</th>
                        <th scope="col">Color</th>
                        <th scope="col">Year</th>
                        <th scope="col">Category</th>
                        <th scope="col">Price</th>
                        <th scope="col">Quantity</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="listcars">
                        <tr>
                            <td><s:property value="id" /></td>
                            <td><s:property value="carName" /></td>
                            <td><s:property value="color" /></td>
                            <td><s:property value="year" /></td>
                            <td><s:property value="category" /></td>
                            <td><s:property value="price" /></td>
                            <td><s:property value="quantity" /></td>
                        </tr>    
                    </s:iterator>
                </tbody>
            </table>
        </s:else>


    </body>
</html>
