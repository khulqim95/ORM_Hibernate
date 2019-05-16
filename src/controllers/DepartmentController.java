/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Daos.DepartmentDAO;
import daos.EmployeeDAO;
import Icontrollers.IDepartmentController;
import Idaos.IDepartmentDAO;
import idaos.IEmployeeDAO;
import models.Department;
import models.Employee;
import models.Location;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author RossaHening
 */
public class DepartmentController implements IDepartmentController{
    
     
     private IDepartmentDAO iddao;
        
    public DepartmentController(SessionFactory factory){
        iddao = new DepartmentDAO(factory);
    }
    
    @Override
    public String insert(String id, String name, String manager, String location) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Department d = new Department(new Short(id), name, new Employee(Integer.parseInt(manager)), new Location(new Short(location)));
            if (iddao.insert(d)){
                return "insert success";
            } else {
                return "insert failed";
            }
    }

    @Override
    public List<Department> getAll() {
        return iddao.getAll();
    }


  
}
