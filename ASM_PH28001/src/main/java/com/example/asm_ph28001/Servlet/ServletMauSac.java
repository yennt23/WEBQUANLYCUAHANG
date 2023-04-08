package com.example.asm_ph28001.Servlet;

import com.example.asm_ph28001.Model.MauSac;
import com.example.asm_ph28001.repository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ServletMauSac", value = {
        "/ServletMauSac/hien-thi",
        "/ServletMauSac/detail",
        "/ServletMauSac/view-add",
        "/ServletMauSac/add",
        "/ServletMauSac/delete",
        "/ServletMauSac/view-update",
        "/ServletMauSac/update",
})
public class ServletMauSac extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri =request.getRequestURI();
    if(uri.contains("hien-thi")){
        List<MauSac> listMauSac = mauSacRepository.getAll();
        request.setAttribute("listMauSac",listMauSac);
        request.getRequestDispatcher("/MauSac/MauSac.jsp").forward(request,response);
    }
    else if(uri.contains("detail")){
        this.detailMauSac(request,response);
    }
    else if(uri.contains("view-add")){
        this.viewAddMauSac(request,response);
    }
    else if(uri.contains("delete")){
        this.deleteMauSac(request,response);
    }
    else if(uri.contains("view-update")){
        this.viewUpdateMauSac(request,response);
    }

    }

    private void viewAddMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/MauSac/addMauSac.jsp").forward(request,response);
    }

    private void deleteMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        MauSac mauSac = new MauSac();
        mauSac = mauSacRepository.getById(id);
        mauSacRepository.delete(mauSac);
        response.sendRedirect("/ServletMauSac/hien-thi");
    }

    private void viewUpdateMauSac(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/MauSac/updateMauSac.jsp").forward(request,response);
    }

    private void detailMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.fromString(request.getParameter("id"));
        MauSac mauSac = mauSacRepository.getById(id);
        request.setAttribute("mauSac",mauSac);
        request.getRequestDispatcher("/MauSac/updateMauSac.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            this.addMauSac(request,response);
        }
        else if(uri.contains("update")){
            this.updateMauSac(request,response);
        }
    }

    private void updateMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        MauSac mauSac = new MauSac();
        mauSac = mauSacRepository.getById(id);
        mauSac.setMa(ma);
        mauSac.setTen(ten);
        mauSacRepository.update(mauSac);
        response.sendRedirect("/ServletMauSac/hien-thi");
    }

    private void addMauSac(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        MauSac mauSac = new MauSac();
        mauSac.setMa(ma);
        mauSac.setTen(ten);
        mauSacRepository.add(mauSac);
        response.sendRedirect("/ServletMauSac/hien-thi");
    }
}
