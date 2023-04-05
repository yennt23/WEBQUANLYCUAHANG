<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 30/03/2023
  Time: 3:01 pm
  To change this template use File | Settings | File Templates.
--%>
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
<header>
  <h3 style="text-align: center;">Thêm</h3>
</header>
<main class="container">
  <section>
    <form action="/ServletCuaHang/add" method="post">
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
          <label>Địa chỉ</label>
          <input type="text" class="form-control"  name="diaChi"/>
        </div>
        <div class="col-6">
          <label>Thành Phố</label>
          <input type="text" class="form-control" name="thanhPho"/>
        </div>

        <div class="col-6">
          <label>QUốc Gia</label>
          <input type="text" class="form-control"  name="quocGia"/>
        </div>
      </div>
      </div>

      <div class="row mt-4" style="justify-content: center">
        <button class="btn btn-success col-1 m-3" type="submit">
          Add
        </button>
      </div>

    </form>
  </section>
</main>
<footer><p style="text-align: center;">PH28001 - Nguyễn Thị Yến</p></footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
