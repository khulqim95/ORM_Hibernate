/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idaos;


import models.Department;
import java.util.List;

/**
 *
 * @author WIN7
 */
public interface IDepartmentDAO {
   
    public boolean update(Department d);
    
     public List<Department> getAll();
     public List<Department> search (String key);

   
}
