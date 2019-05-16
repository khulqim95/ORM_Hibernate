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
 * @author Relion31
 */
public interface IEmployeeController {
    public List<Employee> getAll();
    public String save(String id, String first_name, String last_name, String email, String phone, String hire_date, String Job, String salary, String commission, String manager, String department );
}
