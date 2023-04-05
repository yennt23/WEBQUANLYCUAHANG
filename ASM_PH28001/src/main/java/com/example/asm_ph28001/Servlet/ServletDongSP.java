package com.example.asm_ph28001.Servlet;

import com.example.asm_ph28001.Model.DongSP;
import com.example.asm_ph28001.repository.DongSPRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ServletDongSP", value = {
        "/DongSanPham/hien-thi",
        "/DongSanPham/detail",
        "/DongSanPham/view-add",
        "/DongSanPham/add",
        "/DongSanPham/view-update",
        "/DongSanPham/update",
        "/DongSanPham/delete",
})
public class ServletDongSP extends HttpServlet {
    private DongSPRepository dongSanPhamRepository= new DongSPRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<DongSP> listDongSanPham = dongSanPhamRepository.getAll();
            request.setAttribute("listDongSanPham",listDongSanPham);
            request.getRequestDispatcher("/DongSP/DongSP.jsp").forward(request,response);
        }
        else if(uri.contains("detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = new DongSP();
            dongSP = dongSanPhamRepository.getById(id);
            request.setAttribute("dongSP",dongSP);
            request.getRequestDispatcher("/DongSP/updateDongSP.jsp").forward(request,response);
        }
        else if(uri.contains("delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = new DongSP();
            dongSP = dongSanPhamRepository.getById(id);
            dongSanPhamRepository.delete(dongSP);
            response.sendRedirect("/DongSanPham/hien-thi");
        }
        else if(uri.contains("view-add")){
            request.getRequestDispatcher("/DongSP/addDongSP.jsp").forward(request,response);

        }
        else if(uri.contains("view-update")){
            request.getRequestDispatcher("/DongSP/updateDongSP.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP(ma,ten);
            dongSanPhamRepository.add(dongSP);
            response.sendRedirect("/DongSanPham/hien-thi");
        }
        else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            DongSP dongSP = new DongSP();
            dongSP = dongSanPhamRepository.getById(id);
            dongSP.setMa(ma);
            dongSP.setTen(ten);
            dongSanPhamRepository.update(dongSP);
            response.sendRedirect("/DongSanPham/hien-thi");
        }
    }
}
