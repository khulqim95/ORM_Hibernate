/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobDAO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import models.Job;
import models.Region;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Relion31
 */
public class JobDao implements IJobDAO {

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public JobDao(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Override
    public List<Job> getData(Job j, boolean isGetById) {
        List<Job> jobs = new ArrayList<>();
         try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (isGetById) {
                String hql = "FROM Job Where job_id = :a";
                Query query = session.createQuery(hql);
                query.setParameter("a", j.getJobId());
                jobs = query.list();
            } else {
                jobs = session.createQuery("FROM Job").list();
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return jobs;
    }

    @Override
    public List<Job> search(Object key) {
        List<Job> search = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Job.class.getSimpleName() + " WHERE ";
            for (Field field : Job.class.getDeclaredFields()) {
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

    @Override
    public boolean delete(Job j) {
       boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(j);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
