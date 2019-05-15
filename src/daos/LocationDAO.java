package daos;

import entities.Location;
import entities.Region;
import idaos.ILocationDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author RR17
 */
public class LocationDAO implements ILocationDAO {
    private SessionFactory sessionFactory = null; //masuk koneksi pintu utama (masuk ke table HR)
    private Session session = null; //masuk ke koneksi dalam yg sudah ada tujuan(hanya beberapa sesi2)
    private Transaction transaction = null;
    
    public LocationDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public LocationDAO(SessionFactory factory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          List<Location> locations = new ArrayList<>();
        try {
            session = sessionFactory.openSession(); //pembukaan sesinya
            transaction = session.beginTransaction(); //kemudian pembukaan session untuk transaksi
//            transaction.begin(); //mulai transaksi
            locations = session.createQuery("FROM Location").list(); //regions kita isikan dengan mengambil data dari object Region
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
        return locations;
    }

    @Override
    public Location getById(BigDecimal locationId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Location location = null;
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Location WHERE locationId = :locationId";
            Query query = session.createQuery(hql);
            query.setParameter("locationId", locationId);
            location = (Location) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        }
        return location;
    }

    @Override
    public Location search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Location location) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(location);
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
    public boolean update(Location location) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.update(location);
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
    public boolean delete(Location location) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(location);
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
