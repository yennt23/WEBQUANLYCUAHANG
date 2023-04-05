<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 31/03/2023
  Time: 2:55 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ServletNhanVien/add" method="post">
    <div class="row mt-4">
        <div class="col-6">
            <label>Mã</label>
            <input type="text" class="form-control"  name="ma"/>
        </div>
        <div class="col-6">
            <label>Tên</label>
            <input type="text" class="form-control"  name="ten"/>
        </div>
        <div class="col-6">
            <label>Tên đệm</label>
            <input type="text" class="form-control"  name="tenDem"/>
        </div>
        <div class="col-6">
            <label>Họ </label>
            <input type="text" class="form-control"  name="ho"/>
        </div>
        <div class="col-6">
            <label>Địa chỉ </label>
            <input type="text" class="form-control"  name="diaChi"/>
        </div>
        <div class="col-6">
            <label>Sđt </label>
            <input type="text" class="form-control"  name="sdt"/>
        </div>
        <div class="col-6">
            <label>Ngày Sinh </label>
            <input type="date" class="form-control"  name="ngaySinh"/>
        </div>
        <div class="col-6">
            <label>Mật Khẩu </label>
            <input type="text" class="form-control"  name="matKhau"/>
        </div>
        <div class="col-6">
            <label>Giới tính</label>
            <input type="radio" class="form-control" name="gioiTinh" value="Nu"/>
            <label>Nữ</label><br>
            <input type="radio" class="form-control" name="gioiTinh" value="Nam"/>
            <label>Nam</label><br>
        </div>
        <div class="col-6">
            <label>Trạng thái</label>
            <input type="radio" class="form-control" name="trangThai" value="0"/>
            <label>Đã nghỉ</label><br>
            <input type="radio" class="form-control" name="trangThai" value="1"/>
            <label>Còn làm</label><br>
        </div>
        <div class="row mt-4" style="justify-content: center">
            <button class="btn btn-success col-1 m-3" type="submit">
                Add
            </button>
        </div>
</form>
</body>
</html>
