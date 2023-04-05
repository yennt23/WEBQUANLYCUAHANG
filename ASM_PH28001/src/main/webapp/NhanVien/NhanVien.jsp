<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 14/03/2023
  Time: 3:15 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <h3 style="text-align: center;">Quản Lý Nhan Vien</h3>
    <section>
        <a href="/ServletNhanVien/view-add" class="btn btn-success " tabindex="-1" role="button"
           aria-disabled="true">Add</a>
    </section>
</header>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Ma</th>
        <th scope="col">Ten</th>
        <th scope="col">TenDem</th>
        <th scope="col">Ho</th>
        <th scope="col">GioiTinh</th>
        <th scope="col">Ngay sinh</th>
        <th scope="col">Dia chi</th>
        <th scope="col">Sdt</th>
        <th scope="col">trang thai</th>
        <th scope="col">trangthai</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNhanVien}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.ma}</td>
            <td>${l.tenDem}</td>
            <td>${l.ho}</td>
            <td>${l.gioiTinh}</td>
            <td>${l.ngaySinh}</td>
            <td>${l.diaChi}</td>
            <td>${l.sdt}</td>
            <td>${l.matKhau}</td>
            <td>${l.trangThai}</td>
            <td>
                <a href="/ServletNhanVien/delete?id=${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                   aria-disabled="true">Remove</a>
                <a href="/ServletNhanVien/view-update?id=${l.id}" class="btn btn-danger " tabindex="-1" role="button"
                   aria-disabled="true">update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
