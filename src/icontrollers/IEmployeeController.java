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
 * @author yosef
 */
public interface IEmployeeController {

    public List<Employee> search(String key);
    
    public List<Employee> getAll();
}
