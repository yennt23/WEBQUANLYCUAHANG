package com.example.asm_ph28001.repository;

import com.example.asm_ph28001.Model.NSX;
import com.example.asm_ph28001.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class NSXRepositopy {
    Session session = HibernateUtil.getFACTORY().openSession();
    public List<NSX> getAll(){
        Query query = session.createQuery("from NSX");
        List<NSX>listNSX = (List<NSX>)query.getResultList();
        return listNSX;
    }
    public boolean add(NSX nsx){
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(NSX nsx){
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.update(nsx);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(NSX nsx){
        Transaction transaction;
        try {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public NSX getById(UUID id){
        NSX nsx = new NSX();
        try {
            nsx = session.get(NSX.class,id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return nsx;
    }
}
