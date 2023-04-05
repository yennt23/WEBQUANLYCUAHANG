package com.example.asm_ph28001.Servlet;

import com.example.asm_ph28001.Model.KhachHang;
import com.example.asm_ph28001.repository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ServletKhachHang", value = {
        "/ServletKhachHang/hien-thi",
        "/ServletKhachHang/add",
        "/ServletKhachHang/detail",
        "/ServletKhachHang/update",
        "/ServletKhachHang/delete",
})
public class ServletKhachHang extends HttpServlet {
    KhachHangRepository khachHangRepository = new KhachHangRepository();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        }
        else if(uri.contains("detail")){
            this.detailKhachHang(request,response);
        }
        else if(uri.contains("delete")){
            this.deleteKhachHang(request,response);
        }
    }

    private void deleteKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        KhachHang khachHang = new KhachHang();
        khachHang = khachHangRepository.getById(id);
        khachHangRepository.delete(khachHang);
        response.sendRedirect("/ServletKhachHang/hien-thi");
    }

    private void detailKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        KhachHang khachHang = khachHangRepository.getById(id);
        request.setAttribute("khachHang", khachHang);
        System.out.println(khachHang.getNgaySinh());
        String ngaySinh = dateFormat.format(khachHang.getNgaySinh());
        request.setAttribute("ngaySinh", ngaySinh);
        request.getRequestDispatcher("/KhachHang/updateKhachHang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addKhachHang(request, response);
        }
        else if(uri.contains("update")){
            this.updateKhachHang(request,response);
        }
    }

    private void updateKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String sdt = request.getParameter("sdt");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
        KhachHang khachHang = new KhachHang();
        khachHang=khachHangRepository.getById(id);
        khachHang.setMa(ma);
        khachHang.setTen(ten);
        khachHang.setTenDem(tenDem);
        khachHang.setDiaChi(diaChi);
        khachHang.setThanhPho(thanhPho);
        khachHang.setQuocGia(quocGia);
        khachHang.setSdt(sdt);
        khachHang.setNgaySinh(ngaySinh);
        khachHang.setHo(ho);
        khachHangRepository.update(khachHang);
        response.sendRedirect("/ServletKhachHang/hien-thi");
    }

    private void addKhachHang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String sdt = request.getParameter("sdt");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e){
            throw new RuntimeException(e);
        }
    KhachHang khachHang = new KhachHang();
        khachHang.setMa(ma);
        khachHang.setTen(ten);
        khachHang.setTenDem(tenDem);
        khachHang.setDiaChi(diaChi);
        khachHang.setThanhPho(thanhPho);
        khachHang.setQuocGia(quocGia);
        khachHang.setSdt(sdt);
        khachHang.setNgaySinh(ngaySinh);
        khachHang.setHo(ho);
        khachHangRepository.add(khachHang);
        response.sendRedirect("/ServletKhachHang/hien-thi");
    }
    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> khachHangList = khachHangRepository.getAll();
        request.setAttribute("khachHangList", khachHangList);
        request.getRequestDispatcher("/KhachHang/KhachHang.jsp").forward(request, response);
    }
}
