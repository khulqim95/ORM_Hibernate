/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.LocationDAO;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author sofia
 */
public class LocationController implements icontroller.ILocationController {
    
    private LocationDAO ldao;

    public LocationController(SessionFactory factory) {
        ldao = new LocationDAO(factory);
    }
    
    @Override
    public Location getById(String id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ldao.getById(id);
    }
    
}
