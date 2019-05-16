/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Idaos.IDepartmentDAO;
import models.Country;
import models.Department;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author WIN7
 */
public class DepartmentDAO implements IDepartmentDAO {

    private SessionFactory sessionFactory = null; // KONEKSI DATABSAE SESION FACTORY 
    private Session session = null;
    private Transaction transaction = null;

    public DepartmentDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public boolean update(Department d) {

        boolean result = false;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(d);
            transaction.commit();
            // session.update(r);
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

    @Override
    public List<Department> getAll() {
        List<Department> department = new ArrayList<>(); // diamond operator <>
        try {
            session = sessionFactory.openSession(); // membuka sesi 
            transaction = session.beginTransaction(); // sesi dimulai
            //transaction.begin();// transaksi di mulai
            department = session.createQuery("FROM Department").list(); // from region itu nama class nya 
            transaction.commit();// sesi di kommit 

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return department;
    }

    @Override
    public List<Department> search(String key) {
        List<Department> departments = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Department.class.getSimpleName() + " WHERE ";
            for (Field field : Department.class.getDeclaredFields()) {
                if (!field.getName().contains("UID") && !field.getName().contains("List")) {
                    hql += field.getName() + " LIKE '%" + key + "%' OR ";
                }
            }
            hql = hql.substring(0, hql.lastIndexOf(" OR "));
            hql += " ORDER BY 1";
//            System.out.println(hql);
            departments = session.createQuery(hql).list();
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
        return departments;

    }

}
