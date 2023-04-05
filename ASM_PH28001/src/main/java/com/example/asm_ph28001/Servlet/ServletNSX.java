package com.example.asm_ph28001.Servlet;

import com.example.asm_ph28001.Model.NSX;
import com.example.asm_ph28001.repository.NSXRepositopy;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ServletNSX", value = {
        "/ServletNSX/hien-thi",
        "/ServletNSX/detail",
        "/ServletNSX/view-add",
        "/ServletNSX/add",
        "/ServletNSX/view-update",
        "/ServletNSX/update",
        "/ServletNSX/delete",
})
public class ServletNSX extends HttpServlet {
    private NSXRepositopy nsxRepositopy = new NSXRepositopy();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            List<NSX>listNSX = nsxRepositopy.getAll();
            request.setAttribute("listNSX",listNSX);
            request.getRequestDispatcher("/NSX/NSX.jsp").forward(request,response);
        }
        else if(uri.contains("detail")){
            this.detailNSX(request,response);
        }
        else if(uri.contains("delete")){
            this.deleteNSX(request,response);
        }
        else if(uri.contains("view-add")){
            this.viewAddNSX(request,response);
        }
        else if(uri.contains("view-update")){
            this.viewUpdate(request,response);
        }
    }

    private void deleteNSX(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        NSX nsx = nsxRepositopy.getById(id);
        nsxRepositopy.delete(nsx);
        response.sendRedirect("/ServletNSX/hien-thi");
    }

    private void viewAddNSX(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/NSX/addNSX.jsp").forward(request,response);

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/NSX/updateNSX.jsp").forward(request,response);
    }

    private void detailNSX(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.fromString(request.getParameter("id"));
        NSX nsx = new NSX();
        nsx = nsxRepositopy.getById(id);
       request.setAttribute("nsx",nsx);
       request.getRequestDispatcher("/NSX/updateNSX.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);
            nsxRepositopy.add(nsx);
            response.sendRedirect("/ServletNSX/hien-thi");
        }
        else if(uri.contains("update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx = nsxRepositopy.getById(id);
            nsx.setMa(ma);
            nsx.setTen(ten);
            nsxRepositopy.update(nsx);
            response.sendRedirect("/ServletNSX/hien-thi");
        }
    }
}
