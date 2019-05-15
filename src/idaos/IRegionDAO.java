/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.math.BigDecimal;
import java.util.List;
import models.Region;

/**
 *
 * @author sofia
 */
public interface IRegionDAO {
    public List<Region> getAll();
    public Region getById(String regionId);
    public List<Region> getId(String id);
    public boolean insertRegion(Region region);
    public boolean update(Region region);
    public boolean delete(Region region);
//    public List<Region> search (Object key);
    public Region search (String key);
    
    
}
