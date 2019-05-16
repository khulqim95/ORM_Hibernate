/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idaos;

import Models.Region;
import java.util.List;

/**
 *
 * @author WIN7
 */
public interface IRegionDAO  {
    
    public List<Region> getAll();
    
    public boolean insert(Region r);
    
    public boolean update(Region r);
    
    public boolean delete(Region r);

    public Region getId(String id);
    
    public List<Region> getById(String id);
    
    public List<Region> search (Object key);
    
}
