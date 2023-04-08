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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../header.jsp" />
<main class="container">
    <header>
        <br>
        <h3 style="text-align: center;">Quản Lý NSX</h3>
    </header>
    <form action="/ServletNSX/update" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label>ID</label>
                <input type="hidden" class="form-control" value="${nsx.id}" name="id"/>
            </div>
            <div class="col-6">
                <label>Mã</label>
                <input type="text" class="form-control" value="${nsx.ma}" name="ma"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" class="form-control" value="${nsx.ten}" name="ten"/>
            </div>
        </div>
        </div>
        <div class="row mt-4" style="justify-content: center">
            <button class="btn btn-success col-1 m-3" type="submit">
                update
            </button>
        </div>
    </form>
</main>
</body>
</html>
