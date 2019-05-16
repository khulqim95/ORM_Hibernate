/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import icontrollers.ILocationController;
import idaos.ILocationDAO;
import java.util.List;
import models.Country;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author yosef
 */
public class LocationController implements ILocationController{ 
    
    private ILocationDAO ildao;
    public LocationController(SessionFactory factory) {
        ildao = new LocationDAO(factory);
    }
    
    @Override
    public List<Location> search(String key) {
        return ildao.search(key);
    }

    @Override
    public List<Location> getAll() {
        return ildao.getAll();
    }

    @Override
    public String Update(String id, String street, String postal, String city, String state, String countryId) {
        String result = "Maaf data gagal disimpan";
        Location location = new Location(new Short(id), street, postal, city, state, new Country(countryId));
        if (ildao.update(location)) { 
            result = "Data berhasil diupdate";
        }
        return result;
    }
}
