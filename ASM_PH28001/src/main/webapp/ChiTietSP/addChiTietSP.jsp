<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 30/03/2023
  Time: 10:18 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ServletChiTietSP/add" method="post" class="container">
    <div class="my-3 p-3 bg-body rounded shadow-sm">
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Nam bh</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="namBH"><br>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Mota</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="moTa"><br>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">So luong ton</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="soLuongTon"><br>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Gia nhap</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="giaNhap"><br>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Màu sắc</label>
            <div class="col-sm-10">
                <select class="form-select" name="mauSac">
                    <c:forEach items="${listMau}" var="mau">
                        <option value="${mau.id}">${mau.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Sản phẩm</label>
            <div class="col-sm-10">
                <select class="form-select" name="sanPham">
                    <c:forEach items="${listsp}" var="sp">
                        <option value="${sp.id}">${sp.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">Dong SP</label>
            <div class="col-sm-10">
                <select class="form-select" name="dongSP">
                    <c:forEach items="${listDongSP}" var="dongSP">
                        <option value="${dongSP.id}">${dongSP.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="mb-3 row">
            <label class="col-sm-2 col-form-label">NSX</label>
            <div class="col-sm-10">
                <select class="form-select" name="nsx">
                    <c:forEach items="${listnsx}" var="nsx">
                        <option value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </div>
    <button type="submit">Them</button>
</form>
</body>
</html>