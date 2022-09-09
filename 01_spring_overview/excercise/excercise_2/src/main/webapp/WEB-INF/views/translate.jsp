<%--
  Created by IntelliJ IDEA.
  User: TUF
  Date: 09/09/2022
  Time: 10:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/translate" method="get">

    <input type="text" name="keyword" placeholder="Vui lòng nhập từ muốn dịch">
    <select name="lang">
        <option value="">Chọn ngôn ngữ bạn muốn chuyển đổi</option>
        <option value="eng">English</option>
        <option value="vie">Vietnamese</option>
    </select>
    <button type="submit">Translate</button>
    <%--    <span><c:out value="${translate}"></c:out></span>--%>
</form>
<c:forEach var="word" items="${translate}">
    <c:if test="${translate.size()== 0}">
        <p> Từ bạn cần tìm chúng tôi chưa cập nhật</p>
    </c:if>
    <p>Tiếng việt: <c:out value="${word.vietnamese}"></c:out></p>
    <p>Tiếng Anh: <c:out value="${word.english}"></c:out></p>
</c:forEach>
</body>
</html>
