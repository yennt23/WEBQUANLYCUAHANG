package com.example.asm_ph28001.repository;

import com.example.asm_ph28001.Model.ChiTietSP;
import com.example.asm_ph28001.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    Session session = HibernateUtil.getFACTORY().openSession();

    public ArrayList<ChiTietSP> getAll() {
        Query query = session.createQuery("from ChiTietSP ");
        ArrayList<ChiTietSP> listChiTietSP = (ArrayList<ChiTietSP>) query.getResultList();
        return listChiTietSP;
    }

    public boolean add(ChiTietSP chiTietSP) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ChiTietSP chiTietSP) {
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.update(chiTietSP);
            transaction.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
  public boolean delete(ChiTietSP chiTietSP){
        Transaction transaction;
        try{
            transaction = session.beginTransaction();
            session.delete(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;

  }
  public ChiTietSP getById(UUID id){
        ChiTietSP chiTietSP = new ChiTietSP();
        try {
            chiTietSP = session.get(ChiTietSP.class, id);

        } catch (Exception e){
            e.printStackTrace();
        }
        return chiTietSP;
  }

}
