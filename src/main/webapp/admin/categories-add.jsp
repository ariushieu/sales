<%--
  Created by IntelliJ IDEA.
  User: hieun
  Date: 11/6/2025
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tạo danh mục </title>
</head>
<body>
<h2>Tạo danh mục mới</h2>

<c:if test="${not empty error}">
  <p style="color: red;">${error}</p>
</c:if>

<form action="/category/add" method="post">
  <label>Loại danh mục</label><br>
  <input type="text" name="type" required><br><br>
  <label>Mô tả</label><br>
  <textarea name="description" rows="4" cols="30"></textarea><br><br>
  <button type="submit">Thêm</button>
</form>
</body>
</html>
