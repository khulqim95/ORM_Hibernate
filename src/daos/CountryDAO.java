/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ICountryDAO;
import java.util.ArrayList;
import java.util.List;
import models.Country;
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
    
}
