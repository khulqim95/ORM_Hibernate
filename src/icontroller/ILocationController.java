/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Icontroller;

//import Models.Region;
import Models.Location;
import java.util.List;

/**
 *
 * @author WIN7
 */
public interface ILocationController {
    
    public List<Location> getAll();

//    public List<Location> getById(String id);

    public List<Location> search(String key);

    public String insert(String id, String name);

    public String update(String id, String name);

    public String delete(String id);
    
}
