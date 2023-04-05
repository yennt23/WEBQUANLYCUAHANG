package com.example.asm_ph28001.repository;

import com.example.asm_ph28001.Model.MauSac;
import com.example.asm_ph28001.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MauSacRepository {
    Session session = HibernateUtil.getFACTORY().openSession();
    public List<MauSac>getAll(){
        Query query = session.createQuery("from MauSac ");
        List<MauSac>listMauSac = (List<MauSac>) query.getResultList();
        return listMauSac;
    }
    public boolean add(MauSac mauSac){
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        } return false;
    }
     public boolean update(MauSac mauSac){
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.update(mauSac);
            transaction.commit();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
     }
     public boolean delete(MauSac mauSac){
        Transaction transaction;
       try {
           transaction = session.beginTransaction();
           session.delete(mauSac);
           transaction.commit();
           return true;
       } catch (Exception e){
           e.printStackTrace();
       }
       return false;

     }
     public MauSac getById(UUID id){
        MauSac mauSac = new MauSac();
        try {
            mauSac = session.get(MauSac.class,id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return mauSac;
     }


}
