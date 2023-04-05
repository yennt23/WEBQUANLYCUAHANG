<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/14/2023
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<header>
        <h3 style="text-align: center;">Quản Lý Dong SP</h3>
        <section>
            <a href="/DongSanPham/view-add" class="btn btn-success " tabindex="-1" role="button"
               aria-disabled="true">Add</a>
        </section>
</header>
<table class="table ">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">ma</th>
        <th scope="col">ten</th>
    </tr>
    </thead>
    <tboby>
        <c:forEach items="${listDongSanPham}" var="l">
            <tr>
                <td>${l.id}</td>
                <td>${l.ma}</td>
                <td>${l.ten}</td>
                <td>
                    <a href="/DongSanPham/delete?id=${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                       aria-disabled="true">Remove</a>
                    <a href="/DongSanPham/detail?id=${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                       aria-disabled="true">update</a>
                </td>
            </tr>
        </c:forEach>
    </tboby>
</table>
</body>
</html>