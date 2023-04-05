package com.example.asm_ph28001.Model;



import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "MauSac")
public class MauSac {
    @Id
    @GenericGenerator(name = "generator", strategy = "uuid2", parameters = {})

    @GeneratedValue(generator = "generator")
    @Column(columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @OneToMany(mappedBy = "mauSac")
    private List<ChiTietSP> listChiTiet;

    public MauSac(String ma, String ten) {

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

    public MauSac() {

    }
}
