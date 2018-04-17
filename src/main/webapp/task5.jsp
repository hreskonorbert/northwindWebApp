<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import ="com.codecool.web.servlets.Task1Servlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Task 4</title>
</head>
<body>
<table align="middle" border="1">
    <tr>
        <th>Company</th><th>Product</th><th>Max Price</th>
        </tr>

<c:forEach items="${sessionScope.queryResults}" var="results">
    <tr>
    <c:forEach items="${results}" var="result">
        <td>${result}</td>
    </c:forEach>
    </tr>
</c:forEach>
</table>

<a href="index.html"><p>Go back</p></a>
</body>
</html>
