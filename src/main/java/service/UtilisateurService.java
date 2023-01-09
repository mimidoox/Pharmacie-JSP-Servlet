/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.Admin;
import entities.Pharmacien;
import entities.Utilisateur;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class UtilisateurService implements IDao<Utilisateur> {

    @Override
    public boolean create(Utilisateur o) {
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
    public boolean update(Utilisateur o) {
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
    public boolean delete(Utilisateur o
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
    public Utilisateur findById(int id
    ) {
        Session session = null;
        Transaction tx = null;
        Utilisateur utilisateur = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateur = (Utilisateur) session.get(Utilisateur.class, id);
            tx.commit();
            return utilisateur;
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
    public List<Utilisateur> findAll() {
        Session session = null;
        Transaction tx = null;
        Utilisateur utilisateur = null;
        List<Utilisateur> utilisateurs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateurs = session.createQuery("from Utilisateur").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return utilisateurs;
   
    }
    public List<Admin> findAdmins() {
        Session session = null;
        Transaction tx = null;
        Admin utilisateur = null;
        List<Admin> utilisateurs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateurs = session.createQuery("from Admin").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return utilisateurs;
   
    }
    public List<Pharmacien> findPharmaciens() {
        Session session = null;
        Transaction tx = null;
        Pharmacien utilisateur = null;
        List<Pharmacien> utilisateurs = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateurs = session.createQuery("from Pharmacien").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally{
            if(session != null)
                session.close();
        }
        return utilisateurs;
   
    }
    public Utilisateur findUserByEmailPass(String email,String pass) {
		Session session = null;
        Transaction tx = null;
        Utilisateur user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            org.hibernate.Query query = session.createQuery("from Utilisateur where login =:login and password=:pass");
            query.setParameter("login", email);
            query.setParameter("pass", pass);
            user = (Utilisateur) query.uniqueResult();
            tx.commit();
            return user;
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


}
