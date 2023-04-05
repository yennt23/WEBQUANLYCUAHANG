package com.example.asm_ph28001.repository;

import com.example.asm_ph28001.Model.KhachHang;
import com.example.asm_ph28001.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public List<KhachHang> getAll() {
        Query query = session.createQuery("from KhachHang", KhachHang.class);
        ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) query.getResultList();
        return listKhachHang;
//        List<KhachHang> khachHangList = new ArrayList<>();
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query query = session.createQuery("FROM KhachHang ", KhachHang.class);
//            khachHangList = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return khachHangList;
    }

    public static void main(String[] args) {
        KhachHangRepository khachHangRepository = new KhachHangRepository();
        List<KhachHang> Kh = khachHangRepository.getAll();
        for (KhachHang khachHang : Kh) {
            System.out.println(khachHang.toString());
        }
    }

    public Boolean add(KhachHang khachHang) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(KhachHang khachHang) {
        Transaction transaction;
        try  {
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public KhachHang getById(UUID id) {
        KhachHang khachHang = new KhachHang();
        try {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            khachHang = session.get(KhachHang.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public boolean delete(KhachHang khachHang) {
        Transaction transaction ;
        try {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
