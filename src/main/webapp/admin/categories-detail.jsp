<%--
  Created by IntelliJ IDEA.
  User: hieun
  Date: 11/6/2025
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tieets danh mục</title>
</head>
<body>
<h2>Chi tiết danh mục</h2>

<c:if test="${not empty category}">
  <p><strong>ID:</strong> ${category.categoryId}</p>
  <p><strong>Loại:</strong> ${category.type}</p>
  <p><strong>Mô tả:</strong> ${category.description}</p>
</c:if>

<p><a href="/categories">Quay lại</a></p>
</body>
</html>
