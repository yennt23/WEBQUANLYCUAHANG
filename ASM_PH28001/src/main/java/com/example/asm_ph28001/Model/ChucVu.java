package com.example.asm_ph28001.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Data
@Table(name = "ChucVu")
@Entity
public class ChucVu {
    @Id
    @GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})

    @GeneratedValue(generator = "generator")
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "ten")
    private String ten;
    @OneToMany(mappedBy = "cv")
    private List<NhanVien> listnv;

    public ChucVu() {

    }

    public ChucVu(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<NhanVien> getListnv() {
        return listnv;
    }

    public void setListnv(List<NhanVien> listnv) {
        this.listnv = listnv;
    }
}
