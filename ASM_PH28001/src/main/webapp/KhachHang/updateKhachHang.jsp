<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27/03/2023
  Time: 9:56 pm
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
        <h3 style="text-align: center;">Quản Lý Khách Hàng</h3>
    </header>
    <form action="/ServletKhachHang/update?id=${khachHang.id}" method="post" class="container">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Mã</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="ma" value="${khachHang.ma}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Tên</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="ten" value="${khachHang.ten}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Tên Đệm</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="tenDem" value="${khachHang.tenDem}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Họ</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="ho" value="${khachHang.ho}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ngày Sinh</label>
            <div class="col-sm-10">
                <input class="form-control" type="date" name="ngaySinh" value="${ngaySinh}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">SĐT</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="sdt" value="${khachHang.sdt}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Địa Chỉ</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="diaChi" value="${khachHang.diaChi}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Thành Phố</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="thanhPho" value="${khachHang.thanhPho}"><br>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Quốc Gia</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="quocGia" value="${khachHang.quocGia}"><br>
            </div>
        </div>
        <button type="submit">update</button>
    </form>
</main>
</body>
</html>
