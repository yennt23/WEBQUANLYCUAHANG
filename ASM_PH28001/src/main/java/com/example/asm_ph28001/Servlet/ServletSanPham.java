package com.example.asm_ph28001.Servlet;

import com.example.asm_ph28001.Model.SanPham;
import com.example.asm_ph28001.repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ServletSanPham", value = {
        "/ServletSanPham/hien_thi",
        "/ServletSanPham/detail",
        "/ServletSanPham/view-add",
        "/ServletSanPham/add",
        "/ServletSanPham/view-update",
        "/ServletSanPham/update",
        "/ServletSanPham/delete",
})

public class ServletSanPham extends HttpServlet {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien_thi")) {
                this.hienThiSanPham(request,response);
        }
        else if(url.contains("view-add")){
            this.viewAdd(request,response);
        }
        else if(url.contains("view-update")){
            this.viewUpdate(request,response);
        }
        else if (url.contains("detail")){
            this.detailSP(request,response);
        }
        else if (url.contains("delete")){
            this.deleteSP(request,response);
        }
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/SanPham/addSanPham.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/SanPham/updateSanPham.jsp").forward(request,response);

    }

    private void detailSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        SanPham sanPham = new SanPham();
        sanPham = sanPhamRepository.getById(id);
        request.setAttribute("sanPham",sanPham);
        request.getRequestDispatcher("/SanPham/updateSanPham.jsp").forward(request,response);
    }

    private void deleteSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        SanPham sanPham = new SanPham();
        sanPham = sanPhamRepository.getById(id);
        sanPhamRepository.delete(sanPham);
       response.sendRedirect("/ServletSanPham/hien_thi");
    }

    protected void hienThiSanPham(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham>listSP =   sanPhamRepository.getAll();
        request.setAttribute("listSP",listSP);
        request.getRequestDispatcher("/SanPham/SanPham.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addSanPham(request,response);
        }
        else if(uri.contains("update")){
            this.updateSanPham(request,response);
        }
    }

    private void updateSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
      UUID id = UUID.fromString(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        SanPham sanPham = new SanPham();
        sanPham=sanPhamRepository.getById(id);
        sanPham.setTen(ten);
        sanPham.setMa(ma);
        sanPhamRepository.update(sanPham);
        response.sendRedirect("/ServletSanPham/hien_thi");
    }

    private void addSanPham(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        SanPham sanPham = new SanPham(ma,ten);
        sanPhamRepository.add(sanPham);
        response.sendRedirect("/ServletSanPham/hien_thi");
    }
}
