package com.example.asm_ph28001.Model;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;
import javax.persistence.*;

@Table(name = "DongSP")
@Entity
public class DongSP {
    @Id
//    @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "uniqueidentifier")
    private UUID id;

    @Column(name = "ma", unique = true)
    private String ma;

    @Column(name = "ten", columnDefinition = "Nvarchar(100)")
    private String ten;

    @OneToMany(mappedBy = "dongSP")
    private List<ChiTietSP>chiTietSP;

    public DongSP() {
    }

    public DongSP(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public DongSP(UUID id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }

    public UUID getId() {
        return id;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
