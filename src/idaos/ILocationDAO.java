/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idaos;

import Models.Location;
import java.util.List;

/**
 *
 * @author WIN7
 */
public interface ILocationDAO {
    public List<Location> getAll();
    
    public boolean insert(Location l);
    
    public boolean Update(Location l);
    
    public boolean delete (Location l);
    
//    public Location getId(String id);
//    
//    public List<Location> getById(String id);

    public List<Location> search (Object keyword);
    

}
