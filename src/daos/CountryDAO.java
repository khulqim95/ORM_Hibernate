/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Idaos.ICountryDAO;
import models.Country;
import models.Region;
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
public class CountryDAO implements ICountryDAO{
    
    private SessionFactory sessionFactory =null; // KONEKSI DATABSAE SESION FACTORY 
    private Session session = null; 
    private Transaction transaction = null; 
    
    public CountryDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Country> getAll() {
         List<Country> country  = new ArrayList<>(); // diamond operator <>
        try {
            session = sessionFactory.openSession(); // membuka sesi 
            transaction = session.beginTransaction(); // sesi dimulai
            //transaction.begin();// transaksi di mulai
            country =session.createQuery("FROM Country").list(); // from region itu nama class nya 
            transaction.commit();// sesi di kommit 
            
        } catch (Exception e) {
            if (transaction!=null) transaction.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{
            session.close();
        }
        return country;
    }

    

    @Override
    public boolean insert(Country c) {
        boolean result = false;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(c);
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
    public boolean update(Country c) {
        boolean result = false;
        
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(c);
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
    public Country getId(String id) {
        
       Country country = null;
       session = this.sessionFactory.openSession();
       transaction = session.beginTransaction();
        try {
            String hql = "FROM Country WHERE countryId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a",new BigDecimal(id));
            country = (Country) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return country;
    }

    @Override
    public List<Country> getById(String id) {
        List<Country> country = new ArrayList<>();
      
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql =" FROM Country WHERE countryId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", new BigDecimal(id));
            
            country = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }         
        }
        return  country;
        
    }
    

    @Override
    public List<Country> search(String key) {
        List<Country> search = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Country.class.getSimpleName() + " WHERE ";
            for (Field field : Country.class.getDeclaredFields()) {
                if (!field.getName().contains("UID")&& !field.getName().contains("List")) {
                hql += field.getName() + " LIKE '%" + key + "%' OR ";
                }
            }
            hql = hql.substring(0, hql.lastIndexOf(" OR "));
            hql += " ORDER BY 1";
            search = session.createQuery(hql).list();
            transaction.commit();
//            System.out.println(hql);
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


    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
