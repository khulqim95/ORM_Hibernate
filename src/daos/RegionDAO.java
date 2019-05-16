/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Idaos.IRegionDAO;
import Models.Region;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author WIN7
 */
public class RegionDAO implements IRegionDAO{
    
    private SessionFactory sessionFactory =null; // KONEKSI DATABSAE SESION FACTORY 
    private Session session = null; 
    private Transaction transaction = null; 

    
    public RegionDAO(){
        this.sessionFactory= HibernateUtil.getSessionFactory();// CONSTRUCTUR LANGSUNG BIKIN KONEKSI NYA INSTANSIASI
    }

    @Override // satu fungsi nama nya get ALL
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>(); // diamond operator <>
        try {
            session = sessionFactory.openSession(); // membuka sesi 
            transaction = session.beginTransaction(); // sesi dimulai
            //transaction.begin();// transaksi di mulai
            regions =session.createQuery("FROM Region").list(); // from region itu nama class nya 
            transaction.commit();// sesi di kommit 
            
        } catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{
            session.close();
        }
        return regions;
    }

    @Override
    public boolean insert(Region r) {
        boolean result = false;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(r);
             transaction.commit();
           // session.update(r);
            result = true;
             
        } catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{
            session.close();
        }
        return result;
    }

    @Override
    public boolean update(Region r) {
        boolean result = false;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(r);
             transaction.commit();
           // session.update(r);
            result = true;
             
        } catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{
            session.close();
        }
        return result;
        
        
    }

    @Override
    public boolean delete(Region r) {
            boolean result = false;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(r);
             transaction.commit();
           // session.update(r);
            result = true;
             
        } catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{
            session.close();
        }
        return result;
        
    }

    @Override
    public List<Region> getById(String id) {
        List<Region> region = new ArrayList<>();
      
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql =" FROM Region WHERE regionId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", new BigDecimal(id));
            
            region = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
                
            }
        }
        return  region;
    
        
    }

    @Override
    public Region getId(String id) {
       Region region = null;
       session = this.sessionFactory.openSession();
       transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE regionId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a",new BigDecimal(id));
            region = (Region) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
    }

    @Override
    public List<Region> search(Object key) {
        
        List<Region> search = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Region.class.getSimpleName() + " WHERE ";
            for (Field field : Region.class.getDeclaredFields()) {
                if (!field.getName().contains("UID")&& !field.getName().contains("List")) {
                hql += field.getName() + " LIKE '%" + key + "%' OR ";
                }
            }
            hql = hql.substring(0, hql.lastIndexOf(" OR "));
            hql += " ORDER BY 1";
            search = session.createQuery(hql).list();
            transaction.commit();
            System.out.println(hql);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return search;
    
    }
    
        }

