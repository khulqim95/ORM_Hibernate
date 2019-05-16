/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Icontroller;

import Models.Employee;
import java.util.List;

/**
 *
 * @author WIN7
 */
public interface IDepartmentController {
    
  public String update(String id, String name,String Manager_id, String Location_id);
    
}
