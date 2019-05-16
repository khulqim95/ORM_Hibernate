/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IDepartmentDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import tools.Hibernate;

/**
 *
 * @author ASUS
 */
public class DepartmentDAO implements IDepartmentDAO {

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

//    public DepartmentDAO() {
//        this.sessionFactory = Hibernate.getSessionFactory();
//    }
    public DepartmentDAO(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }


    @Override
    public List<Department> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Department> getById(String id) {
        List<Department> departments = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "FROM Department WHERE departmentId = :a";
            Query query = session.createQuery(hql);
            query.setParameter("a", new Short(id));
            departments = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return departments;
    }

    @Override
    public Department getId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Department> search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Department d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Department d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteById(Department d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
