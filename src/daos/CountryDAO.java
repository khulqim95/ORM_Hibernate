/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ICountryDAO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ode
 */
public class CountryDAO implements ICountryDAO {

    SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public List<Country> getAll() {
        List<Country> country = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            country = session.createQuery("FROM Country").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public boolean delete(Country country) {
        boolean result = false;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {

            session.delete(country);
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
    public List<Country> search(Object keyword) {
        List<Country> country = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Country.class.getSimpleName() + " WHERE ";
            for (Field field : Country.class.getDeclaredFields()) {
                if (!field.getName().contains("UID") && !field.getName().contains("List")) {
                    hql += field.getName() + " LIKE '%" + keyword + "%' OR ";
                }
            }
            hql = hql.substring(0, hql.lastIndexOf(" OR "));
            hql += " ORDER BY 1";
            country = session.createQuery(hql).list();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return country;
    }

}
