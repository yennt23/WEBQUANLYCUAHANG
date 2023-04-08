<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 30/03/2023
  Time: 10:18 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="../header.jsp" />
<header>
    <br>
    <h3 style="text-align: center;">Quản Lý CTSP</h3>

</header>
<main class="container">

    <form action="/ServletChiTietSP/update" method="post" class="container">
        <div class="my-3 p-3 bg-body rounded shadow-sm">
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">ID</label>
                <div class="col-sm-10">
                    <input class="form-control" type="hidden" name="id" value="${chiTietSP.id}"><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Nam bh</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="namBH" value="${chiTietSP.namBH}"><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Mota</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="moTa" value="${chiTietSP.moTa}"><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">So luong ton</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="soLuongTon" value="${chiTietSP.soLuongTon}"><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Gia nhap</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" name="giaNhap" value="${chiTietSP.giaNhap}"><br>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Màu sắc</label>
                <div class="col-sm-10">
                    <select class="form-select" name="mauSac">
                        <c:forEach items="${listMau}" var="mau">
                            <option value="${mau.id}" ${mau.ten==chiTietSP.mauSac.ten?"selected":""} >${mau.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Sản phẩm</label>
                <div class="col-sm-10">
                    <select class="form-select" name="sanPham">
                        <c:forEach items="${listsp}" var="sp">
                            <option value="${sp.id}" ${sp.ten==chiTietSP.sanpham.ten?"selected":""} >${sp.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">Dong SP</label>
                <div class="col-sm-10">
                    <select class="form-select" name="dongSP">
                        <c:forEach items="${listDongSP}" var="dongSP">
                            <option value="${dongSP.id}" ${dongSP.ten==chiTietSP.dongSP.ten?"selected":""} >${dongSP.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="mb-3 row">
                <label class="col-sm-2 col-form-label">NSX</label>
                <div class="col-sm-10">
                    <select class="form-select" name="nsx">
                        <c:forEach items="${listnsx}" var="nsx">
                            <option value="${nsx.id}" ${nsx.ten==chiTietSP.nsx.ten?"selected":""} >${nsx.ten}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div>
        <button type="submit">update</button>
    </form>
</main>
</body>
</html>
