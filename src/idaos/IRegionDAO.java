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
 * @author Relion31
 */
public interface IRegionDAO {
    public List<Region> getAll();
    public List<Region> select(Region r);
    public List<Region> search(Object key);
    public List<Region> getData(Region r, boolean isGetById);
    public boolean save(Region r);
    public boolean delete(Region r);
    
}
