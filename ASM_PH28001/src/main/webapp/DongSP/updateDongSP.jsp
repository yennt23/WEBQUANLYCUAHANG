<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 29/03/2023
  Time: 2:31 pm
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
<form action="/DongSanPham/update?id=${dongSP.id}" method="post" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">id</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="id" value="${dongSP.id}"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ma" value="${dongSP.ma}"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ten" value="${dongSP.ten}"><br>
        </div>
    </div>
    <button type="submit">update</button>
</form>
</body>
</html>
