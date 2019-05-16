/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Department;

/**
 *
 * @author sofia
 */
public interface IDepartment {
    public List<Department> getAll();
    public List<Department> search(Object keyword);
    public boolean delete(Department department);
    
}
