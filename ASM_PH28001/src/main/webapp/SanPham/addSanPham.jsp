<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 30/03/2023
  Time: 4:01 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
  <h3 style="text-align: center;">Thêm</h3>
</header>
<form action="/ServletSanPham/add?id=${sanPham.id}" method="post">
  <div class="row mt-4">
    <div class="col-6">
      <label>Mã</label>
      <input type="text" class="form-control"  name="ma"/>
    </div>
    <div class="col-6">
      <label>Tên</label>
      <input type="text" class="form-control"  name="ten"/>
    </div>
  </div>

  <div class="row mt-4" style="justify-content: center">
    <button class="btn btn-success col-1 m-3" type="submit">
      Add
    </button>
  </div>
</form>
</body>
</html>
