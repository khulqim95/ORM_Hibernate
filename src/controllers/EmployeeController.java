/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
import java.util.List;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author yosef
 */
public class EmployeeController implements IEmployeeController{
    
    private IEmployeeDAO iedao;
    public EmployeeController(SessionFactory factory) {
        iedao = new EmployeeDAO();
    }

    @Override
    public List<Employee> search(String key) {
        return iedao.search(key);
    }

    @Override
    public List<Employee> getAll() {
        return iedao.getAll();
    }
    
}
