/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.List;
import models.Region;
import idaos.IRegionDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;
/**
 *
 * @author sofia
 */
public class RegionDAO implements idaos.IRegionDAO{

    private SessionFactory factory = null;
    private Session session = null;
    private Transaction transaction = null;

    public RegionDAO() {
        this.factory = HibernateUtil.getSessionFactory();
    }
       
    public  RegionDAO(SessionFactory factory){
        this.factory = factory;
    }
    
    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<Region>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
//            transaction.begin();
            regions = session.createQuery("FROM Region").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return regions;
    }           
    
     @Override
    public boolean insertRegion(Region region) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;   
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(region);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());            
        } finally {
            session.close();
        }
        return result;
    }
    
    @Override
    public boolean update(Region region ) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;   
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(region);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());            
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(Region region) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;   
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.delete(region);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());            
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public Region getById(String regionId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Region region = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE regionId = :regionId";
            Query query = session.createQuery(hql);
            query.setParameter("regionId", new BigDecimal(regionId));
            region = (Region) query.uniqueResult();            
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
        return region;         
    }   

    @Override
    public Region search(String key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
//        List<Region> region = new ArrayList<>();
//        session = this.sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        try {
//            String hql = "FROM Region WHERE regionId LIKE :id OR regionName LIKE :name";
//            Query query = session.createQuery(hql);
//            query.setParameter("id", new BigDecimal(key));
//            query.setParameter("name",key);
//            region = query.list();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//        return region;
          Region region = null;
        session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE regionId LIKE :regionId OR regionName LIKE :regionName";
            Query query = session.createQuery(hql);
            query.setParameter("regionId", new BigDecimal(key));
            query.setParameter("regionName", key);
            region = (Region) query.uniqueResult();            
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
        return region;      
    }

    @Override
    public List<Region> getId(String id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.         
       List<Region> region = new ArrayList<>();
       session = this.factory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Region WHERE regionId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a",new BigDecimal(id));
            region = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return region;
    }
}
