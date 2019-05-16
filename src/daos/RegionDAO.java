/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
import models.Region;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author yosef
 */
public class RegionDAO implements IRegionDAO {

    // Koneksi Awal
    private SessionFactory sessionFactory = null;
    // Koneksi Inti
    private Session session = null;
    // 
    private Transaction transaction = null;

    public RegionDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
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
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return regions;
    }

//    @Override
//    public boolean insert(Region r) {
//        boolean result = false;
//        session = this.sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        try {
//            session.save(r);
//            transaction.commit();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return result;
//    }
//    @Override
//    public boolean update(Region r) {
//         boolean result = false;
//        session = this.sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        try {
//            session.update(r);
//            transaction.commit();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            session.close();
//        }
//        return result;
//    }
    @Override
    public List<Region> getById(String id) {
        List<Region> region = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE regionId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", new BigDecimal(id));
            region = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
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
    public boolean delete(Region r) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(r);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }
//
//    @Override
//    public List<Region> search(String key) {
//       List<Region> region = new ArrayList<>();
//       session = this.sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        try {
//            String hql = "FROM Region WHERE regionId  ";
//            Query query = session.createQuery(hql);
//            region = query.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        return region;
//    }
    @Override
    public List<Region> search(Object key) {
        List<Region> search = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Region.class.getSimpleName() + " WHERE ";
            for (Field field : Region.class.getDeclaredFields()) {
                if (!field.getName().contains("UID") && !field.getName().contains("List")) {
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
}
