<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 14/03/2023
  Time: 3:14 pm
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
<jsp:include page="../header.jsp" />
<main class="container">
    <header>
        <br>
        <h3 style="text-align: center;">Quản Lý Cửa Hàng</h3>
        <section>
            <a href="/ServletCuaHang/view-add" class="btn btn-success " tabindex="-1" role="button"
               aria-disabled="true">Add</a>
        </section>
    </header>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Ma</th>
            <th scope="col">Ten</th>
            <th scope="col">Dia Chi</th>
            <th scope="col">Thanh pho</th>
            <th scope="col">Quoc gia</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listCH}" var="l">
            <tr>
                <td>${l.id}</td>
                <td>${l.ma}</td>
                <td>${l.ten}</td>
                <td>${l.diaChi}</td>
                <td>${l.thanhPho}</td>
                <td>${l.quocGia}</td>
                <td>
                    <a href="/ServletCuaHang/delete?id=${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                       aria-disabled="true">Remove</a>
                    <a href="/ServletCuaHang/detail?id=${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                       aria-disabled="true">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>
