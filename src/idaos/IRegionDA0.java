/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import models.Region;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Ode
 */
public interface IRegionDA0 {

    public List<Region> getAll();

    public List<Region> getById(String id);

    public Region getId(String id);
    
//    public List<Region> search(String key);

    public boolean insert(Region region);

    public boolean update(Region region);

    public boolean delete(Region region);

}
