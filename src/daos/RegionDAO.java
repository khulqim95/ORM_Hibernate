/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import idaos.IRegionDAO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import models.Region;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import tools.HibernateUtil;

/**
 *
 * @author Relion31
 */
public class RegionDAO implements IRegionDAO {

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public RegionDAO(SessionFactory factory) {
//        this.sessionFactory = HibernateUtil.getSessionFactory();
        this.sessionFactory = factory;
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
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return regions;
    }

    @Override
    public boolean save(Region r) {
        boolean result = false;
        List<Region> listRegion = new ArrayList<>();
        listRegion = getData(new Region(r.getRegionId()), true);
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (listRegion.isEmpty()) {
                session.save(r);
            } else {
                session.update(r);
            }
            transaction.commit();
            result = true;
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

    @Override
    public List<Region> getData(Region r, boolean isGetById) {
        List<Region> regions = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (isGetById) {
//                regions = session.createQuery("FROM Region Where region id = :a").list();
                String hql = "FROM Region Where region_id = :a";
                Query query = session.createQuery(hql);
                query.setParameter("a", r.getRegionId());
                regions = query.list();
            } else {
                regions = session.createQuery("FROM Region").list();
//                hql = "FROM Region";
                //  Query query = (Query) session.createQuery(hql);
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
        return regions;
    }

    @Override
    public List<Region> select(Region r) {

        List<Region> search = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
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
        return search;
    }

    @Override
    public boolean delete(Region r) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(r);
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
