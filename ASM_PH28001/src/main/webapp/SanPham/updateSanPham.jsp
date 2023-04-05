<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 30/03/2023
  Time: 4:02 pm
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
<form action="/ServletSanPham/update?${sanPham.id}" method="post">
  <div class="row mt-4">
    <div class="col-6">
      <label>id</label>
      <input type="text" class="form-control" value="${sanPham.id}" name="id"/>
    </div>
    <div class="col-6">
      <label>Mã</label>
      <input type="text" class="form-control"  value="${sanPham.ma}" name="ma"/>
    </div>
    <div class="col-6">
      <label>Tên</label>
      <input type="text" class="form-control"  value="${sanPham.ten}" name="ten"/>
    </div>
  </div>

  <div class="row mt-4" style="justify-content: center">
    <button class="btn btn-success col-1 m-3" type="submit">
      update
    </button>
  </div>

</form>
</body>
</html>
