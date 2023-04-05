package com.example.asm_ph28001.Servlet;

import com.example.asm_ph28001.Model.ChucVu;
import com.example.asm_ph28001.repository.ChucVuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVu", value ={
        "/ChucVu/hien_thi",
        "/ChucVu/detail",
        "/ChucVu/view-add",
        "/ChucVu/add",
        "/ChucVu/delete",
        "/ChucVu/view-update",
        "/ChucVu/update",
})
public class ServletChucVu extends HttpServlet {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien_thi")) {
            List<ChucVu> listChucVu = chucVuRepository.getAll();
            request.setAttribute("listChucVu",listChucVu);
            request.getRequestDispatcher("/ChucVu/ChucVu.jsp").forward(request,response);
        }
        else if (url.contains("detail")){
            this.detailChucVu(request,response);
        }
        else if(url.contains("view-update")){
            this.viewUpdate(request,response);
        }
        else if(url.contains("view-add")){
            request.getRequestDispatcher("/ChucVu/addChucVu.jsp").forward(request,response);
        }
        else if(url.contains("delete")){
            this.deleteChucVu(request,response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ChucVu/updateChucVu.jsp").forward(request,response);

    }

    private void detailChucVu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChucVu chucVu = chucVuRepository.getById(id);
        request.setAttribute("chucVu",chucVu);
        request.getRequestDispatcher("/ChucVu/updateChucVu.jsp").forward(request,response);
    }

    private void deleteChucVu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChucVu chucVu = new ChucVu();
        chucVu = chucVuRepository.getById(id);
        chucVuRepository.delete(chucVu);
        response.sendRedirect("/ChucVu/hien_thi");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu(ma,ten);
           chucVuRepository.add(chucVu);
//            request.getRequestDispatcher("/ChucVu/ChucVu.jsp").forward(request,response);
            response.sendRedirect("/ChucVu/hien_thi");
//            request.setAttribute("listChucVu",listChucVu);

        }
        else if(url.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma =request.getParameter("ma");
            String ten = request.getParameter("ten");
            ChucVu chucVu = new ChucVu();
            chucVu = chucVuRepository.getById(id);
            chucVu.setTen(ten);
            chucVu.setMa(ma);
            chucVuRepository.update(chucVu);
            response.sendRedirect("/ChucVu/hien_thi");
        }
    }



}
