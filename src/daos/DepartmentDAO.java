/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Idaos.IDepartmentDAO;
import Models.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author WIN7
 */
public class DepartmentDAO implements IDepartmentDAO{
    
    private SessionFactory sessionFactory =null; // KONEKSI DATABSAE SESION FACTORY 
    private Session session = null; 
    private Transaction transaction = null; 
    
    public DepartmentDAO(){
        this.sessionFactory= HibernateUtil.getSessionFactory();
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
            if (transaction!=null) transaction.rollback();
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{
            session.close();
        }
        return result;
        
        
    }
    
}
