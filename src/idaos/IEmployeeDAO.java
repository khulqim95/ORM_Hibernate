/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Employee;

/**
 *
 * @author yosef
 */
public interface IEmployeeDAO {

    public List<Employee> search(Object key);

    public List<Employee> getAll();
}
