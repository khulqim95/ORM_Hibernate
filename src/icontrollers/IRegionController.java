/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author yosef
 */
public interface IRegionController {
    public List<Region> getAll();
    
    public List<Region> search(String key);
    
    public List<Region> getById(String id);
    
    public String delete(Region r);
}
