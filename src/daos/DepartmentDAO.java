/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import models.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author sofia
 */
public class DepartmentDAO implements idaos.IDepartment{

    private SessionFactory sessionFactory = null;
    private Session session = null;
    private Transaction transaction = null;
    
    public  DepartmentDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public  DepartmentDAO(SessionFactory factory){
       this.sessionFactory = factory;
    }
    
    @Override
    public List<Department> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Department> departments = new ArrayList<Department>();
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
//            transaction.begin();
            departments = session.createQuery("FROM Department").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return departments;
    }

    @Override
    public boolean delete(Department department) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;   
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(department);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());            
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Department> search(Object keyword) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Department> departments = new ArrayList<>();
        try {
            session =  sessionFactory.openSession();
            transaction = session.beginTransaction();
            String hql = "FROM " + Department.class.getSimpleName() + " WHERE ";
            for (Field field : Department.class.getDeclaredFields()) {
                if (!field.getName().contains("UID") && !field.getName().contains("List")) {
                    hql += field.getName() + " LIKE '%" + keyword + "%' OR ";
                }
            }
            hql = hql.substring(0, hql.lastIndexOf(" OR "));
            hql += " ORDER BY 1";
//            System.out.println(hql);
            departments = session.createQuery(hql).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            session.close();
        }
        return departments;
    }
    
}
