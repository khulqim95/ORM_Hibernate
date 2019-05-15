package daos;

import entities.Employee;
import entities.Job;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;
import idaos.IEmployeeDAO;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author RR17
 */
public class EmployeeDAO implements IEmployeeDAO {
    
    private SessionFactory sessionFactory = null; //masuk koneksi pintu utama (masuk ke table HR)
    private Session session = null; //masuk ke koneksi dalam yg sudah ada tujuan(hanya beberapa sesi2)
    private Transaction transaction = null;

    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee getById(BigDecimal employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employee search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Employee employee) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.save(employee);
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
    public boolean update(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int employeeId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            session.delete(new Employee(employeeId));
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
