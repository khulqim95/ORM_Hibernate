/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDA0;
import models.Region;
import tools.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ode
 */
public class RegionDAO implements IRegionDA0 {

    SessionFactory sessionFactory = null;

    private Session session = null;

    private Transaction transaction = null;

    public RegionDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();

    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<Region>();
        try {

            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
//            transaction.begin();
            regions = session.createQuery("FROM Region").list();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return regions;

    }

    @Override
    public boolean insert(Region region) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {

            session.save(region);
            transaction.commit();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean update(Region region) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {

            session.update(region);
            transaction.commit();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(Region region) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {

            session.delete(region);
            transaction.commit();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Region> getById(String id) {
        List<Region> region = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "from Region Where regionId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", new BigDecimal(id));
            region = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return region;
    }
    
    @Override
    public Region getId(String id) {
        Region region = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "from Region Where regionId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", new BigDecimal(id));
            region = (Region) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return region;
    }
    
//    @Override
//    public List<Region> search(String key) {
//        List<Region> region = new ArrayList<>();
//        session = this.sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        try {
//            String hql = "from Region Where regionId = :a";
//            Query query = session.createQuery(hql);
//            query.setParameter("a", new BigDecimal(key));
//            region = query.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            System.out.println(e.getMessage());
//        } finally {
//            session.close();
//        }
//        return region;
//    }

}
