/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeeDAO;
import models.Employee;
import tools.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ode
 */
public class EmployeeDAO implements IEmployeeDAO {

    SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

//    public EmployeeDAO() {
//        this.sessionFactory = HibernateUtil.getSessionFactory();
//    }
    public EmployeeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Employee> getById(String id) {
        List<Employee> employee = new ArrayList<>();
        session = this.sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            String hql = "from Employee where employeeId = :e";
            Query query = session.createQuery(hql);
            query.setParameter("e", Integer.parseInt(id));
            employee = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return employee;
    }

}
