<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hieun
  Date: 11/6/2025
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách danh mục</title>
</head>
<body>
<h2>Danh sách danh mục</h2>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Loại</th>
        <th>Mô tả</th>
    </tr>
    <c:forEach var="cat" items="${categories}">
        <tr>
            <td>${cat.categoryId}</td>
            <td>${cat.type}</td>
            <td>${cat.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
