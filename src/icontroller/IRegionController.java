/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Icontroller;

import Models.Region;
import java.util.List;

/**
 *
 * @author WIN7
 */
public interface IRegionController {
    
    public List<Region> getAll();

    public List<Region> getById(String id);

    public List<Region> search(String key);

    public String insert(String id, String name);

    public String update(String id, String name);

    public String delete(String id);
    
    
    
}
