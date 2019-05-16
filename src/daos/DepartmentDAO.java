/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Idaos.IDepartmentDAO;
import models.Department;
import models.Employee;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author RossaHening
 */
public class DepartmentDAO implements  IDepartmentDAO{
    private SessionFactory sessionFactory = null; // KONEKSI DATABSAE SESION FACTORY 
    private Session session = null;
    private Transaction transaction = null;

//    public DepartmentDAO() {
//        this.sessionFactory = HibernateUtil.getSessionFactory();// CONSTRUCTUR LANGSUNG BIKIN KONEKSI NYA INSTANSIASI
//    }
    public DepartmentDAO(SessionFactory sessionFactory) {
       this.sessionFactory=sessionFactory;
    }

    @Override
    public boolean insert(Department d) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        session = sessionFactory.openSession(); // membuka sesi 
        transaction = session.beginTransaction(); // sesi dimulai
        try {

            session.save(d);
            transaction.commit();// sesi di kommit 
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();

            }
//          
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
// transaction.begin(); 
            departments = session.createQuery("FROM Department").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public List<Department> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Department> search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Department d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
