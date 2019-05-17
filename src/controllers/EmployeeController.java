/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.JobDao;
import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
import idaos.IJobDAO;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author Relion31
 */
public class EmployeeController implements IEmployeeController {

    private IEmployeeDAO iemdao;
//    Date d = new Date();
    public EmployeeController(SessionFactory factory) {
        iemdao = new EmployeeDAO(factory);
        
    }
    Date date = new Date(); // this object contains the current date value 
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    public List<Employee> getAll() {
        return iemdao.getData(new Employee(0), false);
    }

//    @Override
//    public String sd(String id, String first_name, String last_name, String email, String hire_date) {
//        String result = "Maaf data gagal disimpan";
//        Employee employee = new Employee(Integer.parseInt(id), last_name, email, new java.sql.Date(d.getTime()));
//        if (iemdao.save(employee)) {
//            result="Data Berhasil Disimpan";
//        }
//        return result;
//    }

    @Override
    public String save(String id, String first_name, String last_name, String email, String phone, String hire_date, String Job, String salary, String commission, String manager, String department) {
        String result = "Maaf data gagal disimpan";
        try {
        date = formatter.parse(hire_date);
        Employee e = new Employee(Integer.parseInt(id), first_name, last_name, email, phone, new java.sql.Date(date.getTime()), new BigDecimal(salary), new BigDecimal(commission), new Department(Short.parseShort(department)), new Employee(Integer.parseInt(manager)), new Job(Job));
        if (iemdao.save(e)) {
            result="Data Berhasil Disimpan";
        }
            
        } catch (ParseException ex) {
             Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
