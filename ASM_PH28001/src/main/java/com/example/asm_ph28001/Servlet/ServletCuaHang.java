package com.example.asm_ph28001.Servlet;

import com.example.asm_ph28001.Model.ChucVu;
import com.example.asm_ph28001.Model.CuaHang;
import com.example.asm_ph28001.repository.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ServletCuaHang", value = {
        "/ServletCuaHang/hien_thi",
        "/ServletCuaHang/detail",
        "/ServletCuaHang/view-add",
        "/ServletCuaHang/add",
        "/ServletCuaHang/view-update",
        "/ServletCuaHang/update",
        "/ServletCuaHang/delete",
})
public class ServletCuaHang extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien_thi")) {
            this.hienThiCuaHang(request, response);
        } else if (url.contains("detail")) {
            this.detailCuaHang(request, response);
        } else if (url.contains("view-add")) {
            this.viewAddCuaHang(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdateCuaHang(request, response);
        } else if (url.contains("delete")) {
            this.deleteCuaHang(request, response);
        }
    }

    private void viewAddCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/CuaHang/addCuaHang.jsp").forward(request, response);

    }

    private void viewUpdateCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/CuaHang/updateCuaHang.jsp").forward(request, response);

    }

    private void deleteCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        CuaHang cuaHang = new CuaHang();
        cuaHang = cuaHangRepository.getById(id);
        cuaHangRepository.delete(cuaHang);
        response.sendRedirect("/ServletCuaHang/hien_thi");
    }

    private void detailCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        CuaHang cuaHang = cuaHangRepository.getById(id);
        request.setAttribute("cuaHang", cuaHang);
        request.getRequestDispatcher("/CuaHang/updateCuaHang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addCuaHang(request, response);
        } else if (url.contains("update")) {
            this.updateCuaHang(request, response);
        }
    }

    private void updateCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang cuaHang = new CuaHang();
        cuaHang=cuaHangRepository.getById(id);
        cuaHang.setMa(ma);
        cuaHang.setTen(ten);
        cuaHang.setDiaChi(diaChi);
        cuaHang.setThanhPho(thanhPho);
        cuaHangRepository.update(cuaHang);
        response.sendRedirect("/ServletCuaHang/hien_thi");
    }

    private void addCuaHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang cuaHang = new CuaHang(ma,ten,diaChi,thanhPho,quocGia);
        cuaHangRepository.add(cuaHang);
        response.sendRedirect("/ServletCuaHang/hien_thi");

    }

    private void hienThiCuaHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CuaHang> listCH = cuaHangRepository.getAll();
        request.setAttribute("listCH", listCH);
        request.getRequestDispatcher("/CuaHang/CuaHang.jsp").forward(request, response);
    }

}
