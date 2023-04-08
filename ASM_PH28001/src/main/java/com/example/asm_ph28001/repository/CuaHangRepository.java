package com.example.asm_ph28001.repository;

import com.example.asm_ph28001.Model.CuaHang;
import com.example.asm_ph28001.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.UUID;

public class CuaHangRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<CuaHang> getAll() {
        Query query = session.createQuery("from CuaHang ");
        ArrayList<CuaHang> listCH = (ArrayList<CuaHang>) query.getResultList();
        return listCH;
    }

    public boolean add(CuaHang cuaHang) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(CuaHang cuaHang) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.update(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(CuaHang cuaHang) {
        Transaction transaction ;
        try {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public CuaHang getById(UUID id) {
        CuaHang cuaHang = new CuaHang();
        try {
            cuaHang = session.get(CuaHang.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cuaHang;
    }
}
