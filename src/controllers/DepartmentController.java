/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import icontrollers.IDepartmentController;
import idaos.IDepartmentDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Department;
import org.hibernate.SessionFactory;
//import tools.Hibernate;

/**
 *
 * @author ASUS
 */
public class DepartmentController implements IDepartmentController{
    private IDepartmentDAO iddao;

    public DepartmentController(SessionFactory factory) {
        iddao = new DepartmentDAO(factory);
    }

    @Override
    public List<Department> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Department> getById(String id) {
        return iddao.getById(id);
    }

    @Override
    public List<Department> search(Object keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String id, String name, String manager, String Location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(String id, String name, String manager, String Location) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
