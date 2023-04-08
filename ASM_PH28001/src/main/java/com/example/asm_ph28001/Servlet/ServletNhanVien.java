package com.example.asm_ph28001.Servlet;

import com.example.asm_ph28001.Model.*;
import com.example.asm_ph28001.repository.ChucVuRepository;
import com.example.asm_ph28001.repository.CuaHangRepository;
import com.example.asm_ph28001.repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ServletNhanVien", value = {
        "/ServletNhanVien/hien-thi",
        "/ServletNhanVien/detail",
        "/ServletNhanVien/view-add",
        "/ServletNhanVien/add",
        "/ServletNhanVien/view-update",
        "/ServletNhanVien/update",
        "/ServletNhanVien/delete",
})
public class ServletNhanVien extends HttpServlet {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private ChucVuRepository chucVuRepository = new ChucVuRepository();
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.hienThiNhanVien(request,response);
        }
       else if(uri.contains("detail")){
            this.detail(request,response);
        }
       else if(uri.contains("view-add")){
            this.viewadd(request,response);
        }
       else if(uri.contains("view-update")){
            this.viewupdate(request,response);
        }
        else if(uri.contains("delete")){
            this.delete(request,response);
        }
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        NhanVien nhanVien = nhanVienRepository.getById(id);

        List<ChucVu> listcv = new ArrayList<>();
        listcv = chucVuRepository.getAll();
        request.setAttribute("listcv", listcv);

        List<CuaHang> listch = new ArrayList<>();
        listch = cuaHangRepository.getAll();
        request.setAttribute("listch", listch);


        request.setAttribute("nhanVien",nhanVien);

        request.getRequestDispatcher("/NhanVien/updateNhanVien.jsp").forward(request,response);
    }

    private void viewadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChucVu> listcv = new ArrayList<>();
        listcv = chucVuRepository.getAll();
        request.setAttribute("listcv", listcv);

        List<CuaHang> listch = new ArrayList<>();
        listch = cuaHangRepository.getAll();
        request.setAttribute("listch", listch);

        request.getRequestDispatcher("/NhanVien/addNhanVien.jsp").forward(request,response);
    }

    private void viewupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        NhanVien nhanVien = new NhanVien();
        nhanVien = nhanVienRepository.getById(id);
        System.out.println(nhanVien.getNgaySinh());
        String ngaySinh = dateFormat.format(nhanVien.getNgaySinh());
        request.setAttribute("ngaySinh", ngaySinh);
        List<ChucVu> listcv = new ArrayList<>();
        listcv = chucVuRepository.getAll();
        request.setAttribute("listcv", listcv);

        List<CuaHang> listch = new ArrayList<>();
        listch = cuaHangRepository.getAll();
        request.setAttribute("listch", listch);
        request.setAttribute("nhanVien",nhanVien);
        request.getRequestDispatcher("/NhanVien/updateNhanVien.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UUID id = UUID.fromString(request.getParameter("id"));
        NhanVien nhanVien = new NhanVien();
        nhanVien = nhanVienRepository.getById(id);
       nhanVienRepository.delete(nhanVien);
       response.sendRedirect("/ServletNhanVien/hien-thi");
    }

    private void hienThiNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien>listNhanVien = nhanVienRepository.getAll();
        System.out.println(listNhanVien.size());
        request.setAttribute("listNhanVien",listNhanVien);
        request.getRequestDispatcher("/NhanVien/NhanVien.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if(uri.contains("add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String gioiTinh = request.getParameter("gioiTinh");
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String idcv = request.getParameter("chucVu");
            ChucVu chucVu = chucVuRepository.getById(UUID.fromString(idcv));
            String idch = request.getParameter("cuaHang");
            CuaHang cuaHang = cuaHangRepository.getById(UUID.fromString(idch));
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (ParseException e){
                throw new RuntimeException(e);
            }
            String matKhau = request.getParameter("matKhau");
            String trangThai = request.getParameter("trangThai");

            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setTenDem(tenDem);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setSdt(sdt);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setHo(ho);
            nhanVien.setMatKhau(matKhau);
            nhanVien.setTrangThai(Integer.parseInt(trangThai));
            nhanVien.setCv(chucVu);
            nhanVien.setCuaHang(cuaHang);
           nhanVienRepository.add(nhanVien);
            response.sendRedirect("/ServletNhanVien/hien-thi");
        }
        else if(uri.contains("update")){
            {   UUID id = UUID.fromString(request.getParameter("id"));
                String ma = request.getParameter("ma");
                String ten = request.getParameter("ten");
                String tenDem = request.getParameter("tenDem");
                String ho = request.getParameter("ho");
                String gioiTinh = request.getParameter("gioiTinh");
                String diaChi = request.getParameter("diaChi");
                String sdt = request.getParameter("sdt");
                String idcv = request.getParameter("chucVu");
                ChucVu chucVu = chucVuRepository.getById(UUID.fromString(idcv));
                String idch = request.getParameter("cuaHang");
                CuaHang cuaHang = cuaHangRepository.getById(UUID.fromString(idch));
                Date ngaySinh;
                try {
                    ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
                } catch (ParseException e){
                    throw new RuntimeException(e);
                }
                String matKhau = request.getParameter("matKhau");
                String trangThai = request.getParameter("trangThai");

                NhanVien nhanVien = new NhanVien();
                nhanVien = nhanVienRepository.getById(id);
                nhanVien.setMa(ma);
                nhanVien.setTen(ten);
                nhanVien.setTenDem(tenDem);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setSdt(sdt);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setHo(ho);
                nhanVien.setCv(chucVu);
                nhanVien.setCuaHang(cuaHang);
                nhanVien.setMatKhau(matKhau);
                nhanVien.setTrangThai(Integer.parseInt(trangThai));

                nhanVienRepository.update(nhanVien);
                response.sendRedirect("/ServletNhanVien/hien-thi");
            }
        }
        }
    }

