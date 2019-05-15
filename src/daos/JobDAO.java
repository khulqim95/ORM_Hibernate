/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobDAO;
import java.util.ArrayList;
import java.util.List;
import models.Job;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author sofia
 */
public class JobDAO implements IJobDAO{
    
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public JobDAO() {
         this.sessionFactory = HibernateUtil.getSessionFactory();
    }        
    
    public  JobDAO(SessionFactory factory){
       this.sessionFactory = factory;
    }
    
    @Override
    public boolean deleteById(Job job) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         boolean result = false;   
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();            
            session.delete(job);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());            
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean update(Job job) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;   
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(job);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());            
        } finally {
            session.close();
        }
        return result; 
    }

    @Override
    public boolean insert(Job job) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;   
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(job);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());            
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Job> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Job> jobs = new ArrayList<Job>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
//            transaction.begin();
            jobs = session.createQuery("FROM Job").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return jobs;
    }
}
