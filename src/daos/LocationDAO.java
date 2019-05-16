/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILocationDAO;
import models.Location;
import tools.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ode
 */
public class LocationDAO implements ILocationDAO {

    SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

//    public LocationDAO() {
//        this.sessionFactory = HibernateUtil.getSessionFactory();
//    }
        public LocationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Location> getAll() {
        List<Location> location = new ArrayList<Location>();
        try {

            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            location = session.createQuery("FROM Location").list();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return location;

    }
}
