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
 * @author Relion31
 */
public interface IRegionController {
    public List<Region> getAll();
    public List<Region> search(String key);
}
