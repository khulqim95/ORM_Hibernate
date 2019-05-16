/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import icontrollers.IEmployeeController;
import java.util.List;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ode
 */
public class EmployeeController implements IEmployeeController {

    private EmployeeDAO employeeDAO;

    public EmployeeController(SessionFactory sessionFactory) {
        employeeDAO = new EmployeeDAO(sessionFactory);
    }

    @Override
    public List<Employee> getById(String id) {
        return employeeDAO.getById(id);
    }

}
