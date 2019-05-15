/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILocationDAO;
import java.math.BigDecimal;
import models.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author sofia
 */
public class LocationDAO implements ILocationDAO {

    private SessionFactory factory = null;
    private Session session = null;
    private Transaction transaction = null;
    
    public  LocationDAO(SessionFactory factory){
        this.factory = HibernateUtil.getSessionFactory();
    }
    
    @Override
    public Location getById(String locationId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Location location = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE regionId = :regionId";
            Query query = session.createQuery(hql);
            query.setParameter("regionId", new BigDecimal(locationId));
            location = (Location) query.uniqueResult();            
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
        return location;         
    }
    
}
