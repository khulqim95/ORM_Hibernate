/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Idaos.ILocationDAO;
import Models.Location;
import Models.Region;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import org.hibernate.Query;

/**
 *
 * @author WIN7
 */
public class LocationDAO implements ILocationDAO{
    
    private SessionFactory sessionFactory =null; // KONEKSI DATABSAE SESION FACTORY 
    private Session session = null; 
    private Transaction transaction = null; 
    
    public LocationDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Location> getAll() {
        List<Location> regions = new ArrayList<>(); // diamond operator <>
        try {
            session = sessionFactory.openSession(); // membuka sesi 
            transaction = session.beginTransaction(); // sesi dimulai
            //transaction.begin();// transaksi di mulai
            regions =session.createQuery("FROM Location").list(); // from region itu nama class nya 
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
    public boolean insert(Location l) {
        boolean result = false;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(l);
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
    public boolean Update(Location l) {
         boolean result = false;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(l);
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
    public boolean delete(Location l) {
         boolean result = false;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(l);
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
    public List<Location> search(Object keyword) {
        List<Location> search = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Location.class.getSimpleName() + " WHERE ";
            for (Field field : Location.class.getDeclaredFields()) {
                if (!field.getName().contains("UID") && !field.getName().contains("List")) {
                    hql += field.getName() + " LIKE '%" + keyword + "%' OR ";
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

//    @Override
//    public Location getId(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Location> getById(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
