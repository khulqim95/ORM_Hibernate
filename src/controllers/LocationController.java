/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.LocationDAO;
import icontrollers.ILocationCotroller;
import java.util.List;
import models.Location;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ode
 */
public class LocationController implements ILocationCotroller {

    private LocationDAO locationDAO;

    public LocationController(SessionFactory sessionFactory) {
        locationDAO = new LocationDAO(sessionFactory);
    }
    
    @Override
    public List<Location> getAll(){
    return locationDAO.getAll();
    }
}
