package com.example.asm_ph28001.Servlet;

import com.example.asm_ph28001.Model.*;
import com.example.asm_ph28001.repository.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ServletChiTietSP", value = {
        "/ServletChiTietSP/hien-thi",
        "/ServletChiTietSP/detail",
        "/ServletChiTietSP/view-add",
        "/ServletChiTietSP/add",
        "/ServletChiTietSP/view-update",
        "/ServletChiTietSP/update",
        "/ServletChiTietSP/delete",
})
public class ServletChiTietSP extends HttpServlet {
    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private NSXRepositopy nsxRepositopy = new NSXRepositopy();
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri = request.getRequestURI();
    if(uri.contains("hien-thi")){
        this.hienThi(request,response);
    }
    else if(uri.contains("delete")){
        this.deleteChiTietSP(request,response);
    }
    else if(uri.contains("detail")){
        this.detailCTSP(request,response);

    } else if(uri.contains("view-add")){
        this.viewAdd(request,response);
    }
    else if(uri.contains("view-update")){
        this.viewUpdate(request,response);
    }


    }

    private void detailCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChiTietSP chiTietSP = new ChiTietSP();
         chiTietSP = chiTietSPRepository.getById(id);
        request.setAttribute("chiTietSP",chiTietSP);

        List<MauSac> listMau = new ArrayList<>();
        listMau = mauSacRepository.getAll();
        System.out.println("-------------" + listMau.size());
        request.setAttribute("listMau", listMau);

        List<SanPham> listsp = new ArrayList<>();
        listsp = sanPhamRepository.getAll();
        request.setAttribute("listsp", listsp);

        List<NSX> listnsx = new ArrayList<>();
        listnsx = nsxRepositopy.getAll();
        request.setAttribute("listnsx", listnsx);

        List<DongSP> listDongSP = new ArrayList<>();
        listDongSP = dongSPRepository.getAll();
        request.setAttribute("listDongSP", listDongSP);


        request.getRequestDispatcher("/ChiTietSP/updateChiTietSP.jsp").forward(request,response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MauSac> listMau = new ArrayList<>();
        listMau = mauSacRepository.getAll();
        System.out.println("-------------" + listMau.size());
        request.setAttribute("listMau", listMau);

        List<SanPham> listsp = new ArrayList<>();
        listsp = sanPhamRepository.getAll();
        request.setAttribute("listsp", listsp);

        List<NSX> listnsx = new ArrayList<>();
        listnsx = nsxRepositopy.getAll();
        request.setAttribute("listnsx", listnsx);

        List<DongSP> listDongSP = new ArrayList<>();
        listDongSP = dongSPRepository.getAll();
        request.setAttribute("listDongSP", listDongSP);

        request.getRequestDispatcher("/ChiTietSP/addChiTietSP.jsp").forward(request,response);

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ChiTietSP/updateChiTietSP.jsp").forward(request,response);

    }

    private void deleteChiTietSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        ChiTietSP chiTietSP = chiTietSPRepository.getById(id);
        chiTietSPRepository.delete(chiTietSP);
        response.sendRedirect("/ServletChiTietSP/hien-thi");
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ChiTietSP>listChiTietSP = chiTietSPRepository.getAll();
        request.setAttribute("listChiTietSP",listChiTietSP);
        request.getRequestDispatcher("/ChiTietSP/ChiTietSP.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri = request.getRequestURI();
    if(uri.contains("add")){
        this.addChiTietSP(request,response);
    }
    else if(uri.contains("update")){
        this.updateChiTietSP(request,response);
    }
    }

    private void updateChiTietSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        String mota = request.getParameter("moTa");
        int nambh = Integer.parseInt(request.getParameter("namBH"));
        int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        int gianhap = Integer.parseInt(request.getParameter("giaNhap"));
        String idMau = request.getParameter("mauSac");
        MauSac mauSac = mauSacRepository.getById(UUID.fromString(idMau));
        String idsp = request.getParameter("sanPham");
        SanPham sanPham = sanPhamRepository.getById(UUID.fromString(idsp));
        String idnsx = request.getParameter("nsx");
        NSX nsx = nsxRepositopy.getById(UUID.fromString(idnsx));
        String idDongSP = request.getParameter("dongSP");
        DongSP dongSP = dongSPRepository.getById(UUID.fromString(idDongSP));
        ChiTietSP chiTietSP = new ChiTietSP();
        chiTietSP = chiTietSPRepository.getById(id);
        chiTietSP.setMoTa(mota);
        chiTietSP.setNamBH(nambh);
        chiTietSP.setSoLuongTon(soLuongTon);
        chiTietSP.setGiaNhap(gianhap);
        chiTietSP.setMauSac(mauSac);
        chiTietSP.setSanpham(sanPham);
        chiTietSP.setNsx(nsx);
        chiTietSPRepository.update(chiTietSP);
        response.sendRedirect("/ServletChiTietSP/hien-thi");
    }

    private void addChiTietSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String mota = request.getParameter("moTa");
        int nambh = Integer.parseInt(request.getParameter("namBH"));
        int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        int gianhap = Integer.parseInt(request.getParameter("giaNhap"));
        String idMau = request.getParameter("mauSac");
        MauSac mauSac = mauSacRepository.getById(UUID.fromString(idMau));
        String idsp = request.getParameter("sanPham");
        SanPham sanPham = sanPhamRepository.getById(UUID.fromString(idsp));
        String idnsx = request.getParameter("nsx");
        NSX nsx = nsxRepositopy.getById(UUID.fromString(idnsx));
        String idDongSP = request.getParameter("dongSP");
        DongSP dongSP = dongSPRepository.getById(UUID.fromString(idDongSP));
        ChiTietSP chiTietSP = new ChiTietSP();
        chiTietSP.setMoTa(mota);
        chiTietSP.setNamBH(nambh);
        chiTietSP.setSoLuongTon(soLuongTon);
        chiTietSP.setGiaNhap(gianhap);
        chiTietSP.setMauSac(mauSac);
        chiTietSP.setSanpham(sanPham);
        chiTietSP.setNsx(nsx);
        chiTietSPRepository.add(chiTietSP);
        response.sendRedirect("/ServletChiTietSP/hien-thi");
    }
}
