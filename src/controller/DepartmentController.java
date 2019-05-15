/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.CountryDAO;
import daos.DepartmentDAO;
import icontroller.IDepartmentController;
import java.util.List;
import models.Department;
import org.hibernate.SessionFactory;

/**
 *
 * @author sofia
 */
public class DepartmentController implements IDepartmentController{
    
    private DepartmentDAO ddao;

    
    public DepartmentController(SessionFactory factory) {
        ddao = new DepartmentDAO(factory);
    }
    
    @Override
    public List<Department> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ddao.getAll();
    }

    @Override
    public String delete(Department department) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = "";
        if (ddao.delete(department)) {
            result = "delete success";
        }else {
            result =  "delete failed";
        }
        return result;
    }

    @Override
    public List<Department> search(String keyword) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ddao.search(keyword);
    }
    
}
