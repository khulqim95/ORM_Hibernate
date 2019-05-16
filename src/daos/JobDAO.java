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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import tools.Hibernate;

/**
 *
 * @author ASUS
 */
public class JobDAO implements IJobDAO {
    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

//    public JobDAO() {
//        this.sessionFactory = Hibernate.getSessionFactory();
//    }
    
    public JobDAO(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }



    @Override
    public List<Job> getAll() {
        List<Job> job = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
//            transaction.begin();
            job = session.createQuery("FROM Job").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return job;
    }
    

    @Override
    public List<Job> getById(String id) {
        List<Job> jobs = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Job WHERE jobId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", id);
            jobs = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return jobs;
    }


    @Override
    public List<Job> search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Job j) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(j);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean update(Job j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(Job j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
