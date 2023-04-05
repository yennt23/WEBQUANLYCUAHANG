package com.example.asm_ph28001.repository;

import com.example.asm_ph28001.Model.SanPham;
import com.example.asm_ph28001.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public List<SanPham> getAll() {
        Query query = session.createQuery("from SanPham ");
        List<SanPham> listSP = query.getResultList();
        return listSP;
    }

    public boolean add(SanPham sanPham) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(SanPham sanPham) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(SanPham sanPham) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.update(sanPham);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public SanPham getById(UUID id) {
        SanPham sanPham = new SanPham();
        try {
            sanPham = session.get(SanPham.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }


}
