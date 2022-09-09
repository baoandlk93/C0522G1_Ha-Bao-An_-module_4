<%--
  Created by IntelliJ IDEA.
  User: TUF
  Date: 09/09/2022
  Time: 10:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/exchange" method="get">
    <select name="result">
        <option value="">Select One</option>
        <option value="usd">USD</option>
        <option value="vnd">VND</option>
    </select>
    <input type="number" name="unit">
    <input type="text" value="<c:out value ="${currency}"></c:out>">
    <button type="submit">Exchange</button>
</form>
</body>
</html>
