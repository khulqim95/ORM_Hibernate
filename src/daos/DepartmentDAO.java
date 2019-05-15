package daos;

import entities.Department;
import idaos.IDepartmentDAO;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author RR17
 */
public class DepartmentDAO implements IDepartmentDAO {
    
    private SessionFactory sessionFactory = null; //masuk koneksi pintu utama (masuk ke table HR)
    private Session session = null; //masuk ke koneksi dalam yg sudah ada tujuan(hanya beberapa sesi2)
    private Transaction transaction = null;

    public DepartmentDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Department> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Department getById(BigDecimal departmentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Department search(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Department department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Department department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Department department) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
