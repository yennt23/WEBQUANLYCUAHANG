<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 14/03/2023
  Time: 3:13 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<header>
    <h3 style="text-align: center;">Quản Lý CTSP</h3>
    <section>
        <a href="/ServletChiTietSP/view-add" class="btn btn-success " tabindex="-1" role="button"
           aria-disabled="true">Add</a>
    </section>
</header>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">ten mau</th>
        <th scope="col">ten sp</th>
        <th scope="col">ten NSX</th>
        <th scope="col">ten Dong SP</th>
        <th scope="col">NAM BH</th>
        <th scope="col">MOTA</th>
        <th scope="col">SO LUONG TON</th>
        <th scope="col">GIA NHAP</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listChiTietSP}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.mauSac.ten}</td>
            <td>${l.sanpham.ten}</td>
            <td>${l.nsx.ten}</td>
            <td>${l.dongSP.ten}</td>
            <td>${l.namBH}</td>
            <td>${l.moTa}</td>
            <td>${l.soLuongTon}</td>
            <td>${l.giaNhap}</td>
            <td>
                <a href="/ServletChiTietSP/delete?id=${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                   aria-disabled="true">Remove</a>
                <a href="/ServletChiTietSP/detail?id=${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                   aria-disabled="true">update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
