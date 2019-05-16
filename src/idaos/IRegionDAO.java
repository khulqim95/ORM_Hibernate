/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author yosef
 */
public interface IRegionDAO {
    
    public List<Region> getAll();
//    
    public Region getId(String id);
    
    public List<Region> getById(String id);
    
//    public boolean insert(Region r);
//    
//    public boolean update(Region r);
    
    public boolean delete (Region r);
    
    public List<Region> search(Object key); 
       
}
