/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeeDAO;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Relion31
 */
public class EmployeeDAO implements IEmployeeDAO {

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;

    public EmployeeDAO(SessionFactory factory) {
        this.sessionFactory = factory;
    }

    @Override
    public List<Employee> getData(Employee em, boolean isGetById) {
         List<Employee> employees = new ArrayList<>();
         try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (isGetById) {
                String hql = "FROM Employee Where employee_id = :a";
                Query query = session.createQuery(hql);
                query.setParameter("a", em.getEmployeeId());
                employees = query.list();
            } else {
                employees = session.createQuery("FROM Employee").list();
            }
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
        return employees;
    }

    @Override
    public boolean save(Employee em) {
        boolean result = false;
        List<Employee> listEmployee = new ArrayList<>();
        listEmployee = getData(new Employee(em.getEmployeeId()), true);
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (listEmployee.isEmpty()) {
                session.save(em);
            } else {
                session.update(em);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

}
