/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Icontrollers;

import models.Department;
import models.Location;
import java.util.List;

/**
 *
 * @author RossaHening
 */
public interface IDepartmentController {
    public List<Department> getAll();
    public String insert(String id, String name, String manager, String location);
    
}
