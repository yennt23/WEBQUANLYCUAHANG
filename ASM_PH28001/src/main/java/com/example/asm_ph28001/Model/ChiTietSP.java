package com.example.asm_ph28001.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
public class ChiTietSP {
    @Id
//    @GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})

//    @GeneratedValue(generator = "generator")
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanpham;
    //    @Column(name = "IdNsx")
//    private int idNsx;
    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NSX nsx;
    //    @Column(name = "IdMauSac")
//    private int idMausac;
    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    //    @Column(name = "IdDongSP")
//    private int idDongsp;
    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;
    @Column(name = "NamBH")
    private int namBH;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private long soLuongTon;
    @Column(name = "GiaNhap")
    private long giaNhap;
    @Column(name = "GiaBan")
    private long giaBan;


    public ChiTietSP() {

    }

    public ChiTietSP(UUID id, SanPham sanpham, NSX nsx, MauSac mauSac, DongSP dongSP, int namBH, String moTa, long soLuongTon, long giaNhap, long giaBan) {
        this.id = id;
        this.sanpham = sanpham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public ChiTietSP(SanPham sanpham, NSX nsx, MauSac mauSac, DongSP dongSP, int namBH, String moTa, long soLuongTon, long giaNhap, long giaBan) {
        this.sanpham = sanpham;
        this.nsx = nsx;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public NSX getNsx() {
        return nsx;
    }

    public void setNsx(NSX nsx) {
        this.nsx = nsx;
    }

    public MauSac getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac mauSac) {
        this.mauSac = mauSac;
    }

    public DongSP getDongSP() {
        return dongSP;
    }

    public void setDongSP(DongSP dongSP) {
        this.dongSP = dongSP;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public long getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(long soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public long getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(long giaNhap) {
        this.giaNhap = giaNhap;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }
}
