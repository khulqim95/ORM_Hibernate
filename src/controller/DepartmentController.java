/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Daos.DepartmentDAO;
import Icontroller.IDepartmentController;
import Idaos.IDepartmentDAO;
import Models.Country;
import Models.Department;
import Models.Employee;
import Models.Location;
import Models.Region;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN7
 */
public class DepartmentController implements IDepartmentController{
    
    private IDepartmentDAO idc;
    
    public DepartmentController(SessionFactory factory){
        idc = new DepartmentDAO();
    }

    @Override
    public String update(String id, String name, String Manager_id, String Location_id) {
        Department d = new Department(new Short(id), name, new Employee(new Integer(Manager_id)), new Location(new Short(Location_id)));
        d.setDepartmentId(new Short(id));
        if (idc.update(d)) {
            return "update succes";
        }else{
            return "update failed";
        }
    }


    
}
