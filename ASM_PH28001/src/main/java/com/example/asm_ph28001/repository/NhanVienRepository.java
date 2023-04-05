package com.example.asm_ph28001.repository;

import com.example.asm_ph28001.Model.NhanVien;
import com.example.asm_ph28001.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    Session session = HibernateUtil.getFACTORY().openSession();
    public List<NhanVien> getAll(){
        Query query = session.createQuery("from NhanVien ");
        List<NhanVien>listNhanVien = query.getResultList();
        return listNhanVien;
    }
    public boolean add(NhanVien nhanVien){
        Transaction transaction;
        try{
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(NhanVien nhanVien){
        Transaction transaction;
        try {
            transaction=session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }
    public boolean update(NhanVien nhanVien){
        Transaction transaction;
        try {
            transaction=session.beginTransaction();
            session.update(nhanVien);
            transaction.commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;

    }
    public NhanVien getById(UUID id){
        NhanVien nhanVien = new NhanVien();
        try {
            nhanVien = session.get(NhanVien.class,id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return nhanVien;
    }




}
