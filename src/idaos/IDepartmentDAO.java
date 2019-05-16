/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idaos;

import models.Department;
import models.Location;
import java.util.List;



/**
 *
 * @author RossaHening
 */
public interface IDepartmentDAO {
    public List<Department> getAll();
    
    public List<Department> getById(String id);

    public List<Department> search(String key);

    public boolean insert(Department d);

    public boolean update(Department d);

    public boolean delete(int id);
    
    
}
