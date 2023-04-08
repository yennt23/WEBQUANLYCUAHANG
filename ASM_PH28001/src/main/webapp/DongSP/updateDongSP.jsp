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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../header.jsp" />
<main class="container">
    <header>
        <br>
        <h3 style="text-align: center;">Quản Lý Dong SP</h3>
    </header>
    <form action="/DongSanPham/update?id=${dongSP.id}" method="post" class="container">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">id</label>
            <div class="col-sm-10">
                <input class="form-control" type="hidden" name="id" value="${dongSP.id}"><br>
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
</main>
</body>
</html>
