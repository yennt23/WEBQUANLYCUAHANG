<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 14/03/2023
  Time: 3:14 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
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
    <form action="/ServletKhachHang/add" method="post" class="container">
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
                <input class="form-control" type="date" name="ngaySinh" value="${khachHang.ngaySinh}"><br>
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
        <button type="submit">Thêm</button>
    </form>
    <div class="container">
        <table class="table ">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">ma</th>
                <th scope="col">ten</th>
                <th scope="col">tenDem</th>
                <th scope="col">ho</th>
                <th scope="col">ngaySinh</th>
                <th scope="col">sDT</th>
                <th scope="col">diaChi</th>
                <th scope="col">thanhPho</th>
                <th scope="col">quocGia</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tboby>
                <c:forEach items="${khachHangList}" var="l">
                    <tr>
                        <td>${l.id}</td>
                        <td>${l.ma}</td>
                        <td>${l.ho}</td>
                        <td>${l.tenDem}</td>
                        <td>${l.ten}</td>
                        <td>${l.ngaySinh}</td>
                        <td>${l.sdt}</td>
                        <td>${l.diaChi}</td>
                        <td>${l.thanhPho}</td>
                        <td>${l.quocGia}</td>
                        <td>
                            <a href="/ServletKhachHang/detail?id=${l.id}">detail</a>
                            <a href="/ServletKhachHang/delete?id=${l.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tboby>
        </table>
    </div>
    <footer><p style="text-align: center;">Yênnnn</p></footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
            integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
            crossorigin="anonymous"></script>
</main>
</body>
</html>
