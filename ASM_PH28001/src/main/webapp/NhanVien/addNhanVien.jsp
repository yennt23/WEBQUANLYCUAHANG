<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 31/03/2023
  Time: 2:55 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../header.jsp" />
<header>
    <br>
    <h3 style="text-align: center;">Quản Lý Nhân Viên</h3>
</header>
<main class="container">
    <form action="/ServletNhanVien/add" method="post">
        <div class="row mt-4">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" class="form-control" name="ma"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" class="form-control" name="ten"/>
            </div>
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" class="form-control" name="tenDem"/>
            </div>
            <div class="col-6">
                <label>Họ </label>
                <input type="text" class="form-control" name="ho"/>
            </div>
            <div class="col-6">
                <label>Địa chỉ </label>
                <input type="text" class="form-control" name="diaChi"/>
            </div>
            <div class="col-6">
                <label>Sđt </label>
                <input type="text" class="form-control" name="sdt"/>
            </div>
            <div class="col-6">
                <label>Ngày Sinh </label>
                <input type="date" class="form-control" name="ngaySinh"/>
            </div>
            <div class="col-6">
                <label>Mật Khẩu </label>
                <input type="text" class="form-control" name="matKhau"/>
            </div>
            <div class="col-6">
                Giới Tính
                <input type="radio" name="gioiTinh" value="0" checked>Nam
                <input type="radio" name="gioiTinh" value="1">Nữ
            </div>

            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Chức Vụ</label>
                <div class="col-sm-10">
                    <select class="form-select" name="chucVu">
                        <c:forEach items="${listcv}" var="cv">
                            <option value="${cv.id}">${cv.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Cua hang</label>
                <div class="col-sm-10">
                    <select class="form-select" name="cuaHang">
                        <c:forEach items="${listch}" var="ch">
                            <option value="${ch.id}">${ch.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <p>Trang Thai:</p>
            <select name="trangThai">
                <option value="0">Độc Thân</option>
                <option value="1">Có Ny</option>
                <option value="2">Có GĐ</option>
            </select>
            <div class="row mt-4" style="justify-content: center">
                <button class="btn btn-success col-1 m-3" type="submit">
                    Add
                </button>
            </div>
        </div>
    </form>
</main>
</body>
</html>
