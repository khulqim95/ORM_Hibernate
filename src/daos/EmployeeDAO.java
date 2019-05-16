/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeeDAO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author yosef
 */
public class EmployeeDAO implements IEmployeeDAO{

    // Koneksi Awal
    private SessionFactory sessionFactory = null;
    // Koneksi Inti
    private Session session = null;
    // 
    private Transaction transaction = null;

    public EmployeeDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    @Override
    public List<Employee> search(Object key) {
       List<Employee> search = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Employee.class.getSimpleName() + " WHERE ";
            for (Field field : Employee.class.getDeclaredFields()) {
                if (!field.getName().contains("UID") && !field.getName().contains("List")) {
                    hql += field.getName() + " LIKE '%" + key + "%' OR ";
                }
            }
            hql = hql.substring(0, hql.lastIndexOf(" OR "));
            hql += " ORDER BY 1";
            search = session.createQuery(hql).list();
            transaction.commit();
//            System.out.println(hql);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return search;

    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
//            transaction.begin();
            employees = session.createQuery("FROM Employee").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return employees;
    }
    
}
