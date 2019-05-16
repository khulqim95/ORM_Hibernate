/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILocationDAO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author yosef
 */
public class LocationDAO implements ILocationDAO {

    // Koneksi Awal
    private SessionFactory sessionFactory = null;
    // Koneksi Inti
    private Session session = null;
    // 
    private Transaction transaction = null;

    public LocationDAO(SessionFactory factory) {
        this.sessionFactory = factory;
    }

//    public LocationDAO() {
//        this.sessionFactory = HibernateUtil.getSessionFactory();
//    }
    @Override
    public boolean update(Location l) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.update(l);
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

    @Override
    public List<Location> search(Object key) {
        List<Location> search = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Location.class.getSimpleName() + " WHERE ";
            for (Field field : Location.class.getDeclaredFields()) {
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

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
//            transaction.begin();
            locations = session.createQuery("FROM Location").list();
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
        return locations;
    }
}
