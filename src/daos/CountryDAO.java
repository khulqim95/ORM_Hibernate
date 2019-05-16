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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author sofia
 */
public class CountryDAO implements ICountryDAO{

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;
    
    public  CountryDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public  CountryDAO(SessionFactory factory){
       this.sessionFactory = factory;
    }
    
    @Override
    public List<Country> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Country> countrys = new ArrayList<Country>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
//            transaction.begin();
            countrys = session.createQuery("FROM Country").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return countrys;
    }

    @Override
    public Country getById(String countryId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Country country = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Country WHERE countryId = :countryId";
            Query query = session.createQuery(hql);
            query.setParameter("countryId", countryId);
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
    public boolean insert(Country country) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(country);
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
      List<Country> countries = new ArrayList<>();
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
//            System.out.println(hql);
            countries = session.createQuery(hql).list();
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
        return countries;
    }

    @Override
    public boolean update(Country country) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(country);
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
    public boolean delete(Country country) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
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

}
    

