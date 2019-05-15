/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontroller;

import java.util.List;
import models.Department;

/**
 *
 * @author sofia
 */
public interface IDepartmentController {
    public List<Department> getAll();
    public List<Department> search(String keyword);
    public String delete(Department department);
}
