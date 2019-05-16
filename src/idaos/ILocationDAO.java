/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Location;

/**
 *
 * @author yosef
 */
public interface ILocationDAO {

    public boolean update(Location l);

    public List<Location> search(Object key);

    public List<Location> getAll();
}
