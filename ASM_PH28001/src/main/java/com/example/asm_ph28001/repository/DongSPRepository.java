package com.example.asm_ph28001.repository;

import com.example.asm_ph28001.Model.DongSP;
import com.example.asm_ph28001.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class DongSPRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<DongSP> getAll() {
        Query query = session.createQuery("from DongSP");
        ArrayList<DongSP> listDongSanPham = (ArrayList<DongSP>) query.getResultList();
        return listDongSanPham;
    }

    public boolean add(DongSP dongSP) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(DongSP dongSP) {
        Transaction transaction =null;
        try {
            transaction = session.beginTransaction();
            session.update(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(DongSP dongSP) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.delete(dongSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public DongSP getById(UUID id) {
        DongSP dongSP = new DongSP();
        try {
            dongSP = session.get(DongSP.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dongSP;
    }

}
