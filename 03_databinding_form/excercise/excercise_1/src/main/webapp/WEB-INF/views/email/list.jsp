<%--
  Created by IntelliJ IDEA.
  User: TUF
  Date: 13/09/2022
  Time: 3:04 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<a>
</a>
<table class="table">
    <tr>
        <td hidden>ID</td>
        <td>Language</td>
        <td>Page size</td>
        <td>Spam Filter</td>
        <td>Signature</td>
        <td></td>
    </tr>
    <c:forEach items="${emailList}" var="email">
        <tr>
            <td hidden>${email.id}</td>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamFilter}</td>
            <td>${email.signature}</td>
            <td class="text-center"><a href="/email/edit?id=${email.id}">
                <span class="fa-solid fa-user-pen text-primary h4 m-auto">Edit</span>
            </a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
