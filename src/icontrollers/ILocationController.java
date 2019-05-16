/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Location;

/**
 *
 * @author yosef
 */
public interface ILocationController {

    public List<Location> search(String key);

    public List<Location> getAll();
    
    public String Update (String id, String street, String postal, String city, String state, String countryId);
}
