/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Pharmacie;
import entities.Pharmacien;
import entities.Zone;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class PharmacieService implements IDao<Pharmacie> {

    @Override
    public boolean create(Pharmacie o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean update(Pharmacie o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Pharmacie o
    ) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public Pharmacie findById(int id
    ) {
        Session session = null;
        Transaction tx = null;
        Pharmacie pharmacie = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            pharmacie = (Pharmacie) session.get(Pharmacie.class, id);
            tx.commit();
            return pharmacie;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return null;
    }

    @Override
    public List<Pharmacie> findAll() {
        Session session = null;
        Transaction tx = null;
        Pharmacie pharmacie = null;
        List<Pharmacie> pharmacies = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            pharmacies = session.createQuery("from Pharmacie").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return pharmacies;
   
    }
    
     public List<Pharmacie> findPharmaciesByZone(Zone v){
        Session session = null;
        Transaction tx = null;
        List<Pharmacie> pharmacies = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query = session.getNamedQuery("findPharmaciesByZone");
            query.setParameter("id", v.getId());
            pharmacies = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return pharmacies;
    }
     public List<Pharmacie> findPharmaciesByOwner(Pharmacien p){
         Session session = null;
         Transaction tx = null;
         List<Pharmacie> pharmacies = null;
         try {
             session = HibernateUtil.getSessionFactory().openSession();
             tx = session.beginTransaction();
             Query query = session.getNamedQuery("findPharmaciesByOwner");
             query.setParameter("id", p.getId());
             pharmacies = query.list();
             tx.commit();
         } catch (HibernateException e) {
             if (tx != null) {
                 tx.rollback();
             }
         }finally{
             if(session != null)
                 session.close();
         }
         return pharmacies;
     }

}
