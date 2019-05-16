/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Employee;

/**
 *
 * @author Ode
 */
public interface IEmployeeController {
    
    public List<Employee> getById(String id);
    
    
}
