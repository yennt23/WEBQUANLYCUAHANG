package com.example.asm_ph28001.repository;

import com.example.asm_ph28001.Model.ChucVu;
import com.example.asm_ph28001.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class ChucVuRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<ChucVu> getAll() {
        Query query = session.createQuery("from ChucVu ");
        ArrayList<ChucVu> listChucVu = (ArrayList<ChucVu>) query.getResultList();
        return listChucVu;
    }

    public boolean add(ChucVu chucVu) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean delete(ChucVu chucVu) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public boolean update(ChucVu chucVu) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.update(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ChucVu getById(UUID id) {
        ChucVu chucVu = new ChucVu();
        try {
            chucVu = session.get(ChucVu.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }
}
